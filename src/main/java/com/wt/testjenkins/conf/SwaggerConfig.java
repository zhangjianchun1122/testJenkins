package com.wt.testjenkins.conf;

/**
 * ClassName: SwaggerConfig
 * Description: TODO
 *
 * @author zjc
 * @date 2023/6/19 16:55
 * @Version 1.0
 */

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * swagger配置
 * 访问地址：项目路径前缀/swagger-ui/index.html
 */
@Configuration
@EnableWebMvc
public class SwaggerConfig {

    /**
     * 配置了swagger的Docket的bean实例
     * 此方法可配置多个，复制后改个方法名即可，用于分组
     * @return
     */
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
//        Profiles profiles = Profiles.of("dev","test");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
//        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("南京WT")
                .apiInfo(apiInfo())
//                .enable(flag)//enable是否启动Swagger，如果为false，则Swagger不能在浏览器中访问
                .select()
                //RequestHandlerSelectors.basePackage("包名")  单包扫描
                //RequestHandlerSelectors.basePackage("包名").or(RequestHandlerSelectors.basePackage("包名"))  多包扫描
                .apis(RequestHandlerSelectors.basePackage("com.wt.testjenkins.controller"))
                //加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

    /**
     * 配置swagger信息=apiInfo
     * @return
     */
    private ApiInfo apiInfo(){
        Contact contact = new Contact("项目组成员", "", "");
        return new ApiInfo(
                "swaggerAPI文档",
                "在高处有如临深渊的谨慎，在低谷有仰望星空的勇气。",
                "v1.0",
                "",
                contact,
                "Apache Tomcat/9.0.64",
                "https://tomcat.apache.org/tomcat-9.0-doc/building.html",
                new ArrayList<>());
    }
}


