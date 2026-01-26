package com.productos.producto.service;

import com.productos.producto.entity.Usuario;
import com.productos.producto.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario userModel = this.iUserRepository.findByUsername(username);
        if(userModel == null) {
            throw  new UsernameNotFoundException(username);
        }
        return new User(userModel.getUsername(), userModel.getPassword(), new ArrayList<>());
    }
}
