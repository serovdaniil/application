package bsuir.kaf.electroniki.core.command.thirdSection;

import java.time.LocalDate;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.model.CurStatus;
import bsuir.kaf.electroniki.model.User;
import bsuir.kaf.electroniki.service.CurSysService;
import bsuir.kaf.electroniki.service.CurSysServiceImpl;

public class CreateCurStatusCommand implements Command {

    private final CurSysService curStatusEntityService;

    private final RequestFactory requestFactory;

    public CreateCurStatusCommand(CurSysService curStatusEntityService) {
        this.curStatusEntityService = curStatusEntityService;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        CurStatus entity = new CurStatus(
            LocalDate.now(),
            new User(
                Long.parseLong(request.getParameter("iserId"))),
            Long.parseLong(request.getParameter("sysEquipId"))
        );

        if (!request.getParameter("crit0").isEmpty()) {
            entity.setIdMark(Long.parseLong(request.getParameter("crit0")));
        }
        else if (!request.getParameter("crit1").isEmpty()) {
            entity.setIdMark(Long.parseLong(request.getParameter("crit1")));
        }
        else if (!request.getParameter("crit2").isEmpty()) {
            entity.setIdMark(Long.parseLong(request.getParameter("crit2")));
        }
        else if (!request.getParameter("crit3").isEmpty()) {
            entity.setIdMark(Long.parseLong(request.getParameter("crit3")));
        }
        else if (!request.getParameter("crit4").isEmpty()) {
            entity.setIdMark(Long.parseLong(request.getParameter("crit4")));
        }

        curStatusEntityService.create(entity);

        request.addAttributeToJsp("unitId", request.getParameter("unitId"));
        request.addAttributeToJsp("sysEquipId", request.getParameter("sysEquipId"));
        request.addAttributeToJsp("safIndId", request.getParameter("safIndId"));
        request.addAttributeToJsp("safIndName", request.getParameter("safIndName"));
        request.addAttributeToJsp("users", curStatusEntityService.findAll());

        return requestFactory.createForwardResponse(PagePaths.THIRD_SECTION);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static CreateCurStatusCommand getInstance() {
        return CreateCurStatusCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final CreateCurStatusCommand INSTANCE =
            new CreateCurStatusCommand(CurSysServiceImpl.getInstance());
    }
}