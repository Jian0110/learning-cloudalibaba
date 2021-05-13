package com.gateway.service;


import com.gateway.model.User;

import javax.validation.ValidationException;
import java.util.Arrays;
import java.util.Optional;

public class TestService {
    public static void main(String[] args) {
        /*try {
            String str = null;
            Optional.ofNullable(str).orElseThrow(()->new ValidationException("数据缺失"));
            System.out.println("======");

        } catch (Exception e){
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }*/
        System.out.println("1911239003072200".substring(4,6));
        System.out.println("23".equals("1911239003072200".substring(5,6)));
    }
}
