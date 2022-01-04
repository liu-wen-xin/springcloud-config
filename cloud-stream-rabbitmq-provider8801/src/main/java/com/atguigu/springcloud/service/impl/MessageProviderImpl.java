package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;
import java.util.UUID;

@EnableBinding(Source.class)    //生产者定义发送消息的[通道]  不需要使用service
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    //拿到消息需要的绑定器，将消息绑定到通道
    @Resource
    private MessageChannel output;

    //实现发送消息的方法 withPayload()
    @Override
    public String send() {
        //生成随机数作为发送的消息
        String message = UUID.randomUUID().toString();
        //使用output对象发送消息
        this.output.send(MessageBuilder.withPayload(message).build());
        log.info("发送的消息为："+message);
        return message;
    }
}
