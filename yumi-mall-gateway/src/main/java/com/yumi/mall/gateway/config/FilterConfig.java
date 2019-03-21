package com.yumi.mall.gateway.config;

import com.yumi.mall.gateway.filters.AccessGatewayFilter;
import com.yumi.mall.gateway.filters.RequestTimeGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FilterConfig
 * @Description TODO
 * @Author yuyu
 * @Date 2019/3/4 15:55
 * @Version 1.0
 **/
@Configuration
public class FilterConfig {
    @Bean
    public RequestTimeGatewayFilterFactory requestTimeGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }
    @Bean
    public AccessGatewayFilter tokenFilter(){
        return new AccessGatewayFilter();
    }
}
