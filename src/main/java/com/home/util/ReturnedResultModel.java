package com.home.util;

import java.util.Objects;

import org.springframework.http.HttpStatus;

public class ReturnedResultModel {

	
	 private String message ;
	 private String error ;
	 private HttpStatus status ;
//	 private Objects result;
	 private Object  result;
	 
	 
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}



}
