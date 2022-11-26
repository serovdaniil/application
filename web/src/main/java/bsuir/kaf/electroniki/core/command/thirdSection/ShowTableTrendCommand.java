package bsuir.kaf.electroniki.core.command.thirdSection;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.service.TrendService;
import bsuir.kaf.electroniki.service.TrendServiceImpl;

public class ShowTableTrendCommand implements Command {

    private final TrendService service;

    private final RequestFactory requestFactory;

    public ShowTableTrendCommand(TrendService service) {
        this.service = service;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {

        request.addAttributeToJsp(
            "trends", service.findAllValueForUnitAndIndicator(
                Long.parseLong(request.getParameter("idUnit")), Long.parseLong(request.getParameter("idSafInd"))
            )
        );
        request.addAttributeToJsp("safIndName", request.getParameter("safIndName"));
        request.addAttributeToJsp("unitId", request.getParameter("unitId"));
        request.addAttributeToJsp("meas", request.getParameter("meas"));

        return requestFactory.createForwardResponse(PagePaths.TABLE_FOR_TREND);

    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowTableTrendCommand getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowTableTrendCommand INSTANCE =
            new ShowTableTrendCommand(TrendServiceImpl.getInstance());
    }
}