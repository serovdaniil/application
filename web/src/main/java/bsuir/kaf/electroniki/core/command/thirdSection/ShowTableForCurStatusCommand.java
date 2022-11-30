package bsuir.kaf.electroniki.core.command.thirdSection;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.service.CurSysService;
import bsuir.kaf.electroniki.service.CurSysServiceImpl;

public class ShowTableForCurStatusCommand implements Command {

    private final CurSysService curStatusEntityService;

    private final RequestFactory requestFactory;

    public ShowTableForCurStatusCommand(CurSysService curStatusEntityService) {
        this.curStatusEntityService = curStatusEntityService;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {

        request.addAttributeToJsp("values",
            curStatusEntityService.findCurStatusBySystem(
                Long.parseLong(request.getParameter("idSystem"))
            )
        );
        request.addAttributeToJsp("unitId", request.getParameter("unitId"));
        request.addAttributeToJsp("sysEquipName", request.getParameter("sysEquipName"));
        request.addAttributeToJsp("kks", request.getParameter("kks"));

        return requestFactory.createForwardResponse(PagePaths.TABLE_FOR_CUR_STATUS);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowTableForCurStatusCommand getInstance() {
        return ShowTableForCurStatusCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowTableForCurStatusCommand INSTANCE =
            new ShowTableForCurStatusCommand(CurSysServiceImpl.getInstance());
    }
}