package com.apirest.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apirest.apirest.repository.ProductoRepository;
import com.apirest.apirest.entity.ProductoEntity;

@RestController
@RequestMapping("/productos")

public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<ProductoEntity> getAllProductos(){
        return productoRepository.findAll();        
    }

    @GetMapping("/{id}")
    public ProductoEntity getProductoById(@PathVariable long id){
        return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el id: " + id));
    }


    @PostMapping
    public ProductoEntity createProducto(@RequestBody ProductoEntity producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public ProductoEntity upadteProducto(@PathVariable long id, @RequestBody ProductoEntity detallesproducto){
        ProductoEntity producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el id: " + id));
        
        producto.setName(detallesproducto.getName());
        producto.setPrice(detallesproducto.getPrice());

        return productoRepository.save(producto);

    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable long id){
        ProductoEntity producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el id: " + id));

        productoRepository.delete(producto);
        return "producto eliminado";
    }



}
