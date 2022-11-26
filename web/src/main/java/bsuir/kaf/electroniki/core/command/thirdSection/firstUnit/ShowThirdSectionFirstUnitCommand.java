package bsuir.kaf.electroniki.core.command.thirdSection.firstUnit;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;

public class ShowThirdSectionFirstUnitCommand implements Command {

    private final RequestFactory requestFactory;

    public ShowThirdSectionFirstUnitCommand() {
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {

        return requestFactory.createForwardResponse(PagePaths.THIRD_SECTION_FIRST_UNIT);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowThirdSectionFirstUnitCommand getInstance() {
        return ShowThirdSectionFirstUnitCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowThirdSectionFirstUnitCommand INSTANCE =
            new ShowThirdSectionFirstUnitCommand();
    }
}
