package com.qiang.demomall.ordercenter.config.aop;

import com.google.gson.Gson;
import com.qiang.demomall.common.annotations.PrintLog;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;

/**
 * @description 日志打印切面类
 *
 * @author qiang
 * @date 2023-09-02 13:11:50
 */
@Slf4j
@Aspect
@Component
public class PrintLogAop {

    /**
     * 请求参数及请求响应打印切面
     */
    @Pointcut("within(com.qiang.demomall.ordercenter.api..*)")
    public void requestLogPointCut() {
    }


    /**
     * 打印请求参数
     * @param jp jp
     */
    @Before("requestLogPointCut()")
    public void printRequestParams(JoinPoint jp) {
        LogPrinter.printParams(jp);
    }

    /**
     * 打印请求响应
     * @param jp jp
     * @param result 请求响应
     */
    @AfterReturning(pointcut = "requestLogPointCut()", returning = "result")
    public void printResponse(JoinPoint jp, Object result) {
        LogPrinter.printResponse(result, jp);
    }


    /**
     * 打印方法参数
     * @param jp jp
     * @param printLog printLog
     */
    @Before(value = "within(com.qiang.demomall..*) && @annotation(printLog)", argNames = "jp,printLog")
    public void printMethodParams(JoinPoint jp, PrintLog printLog) {
        if (!printLog.before()) {
            return;
        }
        LogPrinter.printParams(jp);
    }

    /**
     * 方法结果打印
     * @param jp jp
     * @param printLog printLog
     * @param result result
     */
    @AfterReturning(pointcut = "within(com.qiang.demomall..*) && @annotation(printLog)", returning = "result")
    public void printMethodResult(JoinPoint jp, PrintLog printLog, Object result) {

        if (!printLog.after()) {
            return;
        }
        LogPrinter.printResponse(result, jp);
    }


    private static class LogPrinter {

        private final static Gson gson = new Gson();

        public static String getClassName(Class<?> clazz) {
            String className = clazz.toString();//获取目标类名
            return className.substring(className.lastIndexOf(".") + 1);
        }

        public static void printParams(JoinPoint jp) {
            String requestURI = "";
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes != null) {
                HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
                requestURI = request.getRequestURI();
            }


            String className = getClassName(jp.getTarget().getClass());
            String signatureName = jp.getSignature().getName();
            Object[] parames = jp.getArgs();

            StringBuilder builder = new StringBuilder();
            if (StringUtils.hasText(requestURI)) {
                builder.append("请求路径uri=").append(requestURI).append(",");
            }
            builder.append(className).append(".").append(signatureName);
            builder.append("::").append("请求参数==> ");
            if (parames != null) {
                for (Object parame : parames) {
                    if (parame == null) {
                        builder.append("null").append(",");
                        continue;
                    }
                    if (parame instanceof ServletRequest) {
                        continue;
                    }
                    String name = parame.getClass().getName();
                    name = name.substring(name.lastIndexOf(".") + 1);
                    builder.append(name).append("=").append(gson.toJson(parame)).append(",");
                }
            }

            if (builder.charAt(builder.length() - 1) == ',') {
                builder.deleteCharAt(builder.length() - 1);
            }
            log.info(builder.toString());
        }

        public static void printResponse(Object result, JoinPoint jp) {

            String signatureName = jp.getSignature().getName();
            String className = getClassName(jp.getTarget().getClass());
            StringBuilder builder = new StringBuilder();
            builder.append(className).append(".").append(signatureName).append("::返回结果==> ");
            builder.append(gson.toJson(result));

            log.info(builder.toString());
        }
    }
}
