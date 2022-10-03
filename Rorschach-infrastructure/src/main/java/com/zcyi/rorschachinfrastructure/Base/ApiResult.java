package com.zcyi.rorschachinfrastructure.Base;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Api统一响应实体类
 * @param <T> 业务实体类
 */
@Setter(AccessLevel.PRIVATE)
public class ApiResult<T> {

    public int resultCode;
    public T Data;
    public String Message;
    public boolean success;

    public static <T> ApiResult<T> Success() {
        return Success(ApiResultCode.Succeed.Message(), null, ApiResultCode.Succeed.Value());
    }
    public static <T> ApiResult<T> Success(T data) {
        return Success(ApiResultCode.Succeed.Message(), data, ApiResultCode.Succeed.Value());
    }

    public static <T> ApiResult<T> Success(String msg) {
        return Success(msg, null);
    }

    public static <T> ApiResult<T> Success(String msg, T data) {
        return Success(msg, data, ApiResultCode.Succeed.Value());
    }

    public static <T> ApiResult<T> Success(String msg, T data, int code) {
        ApiResult<T> result = new ApiResult<>();
        result.setMessage(msg);
        result.setData(data);
        result.setResultCode(code);
        result.setSuccess(true);

        return result;
    }

    public static <T> ApiResult<T> Failed() {
        return Failed(ApiResultCode.Failed.Message(), null, ApiResultCode.Failed.Value());
    }

    public static <T> ApiResult<T> Failed(String msg) {
        return Failed(msg, null);
    }

    public static <T> ApiResult<T> Failed(String msg, T data) {
        return Failed(msg, data, ApiResultCode.Failed.Value());
    }

    public static <T> ApiResult<T> Failed(String msg, T data, int code) {
        ApiResult<T> result = new ApiResult<>();
        result.setMessage(msg);
        result.setData(data);
        result.setResultCode(code);
        result.setSuccess(false);
        return result;
    }

    public static <T> ApiResult<T> Error(String msg) {
        ApiResult<T> result = new ApiResult<>();
        result.setMessage(msg);
        result.setResultCode(ApiResultCode.Error.Value());

        result.setSuccess(false);
        return result;
    }
}
