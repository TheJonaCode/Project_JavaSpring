package com.projects.springmarket.domain.service;

import com.projects.springmarket.domain.Product;
import com.projects.springmarket.domain.Purchase;
import com.projects.springmarket.persistence.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private CompraRepository compraRepository;

    public List<Purchase> getAll(){
        return compraRepository.getAll();
    }

    public Optional<Purchase> getByClient(int productId){
        return compraRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return compraRepository.save(purchase);
    }

    public boolean delete(int productId){
        return getByClient(clientId).map(purchase ->{
            compraRepository.delete(clientId);
            return true;
        }).orElse(false);
    }
}
