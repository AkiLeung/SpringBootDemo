package com.springboot.demo.exception;

import com.springboot.demo.enums.StatusEnum;
import lombok.Getter;

/**
 * @author Joseph.L
 * @date
 * @description
 */
@Getter
public class JsonException extends BaseException {

    public JsonException(StatusEnum statusEnum) {
        super(statusEnum);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}
