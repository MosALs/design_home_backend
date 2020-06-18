package com.home.security.model;

import lombok.Getter;
import lombok.Setter;



public class AuthenticationResponse {

    private String jwt ;


    public AuthenticationResponse(String jwt) {
    }

    public AuthenticationResponse() {

    }

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
    
    
}
