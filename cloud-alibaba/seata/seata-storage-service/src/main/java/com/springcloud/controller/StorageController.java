package com.springcloud.controller;

import com.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storage/")
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 模拟对商品库存减一
     * @param productId
     * @return
     */
    @PostMapping("/deduct")
    public Boolean deduct(Long productId){
        try {
            storageService.deduct(productId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
