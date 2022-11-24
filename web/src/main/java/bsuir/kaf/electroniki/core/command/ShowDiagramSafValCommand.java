package bsuir.kaf.electroniki.core.command;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.model.PercentageSafVal;
import bsuir.kaf.electroniki.model.SafVal;
import bsuir.kaf.electroniki.service.SafValService;
import bsuir.kaf.electroniki.service.SafValServiceImpl;

public class ShowDiagramSafValCommand implements Command {

    private final SafValService service;

    private final RequestFactory requestFactory;

    public ShowDiagramSafValCommand(SafValService service) {
        this.service = service;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        List<SafVal> valList = service.findAllValueForUnitAndIndicator(
            Long.parseLong(request.getParameter("idUnit")), Long.parseLong(request.getParameter("idSafInd")));

        double maxValue = 0;

        for (SafVal item : valList) {
            if (item.getValue().doubleValue() > maxValue) {

                maxValue = item.getValue().doubleValue();
            }
        }

        double finalMaxValue = maxValue;
        List<PercentageSafVal> values = valList.stream()
            .map(it -> {
                PercentageSafVal percentageSafVal = new PercentageSafVal();

                double normalizeValue = it.getValue().doubleValue() / finalMaxValue * 100;

                percentageSafVal.setPeriod(it.getPeriod());
                percentageSafVal.setPercentage(normalizeValue);
                percentageSafVal.setHeight(300 - normalizeValue);

                return percentageSafVal;
            })
            .sorted(Comparator.comparing(PercentageSafVal::getPeriod))
            .collect(Collectors.toList());

        request.addAttributeToJsp("values", values);
        request.addAttributeToJsp("safIndName", request.getParameter("safIndName"));
        request.addAttributeToJsp("unitId", request.getParameter("unitId"));

        return requestFactory.createForwardResponse(PagePaths.DIAGRAM_FOR_SAF_VAL);

    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowDiagramSafValCommand getInstance() {
        return ShowDiagramSafValCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowDiagramSafValCommand INSTANCE =
            new ShowDiagramSafValCommand(SafValServiceImpl.getInstance());
    }
}