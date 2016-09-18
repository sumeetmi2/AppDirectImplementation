/*
 *  
 * Created on Sep 7, 2016
 *
 */
package com.appdirect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author SumeetS
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket subscribeApis() {
	return new Docket(DocumentationType.SWAGGER_2).groupName("subscribe-apis").apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
		.paths(subscribeApiPaths()).build();
    }

    /**
     * @return
     */
    private Predicate<String> subscribeApiPaths() {
	return PathSelectors.regex("/subscribe/.*");
    }

    @Bean
    public Docket resourceApis() {
	return new Docket(DocumentationType.SWAGGER_2).groupName("resource-apis").apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
		.paths(resourceApiPaths()).build();
    }

    /**
     * @return
     */
    private Predicate<String> resourceApiPaths() {
	return PathSelectors.regex("/resource/.*");
    }

    
    private ApiInfo apiInfo() {
	ApiInfo apiInfo = new ApiInfoBuilder().title("AppDirect").description("AppDirect APIs").contact("sumeetmi2@gmail.com")
		.license("Appdirect API License").licenseUrl("appdirect API License URL").termsOfServiceUrl("appdirect Terms of Service URL")
		.version("1.0.0").build();
	return apiInfo;
    }
}

