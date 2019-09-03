package dev.paie.exception;

public class MatriculeInconnu extends RuntimeException {

    public MatriculeInconnu() {
    }

    public MatriculeInconnu(String message) {
        super(message);
    }

    public MatriculeInconnu(String message, Throwable cause) {
        super(message, cause);
    }

    public MatriculeInconnu(Throwable cause) {
        super(cause);
    }

    public MatriculeInconnu(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
