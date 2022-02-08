package top.werls.springboottemplate.system.Security;


import com.google.gson.Gson;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import top.werls.springboottemplate.common.ResultData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author leee
 */
@Component
public class CustomizeAuthEntryPoint implements AuthenticationEntryPoint {
    /**
     * Commences an authentication scheme.
     * <p>
     * <code>ExceptionTranslationFilter</code> will populate the <code>HttpSession</code>
     * attribute named
     * <code>AbstractAuthenticationProcessingFilter.SPRING_SECURITY_SAVED_REQUEST_KEY</code>
     * with the requested target URL before calling this method.
     * <p>
     * Implementations should modify the headers on the <code>ServletResponse</code> as
     * necessary to commence the authentication process.
     *
     * @param request       that resulted in an <code>AuthenticationException</code>
     * @param response      so that the user agent can begin authentication
     * @param authException that caused the invocation
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        Gson gson = new Gson();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(gson.toJson(ResultData.notLogin(authException.getMessage())));
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().flush();
    }
}
