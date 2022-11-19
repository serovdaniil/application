package bsuir.kaf.electroniki.core.command;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.model.SafInd;
import bsuir.kaf.electroniki.service.EntityService;
import bsuir.kaf.electroniki.service.SafIndServiceImpl;

public class ShowSecondPowerUnitPage implements Command {

    private final RequestFactory requestFactory;

    private final EntityService<SafInd> service;

    public ShowSecondPowerUnitPage(EntityService<SafInd> service) {
        this.service = service;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        request.addAttributeToJsp("safInds", service.findAll());
        return requestFactory.createForwardResponse(PagePaths.SECOND_POWER_UNIT_PAGE);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowSecondPowerUnitPage getInstance() {
        return ShowSecondPowerUnitPage.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowSecondPowerUnitPage INSTANCE =
            new ShowSecondPowerUnitPage(SafIndServiceImpl.getInstance());
    }
}
