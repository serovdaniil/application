package bsuir.kaf.electroniki.core.command.thirdSection;

import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.model.CurStatus;
import bsuir.kaf.electroniki.model.PercentageSafVal;
import bsuir.kaf.electroniki.model.Trend;
import bsuir.kaf.electroniki.service.CurSysService;
import bsuir.kaf.electroniki.service.CurSysServiceImpl;
import bsuir.kaf.electroniki.service.TrendService;
import bsuir.kaf.electroniki.service.TrendServiceImpl;

public class ShowDiagramCurStatusCommand implements Command {

    private final CurSysService service;

    private final RequestFactory requestFactory;

    public ShowDiagramCurStatusCommand(CurSysService service) {
        this.service = service;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        List<CurStatus> valList = service.findCurStatusBySystem(
            Long.parseLong(request.getParameter("idSystem"))
        );
        double maxValue = 0;

        for (CurStatus item : valList) {
            if (item.getDistant().doubleValue() > maxValue) {

                maxValue = item.getDistant().doubleValue();
            }
        }

        double finalMaxValue = maxValue;
        List<PercentageSafVal> values = valList.stream()
            .map(it -> {
                PercentageSafVal percentageSafVal = new PercentageSafVal();

                double normalizeValue = it.getDistant().doubleValue() / finalMaxValue * 100;

                percentageSafVal.setPeriod(Year.parse(it.getDate().toString().substring(0, 4)));
                percentageSafVal.setPercentage(normalizeValue * 2.5);
                percentageSafVal.setHeight(300 - (normalizeValue * 2.5));

                return percentageSafVal;
            })
            .sorted(Comparator.comparing(PercentageSafVal::getPeriod))
            .collect(Collectors.toList());
        double wight = 0;

        if (values.size() != 0) {
            wight = 500 / values.size() > 20
                ? 500 / values.size() < 80 ? 500 / values.size() : 80
                : 20;
        }

        request.addAttributeToJsp("values", values);
        request.addAttributeToJsp("wight", wight);
        request.addAttributeToJsp("safIndName", request.getParameter("safIndName"));
        request.addAttributeToJsp("unitId", request.getParameter("unitId"));
        request.addAttributeToJsp("meas", request.getParameter("meas"));

        return requestFactory.createForwardResponse(PagePaths.DIAGRAM_FOR_CUR_STATUS);

    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowDiagramCurStatusCommand getInstance() {
        return ShowDiagramCurStatusCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowDiagramCurStatusCommand INSTANCE =
            new ShowDiagramCurStatusCommand(CurSysServiceImpl.getInstance());
    }
}