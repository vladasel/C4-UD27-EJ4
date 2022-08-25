package com.ionela.rest;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	.csrf().disable()
    	.authorizeRequests()
    	.antMatchers(HttpMethod.OPTIONS, "/**").authenticated()
        .antMatchers(HttpMethod.GET,"/**").authenticated()
        .antMatchers(HttpMethod.POST,"/**").authenticated()
        .antMatchers(HttpMethod.PUT, "/**").authenticated()
        .antMatchers(HttpMethod.DELETE,"/**").hasRole("admin")
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().httpBasic();
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }

}