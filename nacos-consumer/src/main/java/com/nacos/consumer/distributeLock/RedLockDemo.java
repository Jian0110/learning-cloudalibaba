package com.nacos.consumer.distributeLock;

import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class RedLockDemo {

    public static void main(String[] args) {
        // 配置redis server
        Config config1 = new Config();
        config1.useSingleServer().setAddress("redis://192.168.0.1:6379")
                .setPassword("a123456").setDatabase(0);
        RedissonClient redissonClient1 = Redisson.create(config1);
        Config config2 = new Config();
        config2.useSingleServer().setAddress("redis://192.168.0.2:6379")
                .setPassword("a123456").setDatabase(0);
        RedissonClient redissonClient2 = Redisson.create(config2);

        Config config3 = new Config();
        config3.useSingleServer().setAddress("redis://192.168.0.3:6379")
                .setPassword("a123456").setDatabase(0);
        RedissonClient redissonClient3 = Redisson.create(config3);

        Config config4 = new Config();
        config4.useSingleServer().setAddress("redis://192.168.0.4:6379")
                .setPassword("a123456").setDatabase(0);
        RedissonClient redissonClient4 = Redisson.create(config4);

        Config config5 = new Config();
        config5.useSingleServer().setAddress("redis://192.168.0.5:6379")
                .setPassword("a123456").setDatabase(0);
        RedissonClient redissonClient5 = Redisson.create(config5);

        // redis 分布式锁的key
        String redLockKey = "REDIS_DISTRIBUTE_LOCK_KEY";

        RLock lock1 = redissonClient1.getLock(redLockKey);
        RLock lock2 = redissonClient2.getLock(redLockKey);
        RLock lock3 = redissonClient3.getLock(redLockKey);
        RLock lock4 = redissonClient4.getLock(redLockKey);
        RLock lock5 = redissonClient5.getLock(redLockKey);
        // 向5个redis实例尝试加锁
        RedissonRedLock redLock = new RedissonRedLock(lock1, lock2, lock3, lock4, lock5);
        boolean isLock;
        try {
            // 500ms为超时时间，10s为锁失效时间
            isLock = redLock.tryLock(500, 10000, TimeUnit.MILLISECONDS);
            System.err.println("isLock = " + isLock);
            if (isLock) {
                //TODO 如果获取锁成功，则继续做往下走流程;
            }
        } catch (Exception e) {
        } finally {
            // 最后无论如何, 都需要解锁
            redLock.unlock();
        }
    }

}
