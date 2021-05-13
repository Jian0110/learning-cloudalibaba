package com.springcloud.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name="seata-account-service")
public interface AccountFeignClient {
    @PostMapping("/account/deduct")
    Boolean deduct(@RequestParam("accountId") Long accountId, @RequestParam("payAmount") BigDecimal payAmount);
}
