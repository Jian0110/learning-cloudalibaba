package com.springcloud.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="seata-storage-service")
public interface StorageFeignClient {
    @PostMapping("/storage/deduct")
    Boolean deduct(@RequestParam("productId") Long productId);
}
