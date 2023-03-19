package com.krobusiness.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtResponse {
    private String jwtToken;
    
    

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

    
    
}