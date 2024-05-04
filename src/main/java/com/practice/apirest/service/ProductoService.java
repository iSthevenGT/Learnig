package com.practice.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.apirest.repository.ProductoRepository;
import com.practice.apirest.entity.ProductoEntity;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoEntity> getAllProductos(){
        return productoRepository.findAll();        
    }

    public ProductoEntity getProductoById(long id){
        return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el id: " + id));
    }

    public ProductoEntity createProducto(ProductoEntity producto){
        return productoRepository.save(producto);
    }

    public ProductoEntity upadteProducto(long id, ProductoEntity detallesproducto){
        ProductoEntity producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el id: " + id));
        
        producto.setName(detallesproducto.getName());
        producto.setPrice(detallesproducto.getPrice());

        return productoRepository.save(producto);

    }


    public String deleteProducto(long id){
        ProductoEntity producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el id: " + id));

        productoRepository.delete(producto);
        return "producto eliminado";
    }
}
