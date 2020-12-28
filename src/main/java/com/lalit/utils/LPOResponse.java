package com.lalit.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;


public class LPOResponse {

	boolean error;
	String message;
	Date timestamp;
	Map<String, Object> response = new HashMap<String, Object>();

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

	public LPOResponse(LPOResposeBuilder builder) {
		this.error = builder.error;
		this.message = builder.message;
		this.timestamp = builder.timestamp;

		if (builder.data==null) {
			this.response.put("data", null);
			this.response.put("size", 0);
		}else {
			this.response.put("data", builder.data);
			this.response.put("size", builder.size);
		}
	}

	public static class LPOResposeBuilder {
		boolean error;
		String message;
		Date timestamp;

//		int statusCode;
		Object data;
		int size;

		public LPOResposeBuilder(boolean error, String message) {
			this.error = error;
			this.message = message;
			this.timestamp = new Date();
//			this.statusCode = statusCode.value();
		}
		public LPOResposeBuilder( String message, HttpStatus statusCode) {
			this.error = false;
			this.message = message;
			this.timestamp = new Date();
//			this.statusCode = statusCode.value();
		}

		public LPOResposeBuilder data(Object data, int size) {
			this.data = data;
			this.size = size;
			return this;
		}

		public LPOResponse build() {

			return new LPOResponse(this);
		}

		public LPOResponse error() {

			return new LPOResponse(this);
		}
	}
}
