package bsuir.kaf.electroniki.api.command;

/**
 * The interface contains two methods for checking the redirect and getting the path.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
public interface CommandResponse {

    /**
     * The method of checking for receiving a redirect.
     *
     * @return true or false depending on the operation
     */
    boolean isRedirect();

    /**
     * Method for getting the link.
     *
     * @return returns a link
     */
    String getPath();
}
