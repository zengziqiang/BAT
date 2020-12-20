package com.bat.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author iszengziqiang@163.com
 * @date 2020/12/19 11:46
 * @Version: 1.0
 * @desc //todo
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)//过滤null值
public class ResponseResult<T> {

    private Integer status;//状态值
    private boolean success;//前端用来判断请求是否成功
    private String msg;//提示
    private T data;//数据

    public ResponseResult(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Integer status, boolean success, String msg, T data) {
        this.status = status;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ResponseResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(String msg, T data) {
        return new ResponseResult(true, msg, data);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult(true, data);
    }

    public static <T> ResponseResult<T> success(ResultStatusEnum resultStatusEnum, T data) {
        return new ResponseResult(resultStatusEnum.getStatus(), true, resultStatusEnum.getMsg(), data);
    }

    public static <T> ResponseResult<T> error(ResultStatusEnum resultStatusEnum) {
        return new ResponseResult(resultStatusEnum.getStatus(), false, resultStatusEnum.getMsg(), null);
    }

    public static <T> ResponseResult<T> error(String msg) {
        return new ResponseResult(false, msg);
    }

}
