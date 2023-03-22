package com.fedex.framework.util;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("squid:S3010")
public class SpringUtil {
    private static ApplicationContext applicationContext;

    public SpringUtil(ApplicationContext context) {
        applicationContext = context;
    }

    
    public static <T> T getBean(Class<T> clazz) {
        if (applicationContext == null) {
            throw new RuntimeException("Spring Context is not ready");
        }

        return applicationContext.getBean(clazz);
    }
}
