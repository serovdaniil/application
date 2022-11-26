package bsuir.kaf.electroniki.core.command.thirdSection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.model.SafVal;
import bsuir.kaf.electroniki.model.Trend;
import bsuir.kaf.electroniki.model.User;
import bsuir.kaf.electroniki.service.SafValService;
import bsuir.kaf.electroniki.service.SafValServiceImpl;
import bsuir.kaf.electroniki.service.TrendService;
import bsuir.kaf.electroniki.service.TrendServiceImpl;

public class CreateNewTrendCommand implements Command {

    private final TrendService service;

    private final RequestFactory requestFactory;

    public CreateNewTrendCommand(TrendService employeeService) {
        this.service = employeeService;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        Trend entity = new Trend(
            1L,
            LocalDate.now(),
            Year.parse(request.getParameter("year")),
            new User(Long.parseLong(request.getParameter("iserId"))),
            Long.parseLong(request.getParameter("unitId")),
            Long.parseLong(request.getParameter("safIndId"))
        );
        service.create(entity);

        request.addAttributeToJsp("unitId", request.getParameter("unitId"));
        request.addAttributeToJsp("safIndId", request.getParameter("safIndId"));
        request.addAttributeToJsp("safIndName", request.getParameter("safIndName"));

        return requestFactory.createForwardResponse(PagePaths.EDIT_TREND);

    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static CreateNewTrendCommand getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {

        public static final CreateNewTrendCommand INSTANCE =
            new CreateNewTrendCommand(TrendServiceImpl.getInstance());
    }
}