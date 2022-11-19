package bsuir.kaf.electroniki.core.command;

import bsuir.kaf.electroniki.api.command.Command;

/**
 * A set containing the name of the commands and the classes implementing them.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
public enum CommandRegistry {

    PROJECT_PAGE(ShowMainPage.getInstance(), "main"),

    SECOND_PAGE(ShowAuthorizedPage.getInstance(), "second"),

    EDIT_PAGE(ShowEditSafIndPage.getInstance(), "edit"),

    FIRST_POWER_UNIT_PAGE(ShowFirstPowerUnitPage.getInstance(), "show_first_power_unit"),

    SECOND_POWER_UNIT_PAGE(ShowSecondPowerUnitPage.getInstance(), "show_second_power_unit"),

    DEFAULT(ShowMainPage.getInstance(), "");

    /**
     * command name.
     */
    private final Command command;

    /**
     * command path.
     */
    private final String path;

    /**
     * Constructor for creating an object.
     *
     * @param command command name
     * @param path    command path
     */
    CommandRegistry(Command command, String path) {
        this.command = command;
        this.path = path;
    }

    public Command getCommand() {
        return command;
    }

    public String getPath() {
        return path;
    }

    /**
     * The method searches for execution classes of a specific command by its name.
     *
     * @param name the name of the command to search for the corresponding execution class
     * @return interface Command
     */
    public static Command of(String name) {
        for (CommandRegistry constant : values()) {
            if (constant.path.equalsIgnoreCase(name)) {
                return constant.command;
            }
        }
        return DEFAULT.command;
    }
}
