package dev.paie.remuneratioEmploye;

public class RemunerationEmployeIncompletException extends RuntimeException {
    public RemunerationEmployeIncompletException() {
    }

    public RemunerationEmployeIncompletException(String message) {
        super(message);
    }

    public RemunerationEmployeIncompletException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemunerationEmployeIncompletException(Throwable cause) {
        super(cause);
    }

    public RemunerationEmployeIncompletException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
