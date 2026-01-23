package com.login.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.login.dto.ApiResponse;
import com.login.login.entity.Usuario;
import com.login.login.service.UsuarioService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario request) {

        Usuario usuario = usuarioService.getUser(
                request.getUsername(),
                request.getPassword()
        );

        if (usuario == null) {
            return ResponseEntity.badRequest().body(
                new ApiResponse("Usuario o contraseña incorrectos")
            );
        }

        return ResponseEntity.ok(
            new ApiResponse( usuario)
        );
    }

}
