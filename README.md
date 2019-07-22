# springmvc启动需要创建DispatcherServlet和ContextLoaderListener

DispatcherServlet:初始化控制器,视图解析器,处理器映射
ContextLoaderListener:初始化其他bean(通常驱动后台应用的中间件,数据库层组件)

## 方式一纯注解方式(SpittrWebAppInitializer)
    继承AbstractAnnotationConfigDispatcherServletInitializer
    实现以下方法
    getServletConfigClasses():返回控制器,视图解析器,处理器映射注解类
    getRootConfigClasses():返回扫描注册其他bean(通常驱动后台应用的中间件,数据库层组件)注解类
    getServletMappings():返回DispatcherServlet映射的路径

## 方式二纯xml方式(web_xml.xml)
    web.xml
    加载org.springframework.web.context.ContextLoaderListener
    指定:初始化其他bean(通常驱动后台应用的中间件,数据库层组件)的xml
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring/root-context.xml</param-value>
    </context-param>
    加载org.springframework.web.servlet.DispatcherServlet
    指定:初始化控制器,视图解析器,处理器映射的xml,并随系统启动
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring/servlet-context.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>

## 方式三xml加注解(web_annotation.xml)
    web.xml
    指定使用注解的ApplicationContext
    <context-param>
        <param-name>contextClass</param-name>
        <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
    </context-param>
    加载org.springframework.web.context.ContextLoaderListener
    指定:初始化其他bean(通常驱动后台应用的中间件,数据库层组件)的注解类
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>com.ultra.config.RootConfig</param-value>
    </context-param>
    加载org.springframework.web.servlet.DispatcherServlet
    指定使用注解的ApplicationContext
    <init-param>
        <param-name>contextClass</param-name>
        <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
    </init-param>
    指定:初始化控制器,视图解析器,处理器映射的注解类,并随系统启动
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>com.ultra.config.WebConfig</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>