package com.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputChannel {
    String USER_INPUT = "userInput";
    String ORDER_INPUT = "orderInput";

    @Input(InputChannel.USER_INPUT)
    SubscribableChannel userInput();

    @Input(InputChannel.ORDER_INPUT)
    SubscribableChannel orderInput();
}
