package bsuir.kaf.electroniki.core.command.thirdSection;

import java.time.LocalDate;
import java.time.Year;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.model.Trend;
import bsuir.kaf.electroniki.model.User;
import bsuir.kaf.electroniki.service.EntityService;
import bsuir.kaf.electroniki.service.TrendService;
import bsuir.kaf.electroniki.service.TrendServiceImpl;
import bsuir.kaf.electroniki.service.UserServiceImpl;

public class CreateNewTrendCommand implements Command {

    private final TrendService service;

    private final EntityService<User> userService;

    private final RequestFactory requestFactory;

    public CreateNewTrendCommand(TrendService employeeService, EntityService<User> userService) {
        this.service = employeeService;
        this.userService = userService;
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
        request.addAttributeToJsp("users", userService.findAll());

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
            new CreateNewTrendCommand(TrendServiceImpl.getInstance(), UserServiceImpl.getInstance());
    }
}