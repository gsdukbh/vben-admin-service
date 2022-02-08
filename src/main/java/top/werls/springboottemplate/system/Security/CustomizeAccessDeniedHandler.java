package top.werls.springboottemplate.system.Security;


import com.google.gson.Gson;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import top.werls.springboottemplate.common.ResultData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * Handles an access denied failure.
     *
     * @param request               that resulted in an <code>AccessDeniedException</code>
     * @param response              so that the user agent can be advised of the failure
     * @param accessDeniedException that caused the invocation
     * @throws IOException      in the event of an IOException
     * @throws ServletException in the event of a ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Gson gson = new Gson();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(ResultData.notAuth(accessDeniedException.getMessage())));
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().flush();
    }
}
