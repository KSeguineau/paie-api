package dev.paie.exception;

public class BulletionSalaireIncompletException extends RuntimeException {

    public BulletionSalaireIncompletException() {
    }

    public BulletionSalaireIncompletException(String message) {
        super(message);
    }

    public BulletionSalaireIncompletException(String message, Throwable cause) {
        super(message, cause);
    }

    public BulletionSalaireIncompletException(Throwable cause) {
        super(cause);
    }

    public BulletionSalaireIncompletException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
