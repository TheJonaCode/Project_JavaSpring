package com.projects.springmarket.persistence;

import com.projects.springmarket.persistence.crud.ProductoCrudRepository;
import com.projects.springmarket.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
