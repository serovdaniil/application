package bsuir.kaf.electroniki.core.command.firstAndSecondSection;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.service.SafValService;
import bsuir.kaf.electroniki.service.SafValServiceImpl;

public class ShowTableSafValCommand implements Command {

    private final SafValService service;

    private final RequestFactory requestFactory;

    public ShowTableSafValCommand(SafValService service) {
        this.service = service;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {

        request.addAttributeToJsp(
            "safVals", service.findAllValueForUnitAndIndicator(
                Long.parseLong(request.getParameter("idUnit")), Long.parseLong(request.getParameter("idSafInd"))
            )
        );
        request.addAttributeToJsp("safIndName", request.getParameter("safIndName"));
        request.addAttributeToJsp("unitId", request.getParameter("unitId"));
        request.addAttributeToJsp("meas", request.getParameter("meas"));

        return requestFactory.createForwardResponse(PagePaths.TABLE_FOR_SAF_VAL);

    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowTableSafValCommand getInstance() {
        return ShowTableSafValCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowTableSafValCommand INSTANCE =
            new ShowTableSafValCommand(SafValServiceImpl.getInstance());
    }
}