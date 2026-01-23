package com.productos.producto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.producto.entity.Producto;
import com.productos.producto.repository.IProductoRepository;


@Service
public class ProductoService {

    @Autowired
    private IProductoRepository productoRepository;


        public List<Producto>findAll(){
        List<Producto> productos = productoRepository.findAll();
        List<Producto> productosEnexisteList = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCantidad() > 0) {
                productosEnexisteList.add(producto);
            }
        }
        return productosEnexisteList;
    }

       public Optional<Producto> findById(Long id){
            return productoRepository.findById(id);
    }
    
}
