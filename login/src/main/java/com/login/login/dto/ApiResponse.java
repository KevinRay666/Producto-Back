package com.login.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    
    Object data;

    public ApiResponse(Object data){
        this.data = data;
    }
    
}
