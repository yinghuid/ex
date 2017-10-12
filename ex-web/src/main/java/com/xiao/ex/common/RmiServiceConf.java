package com.xiao.ex.common;

import com.xiao.ex.core.ExceptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;

/**
 * RMI配置
 *
 * @author 肖亭
 * @since 2017年09月15 16:19
 **/
@Component
public class RmiServiceConf {

    /*@Value("${rmi.serviceName}")
    private String serviceName;*/
    @Value("${rmi.port}")
    private int port;

    @Bean
    public RmiServiceExporter accountService(ExceptionService exceptionService) {

        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        // 客户端通过rmi调用的端口
        rmiServiceExporter.setRegistryPort(port);
        // 客户端调用注册调用的服务名
        rmiServiceExporter.setServiceName("exService");
        // 注册的service
        rmiServiceExporter.setService(exceptionService);
        //注册的接口
        rmiServiceExporter.setServiceInterface(ExceptionService.class);
        return rmiServiceExporter;
    }
}
