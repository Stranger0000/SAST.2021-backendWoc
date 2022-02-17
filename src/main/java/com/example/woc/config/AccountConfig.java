package com.example.woc.config;

import com.example.woc.interceptor.AccountInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xyx
 * @date 2022/2/14 23:55
 */

@Configuration
public class AccountConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccountInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/*");

    }
}
