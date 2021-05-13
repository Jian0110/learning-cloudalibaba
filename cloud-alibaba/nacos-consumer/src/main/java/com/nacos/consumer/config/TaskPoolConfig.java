package com.nacos.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * 1.当线程数小于核心线程数时，创建线程。
 * 2.当线程数大于等于核心线程数，且任务队列未满时，将任务放入任务队列。
 * 3.当线程数大于等于核心线程数，且任务队列已满。
 * (1)若线程数小于最大线程数，创建线程。(2)若线程数等于最大线程数，抛出异常，拒绝任务。
 * 即优先考虑顺序为：corePool->queuePool->maxPool->rejectedHandler
 */
@Configuration
public class TaskPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(5);
        // 用来缓冲执行任务的队列
        executor.setQueueCapacity(500);
        // 线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(10);
        // 线程空闲后的最大存活时间
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("taskExecutor-");
        // 拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
