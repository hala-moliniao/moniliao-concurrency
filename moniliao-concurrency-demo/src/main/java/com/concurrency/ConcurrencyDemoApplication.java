package com.concurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ConcurrencyDemoApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyDemoApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean httpFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new com.concurrency.HttpFilter());
        registrationBean.addUrlPatterns("/threadLocal/*");
        return registrationBean;

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new com.concurrency.HttpInterceptor()).addPathPatterns("/**");
    }
}
