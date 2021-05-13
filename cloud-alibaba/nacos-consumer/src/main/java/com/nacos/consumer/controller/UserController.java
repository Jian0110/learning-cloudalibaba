package com.nacos.consumer.controller;

import com.nacos.consumer.common.message.Result;
import com.nacos.consumer.entity.User;
import com.nacos.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser1")
    public String addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.addUser(user);
    }

    /**
     * 参数校验已交给全局异常处理
     * @param user
     * @return
     */
    @PostMapping("/addUser2")
    public String addUser2(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }

    /**
     * 返回内容可全局处理，可以直接返回实体类。
     * @return
     */
    @PostMapping("/getUser")
    public User addUser2() {
        User user = new User();
        user.setId(1111L);
        user.setAccount("user");
        user.setEmail("user@qq.com");
        return user;
    }

    /**
     * 返回string字符
     * @return
     */
    @PostMapping("/getUser2")
    public String getUser2() {
        User user = new User();
        user.setId(1111L);
        user.setAccount("user");
        user.setEmail("user@qq.com");
        return userService.addUser(user);
    }

    /**
     * 也可以使用Result封装
     * @return
     */
    @PostMapping("/getUser3")
    public Result getUser3() {
        User user = new User();
        user.setId(1111L);
        user.setAccount("user");
        user.setEmail("user@qq.com");
        return Result.success(userService.addUser(user));
    }
}
