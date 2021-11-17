package com.callor.js.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * web.xml 을 대신할 config 클래스
 * AbstractAnnotationConfigDispatcherServletInitializer라는 추상메서드를 상속받음
 */
public class AppWebXmlConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // <context-param>에 설정한 root-context.xml 을 초기화 할 method
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // RootConfig.class 이렇게 적으면... 알아서 RootConfig.class를 가져와서 사용할 준비를 한대요
        return new Class[]{RootConfig.class};
    }

    // <servlet> 에 설정한
    // servlet-context.xml 을 초기화 할 method
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class, MyBatisConfig.class};
    }

    // resources mapping 에 설정한
    // url-pattern 을 초기화 할 method
    @Override
    protected String[] getServletMappings() {

        String[] mapping = new String[]{"/"};

//        return new String[0];
        return mapping;
    }

}
