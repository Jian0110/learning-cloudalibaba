package com.springcloud.controller;

import com.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 模拟账户扣款
     * @param accountId
     * @param payAmount
     * @return
     */
    @PostMapping("/deduct")
    public Boolean deduct(Long accountId, BigDecimal payAmount){
        try {
            accountService.deduct(accountId, payAmount);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
