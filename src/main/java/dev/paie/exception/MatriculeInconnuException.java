package dev.paie.exception;

public class MatriculeInconnuException extends RuntimeException {

    public MatriculeInconnuException() {
    }

    public MatriculeInconnuException(String message) {
        super(message);
    }

    public MatriculeInconnuException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatriculeInconnuException(Throwable cause) {
        super(cause);
    }

    public MatriculeInconnuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
