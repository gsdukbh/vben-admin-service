package top.werls.vben.system.exception;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.werls.vben.common.utils.ResultData;



/**
 * 全局异常处理
 *
 * @author leejiawei
 * @version TODO
 * @since on  2022/2/8
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultData<String> defaultExceptionHandler(Exception e, HttpServletResponse response) {
        log.error("Exception:{}", e.getMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return ResultData.systemError(e.getMessage());
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResultData<String> defaultExpiredJwtExceptionHandler(Exception e, HttpServletResponse response) {
        log.error("Exception:{}", e.getMessage());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return ResultData.systemError(e.getMessage());
    }
}
