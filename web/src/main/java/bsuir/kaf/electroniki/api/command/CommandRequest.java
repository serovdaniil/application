package bsuir.kaf.electroniki.api.command;

/**
 * An interface that contains methods for processing receiving/transmitting data in a request.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
public interface CommandRequest {

    /**
     * Adds data in response to a request.
     *
     * @param name      Name of the object to add
     * @param attribute the object itself
     */
    void addAttributeToJsp(String name, Object attribute);

    /**
     * Retrieves data from a query by name.
     *
     * @param name of the object to receive data
     * @return an object in the form of a string
     */
    String getParameter(String name);

    /**
     * The method get data from attributes.
     *
     * @param nameAttribute name of the attribute parameter
     *
     * @return the id employee
     */
    long getEntityId(String nameAttribute);
    /**
     * The method adds an object to the session.
     *
     * @param name name object in session
     * @param value object
     * @return true or false
     */
    boolean addToSession(String name, Object value);

    /**
     * The method removes an object by its name from the session.
     *
     * @param name name object in session
     */
    void removeAttributeInSession(String name);

    /**
     * The method creates a session.
     */
    void createSession();
}
