package com.szafranski.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return null;
	}

	//configuration class (DemoAppConfig)
	@Override
	protected Class<?>[] getServletConfigClasses() {
	
		return new Class[] {DemoAppConfig.class};
	}

	//servlet mapping - dispatcher
	@Override
	protected String[] getServletMappings() {
		
		return new String[] { "/" };
	}

}
