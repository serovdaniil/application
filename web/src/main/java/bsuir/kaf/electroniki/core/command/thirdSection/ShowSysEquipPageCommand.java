package bsuir.kaf.electroniki.core.command.thirdSection;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.service.SysEquipService;
import bsuir.kaf.electroniki.service.SysEquipServiceImpl;

public class ShowSysEquipPageCommand implements Command {

    private final SysEquipService service;

    private final RequestFactory requestFactory;

    public ShowSysEquipPageCommand(SysEquipService service) {
        this.service = service;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {

        request.addAttributeToJsp(
            "sysEquips", service.findSysEquipForIdUnit(Long.parseLong(request.getParameter("idUnit")))
        );
        request.addAttributeToJsp("idUnit", request.getParameter("idUnit"));

        return requestFactory.createForwardResponse(PagePaths.SYS_EQUIP);

    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowSysEquipPageCommand getInstance() {
        return ShowSysEquipPageCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowSysEquipPageCommand INSTANCE =
            new ShowSysEquipPageCommand(SysEquipServiceImpl.getInstance());
    }
}