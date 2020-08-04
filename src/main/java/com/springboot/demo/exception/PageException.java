package com.springboot.demo.exception;

import com.springboot.demo.enums.StatusEnum;
import lombok.Getter;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Getter
public class PageException extends BaseException {

    public PageException(StatusEnum statusEnum) {
        super(statusEnum);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}

