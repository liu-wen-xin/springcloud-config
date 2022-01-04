package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope    //在控制层类加上@RefreshScope注解使当前类下的配置支持Nacos配置文件的自动刷新
public class ConfigClientController {

    //获取配置中心文件的信息
    @Value("${config.info}")
    private String configInfo;

    //获取配置中心文件信息的方法
    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
