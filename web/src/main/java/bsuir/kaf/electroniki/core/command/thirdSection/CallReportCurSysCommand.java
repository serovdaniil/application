package bsuir.kaf.electroniki.core.command.thirdSection;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.service.CurSysService;
import bsuir.kaf.electroniki.service.CurSysServiceImpl;

public class CallReportCurSysCommand implements Command {

    private final CurSysService curStatusEntityService;

    private final RequestFactory requestFactory;

    public CallReportCurSysCommand(CurSysService curStatusEntityService) {
        this.curStatusEntityService = curStatusEntityService;
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        curStatusEntityService.callReportCurSystem(Long.parseLong(request.getParameter("unitId")));

        return requestFactory.createForwardResponse(PagePaths.THIRD_SECTION);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static CallReportCurSysCommand getInstance() {
        return CallReportCurSysCommand.Holder.INSTANCE;
    }

    private static class Holder {

        public static final CallReportCurSysCommand INSTANCE =
            new CallReportCurSysCommand(CurSysServiceImpl.getInstance());
    }
}