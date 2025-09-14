package com.upstock.user.custom.cache;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class CustomCacheManager {
	ConcurrentHashMap<String, CacheObject<Object>> cacheMap = new ConcurrentHashMap<>();
			
			//new ConcurrentHashMap<>();

	public void put(String key, Object value, long ttl) {
		cacheMap.put(key, new CacheObject<>(value, ttl));
	}

	public Object get(String key) {
	
		CacheObject<Object> cacheEntry = cacheMap.get(key);
		if (cacheEntry != null && !cacheMap.get(key).isExpired()) {
			return cacheEntry.getValue();
		} else {
			cacheMap.remove(key);
			return null;
		}
// cacheMap is empty no need to do anything, cacheentry 
	}
}
