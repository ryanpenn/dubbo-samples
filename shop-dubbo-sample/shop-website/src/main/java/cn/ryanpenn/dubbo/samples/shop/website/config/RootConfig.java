package cn.ryanpenn.dubbo.samples.shop.website.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * RootConfig.
 */
@Configuration
@ComponentScan(basePackages = {"cn.ryanpenn.dubbo.samples.shop.website"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
@ImportResource({"classpath:dubbo-context.xml"})
public class RootConfig {

}
