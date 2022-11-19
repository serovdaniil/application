package bsuir.kaf.electroniki.core.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bsuir.kaf.electroniki.api.command.Command;
import bsuir.kaf.electroniki.api.command.CommandRequest;
import bsuir.kaf.electroniki.api.command.CommandResponse;
import bsuir.kaf.electroniki.api.controller.RequestFactory;

/**
 * Servlet for working with requests/responses from the client.
 *
 * @author Daniil Serov
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

    /**
     * A string to search for a command in a query.
     */
    private static final String COMMAND_NAME_PARAM = "command";
    public static final String CONTROLLER_COMMAND_TO_PATH = "/controller?command=";

    /**
     * A RequestFactory object.
     */
    private final RequestFactory requestFactory = RequestFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        processRequest(httpRequest, httpResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        processRequest(httpRequest, httpResponse);
    }

    private void processRequest(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
        throws ServletException, IOException {

        String commandName = httpRequest.getParameter(COMMAND_NAME_PARAM);
        Command command = Command.of(commandName);
        CommandRequest commandRequest = requestFactory.createRequest(httpRequest);
        CommandResponse commandResponse = command.execute(commandRequest);
        proceedWithResponse(httpRequest, httpResponse, commandResponse);
    }

    private void proceedWithResponse(HttpServletRequest req, HttpServletResponse resp,
        CommandResponse commandResponse) throws ServletException, IOException {
        forwardOrRedirectToResponseLocation(req, resp, commandResponse);
    }

    private void forwardOrRedirectToResponseLocation(HttpServletRequest req, HttpServletResponse resp,
        CommandResponse commandResponse) throws IOException, ServletException {
        if (commandResponse.isRedirect()) {
            resp.sendRedirect(req.getContextPath() + CONTROLLER_COMMAND_TO_PATH + commandResponse.getPath());
        }
        else {
            String desiredPath = commandResponse.getPath();
            RequestDispatcher dispatcher = req.getRequestDispatcher(desiredPath);
            dispatcher.forward(req, resp);
        }
    }
}
