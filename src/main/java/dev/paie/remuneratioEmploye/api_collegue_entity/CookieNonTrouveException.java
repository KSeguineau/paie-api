package dev.paie.remuneratioEmploye.api_collegue_entity;

public class CookieNonTrouveException extends RuntimeException{

    public CookieNonTrouveException() {
    }

    public CookieNonTrouveException(String message) {
        super(message);
    }

    public CookieNonTrouveException(String message, Throwable cause) {
        super(message, cause);
    }

    public CookieNonTrouveException(Throwable cause) {
        super(cause);
    }

    public CookieNonTrouveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
