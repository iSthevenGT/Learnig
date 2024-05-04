package com.practice.apirest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;


import com.practice.apirest.service.ProductoService;
import com.practice.apirest.entity.ProductoEntity;

@RestController
@RequestMapping("/productos")

public class ProductoController {

    private ProductoService productoService;

    @GetMapping
    public List<ProductoEntity> getAllProductos(){
        return productoService.getAllProductos();        
    }

    @GetMapping("/{id}")
    public ProductoEntity getProductoById(@PathVariable long id){
        return productoService.getProductoById(id);
    }


    @PostMapping
    public ProductoEntity createProducto(@RequestBody ProductoEntity producto){
        return productoService.createProducto(producto);
    }

    @PutMapping("/{id}")
    public ProductoEntity upadteProducto(@PathVariable long id, @RequestBody ProductoEntity detallesproducto){
        return productoService.upadteProducto(id, detallesproducto);

    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable long id){
        return productoService.deleteProducto(id);
    }



}
