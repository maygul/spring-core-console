package org.ptt.spring.aspect.listener;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class NotifierAspect {

    private static final Logger log = Logger.getLogger(NotifierAspect.class.getName());

    /*
        @Before("execution(* org.ptt.spring.service.impl.*.notify(..))")
        public void beforeNotifyLogging(JoinPoint joinPoint) {
            log.info("Before notify: Kind :" + joinPoint.getKind());
            log.info("Before notify: Signature :" + joinPoint.getSignature());
            log.info("Before notify: Source Location :" + joinPoint.getSourceLocation());
            log.info("Before notify: Static Part :" + joinPoint.getStaticPart());
            log.info("Before notify: Target :" + joinPoint.getTarget());
            log.info("Before notify: This :" + joinPoint.getThis());
            log.info("Before notify: Args :" + joinPoint.getArgs()[0]);
            log.info("Before notify: Declaring Type :" + joinPoint.getSignature().getDeclaringType());
            log.info("Before notify: Declaring Type Name :" + joinPoint.getSignature().getDeclaringTypeName());
            log.info("Before notify: Name :" + joinPoint.getSignature().getName());
            log.info("Before notify: Modifiers :" + joinPoint.getSignature().getModifiers());
            log.info("Before notify: Signature Class :" + joinPoint.getSignature().getClass());
        }

        @After("execution(* org.ptt.spring.service.impl.*.notify(..))")
        public void afterNotifyLogging(JoinPoint joinPoint) {
            log.info("After notify: Kind :" + joinPoint.getKind());
            log.info("After notify: Signature :" + joinPoint.getSignature());
            log.info("After notify: Source Location :" + joinPoint.getSourceLocation());
            log.info("After notify: Static Part :" + joinPoint.getStaticPart());
            log.info("After notify: Target :" + joinPoint.getTarget());
            log.info("After notify: This :" + joinPoint.getThis());
            log.info("After notify: Args :" + joinPoint.getArgs()[0]);
            log.info("After notify: Declaring Type :" + joinPoint.getSignature().getDeclaringType());
            log.info("After notify: Declaring Type Name :" + joinPoint.getSignature().getDeclaringTypeName());
            log.info("After notify: Name :" + joinPoint.getSignature().getName());
            log.info("After notify: Modifiers :" + joinPoint.getSignature().getModifiers());
            log.info("After notify: Signature Class :" + joinPoint.getSignature().getClass());
        }
    */
    @Around("execution(* org.ptt.spring.service.impl.*.notify(..))")
    public Object aroundNotifyLogging(ProceedingJoinPoint joinPoint) throws Throwable {

        long startDate = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startDate;

        log.info("Around notify: Take to time finish :" + executionTime);

        return proceed;
    }

    @Around("execution(* org.ptt.spring.service.impl.TwitterNotifier.aopNotifyExample(..))")
    public Object aroundAopNotifyExample(ProceedingJoinPoint joinPoint) throws Throwable {
        String message = (String) joinPoint.getArgs()[0];

        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message is null or empty");
        } else {
            return joinPoint.proceed();
        }

    }

    @Around("within(org.ptt.spring.service.UselessBean)")
    public Object aroundUselessBean(ProceedingJoinPoint joinPoint) throws Throwable {
        long startDate = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startDate;

        log.info("Around notify: Take to time finish :" + executionTime);

        return proceed;
    }
}
