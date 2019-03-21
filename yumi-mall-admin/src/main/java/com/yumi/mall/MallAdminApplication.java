package com.yumi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 应用启动入口
 */
@SpringBootApplication(scanBasePackages = "com.yumi.mall")
@MapperScan({"com.yumi.mall.mapper","com.yumi.mall.dao"})
@EnableTransactionManagement
@EnableDiscoveryClient
public class MallAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallAdminApplication.class, args);
    }
}
