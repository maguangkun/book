package com.mgk.account.book.modules.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 * Aop 记录日志等
 */
@Component
@Aspect
public class LogAop {
    private static Logger logger = Logger.getLogger("LogAop");
    @Pointcut("execution(* com.mgk.account.book.modules.*.controller.*.*(..))")
    public void logPointcut(){}

    // Before表示logAdvice将在目标方法执行前执行
    @Before("logPointcut()")
    public void beforeLog(JoinPoint joinPoint){
        // 这里只是一个示例，你可以写任何处理逻辑
        saveLog(joinPoint);
    }

    public void saveLog(JoinPoint joinPoint){
        LocalDateTime now = LocalDateTime.now();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        Object[] args = joinPoint.getArgs();
        String param="";
        for (int i = 0; i < args.length; i++) {
            param +="第" + (i+1) + "个参数为:" + args[i].toString()+",";
        }
        String str=String.format("时间【%s】，方法名称【%s】，类名【%s】，参数【%s】",now.toString(),methodName,className,param);
        logger.info(str);
    }
}
