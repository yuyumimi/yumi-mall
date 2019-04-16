package com.yumi.mall.gateway.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yumi.common.core.util.R;
import com.yumi.common.security.jwt.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * toke认证
 */
public class AccessGatewayFilter implements GlobalFilter, Ordered {

    Logger logger = LoggerFactory.getLogger(AccessGatewayFilter.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${jwt.skip.urls}")
    private String[] skipAuthUrls;
    @Value("${jwt.blacklist.key.format}")
    private String jwtBlacklistKeyFormat;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().getPath();
        //跳过不需要验证的路径
        if (Arrays.asList(skipAuthUrls).contains(url)) {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst(this.tokenHeader);
        if (token == null || token.isEmpty() || !token.startsWith(this.tokenHead)) {
            logger.info("token is missing...");
            ServerHttpResponse response = exchange.getResponse();
            R r= R.builder().msg("missing token").code(HttpStatus.UNAUTHORIZED.value()).build();
            return setR(response,r);
        }
        token = token.substring(this.tokenHead.length());// The part after "Bearer "
        String userName = this.jwtTokenUtil.getUserNameFromToken(token);
        if (StringUtils.isBlank(userName)) {
            ServerHttpResponse response = exchange.getResponse();
            R r=R.builder().msg("invalid token").code(HttpStatus.UNAUTHORIZED.value()).build();
            return setR(response,r);
        }
        //将现在的request，添加当前身份
        ServerHttpRequest mutableReq = exchange.getRequest().mutate().header("Authorization-UserName", userName).build();
        ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }

    private Mono<Void> setR(ServerHttpResponse response, R r) {
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        try {
            byte[] msg = objectMapper.writeValueAsBytes(r);
            DataBuffer buffer = response.bufferFactory().wrap(msg);
            return response.writeWith(Flux.just(buffer));
        } catch (JsonProcessingException e) {
            logger.error("对象输出异常", e);
        }
        return null;
    }

    private Mono<Void> setRes(ServerHttpResponse response, R r) {
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        try {
            byte[] msg = objectMapper.writeValueAsBytes(r);
            DataBuffer buffer = response.bufferFactory().wrap(msg);
            return response.writeWith(Flux.just(buffer));
        } catch (JsonProcessingException e) {
            logger.error("对象输出异常", e);
        }
        return null;
    }
}