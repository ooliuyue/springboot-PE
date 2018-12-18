package com.ooliuyue.springboot_swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: ly
 * @Date: 2018/12/18 09:41
 */
@Configuration  //让spring来加载配置
@EnableSwagger2 //开启swagger2
public class Swagger2Config {
    @Bean
    public Docket creatRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ooliuyue.springboot_swagger"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("使用Swagger2构建RESTful APIs")
                .description("一点寒芒先到，随后枪出如龙")
                .contact("ooliuyue")
                .version("1.0")
                .build();


    }

}
