package com.pkuokuo.jwtdemo.config;

import com.pkuokuo.jwtdemo.handler.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author pkuoukuo
 * @date 2021/8/17 14:07
 * <功能简介>
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Autowired
    private LoginHandler loginHandler;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 如果配置项目名，则拦截项目后面的地址，
        //比如配置访问项目名地址为  springboot,则拦截的是"localhost:8080/springboot/hello" 后面的地址
        // 如果没有配置项目名，则拦截地址为 "localhost/hello" 后面的地址
//        registry.addInterceptor(loginHandler).addPathPatterns( "/**").excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        registry.addInterceptor(loginHandler).addPathPatterns( "/**");

    }

}
