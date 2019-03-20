package com.yumi.mall.member.component;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName PasswordConfig
 * @Description 密码加密解密工具
 * @Author yuyu
 * @Date 2019/3/19 9:23
 * @Version 1.0
 **/
@Component
public class PasswordConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
