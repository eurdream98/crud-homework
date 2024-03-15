package com.ohgiraffers.crud.configuration.messages;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class MessageConfiguration {
@Bean
    public ReloadableResourceBundleMessageSource messageSource(){
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:/messages/message");
    messageSource.setDefaultEncoding("UTF-8");
    Locale.setDefault(Locale.KOREA);
    return messageSource;
}
}
