package com.yumi.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ProviderApplication
 * @Description 网关应用
 * @Author yuyu
 * @Date 2019/3/4 9:24
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MallGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallGatewayApplication.class);
    }

}
