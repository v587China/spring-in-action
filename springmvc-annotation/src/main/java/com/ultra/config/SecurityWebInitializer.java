package com.ultra.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * AbstractSecurityWebApplicationInitializer实现了WebApplication-Initializer，因此Spring会发现它，并用它在Web容器中注册DelegatingFilterProxy。
 * 
 *
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {

}
