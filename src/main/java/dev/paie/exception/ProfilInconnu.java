package dev.paie.exception;

public class ProfilInconnu extends RuntimeException {

    public ProfilInconnu() {
    }

    public ProfilInconnu(String message) {
        super(message);
    }

    public ProfilInconnu(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfilInconnu(Throwable cause) {
        super(cause);
    }

    public ProfilInconnu(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
