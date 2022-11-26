package bsuir.kaf.electroniki.core.command;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.core.command.firstAndSecondSection.CreateNewSafValCommand;
import bsuir.kaf.electroniki.core.command.firstAndSecondSection.ShowDiagramSafValCommand;
import bsuir.kaf.electroniki.core.command.firstAndSecondSection.ShowEditSafIndPage;
import bsuir.kaf.electroniki.core.command.firstAndSecondSection.ShowTableSafValCommand;
import bsuir.kaf.electroniki.core.command.firstAndSecondSection.firstSection.ShowFirstPowerUnitPage;
import bsuir.kaf.electroniki.core.command.firstAndSecondSection.secondSection.ShowSecondPowerUnitPage;
import bsuir.kaf.electroniki.core.command.thirdSection.CreateNewTrendCommand;
import bsuir.kaf.electroniki.core.command.thirdSection.ShowDiagramTrendCommand;
import bsuir.kaf.electroniki.core.command.thirdSection.ShowEditTrendPage;
import bsuir.kaf.electroniki.core.command.thirdSection.ShowTableTrendCommand;
import bsuir.kaf.electroniki.core.command.thirdSection.ShowThirdSectionCommand;
import bsuir.kaf.electroniki.core.command.thirdSection.firstUnit.ShowThirdSectionFirstUnitIdentificationAndPrognosisPageCommand;
import bsuir.kaf.electroniki.core.command.thirdSection.firstUnit.ShowThirdSectionFirstUnitCommand;
import bsuir.kaf.electroniki.core.command.thirdSection.secondUnit.ShowThirdSectionSecondUnitCommand;
import bsuir.kaf.electroniki.core.command.thirdSection.secondUnit.ShowThirdSectionSecondUnitIdentificationAndPrognosisPageCommand;

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

    EDIT_PAGE(ShowEditSafIndPage.getInstance(), "edit_saf_val"),

    FIRST_POWER_UNIT_PAGE(ShowFirstPowerUnitPage.getInstance(), "show_first_power_unit"),

    SECOND_POWER_UNIT_PAGE(ShowSecondPowerUnitPage.getInstance(), "show_second_power_unit"),

    THIRD_SECTION(ShowThirdSectionCommand.getInstance(), "third_section"),

    THIRD_SECTION_FIRST_UNIT(ShowThirdSectionFirstUnitCommand.getInstance(), "third_section_first_unit"),

    THIRD_SECTION_SECOND_UNIT(ShowThirdSectionSecondUnitCommand.getInstance(), "third_section_second_unit"),

    THIRD_SECTION_FIRST_UNIT_IDENTIFICATION_AND_PROGNOSIS(ShowThirdSectionFirstUnitIdentificationAndPrognosisPageCommand.getInstance(), "third_section_first_unit_identification_and_prognosis"),

    THIRD_SECTION_SECOND_UNIT_IDENTIFICATION_AND_PROGNOSIS(ShowThirdSectionSecondUnitIdentificationAndPrognosisPageCommand.getInstance(), "third_section_second_unit_identification_and_prognosis"),

    EDIT_TREND(ShowEditTrendPage.getInstance(), "edit_trend"),

    CREATE_TREND(CreateNewTrendCommand.getInstance(), "create_trend"),

    SHOW_TABLE_FOR_TREND(ShowTableTrendCommand.getInstance(), "show_table_for_trend"),

    SHOW_DIAGRAM_FOR_TREND(ShowDiagramTrendCommand.getInstance(), "show_diagram_for_trend"),

    ADD_SAF_VAL(CreateNewSafValCommand.getInstance(), "add_saf_val"),

    SHOW_TABLE_FOR_SAF_VAL(ShowTableSafValCommand.getInstance(), "show_table_for_saf_val"),

    SHOW_DIAGRAM_FOR_SAF_VAL(ShowDiagramSafValCommand.getInstance(), "show_diagram_for_saf_val"),

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
