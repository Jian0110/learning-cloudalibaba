package com.springcloud.service;

import com.springcloud.entity.UserAccount;
import com.springcloud.mapper.UserAccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 模拟下单
 */
@Service
@Slf4j
public class AccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;


    public void deduct(Long accountId, BigDecimal payAmount){
        // 这里先检查有没有账户存在, 生产环境下这里是需要for update数据库锁，或者分布式锁
        UserAccount userAccountFromDB =  userAccountMapper.selectByPrimaryKey(accountId);
        if (userAccountFromDB == null) {
            throw new RuntimeException("account not exist!");
        }
        // 检查余额是否足够
        BigDecimal afterBalance = userAccountFromDB.getBalance().subtract(payAmount);
        if (afterBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("the balance is not enough!");
        }
        UserAccount userAccount = UserAccount.builder()
                .id(accountId)
                .balance(afterBalance)
                .build();
        log.info("deduct account[{}] , current balance is {}", accountId, afterBalance);
        userAccountMapper.updateBalance(userAccount);
    }
}
