package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.springcloud.mapper")
public class
SeataStorageServiceApplication
{
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServiceApplication.class, args);
    }
}
