package com.atguigu.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;

@Service
@EnableBinding(Sink.class)    //标注为消息的接收者
@Slf4j
public class ReceiveMessageListener {

    //从配置中心拿到端口作为作为返回值
    @Value("${server.port}")
    private String serverPort;

    //接受消息生产者发送的消息
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者1号，------->接收到的消息："+message.getPayload()+"\t 端口为："+serverPort);
    }
}
