package top.werls.vben.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author leejiawei
 * @version TODO
 * @since on  2022/2/8
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("execution(public * top.werls.vben.*.controller.*.*(..))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("before class: {}", joinPoint.getSignature().getDeclaringType());
        log.info("before method: {}", joinPoint.getSignature().getName());
    }
    @After("logPointCut()")
    public void after(JoinPoint joinPoint) {
        log.info("after class: {}", joinPoint.getSignature().getDeclaringType());
        log.info("after method: {}", joinPoint.getSignature().getName());
    }
}
