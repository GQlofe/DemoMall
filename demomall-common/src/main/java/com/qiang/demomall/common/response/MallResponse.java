package com.qiang.demomall.common.response;

import com.qiang.demomall.common.enums.ErrorCodeEnum;
import com.qiang.demomall.common.exceptions.MallException;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 统一响应对象
 *
 * @author qiang
 * @date 2023-08-20 20:42:37
 */
@Data
public class MallResponse<T> implements Serializable {
    protected static final long serialVersionUID = 1L;


    // 响应码
    public int code;

    // 响应信息
    public String message;

    // 响应数据
    public T data;


    /**
     * 成功
     * @return response
     */
    public static <T> MallResponse<T> success() {
        MallResponse<T> response = new MallResponse<>();
        response.setCode(ErrorCodeEnum.SUCCESS.getCode());
        response.setMessage(ErrorCodeEnum.SUCCESS.getMessage());
        return response;
    }


    /**
     * 成功，返回数据
     * @param data 数据
     * @return response
     */
    public static <T> MallResponse<T> success(T data) {
        MallResponse<T> response = new MallResponse<>();
        response.setCode(ErrorCodeEnum.SUCCESS.getCode());
        response.setMessage(ErrorCodeEnum.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }


    /**
     * 失败
     * @param errorCode 错误码
     * @return response
     */
    public static <T> MallResponse<T> fail(ErrorCodeEnum errorCode) {
        MallResponse<T> response = new MallResponse<>();
        response.setCode(errorCode.getCode());
        response.setMessage(errorCode.getMessage());
        return response;
    }

    /**
     * 失败
     * @param e 异常
     * @return response
     */
    public static <T> MallResponse<T> fail(MallException e) {
        MallResponse<T> response = new MallResponse<>();
        response.setCode(e.getCode());
        response.setMessage(e.getMsg());
        return response;
    }
}
