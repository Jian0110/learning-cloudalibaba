/**
 * @Author Jian
 * @CreateDate 2019/12/27 9:39 AM
 * @Description
 */
package com.nacos.consumer.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadTest {


    @Async
    public void thread() throws InterruptedException {
        System.out.println(Thread.currentThread());
//        Thread.sleep(1000);
    }

}
