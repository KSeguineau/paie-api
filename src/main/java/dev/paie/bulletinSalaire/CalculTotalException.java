package dev.paie.bulletinSalaire;

public class CalculTotalException extends RuntimeException {
    public CalculTotalException() {
    }

    public CalculTotalException(String message) {
        super(message);
    }

    public CalculTotalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculTotalException(Throwable cause) {
        super(cause);
    }

    public CalculTotalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
