package bsuir.kaf.electroniki.api.controller;

import javax.servlet.http.HttpServletRequest;

import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.core.command.CommandRegistry;
import bsuir.kaf.electroniki.core.controller.PagePaths;
import bsuir.kaf.electroniki.core.controller.SimpleRequestFactory;

/**
 * The interface contains methods for creating responses, namely forward response and redirect response.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
public interface RequestFactory {

    /**
     * Request creation method.
     *
     * @param request object HttpServletRequest
     * @return CommandRequest interface for further processing
     */
    CommandRequest createRequest(HttpServletRequest request);

    /**
     * Method for creating a response to a forward response.
     *
     * @param page the transition page
     * @return interface CommandResponse
     */
    CommandResponse createForwardResponse(PagePaths page);

    /**
     * Method for creating a response to a redirect response request.
     *
     * @param page the transition page
     * @return interface CommandResponse
     */
    CommandResponse createRedirectResponse(CommandRegistry page);

    /**
     * Getting a single instance of the class.
     *
     * @return the instance
     */
    static RequestFactory getInstance() {
        return SimpleRequestFactory.INSTANCE;
    }
}
