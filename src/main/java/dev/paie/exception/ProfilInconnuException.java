package dev.paie.exception;

public class ProfilInconnuException extends RuntimeException {

    public ProfilInconnuException() {
    }

    public ProfilInconnuException(String message) {
        super(message);
    }

    public ProfilInconnuException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfilInconnuException(Throwable cause) {
        super(cause);
    }

    public ProfilInconnuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
