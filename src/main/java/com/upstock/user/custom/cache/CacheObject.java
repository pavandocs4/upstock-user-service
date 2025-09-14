package com.upstock.user.custom.cache;


public class CacheObject<T>{
	long ttl;
	private final T value;
	public CacheObject(T value, long ttl) {
		this.value=value;
		this.ttl = System.currentTimeMillis() + ttl;
	}
	
	public boolean isExpired() {
		return this.ttl < System.currentTimeMillis(); 
	}
	
	public T getValue() {
		return value;
	}
	
}
