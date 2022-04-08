package com.emindsblogapplication.exception;

public class DataAlreadyExistsException extends Exception{
    public DataAlreadyExistsException() {
        super();
    }

    public DataAlreadyExistsException(String message) {
        super(message);
    }

    public DataAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected DataAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
