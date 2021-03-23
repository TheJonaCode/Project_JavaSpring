package com.projects.springmarket.persistence;

import com.projects.springmarket.domain.Purchase;
import com.projects.springmarket.domain.repository.PurchaseRepository;
import com.projects.springmarket.persistence.crud.CompraCrudRepository;
import com.projects.springmarket.persistence.entity.Compra;
import com.projects.springmarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compracrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compracrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compracrudRepository.findByIdCliente(clientId).
                map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPuchase(compracrudRepository.save(compra));
    }
}
