package com;

import com.channel.InputChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({Sink.class, InputChannel.class}) // 绑定配置文件中名称为input的消息通信Binding
public class RocketConsumerApplication
{

    /**
     * 监听INPUT接收消息
     * @param receiveMsg
     */
    @StreamListener(value = Sink.INPUT)
    public void receive(String receiveMsg){
        System.out.println("TopicTest receive :"+receiveMsg+", receiveTime = " + System.currentTimeMillis());
    }

    /**
     * 监听USER_INPUT接收消息
     * @param receiveMsg
     */
    @StreamListener(value = InputChannel.USER_INPUT)
    public void receive2(String receiveMsg){
        System.out.println("TopicTest receive :"+receiveMsg+", receiveTime = " + System.currentTimeMillis());
    }
    public static void main( String[] args )
    {
        SpringApplication.run(RocketConsumerApplication.class, args);
    }
}
