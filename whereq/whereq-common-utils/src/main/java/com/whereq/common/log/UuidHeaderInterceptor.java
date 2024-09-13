package com.whereq.common.log;

import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;
import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
@ConditionalOnClass(value = EnableFeignClients.class)
public class UuidHeaderInterceptor implements RequestInterceptor {
    /* (non-Javadoc)
     * @see feign.RequestInterceptor#apply(feign.RequestTemplate)
     */
	public static final String FDX_REQ_UUID = "fdx-req-uuid";

    @Override
    public void apply(RequestTemplate template) {
       
		if(MDC.get(FDX_REQ_UUID) != null) {
			template.header(FDX_REQ_UUID, MDC.get(FDX_REQ_UUID));
		}
    }
}

