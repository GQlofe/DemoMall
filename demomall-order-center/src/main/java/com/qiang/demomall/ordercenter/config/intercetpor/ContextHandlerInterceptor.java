package com.qiang.demomall.ordercenter.config.intercetpor;

import com.qiang.demomall.common.context.ContextHolder;
import com.qiang.demomall.common.context.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;


/**
 * @description 上下文拦截器
 *
 * @author qiang
 * @date 2023-09-09 23:33:06
 */
@Slf4j
public class ContextHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uid = request.getHeader("uid");

        UserContext context = UserContext.builder().uid(Long.valueOf(uid)).build();

        log.info("添加::线程本地变量context={}", context.toString());
        ContextHolder.set(context);

        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext context = ContextHolder.get(UserContext.class);
        log.info("移除::线程本地变量context={}", context.toString());
        ContextHolder.remove();
    }
}
