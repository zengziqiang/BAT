package com.bat.response;

import lombok.Getter;

/**
 * @author iszengziqiang@163.com
 * @date 2020/12/19 11:54
 * @Version: 1.0
 * @desc //todo
 */
@Getter
public enum ResultStatusEnum {

    /**
     * 广义通用
     */
    INSERT_SUCCESS(2002, "新增成功"),
    INSERT_FAILED(3002, "新增失败"),

    DELETE_SUCCESS(2004, "删除成功"),
    DELETE_FAILED(3004, "删除失败"),

    UPDATE_SUCCESS(2003, "更新成功"),
    UPDATE_FAILED(3003, "更新失败"),

    QUERY_SUCCESS(2001, "查询成功"),
    QUERY_FAILED(3001, "查询失败"),

    EXECUTE_SUCCESS(205, "操作成功"),
    EXECUTE_FAILED(305, "操作失败"),
    BATCH_UPDATE_FAILED(304, "批量更新失败"),
    PARAMETER_IS_NULL(305, "参数为空"),
    PARAMETER_FAILED(306, "无效参数"),

    /**
     * 规约：时间异常类 value定义区间为 -100 ~ -199
     */
    TIME_EMPTY(-100, "时间不能为空"),
    TIME_MORE_THAN_14_DAYS(-101, "时间跨度不能超过两个星期"),

    /**
     * 规约：字段为空 value区间 -200 ~ -299
     */
    OPENID_EMPTY(-201, "openid不能为空");

    private int status;
    private String msg;

    ResultStatusEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
