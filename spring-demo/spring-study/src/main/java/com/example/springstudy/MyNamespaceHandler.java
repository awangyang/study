package com.example.springstudy;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author wangyang
 * @date 2019/08/19
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
