package com.nacos.consumer.common.enums;

import com.nacos.consumer.common.myAssert.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorResponseEnum implements BusinessExceptionAssert {
    NO_ERROR("000000", "处理成功"),
    SYSTEM_ERROR("-1", "系统异常"),
    OAUTH_ERROR("-2", "认证异常"),
    AUTH_ERROR("-3", "鉴权异常"),
    TOO_MANY_REQUEST_ERROR("-4", "请求过于频繁"),
    PARAM_VALIDATE_FAILED("-5", "参数校验失败"),
    REQUEST_NOT_FOUND("404", "访问的资源不存在"),
    BAD_LICENCE_TYPE("7001", "Bad licence type."),
    LICENCE_NOT_FOUND("7002", "Licence not found."),
    USER_NOT_FOUND("7003", "user not found."),

    ;
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;
}
