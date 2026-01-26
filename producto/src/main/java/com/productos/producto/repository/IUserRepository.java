package com.productos.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.producto.entity.Usuario;

@Repository
public interface IUserRepository extends JpaRepository <Usuario, Long>{
 public Usuario findByUsername(String user);
}
