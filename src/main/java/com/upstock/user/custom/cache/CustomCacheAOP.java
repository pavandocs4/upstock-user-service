package com.upstock.user.custom.cache;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomCacheAOP {
	
	@Autowired
	private CustomCacheManager customCacheManager;
	
	@Around("@annotation(CustomCache)")
	public Object applyOnCache(ProceedingJoinPoint pjp) throws Throwable {
		String key= generateKey(pjp);
		
		 Method method = ((MethodSignature) pjp.getSignature()).getMethod();
		 CustomCache cache = method.getAnnotation(CustomCache.class);
		 long ttl= cache.ttl();
		
		if(customCacheManager.get(key) != null) {
			return customCacheManager.get(key);
		}
		
		Object result = pjp.proceed();
		customCacheManager.put(key, result, ttl);
        return result;
		
	}
	
	private String generateKey(ProceedingJoinPoint joinPoint) {
        return Arrays.toString(joinPoint.getArgs());
        
    }
	

}
