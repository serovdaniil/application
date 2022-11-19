package bsuir.kaf.electroniki.service;

/**
 * The error that is being caused in the service layer.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
public class ServiceException extends RuntimeException {

    /**
     * Error Call Constructor.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Error Call Constructor.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     * @param cause   the cause (which is saved for later retrieval by the Throwable.getCause() method).
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Error Call Constructor.
     *
     * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method).
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
