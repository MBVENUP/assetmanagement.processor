package com.sprint1.assetmanagementsystem.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {
	@ExceptionHandler(NoAccessException.class)
	public @ResponseBody ErrorInfo noAccessExceptionHandler(NoAccessException n, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), n.getMessage(), req.getRequestURI());

	}

	@ExceptionHandler(LoginException.class)
	public @ResponseBody ErrorInfo loginExceptionHandler(LoginException n, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), n.getMessage(), req.getRequestURI());
	}

	@ExceptionHandler(NotFoundException.class)
	public @ResponseBody ErrorInfo userNotFoundExceptionHandler(NotFoundException n, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), n.getMessage(), req.getRequestURI());
	}

}