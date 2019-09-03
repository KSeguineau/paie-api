package dev.paie.exception;

public class GradeInconnuException extends RuntimeException {
    public GradeInconnuException() {
    }

    public GradeInconnuException(String message) {
        super(message);
    }

    public GradeInconnuException(String message, Throwable cause) {
        super(message, cause);
    }

    public GradeInconnuException(Throwable cause) {
        super(cause);
    }

    public GradeInconnuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
