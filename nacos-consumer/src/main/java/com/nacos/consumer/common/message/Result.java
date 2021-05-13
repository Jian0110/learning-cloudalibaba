package com.nacos.consumer.common.message;
import	java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nacos.consumer.common.exception.BaseException;
import com.nacos.consumer.common.exception.ErrorType;
import com.nacos.consumer.common.exception.Error;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

@Data
public class Result<T> {

    private String code;
    private String message;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") // 出参格式
    private Date timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
        this.timestamp = new Date();
    }

    /**
     * 成功返回数据
     * @param data
     */
    public Result(T data) {
        this.data = data;
        Error error = ErrorType.NO_ERROR;
        this.code = error.getCode();
        this.message = error.getMessage();
        this.timestamp = new Date();;
    }
    public Result(Error error) {
        this.code = error.getCode();
        this.message = error.getMessage();
        this.timestamp =  new Date();;
    }

    public Result(Error errorType, T data) {
        this(errorType);
        this.data = data;
    }

    /**
     * 内部使用，用于构造成功的结果
     *
     * @param code
     * @param message
     * @param data
     */
    private Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp =  new Date();;
    }

    /**
     * 快速创建成功结果并返回结果数据
     *
     * @param data
     * @return Result
     */
    public static Result success(Object data) {
        return new Result<>(ErrorType.NO_ERROR.getCode(), ErrorType.NO_ERROR.getMessage(), data);
    }

    /**
     * 快速创建成功结果
     *
     * @return Result
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 系统异常类没有返回数据
     *
     * @return Result
     */
    public static Result fail() {
        return new Result(ErrorType.SYSTEM_ERROR);
    }

    /**
     * 系统异常类没有返回数据
     *
     * @param baseException
     * @return Result
     */
    public static Result fail(BaseException baseException) {
        return fail(baseException, null);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return Result
     */
    public static Result fail(BaseException baseException, Object data) {
        return new Result<>(baseException.getErrorType(), data);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param errorType
     * @param data
     * @return Result
     */
    public static Result fail(Error errorType, Object data) {
        return new Result<>(errorType, data);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param errorType
     * @return Result
     */
    public static Result fail(Error errorType) {
        return Result.fail(errorType, null);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return Result
     */
    public static Result fail(Object data) {
        return new Result<>(ErrorType.SYSTEM_ERROR, data);
    }


    /**
     * 成功code=000000
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return ErrorType.NO_ERROR.getCode().equals(this.code);
    }

    /**
     * 失败
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }
}
