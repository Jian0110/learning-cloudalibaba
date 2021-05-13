package com.nacos.consumer.common.myAssert;

import com.nacos.consumer.common.enums.IResponseEnum;
import com.nacos.consumer.common.exception.BaseException;
import com.nacos.consumer.common.exception.BusinessException;

import java.text.MessageFormat;

public interface BusinessExceptionAssert extends IResponseEnum, Assert{
    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg, t);
    }
}
