package bsuir.kaf.electroniki.core.controller;

import java.util.Objects;

import bsuir.kaf.electroniki.api.command.CommandResponse;

/**
 * The class implements the Command Response interface.
 *
 * @author Daniil Serov
 */
public class PlainCommandResponse implements CommandResponse {

    /**
     * Depending on the type of request.
     */
    private final boolean redirect;

    /**
     * Link path.
     */
    private final String path;

    /**
     * Constructor for creating an object.
     *
     * @param path link path
     */
    public PlainCommandResponse(String path) {
        this(false, path);
    }

    /**
     * Constructor for creating an object.
     *
     * @param redirect depending on the type of request
     * @param path     link path
     */
    public PlainCommandResponse(boolean redirect, String path) {
        this.redirect = redirect;
        this.path = path;
    }

    @Override
    public boolean isRedirect() {
        return redirect;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlainCommandResponse that = (PlainCommandResponse) o;
        return redirect == that.redirect && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(redirect, path);
    }

    @Override
    public String toString() {
        return "PlainCommandResponse{" +
            "redirect=" + redirect +
            ", path='" + path + '\'' +
            '}';
    }
}
