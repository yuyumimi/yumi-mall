package com.yumi.mall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName MallProductApplication
 * @Description TODO
 * @Author yuyu
 * @Date 2019/3/22 9:03
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan(value = {"com.yumi.mall.mapper","com.yumi.mall.dao","com.yumi.mall.product.dao"})
@EnableDiscoveryClient
@EnableSwagger2
public class MallProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class);
    }
}
