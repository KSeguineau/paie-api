package dev.paie.bulletinSalaire;

public class AccesInterditException extends RuntimeException {

    public AccesInterditException() {
    }

    public AccesInterditException(String message) {
        super(message);
    }

    public AccesInterditException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccesInterditException(Throwable cause) {
        super(cause);
    }

    public AccesInterditException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
