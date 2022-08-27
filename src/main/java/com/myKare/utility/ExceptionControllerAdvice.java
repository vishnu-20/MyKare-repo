package com.myKare.utility;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myKare.Exception.UserException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setTimeStamp(LocalDate.now());
		errorInfo.setErrorMessage("Service Unavailable");
		
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorInfo> userExceptionHandler(UserException exception){
		
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.UNAUTHORIZED.value());
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setTimeStamp(LocalDate.now());
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.UNAUTHORIZED);
	}
	


}
