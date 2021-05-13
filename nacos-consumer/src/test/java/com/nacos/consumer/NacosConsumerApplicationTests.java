package com.nacos.consumer;


import com.nacos.consumer.service.ThreadTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableAsync
public class NacosConsumerApplicationTests {



   @Autowired
   private ThreadTest thread;

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            thread.thread();
        }
    }

}
