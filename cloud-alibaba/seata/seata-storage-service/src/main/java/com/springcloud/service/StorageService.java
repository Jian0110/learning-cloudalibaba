package com.springcloud.service;
import	java.net.Proxy;

import com.springcloud.entity.Repo;
import com.springcloud.mapper.RepoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
@Slf4j
public class StorageService {

    @Autowired
    private RepoMapper repoMapper;

//    @Transactional(rollbackFor = Exception.class)
    public Boolean deduct(Long productId){
        // 这里先检查有没有库存了, 生产环境下这里是需要for update数据库锁，或者分布式锁
        Repo repoFromDB =   repoMapper.selectByPrimaryKey(productId);
        if (repoFromDB == null) {
            throw new RuntimeException("product not exist!");
        }
        // 对库存减一
        int afterCount = repoFromDB.getAmount()-1;
        // 没有库存剩余了
        if (afterCount < 0) {
            throw new RuntimeException("product storage is no remaining!");
        }
        Repo repo = Repo.builder()
                .id(productId)
                .amount(afterCount)
                .build();
        repoMapper.updateAmount(repo);
        log.info("deduct product[{}] storage, current amount is {}", productId, afterCount);
        return true;
    }
}
