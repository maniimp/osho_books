package com.osho.common;

public class MyFileNotFoundException extends RuntimeException{
	
	public MyFileNotFoundException(String exception)
	{
		super(exception);
	}
	
	public MyFileNotFoundException(String exception, Throwable cause)
	{
		super(exception,cause);
	}

}
