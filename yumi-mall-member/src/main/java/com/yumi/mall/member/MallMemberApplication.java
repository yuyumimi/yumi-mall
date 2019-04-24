package com.yumi.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName MallMemberApplication
 * @Description 会员管理模块
 * @Author yuyu
 * @Date 2019/3/18 15:49
 * @Version 1.0
 **/
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@MapperScan({"com.yumi.mall.mapper","com.yumi.mall.dao", "com.yumi.mall.member.dao"})
@EnableDiscoveryClient
public class MallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallMemberApplication.class);
    }
}
