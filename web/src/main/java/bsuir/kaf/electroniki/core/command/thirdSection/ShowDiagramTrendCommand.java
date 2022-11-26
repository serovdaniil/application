package bsuir.kaf.electroniki.core.command.thirdSection;

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
import bsuir.kaf.electroniki.model.Trend;
import bsuir.kaf.electroniki.service.SafValService;
import bsuir.kaf.electroniki.service.SafValServiceImpl;
import bsuir.kaf.electroniki.service.TrendService;
import bsuir.kaf.electroniki.service.TrendServiceImpl;

public class ShowDiagramTrendCommand implements Command {

    private final TrendService service;

    private final RequestFactory requestFactory;

    public ShowDiagramTrendCommand(TrendService service) {
        this.service = service;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        List<Trend> valList = service.findAllValueForUnitAndIndicator(
            Long.parseLong(request.getParameter("idUnit")), Long.parseLong(request.getParameter("idSafInd")));

        double maxValue = 0;

        for (Trend item : valList) {
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
                percentageSafVal.setPercentage(normalizeValue * 2.5);
                percentageSafVal.setHeight(300 - (normalizeValue * 2.5));

                return percentageSafVal;
            })
            .sorted(Comparator.comparing(PercentageSafVal::getPeriod))
            .collect(Collectors.toList());

        double wight = 500 / values.size() > 20
            ? 500 / values.size() < 80 ? 500 / values.size() : 80
            : 20;

        request.addAttributeToJsp("values", values);
        request.addAttributeToJsp("wight", wight);
        request.addAttributeToJsp("safIndName", request.getParameter("safIndName"));
        request.addAttributeToJsp("unitId", request.getParameter("unitId"));
        request.addAttributeToJsp("meas", request.getParameter("meas"));

        return requestFactory.createForwardResponse(PagePaths.DIAGRAM_FOR_TREND);

    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowDiagramTrendCommand getInstance() {
        return ShowDiagramTrendCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowDiagramTrendCommand INSTANCE =
            new ShowDiagramTrendCommand(TrendServiceImpl.getInstance());
    }
}