package bsuir.kaf.electroniki.core.command.firstAndSecondSection;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;

public class ShowEditSafIndPage implements Command {

    private final RequestFactory requestFactory;

    public ShowEditSafIndPage() {
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        request.addAttributeToJsp("unitId", request.getParameter("unitId"));
        request.addAttributeToJsp("safIndId", request.getParameter("safIndId"));
        request.addAttributeToJsp("safIndName", request.getParameter("safIndName"));
        request.addAttributeToJsp("meas", request.getParameter("meas"));

        return requestFactory.createForwardResponse(PagePaths.EDIT_CRITERIA);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowEditSafIndPage getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowEditSafIndPage INSTANCE =
            new ShowEditSafIndPage();
    }
}
