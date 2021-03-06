package com.yumi.mall.cartItem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName MallOrderApplication
 * @Description 购物车管理启动
 * @Author yuyu
 * @Date 2019/3/18 13:08
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan(value = {"com.yumi.mall.mapper","com.yumi.mall.dao","com.yumi.mall.cartItem.dao"})
@EnableTransactionManagement
@EnableDiscoveryClient
public class MallCartItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallCartItemApplication.class);
    }
}
