package top.werls.springboottemplate.system.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.werls.springboottemplate.common.ResultData;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * @author leejiawei
 * @version TODO
 * @since on  2022/2/8
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultData<String > defaultExceptionHandler(Exception e, HttpServletResponse response) {
        log.error("Exception:{}", e.getMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return ResultData.systemError();
    }
}
