package com.nacos.consumer.service;

import com.nacos.consumer.common.enums.ErrorResponseEnum;
import com.nacos.consumer.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String addUser(User user) {
        ErrorResponseEnum.LICENCE_NOT_FOUND.assertNotNull(user);
        ErrorResponseEnum.LICENCE_NOT_FOUND.assertNotNull(user);
        // 直接编写业务逻辑
        return "success";
    }
}
