package bsuir.kaf.electroniki.core.command.thirdSection.secondUnit;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;

public class ShowThirdSectionSecondUnitCommand implements Command {

    private final RequestFactory requestFactory;

    public ShowThirdSectionSecondUnitCommand() {
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {

        return requestFactory.createForwardResponse(PagePaths.THIRD_SECTION_SECOND_UNIT);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowThirdSectionSecondUnitCommand getInstance() {
        return ShowThirdSectionSecondUnitCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowThirdSectionSecondUnitCommand INSTANCE =
            new ShowThirdSectionSecondUnitCommand();
    }
}
