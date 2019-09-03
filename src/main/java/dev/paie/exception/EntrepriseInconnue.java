package dev.paie.exception;

public class EntrepriseInconnue extends RuntimeException {

    public EntrepriseInconnue() {
    }

    public EntrepriseInconnue(String message) {
        super(message);
    }

    public EntrepriseInconnue(String message, Throwable cause) {
        super(message, cause);
    }

    public EntrepriseInconnue(Throwable cause) {
        super(cause);
    }

    public EntrepriseInconnue(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
