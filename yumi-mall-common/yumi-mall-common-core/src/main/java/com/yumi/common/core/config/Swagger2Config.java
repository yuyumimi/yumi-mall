package com.yumi.common.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2API文档的配置
 * http://ip:port/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${swagger.scan.path}")
    private String scanPackage;
    @Value("${swagger.description}")
    private String description;

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.scanPackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact=new Contact("yuyumimi",
                "https://github.com/yuyumimi/yumi-mall","mendandan@yeah.net");
        return new ApiInfoBuilder()
                .title("yumi-mall商城系统")
                .description(this.description)
                .contact(contact)
                .license("Apache License 2.0")
                .licenseUrl("https://github.com/yuyumimi/yumi-mall/blob/master/LICENSE")
                .version("1.0")
                .build();

    }
}
