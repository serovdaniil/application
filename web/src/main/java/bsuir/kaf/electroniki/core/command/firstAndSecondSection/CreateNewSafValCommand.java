package bsuir.kaf.electroniki.core.command.firstAndSecondSection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.model.SafVal;
import bsuir.kaf.electroniki.model.User;
import bsuir.kaf.electroniki.service.SafValService;
import bsuir.kaf.electroniki.service.SafValServiceImpl;

public class CreateNewSafValCommand implements Command {

    private final SafValService service;

    private final RequestFactory requestFactory;

    public CreateNewSafValCommand(SafValService employeeService) {
        this.service = employeeService;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        SafVal entity = new SafVal(
            1L,
            LocalDate.now(),
            Year.parse(request.getParameter("year")),
            new BigDecimal(request.getParameter("value")),
            new User(Long.parseLong(request.getParameter("iserId"))),
            Long.parseLong(request.getParameter("unitId")),
            Long.parseLong(request.getParameter("safIndId"))
        );
        service.create(entity);

        request.addAttributeToJsp("unitId", request.getParameter("unitId"));
        request.addAttributeToJsp("safIndId", request.getParameter("safIndId"));
        request.addAttributeToJsp("safIndName", request.getParameter("safIndName"));

        return requestFactory.createForwardResponse(PagePaths.EDIT_CRITERIA);

    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static CreateNewSafValCommand getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {

        public static final CreateNewSafValCommand INSTANCE =
            new CreateNewSafValCommand(SafValServiceImpl.getInstance());
    }
}