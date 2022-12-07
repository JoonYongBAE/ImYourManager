package net.manager.iym.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class CustomServletConfig implements WebMvcConfigurer {
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js", "classpath:/templates/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static.fonts", "classpath:/templates/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css", "classpath:/templates/");
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/assets", "classpath:/templates/");
    }

}
