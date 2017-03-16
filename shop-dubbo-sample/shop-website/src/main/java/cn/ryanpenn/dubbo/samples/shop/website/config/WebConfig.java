package cn.ryanpenn.dubbo.samples.shop.website.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * WebConfig
 */
@EnableWebMvc
@Configuration
@ComponentScan("cn.ryanpenn.dubbo.samples.shop.website.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setViewClass(org.springframework.web.servlet.view.freemarker.FreeMarkerView.class);
        resolver.setCache(true); // 开发时可以关闭缓存
        resolver.setContentType("text/html; charset=utf-8");
        //resolver.setViewNames("ftl/*");
        //resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setOrder(0);
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer getFreemarkerConfig() {
        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
        result.setTemplateLoaderPath("WEB-INF/view/");
        return result;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}