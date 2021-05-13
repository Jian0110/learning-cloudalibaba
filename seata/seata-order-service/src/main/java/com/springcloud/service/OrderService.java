package com.springcloud.service;
import	java.math.BigDecimal;

import com.springcloud.entity.ProductOrder;
import com.springcloud.feign.AccountFeignClient;
import com.springcloud.feign.StorageFeignClient;
import com.springcloud.mapper.ProductOrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 模拟下单
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private ProductOrderMapper orderMapper;
    @Autowired
    private StorageFeignClient storageFeignClient;
    @Autowired
    private AccountFeignClient accountFeignClient;

    @GlobalTransactional // TM开启全局事务
    @Transactional(rollbackFor = Exception.class)
    public void createOrder(Long productId, BigDecimal price){
        // 这里模拟获取的是用户的账户ID
        // 通过上下文获取userId再获取accountId（单个账户）
        Long accountId = 1L; // 假设已经获取到了账户ID

        // 1.rpc调用库存微服务检查库存并减库存操作
        Boolean deductStorageSuccess =  storageFeignClient.deduct(productId);
        if (!deductStorageSuccess) {
            throw new RuntimeException("storage deduct failed!");
        }
        // 2.创建订单
        ProductOrder order =  ProductOrder.builder()
                .productId(productId)
                .accountId(accountId)
                .payAmount(price)
                .build();
        log.info("create order : {}", order);
        // 这里为了模拟回滚，所以先对价格的判断放到了创建订单之后，抛出runtime exception
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new NumberFormatException("product price must greater than zero!");
        }
        orderMapper.insertSelective(order);

        // 3.rpc调用账户微服务对余额检查并扣款操作
        Boolean deductAccountSuccess =  accountFeignClient.deduct(accountId, price);
        if (!deductAccountSuccess) {
            throw new RuntimeException("account deduct failed!");
        }
        // 4. 反馈结果
    }
}
