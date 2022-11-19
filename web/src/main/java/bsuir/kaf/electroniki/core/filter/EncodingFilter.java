package bsuir.kaf.electroniki.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Filter for setting data encoding.
 *
 * @author Daniil Serov
 * @version 20220504-1
 * @since 20220303-1
 */
@WebFilter(filterName = "Encoding", urlPatterns = {"/*"}, initParams = {
    @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param")})
public class EncodingFilter implements Filter {

    /**
     * A string that contains the name of the encoding.
     */
    private String code;

    @Override
    public void init(FilterConfig fConfig) {
        code = fConfig.getInitParameter("encoding");
    }

    /**
     * Filtering method.
     *
     * @param request object ServletRequest
     * @param response object ServletResponse
     * @param chain object FilterChain
     * @throws IOException exception
     * @throws ServletException exception
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        String codeRequest = request.getCharacterEncoding();
        if (codeRequest == null || !codeRequest.equalsIgnoreCase(code)) {
            request.setCharacterEncoding(code);
        }
        String codeResponse = response.getCharacterEncoding();
        if (codeResponse == null || !codeResponse.equalsIgnoreCase(code)) {
            response.setCharacterEncoding(code);
        }
        chain.doFilter(request, response);
    }
}
