package com.example.SocialProjectYoutube.annotations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Slf4j
@Aspect
public class MeasureExecutionTimeAspect {
    @Around("@annotation(com.example.SocialProjectYoutube.annotations.MeasureExecutionTime)")
    public Object measureTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = proceedingJoinPoint.proceed();
        stopWatch.stop();
        log.info("Method [{}] took [{}] ms", proceedingJoinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
        return proceed;
    }
}
