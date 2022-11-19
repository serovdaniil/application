package bsuir.kaf.electroniki.api.command;


import bsuir.kaf.electroniki.core.command.CommandRegistry;

/**
 * The interface contains two methods that are used to process commands.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
public interface Command {

    /**
     * The method that serves to process the request from the client, namely,
     * performing the necessary actions with the database, redirecting to the desired page.
     *
     * @param request sending a request
     * @return interface CommandResponse
     */
    CommandResponse execute(CommandRequest request);

    /**
     * A method that searches for the desired class in the list by its short name.
     *
     * @param name the name of the team to search for a link to the team
     * @return the command
     */
    static Command of(String name) {
        return CommandRegistry.of(name);
    }
}
