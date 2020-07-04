package com.osho.common;

public class FileStorageException extends RuntimeException{
	
	public FileStorageException(String exception)
	{
		super(exception);
	}
	
	public FileStorageException(String exception,Throwable cause)
	{
		super(exception,cause);
	}

}
