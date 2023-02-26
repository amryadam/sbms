package com.amryadam.sbms.model.administration;


import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class AuthenticationRequest {

    private String username;
    private String password;

    AuthenticationRequest(String username,String password){
        this.password = password;
        this.username = username;
    }
}
