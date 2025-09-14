package com.upstock.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.upstock.client.starter.lib.global.exception.UserAlreadyExists;
import com.upstock.client.starter.lib.model.UpstockClientExceptionPojo;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserAlreadyExists.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	private UpstockClientExceptionPojo getUserExistException(UserAlreadyExists e, HttpServletRequest servlet) {
		return new UpstockClientExceptionPojo( e.getCode(), e.getMessage(), servlet.getRequestURI());
	}
	
}
