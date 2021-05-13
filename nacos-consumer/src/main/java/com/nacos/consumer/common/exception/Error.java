package com.nacos.consumer.common.exception;

public interface Error {
    String getCode();

    void setCode(String code);

    String getMessage();

    void setMessage(String message);
}
