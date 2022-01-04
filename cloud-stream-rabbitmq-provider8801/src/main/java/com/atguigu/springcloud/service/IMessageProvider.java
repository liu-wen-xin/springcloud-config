package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

public interface IMessageProvider {
    //生产者发送消息的接口
    public String send();
}
