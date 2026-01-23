package com.productos.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productos.producto.entity.Producto;

@Repository
public interface IProductoRepository extends JpaRepository <Producto, Long>{
    


}