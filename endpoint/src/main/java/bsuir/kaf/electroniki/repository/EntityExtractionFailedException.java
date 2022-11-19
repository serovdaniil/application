package bsuir.kaf.electroniki.repository;

/**
 * An error that is caused when there are problems with data processing getting all the data in the database.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
public class EntityExtractionFailedException extends DaoException {

    /**
     * Error Call Constructor.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     */
    public EntityExtractionFailedException(String message) {
        super(message);
    }

    /**
     * Error Call Constructor.
     *
     * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method).
     */
    public EntityExtractionFailedException(Throwable cause) {
        super(cause);
    }
}
