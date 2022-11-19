package bsuir.kaf.electroniki.core.command;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.controller.PagePaths;

public class ShowAuthorizedPage implements Command {

    private final RequestFactory requestFactory;

    public ShowAuthorizedPage() {
        this.requestFactory = RequestFactory.getInstance();
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        return requestFactory.createForwardResponse(PagePaths.AUTHORIZED_PAGE);
    }

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    public static ShowAuthorizedPage getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {

        public static final ShowAuthorizedPage INSTANCE =
            new ShowAuthorizedPage();
    }
}
