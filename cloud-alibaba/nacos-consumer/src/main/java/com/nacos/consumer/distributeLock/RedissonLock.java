package com.nacos.consumer.distributeLock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class RedissonLock {

    public static void main(String[] args) {
        Config config = new Config();
        config.useClusterServers()
                .addNodeAddress("redis://192.168.31.101:7001")
                .addNodeAddress("redis://192.168.31.101:7002")
                .addNodeAddress("redis://192.168.31.101:7003")
                .addNodeAddress("redis://192.168.31.102:7001")
                .addNodeAddress("redis://192.168.31.102:7002")
                .addNodeAddress("redis://192.168.31.102:7003");
        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("anyLock");
        boolean isLock;
        try {
            // 这里不像redLock一样，不需要传入过期时间跟超时时间
            lock.lock();
            //TODO 如果获取锁成功，则继续做往下走流程;
        } catch (Exception e) {
        } finally {
            // 最后无论如何, 都需要解锁
            lock.unlock();
        }
        lock.lock();
        lock.unlock();
    }
}
