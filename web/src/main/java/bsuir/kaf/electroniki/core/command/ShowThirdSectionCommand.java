package bsuir.kaf.electroniki.core.command;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.service.SafValServiceImpl;

public class ShowThirdSectionCommand implements Command {

    private final RequestFactory requestFactory;

    public ShowThirdSectionCommand() {
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        request.addAttributeToJsp(
            "safVals", SafValServiceImpl.getInstance().findAllValueForUnitAndIndicator(
                1, 1)
        );

        System.out.println(SafValServiceImpl.getInstance().findAllValueForUnitAndIndicator(
            1, 1).size());
        return requestFactory.createForwardResponse(PagePaths.THIRD_SECTION);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowThirdSectionCommand getInstance() {
        return ShowThirdSectionCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowThirdSectionCommand INSTANCE =
            new ShowThirdSectionCommand();
    }
}
