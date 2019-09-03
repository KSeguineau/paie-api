package dev.paie.exception;

public class GradeInconnu extends RuntimeException {
    public GradeInconnu() {
    }

    public GradeInconnu(String message) {
        super(message);
    }

    public GradeInconnu(String message, Throwable cause) {
        super(message, cause);
    }

    public GradeInconnu(Throwable cause) {
        super(cause);
    }

    public GradeInconnu(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
