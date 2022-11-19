package bsuir.kaf.electroniki.core.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;
import bsuir.kaf.electroniki.core.command.CommandRegistry;

/**
 * A set that implements the RequestFactory interface.
 *
 * @author Daniil Serov
 */
public enum SimpleRequestFactory implements RequestFactory {

    INSTANCE;

    private final Map<String, CommandResponse> forwardResponseCache = new ConcurrentHashMap<>();
    private final Map<String, CommandResponse> redirectResponseCache = new ConcurrentHashMap<>();

    @Override
    public CommandRequest createRequest(HttpServletRequest request) {
        return new WrappingCommandRequest(request);
    }

    @Override
    public CommandResponse createForwardResponse(PagePaths page) {
        return forwardResponseCache.computeIfAbsent(page.getPath(), PlainCommandResponse::new);
    }

    @Override
    public CommandResponse createRedirectResponse(CommandRegistry page) {
        return redirectResponseCache.computeIfAbsent(page.getPath(), p -> new PlainCommandResponse(true, p));
    }
}
