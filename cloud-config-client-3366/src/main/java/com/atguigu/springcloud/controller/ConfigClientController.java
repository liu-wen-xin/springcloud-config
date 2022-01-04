package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope   //动态刷新配置文件，与3344（客户端）保持一致
public class ConfigClientController {
    //读取配置文件的port值
    @Value("${server.port}")
    private String serverPort;

    //读取配置文件的info值(总线)
    @Value("${config.info}")
    private String configInfo;

    //浏览器访问获取serverPort&configInfo
    @GetMapping("/configInfo")
    public String configInfo(){
        return "serverPort: "+serverPort+"\t\n\n configInfo: "+configInfo;
    }

}
