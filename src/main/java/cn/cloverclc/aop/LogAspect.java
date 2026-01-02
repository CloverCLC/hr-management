package cn.cloverclc.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/**
 * Spring AOP 日志切面类
 * 用于记录控制器/业务层方法的执行日志
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    /**
     * 定义切入点：指定拦截的目标方法范围
     * 示例1：拦截所有Controller层方法（com.example.demo.controller包下所有类的所有方法）
     * 示例2：拦截指定注解标记的方法（可自定义注解，灵活性更高）
     * 示例3：拦截所有Service层方法（com.example.demo.service包下所有类的所有方法）
     */
    @Pointcut("@annotation(cn.cloverclc.annotation.LogRecord)")
    public void logPointcut() {
        // 切入点方法无需实现业务逻辑，仅用于标记切入点0
    }

    /**
     * 前置通知：目标方法执行前执行
     * @param joinPoint 连接点：封装了目标方法的信息
     */
    @Before("logPointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        // 获取HTTP请求对象（仅Controller层有效，Service层无请求对象）
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            // 记录请求基本信息
            log.info("请求URL：{}", request.getRequestURL());
            log.info("请求方式：{}", request.getMethod());
        }
        // 记录目标方法信息
        log.info("目标类名：{}", joinPoint.getTarget().getClass().getName());
        log.info("目标方法名：{}", joinPoint.getSignature().getName());
        log.info("方法参数：{}", Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 环绕通知：目标方法执行前后均可增强，可控制目标方法是否执行，还能捕获异常
     * 核心用途：记录方法执行耗时
     * @param proceedingJoinPoint 可执行的连接点（独有，支持执行目标方法）
     * @return 目标方法的返回结果
     * @throws Throwable 目标方法抛出的异常
     */
    @Around("logPointcut()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 记录方法开始时间
        long startTime = System.currentTimeMillis();

        // 执行目标方法（必须调用，否则目标方法不会执行）
        Object result = proceedingJoinPoint.proceed();

        // 记录方法执行耗时
        long costTime = System.currentTimeMillis() - startTime;
        log.info("目标方法执行耗时：{} 毫秒", costTime);

        // 返回目标方法的执行结果
        return result;
    }

    /**
     * 后置通知：目标方法执行后执行（无论是否发生异常）
     * 注意：无法获取目标方法的返回结果，若需获取返回结果请使用返回通知
     */
    @After("logPointcut()")
    public void afterMethod(JoinPoint joinPoint) {
        log.info("目标方法 {} 执行完毕", joinPoint.getSignature().getName());
    }

    /**
     * 返回通知：目标方法正常执行完毕后执行（仅当方法无异常时执行）
     * @param joinPoint 连接点
     * @param result 目标方法的返回结果（需与@AfterReturning的returning属性名一致）
     */
    @AfterReturning(value = "logPointcut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        log.info("目标方法 {} 正常返回", joinPoint.getSignature().getName());
//        log.info("目标方法返回结果：{}", result);
    }

    /**
     * 异常通知：目标方法抛出异常时执行
     * @param joinPoint 连接点
     * @param ex 目标方法抛出的异常（需与@AfterThrowing的throwing属性名一致）
     */
    @AfterThrowing(value = "logPointcut()", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {
        log.error("目标方法 {} 抛出异常：{}", joinPoint.getSignature().getName(), ex.getMessage());
    }
}