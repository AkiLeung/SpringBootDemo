package com.springboot.demo.enums;

import lombok.Getter;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Getter
public enum StatusEnum {

    /**
     * 操作成功
     */
    OK(200, "操作成功"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(500, "服务器出错啦");

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 内容
     */
    private String message;

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
