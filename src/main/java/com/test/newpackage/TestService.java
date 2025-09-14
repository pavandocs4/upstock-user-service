package com.test.newpackage;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	public double randomNoGenerator() {
		return Math.random();
	}
}
