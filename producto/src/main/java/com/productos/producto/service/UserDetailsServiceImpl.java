package com.productos.producto.service;

import com.productos.producto.entity.Usuario;
import com.productos.producto.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        String role = userModel.getRol();
        return new User(userModel.getUsername(),
        userModel.getPassword(),
        List.of(new SimpleGrantedAuthority("ROLE_" + role))
    );
    }
}
