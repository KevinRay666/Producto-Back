package com.productos.producto.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BadResponse {

    String errorCode;
    String message;

    public BadResponse(String errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }
    
}
