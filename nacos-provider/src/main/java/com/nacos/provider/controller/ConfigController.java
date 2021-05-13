/**
 * @Author Jian
 * @CreateDate 2019/12/25 11:51 AM
 * @Description
 */
package com.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {


    /**
     * 首先通过调用 Nacos Open API
     * 向 Nacos Server 发布配置：dataId 为example.properties，
     * 内容为useLocalCache=true
     */

//    @Value("${config}")
//    private String config;
//
//    @RequestMapping("/get")
//    public String get() {
//        return config;
//    }
}
