package bsuir.kaf.electroniki.core.command;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;

public class ShowMainPage implements Command {

    private final RequestFactory requestFactory;

    public ShowMainPage() {
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
               return requestFactory.createForwardResponse(PagePaths.MAIN);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowMainPage getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowMainPage INSTANCE =
            new ShowMainPage();
    }
}
