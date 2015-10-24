package com.napmir.telegram.exception;

public class TGException extends Exception{

	private static final long serialVersionUID = 1471480082264172219L;
	
	public TGException(final Exception exception){
		super(exception);
	}
	
	public TGException(final String message){
		super(message);
	}

}
