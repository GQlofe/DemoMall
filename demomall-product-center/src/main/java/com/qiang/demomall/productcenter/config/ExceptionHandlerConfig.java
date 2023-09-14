package com.qiang.demomall.productcenter.config;

import com.qiang.demomall.common.enums.ErrorCodeEnum;
import com.qiang.demomall.common.exceptions.MallException;
import com.qiang.demomall.common.response.MallResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description 统一异常处理
 *
 * @author qiang
 * @date 2023-09-02 14:09:51
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerConfig {

    private static final String style = "请求异常：";

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected MallResponse<?> ValidateHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (CollectionUtils.isEmpty(allErrors)) {
            log.error(style + "uri={}, message = {}", request.getRequestURI(), "参数错误");
            return MallResponse.fail(ErrorCodeEnum.PARAM_ERROR);
        }

        MallResponse<Object> response = MallResponse.fail(ErrorCodeEnum.PARAM_ERROR);
        String message = allErrors.get(0).getDefaultMessage();
        if (StringUtils.hasText(message)) {
            response.setMessage(message);
        }
        log.error(style + "uri={}, message = {}", request.getRequestURI(), response.getMessage());
        return response;
    }


    @ExceptionHandler(value = MallException.class)
    protected MallResponse<?> globalExceptionHandler(HttpServletRequest request, MallException e) {
        log.error(style + "uri={}, code={}, msg={}", request.getRequestURI(), e.getCode(), e.getMsg());
        return MallResponse.fail(e);
    }

    @ExceptionHandler(value = Exception.class)
    protected MallResponse<?> exceptionHandler(HttpServletRequest request, Exception e) {
        log.error(style + "uri={}, e = ", request.getRequestURI(), e);
        return MallResponse.fail(ErrorCodeEnum.SYSTEM_ERROR);
    }
}
