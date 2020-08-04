package com.springboot.demo.exception;

import com.springboot.demo.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author Joseph.L
 * @date
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    private Integer code;
    private String message;

    public BaseException(StatusEnum statusEnum) {
        super(statusEnum.getMessage());
        this.code = statusEnum.getCode();
        this.message = statusEnum.getMessage();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}