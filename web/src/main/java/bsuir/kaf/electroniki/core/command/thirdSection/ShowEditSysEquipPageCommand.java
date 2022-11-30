package bsuir.kaf.electroniki.core.command.thirdSection;

import java.util.List;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.model.Crits;
import bsuir.kaf.electroniki.model.User;
import bsuir.kaf.electroniki.service.CritsServiceImpl;
import bsuir.kaf.electroniki.service.EntityService;
import bsuir.kaf.electroniki.service.MarkService;
import bsuir.kaf.electroniki.service.MarkServiceImpl;
import bsuir.kaf.electroniki.service.UserServiceImpl;

public class ShowEditSysEquipPageCommand implements Command {

    private final RequestFactory requestFactory;

    private final EntityService<User> userService;

    private final MarkService markService;

    private final EntityService<Crits> critsService;

    public ShowEditSysEquipPageCommand(EntityService<User> userService, MarkService markService, EntityService<Crits> critsService) {
        this.requestFactory = RequestFactory.getInstance();
        this.userService = userService;
        this.markService = markService;
        this.critsService = critsService;
    }

    @Override
    public CommandResponse execute(CommandRequest request) {

        List<Crits> crits = critsService.findAll();
        crits.remove(0);

        for (int i = 0; i < crits.size(); i++) {
            request.addAttributeToJsp("mark" + i, markService.findMarksByCrit(crits.get(i).getId()));
        }

        request.addAttributeToJsp("unitId", request.getParameter("unitId"));
        request.addAttributeToJsp("sysEquipId", request.getParameter("sysEquipId"));
        request.addAttributeToJsp("sysEquipName", request.getParameter("sysEquipName"));
        request.addAttributeToJsp("users", userService.findAll());
        request.addAttributeToJsp("kks", request.getParameter("kks"));
        request.addAttributeToJsp("crits", crits);

        return requestFactory.createForwardResponse(PagePaths.EDIT_SYS_EQUIP);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowEditSysEquipPageCommand getInstance() {
        return ShowEditSysEquipPageCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowEditSysEquipPageCommand INSTANCE =
            new ShowEditSysEquipPageCommand(UserServiceImpl.getInstance(), MarkServiceImpl.getInstance(), CritsServiceImpl.getInstance());
    }
}
