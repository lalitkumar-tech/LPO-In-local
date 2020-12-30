package com.lalit.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.lalit.utils.LPOResponse;
import com.lalit.utils.LocaleService;


@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Autowired
	private LocaleService localeService;
	
	@ExceptionHandler({ DataNotFoundException.class })
	public ResponseEntity<Object> handleException(final DataNotFoundException e, final WebRequest request) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new LPOResponse.LPOResposeBuilder(true, localeService.getMessage(e.getMessage())).build());
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleException(final Exception e, final WebRequest request) {
		logger.error("Exception: {}", e);
		return ResponseEntity.badRequest().body(new LPOResponse.LPOResposeBuilder(true, e.getMessage()).build());
	}

	
}
