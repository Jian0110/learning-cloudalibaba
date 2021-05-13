package com.nacos.consumer.common.exception;

import com.nacos.consumer.common.enums.IResponseEnum;

public class BaseException extends RuntimeException {
    /**
     * 异常对应的错误类型
     */
    private ErrorType errorType;
    private IResponseEnum responseEnum;

    /**
     * 默认是系统异常
     */
    public BaseException() {
        this.errorType = ErrorType.SYSTEM_ERROR;
    }

    public BaseException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }
    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super(message);
        this.responseEnum = responseEnum;
    }
    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.responseEnum = responseEnum;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
