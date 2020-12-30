package com.lalit.exception;


public class DataAlreadyExistException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataAlreadyExistException(String msg) {
		super(msg);
	}

	public static DataAlreadyExistException of(String msg) {
		return new DataAlreadyExistException(msg);
	}

}
