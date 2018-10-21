package com.zte.crm.winterspring5;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ConditionalOnProperty(name = "handler.mapping.controller.only",
        havingValue = "true",
        matchIfMissing = true)
public class WebConfig extends DelegatingWebMvcConfiguration {
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping() {
            protected boolean isHandler(Class<?> beanType) {
                return (AnnotatedElementUtils.hasAnnotation(beanType, Controller.class));
            }
        };
    }
}
