package com.login.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.login.entity.Usuario;
import com.login.login.repository.IUsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public Usuario getUser(String username, String password){

        return usuarioRepository.findByUsernameAndPassword(username, password);

    }

}
