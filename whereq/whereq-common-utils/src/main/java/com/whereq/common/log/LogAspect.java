package com.whereq.common.log;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Slf4j
@Component
public class LogAspect {
	private static final int LENGTH = 100;
    /**
     * Spring Pointcut that matches all repositories, services and Web REST endpoints.
     */
    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
        " || within(@org.springframework.stereotype.Service *)" +
        " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void spring() {
    }

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controller() {
    }

    @Pointcut("within(com.whereq..*)")
    public void whereq() {
    }

    @Pointcut("within(@com.whereq.common.log.Loggable *) || @annotation(com.whereq.common.log.Loggable)")
    public void loggable() {}

	@Pointcut("within(@com.whereq.common.log.NotLoggable *) || @annotation(com.whereq.common.log.NotLoggable)")
    public void notLoggable() {}

    @Around("!notLoggable() && ((spring() && whereq()) || loggable())")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.nanoTime();

        String request = String.format("%s.%s args:[%s]", 
            joinPoint.getSignature().getDeclaringType().getSimpleName(), // class name
            joinPoint.getSignature().getName(),              // method name
            toShortString(joinPoint.getArgs())               // arguments
        );

        // log rerequest
        log.info("-> {}", request);

        Object result = null;
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Throwable t) {
            result = t;
            throw t;
        } finally {
            // time elapsed in milliseconds
            long timeElapsed = (System.nanoTime() - startTime) / 1000000;

            String response = String.format("%s %dms return:[%s]", request, timeElapsed, toShortString(result));

            if (result instanceof Throwable) {
                log.error("<- error: {}", response);
            } else if (timeElapsed > 5000) {
                log.warn("<- (5s) {}", response);
            } else {
                log.info("<- {}", response);
            }
        }
    }

    private String toShortString(Object[] objs) {
		if(objs == null || objs.length == 0) return null;
		
		StringBuilder strBuf = new StringBuilder();
		for(int i=0; i<objs.length; i++) {
			strBuf.append(toShortString(objs[i])).append(",");
		}
		return strBuf.substring(0, strBuf.length() - 1);
	}

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@SuppressWarnings("rawtypes")
	private String toShortString(Object obj) {
		if(obj == null) return null;

		StringBuilder str = new StringBuilder(obj.getClass().getSimpleName());

		
		if(obj instanceof ResponseEntity) {
			str.append("(").append(toShortString(((ResponseEntity)obj).getBody())).append(")");
		} else if(obj instanceof String || obj instanceof Number || obj instanceof Boolean) {
			str.append("(").append(shortString(obj.toString())).append(")");
		} else if(obj instanceof Date) {
			str.append("(").append(sdf.format(obj)).append(")");
		} else if(obj instanceof Collection) {
			str.append("(");
			Collection c = (Collection)obj;
			str.append(c.size());
			
			if(!c.isEmpty()) {
				Object o = c.iterator().next();
				str.append(" ").append(o == null? "(null)" : o.getClass().getSimpleName());
			}
			str.append(")"); 
		} else if(obj instanceof Throwable) {
			Throwable t = (Throwable)obj;
			String stackTrace = Arrays.asList(t.getStackTrace()).stream().limit(10).map(e -> String.valueOf(e).replaceAll("\\B\\w+(\\.[a-z])","$1")).collect(Collectors.joining("\n", "\n{\n", "\n}\n"));
			str.append("(cause:(")
			.append(getCauseException(t).getMessage())
			.append(")")
			.append(stackTrace)
			.append(")"); 
		} else {
			// str.append("(").append(obj.getClass().getSimpleName()).append(":").append(shortString(obj.toString())).append(")");
		}
		
		return str.toString();
	}

    private Throwable getCauseException(Throwable t) {
        Throwable cause = t.getCause();
        return cause == null ? t : getCauseException(cause);  
	}

    private String shortString(String str) {
        if(str == null) return null;

        if(str.length()<=LENGTH) return str;
        
        return str.subSequence(0, LENGTH) + "..";
    }

	@AfterReturning("controller() && whereq()")
	public void logAfterController(JoinPoint joinPoint) {
		ServletRequestAttributes reqAttr = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		if(reqAttr != null)  {
			HttpServletResponse httpResp = reqAttr.getResponse();

			HttpServletRequest httpReq = reqAttr.getRequest();
			if (httpResp != null)  {
				httpReq.getAttribute("fdx-start");
				// Collection<String> startHeaders = httpResp.getHeaders("fdx-start");
				// long time = -1;
				// if(startHeaders != null && !startHeaders.isEmpty()) {
				// 	try {
				// 		time = Instant.now().toEpochMilli() - Long.parseLong((startHeaders.iterator().next()));
				// 	} catch (UnsupportedOperationException e) {
				// 		log.error(e.getMessage(),e);
				// 	}
				// }
				long time = Instant.now().toEpochMilli() - (Long)httpReq.getAttribute("fdx-start");
				httpResp.addHeader("fdx-cost",String.valueOf(time));
			}
		}
	}
}