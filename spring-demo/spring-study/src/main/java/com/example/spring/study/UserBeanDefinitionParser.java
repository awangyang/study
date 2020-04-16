package com.example.spring.study;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author wangyang
 * @date 2019/08/19
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {


    @Override
    protected Class getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String username = element.getAttribute("username");
        String email = element.getAttribute("email");

        if (StringUtils.hasText(username)) {
            bean.addPropertyValue("username", username);
        }

        if (StringUtils.hasText(email)) {
            bean.addPropertyValue("email", email);
        }
    }
}
