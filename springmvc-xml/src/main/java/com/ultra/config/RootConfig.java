package com.ultra.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @ClassName: RootConfig
 * @Description: 初始化其他bean(通常驱动后台应用的中间件,数据库层组件)
 * @author fan
 * @date 2019年7月12日 下午1:18:13
 * 
 * @version 6.0
 */
@Configuration
@ComponentScan(basePackages = { "com.ultra" }, excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {

}
