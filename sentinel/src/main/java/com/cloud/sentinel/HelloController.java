package com.cloud.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @SentinelResource(value = "hello", blockHandler = "blockHandler")
    @GetMapping("/say")
    public String hello(){
        return  "hello, Lijian";
    }
    public String blockHandler(BlockException e){
        return "hello method is blocked";
    }
}
