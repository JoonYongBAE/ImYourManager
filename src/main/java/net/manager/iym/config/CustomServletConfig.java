package net.manager.iym.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class CustomServletConfig implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/js/**").addResourceLocations("classpath:resources/static/js");
        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:resources/static.fonts");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:resources/static/css");
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:resources/static/assets");
    }

}
