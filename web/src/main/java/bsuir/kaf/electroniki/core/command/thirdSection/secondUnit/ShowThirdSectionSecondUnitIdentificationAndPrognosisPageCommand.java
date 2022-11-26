package bsuir.kaf.electroniki.core.command.thirdSection.secondUnit;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.model.SafInd;
import bsuir.kaf.electroniki.service.EntityService;
import bsuir.kaf.electroniki.service.SafIndServiceImpl;

public class ShowThirdSectionSecondUnitIdentificationAndPrognosisPageCommand implements Command {

    private final RequestFactory requestFactory;

    private final EntityService<SafInd> service;

    public ShowThirdSectionSecondUnitIdentificationAndPrognosisPageCommand(EntityService<SafInd> service) {
        this.service = service;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        request.addAttributeToJsp("safInds", service.findAll());

        return requestFactory.createForwardResponse(PagePaths.THIRD_SECTION_SECOND_UNIT_IDENTIFICATION_AND_PROGNOSIS);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowThirdSectionSecondUnitIdentificationAndPrognosisPageCommand getInstance() {
        return ShowThirdSectionSecondUnitIdentificationAndPrognosisPageCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowThirdSectionSecondUnitIdentificationAndPrognosisPageCommand INSTANCE =
            new ShowThirdSectionSecondUnitIdentificationAndPrognosisPageCommand(SafIndServiceImpl.getInstance());
    }
}