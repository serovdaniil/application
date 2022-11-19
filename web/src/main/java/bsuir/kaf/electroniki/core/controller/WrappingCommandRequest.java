package bsuir.kaf.electroniki.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bsuir.kaf.electroniki.api.command.CommandRequest;

/**
 * A class that implements the Command Request interface for working with the body of receiving/responding to a request.
 *
 * @author Daniil Serov
 */
public class WrappingCommandRequest implements CommandRequest {

    /**
     * Declarations of the HttpServletRequest object.
     */
    private final HttpServletRequest request;

    /**
     * Constructor for creating an object.
     *
     * @param request request object for creating a class object.
     */
    public WrappingCommandRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void addAttributeToJsp(String name, Object attribute) {
        request.setAttribute(name, attribute);
    }

    @Override
    public String getParameter(String name) {
        return request.getParameter(name);
    }

    @Override
    public long getEntityId(String nameAttribute) {
        return Long.parseLong(request.getParameter(nameAttribute));
    }


    @Override
    public boolean addToSession(String name, Object value) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute(name, value);
            return true;
        }
        return false;
    }

    @Override
    public void removeAttributeInSession(String name) {
        HttpSession session = request.getSession(false);
        session.removeAttribute(name);
    }

    @Override
    public void createSession() {
        request.getSession(true);
    }
}
