package com.bxia.bookstore.config;

import com.bxia.bookstore.enums.Gender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 性别转换
     * @return
     */
    @Bean
    public Converter<String, Gender> converter(){
        return new Converter<String, Gender>() {
            @Override
            public Gender convert(String s) {
                return Gender.valueOf(Integer.valueOf(s));
            }
        };
    }
}
