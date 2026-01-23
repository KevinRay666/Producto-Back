package com.productos.producto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productos.producto.dto.ApiResponse;
import com.productos.producto.entity.Producto;
import com.productos.producto.service.ProductoService;
import com.productos.producto.util.BadResponse;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/products")
    public ResponseEntity<ApiResponse> getAll() {

        List<Producto> list = productoService.findAll();
        ApiResponse response = new ApiResponse(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ApiResponse> getId(@PathVariable Long id) {

        Optional<Producto> producto = productoService.findById(id);

        if (producto.isEmpty()) {

            BadResponse badResponse = new BadResponse("ID_INVALIDO", "Ingrese un Id valido");
            ApiResponse response = new ApiResponse(badResponse);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }

        ApiResponse response = new ApiResponse(producto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<ApiResponse> saveProducto(@RequestBody Producto producto) {
        try {

            Producto newProducto = productoService.saveProducto(producto);
            ApiResponse response = new ApiResponse(newProducto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            BadResponse badResponse = new BadResponse("Error", e.getMessage());
            ApiResponse response = new ApiResponse(badResponse);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ApiResponse> updateProducto(@RequestBody Producto productoRequest, @PathVariable Long id) {

        Optional<Producto> productoOptional = productoService.findById(id);
        if (productoOptional.isEmpty()) {

            BadResponse badResponse = new BadResponse("ID_INVALIDO", "Ingrese un Id valido");
            ApiResponse response = new ApiResponse(badResponse);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }

        Producto producto = productoOptional.get();
        producto.setId(id);
        producto.setSku(productoRequest.getSku());
        producto.setNombre(productoRequest.getNombre());
        producto.setPrecio(productoRequest.getPrecio());
        producto.setCantidad(productoRequest.getCantidad());

        Producto productoActualizado = productoService.actualizar(producto);

        ApiResponse response = new ApiResponse(productoActualizado);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
