package com.whereq.common.log;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(Integer.MIN_VALUE)
@Slf4j
@WebFilter("/*")
public class ControllerFilter extends OncePerRequestFilter {

	public static final String FDX_REQ_UUID = "fdx-req-uuid";
	@Value(value="${fdx.utils.log.uid:WhereQ_UID}")
	private String headerName;

	@Value(value="${fdx.utils.log.exlcludeUrls:/ping,/v3/api-docs/**,/swagger-ui/**,/swagger-ui.html**,/webjars/**,/actuator/**,/csrf,/cloudfoundryapplication/**}")
	private Set<String> exlcludeUrls;
	@Value(value="${security.exclude.urls:}")
	private Set<String> exlcludeUrls2;

	@Autowired
	private PathMatcher pm;

	@Override
	protected void doFilterInternal(HttpServletRequest httpReq, HttpServletResponse httpResp, FilterChain chain) throws ServletException, IOException {
		Instant start = Instant.now();
		String callById = httpReq.getHeader(headerName);
		StringBuilder message = new StringBuilder();
	
		String reqUUIID = httpReq.getHeader(FDX_REQ_UUID);
		try {
			httpReq.getParameterMap().entrySet().stream().forEach(e->message.append(e.getKey()).append(":").append(Arrays.toString(e.getValue())).append(","));
			if(reqUUIID == null) {
				String uid = UUID.randomUUID().toString().toUpperCase().replace("-", "");
				reqUUIID = (callById!=null && !callById.isEmpty()) ? callById.concat("-").concat(uid) : uid;
				MDC.put(FDX_REQ_UUID, reqUUIID);
				log.info("FDX_REQ_UUID {} created by {} ", reqUUIID, callById);
			} else {
				MDC.put(FDX_REQ_UUID, reqUUIID);
				log.info("FDX_REQ_UUID {} retrived from caller {} ", reqUUIID, callById);
			}
			httpReq.setAttribute("fdx-start", start.toEpochMilli());
			httpResp.addHeader(FDX_REQ_UUID, reqUUIID);
			httpResp.addHeader("fdx-start", String.valueOf(start.toEpochMilli()));
			log.info(" --> [CALL]: {} by:({}) {}: {} ", httpReq.getMethod(), callById, httpReq.getRequestURI(), message);

			chain.doFilter(httpReq, httpResp);

		} finally {
			Instant finish = Instant.now();
			long time = Duration.between(start, finish).toMillis();
			String pattren = " <---[CALL] :{} {} by:({}) {}: {}------- ({}ms)";
			if (httpResp.getStatus() >= 200 && httpResp.getStatus() < 300) {
				log.info(pattren, httpReq.getMethod(), HttpStatus.valueOf(httpResp.getStatus()), callById, httpReq.getRequestURI(), message, time);
			} else if (httpResp.getStatus() < 400) {
				log.warn(pattren, httpReq.getMethod(), HttpStatus.valueOf(httpResp.getStatus()), callById, httpReq.getRequestURI(), message, time);
			} else {
				log.error(pattren, httpReq.getMethod(), HttpStatus.valueOf(httpResp.getStatus()), callById, httpReq.getRequestURI(), message, time);
			}
			MDC.remove(FDX_REQ_UUID);
		}
	}
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String path = request.getRequestURI();
		if(path != null) {
			for (String url : getExlcludeUrls()){
				if (pm.match(url,path)) return true;
			}
		}
		return false;
	}
	private Set<String> getExlcludeUrls() {
		if(exlcludeUrls2!=null && !exlcludeUrls2.isEmpty()) exlcludeUrls.addAll(exlcludeUrls2);
		return exlcludeUrls;
	}
}

