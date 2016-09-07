/*
 * 
 * Created on Sep 5, 2016
 *
 */
package com.appdirect.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author SumeetS
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.appdirect"})
@EnableAspectJAutoProxy
@SpringBootApplication
public class AppDirectApplication extends SpringBootServletInitializer   {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppDirectApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AppDirectApplication.class, args);
    } 
}
