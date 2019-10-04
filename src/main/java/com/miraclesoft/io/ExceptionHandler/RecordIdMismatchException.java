package com.miraclesoft.io.ExceptionHandler;

public class RecordIdMismatchException extends RuntimeException {
	  public RecordIdMismatchException() {
	        super();
	    }

	    public RecordIdMismatchException(final String message, final Throwable cause) {
	        super(message, cause);
	    }

	    public RecordIdMismatchException(final String message) {
	        super(message);
	    }

	    public RecordIdMismatchException(final Throwable cause) {
	        super(cause);
	    }
}
