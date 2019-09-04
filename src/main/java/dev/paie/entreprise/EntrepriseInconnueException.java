package dev.paie.entreprise;

public class EntrepriseInconnueException extends RuntimeException {

    public EntrepriseInconnueException() {
    }

    public EntrepriseInconnueException(String message) {
        super(message);
    }

    public EntrepriseInconnueException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntrepriseInconnueException(Throwable cause) {
        super(cause);
    }

    public EntrepriseInconnueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
