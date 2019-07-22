package com.ultra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 
 * @ClassName: WebConfig
 * @Description: 初始化控制器,视图解析器,处理器映射
 * @author fan
 * @date 2019年7月12日 下午1:17:13
 * 
 * @version 6.0
 */
@Configuration
@EnableWebMvc // 启用Spring mvc
@ComponentScan("com.ultra.web") // 组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 
     * 配置JSP视图解析器
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        String prefix = "/WEB-INF/views/";
        String suffix = ".jsp";
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(prefix, suffix);
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 配置静态资源处理
     * 
     * @date 2019年7月12日,下午1:21:43
     * @author fan
     * @version 6.0
     *
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer)
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
