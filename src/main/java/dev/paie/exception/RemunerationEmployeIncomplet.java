package dev.paie.exception;

public class RemunerationEmployeIncomplet extends RuntimeException {
    public RemunerationEmployeIncomplet() {
    }

    public RemunerationEmployeIncomplet(String message) {
        super(message);
    }

    public RemunerationEmployeIncomplet(String message, Throwable cause) {
        super(message, cause);
    }

    public RemunerationEmployeIncomplet(Throwable cause) {
        super(cause);
    }

    public RemunerationEmployeIncomplet(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
