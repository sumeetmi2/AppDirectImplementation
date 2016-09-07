/*
 *  
 * Created on Sep 7, 2016
 *
 */
package com.appdirect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

/**
 * @author SumeetS
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers("/assets/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.antMatchers("/swagger/**", "/v2/api-docs/**","/subscribe/**")
		.permitAll().anyRequest().fullyAuthenticated();
    }

    @Bean
    public TextEncryptor textEncryptor() {
	return Encryptors.noOpText();
    }

}

