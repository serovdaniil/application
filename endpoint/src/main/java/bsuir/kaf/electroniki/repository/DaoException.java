package bsuir.kaf.electroniki.repository;

/**
 * The error that is being caused in the dao layer.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
public class DaoException extends RuntimeException {

    /**
     * Error Call Constructor.
     *
     * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method).
     */
    public DaoException(Throwable cause) {
        super(cause);
    }

    /**
     * Error Call Constructor.
     *
     * @param message message exception name
     */
    public DaoException(String message) {
        super(message);
    }
}
