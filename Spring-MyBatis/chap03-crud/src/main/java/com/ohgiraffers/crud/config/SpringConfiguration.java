package com.ohgiraffers.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.crud")
public class SpringConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource (){
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:/messages/");
        source.setDefaultEncoding("UTF-8");
        source.setCacheSeconds(30);
        Locale.setDefault(Locale.KOREA);

        return source;
    }
}
