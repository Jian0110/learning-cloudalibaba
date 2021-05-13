package com.nacos.consumer.common.hanlder;

import com.nacos.consumer.common.exception.BaseException;
import com.nacos.consumer.common.exception.ErrorType;
import com.nacos.consumer.common.message.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;


/**
 * 全局统一异常处理：
 * 1）进入Controller前的异常（404，405,参数校验等异常）: handleServletException、handleBindException、handleValidException
 * 2）自定义（业务）异常: handleBusinessException、handleBaseException
 * 3）未知异常: handleException
 */
@RestControllerAdvice
@Slf4j
@ConditionalOnWebApplication
@ConditionalOnMissingBean(UnifiedExceptionHandler.class)
public class UnifiedExceptionHandler {

    private final static String ENV_PROD = "prod";

    /**
     * 当前环境
     */
    @Value("${spring.profiles.active}")
    private String profile;

//    @Autowired
//    private UnifiedMessageSource unifiedMessageSource;


    /**
     * 获取国际化消息
     *
     * @param e 异常
     * @return
     */
/*    public String getMessage(BaseException e) {
        String code = "response." + e.getResponseEnum().toString();
        String message = unifiedMessageSource.getMessage(code, e.getArgs());

        if (message == null || message.isEmpty()) {
            return e.getMessage();
        }

        return message;*/

    /**
     * Controller上一层相关异常
     *
     * @param e 异常
     * @return 异常结果
     */
//    @ExceptionHandler(value = {
//            NoHandlerFoundException.class, // 404异常
//            HttpRequestMethodNotSupportedException.class, // 若没有对应http方法的控制器，则抛该异常
//            HttpMediaTypeNotSupportedException.class,
//            MissingPathVariableException.class,// 未检测到路径参数。比如url
//            MissingServletRequestParameterException.class,// 缺少请求参数
//            TypeMismatchException.class,// 参数类型匹配失败
//            HttpMessageNotReadableException.class,// 即请求头携带了"content-type: application/json;charset=UTF-8"，但接收参数却没有添加注解@RequestBody，
//                                                // 或者请求体携带的 json 串反序列化成 pojo 的过程中失败了，也会抛该异常；
//            HttpMessageNotWritableException.class,// 返回的 pojo 在序列化成 json 过程失败了，那么抛该异常
//            // BindException.class,
//            // MethodArgumentNotValidException.class
//            HttpMediaTypeNotAcceptableException.class,
//            ServletRequestBindingException.class,
//            ConversionNotSupportedException.class,
//            MissingServletRequestPartException.class,
//            AsyncRequestTimeoutException.class
//    })
//    @ResponseBody
//    public Result handleServletException(Exception e) {
//        log.error(e.getMessage(), e);
//        int code = CommonResponseEnum.SERVER_ERROR.getCode();
//        try {
//            ServletResponseEnum servletExceptionEnum = ServletResponseEnum.valueOf(e.getClass().getSimpleName());
//            code = servletExceptionEnum.getCode();
//        } catch (IllegalArgumentException e1) {
//            log.error("class [{}] not defined in enum {}", e.getClass().getName(), ServletResponseEnum.class.getName());
//        }
//
//        if (ENV_PROD.equals(profile)) {
//            // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如404.
//            code = CommonResponseEnum.SERVER_ERROR.getCode();
//            BaseException baseException = new BaseException(CommonResponseEnum.SERVER_ERROR);
//            String message = getMessage(baseException);
//            return new ErrorResponse(code, message);
//        }
//
//        return Result.fail(code, e.getMessage());
//    }


    /**
     * 全局处理参数绑定异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Result handleBindException(BindException e) {
        log.error("参数绑定校验异常", e);
        List<FieldError> errorList = e.getBindingResult().getFieldErrors();
        String field = e.getBindingResult().getFieldError().getField().replace("parameter.", "");
        // 从异常对象中拿到ObjectError对象
        String message = errorList.isEmpty() ? "" : errorList.get(0).getDefaultMessage();
        log.info("入参校验失败：{}", message);
        // 然后提取错误提示信息进行返回
        return Result.fail(ErrorType.PARAM_VALIDATE_FAILED, "验证失败:字段[" + field + "]" + message);
    }
    /**
     * 全局处理参数校验异常：MethodArgumentNotValidException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> errorList = e.getBindingResult().getFieldErrors();
        String field = e.getBindingResult().getFieldError().getField().replace("parameter.", "");
        // 从异常对象中拿到ObjectError对象
        String message = errorList.isEmpty() ? "" : errorList.get(0).getDefaultMessage();
        log.info("入参校验失败：{}", message);
        // 然后提取错误提示信息进行返回
        return Result.fail(ErrorType.PARAM_VALIDATE_FAILED, "验证失败:字段[" + field + "]" + message);
    }


}
