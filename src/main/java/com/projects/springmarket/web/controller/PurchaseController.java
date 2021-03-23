package com.projects.springmarket.web.controller;

import com.projects.springmarket.domain.Product;
import com.projects.springmarket.domain.PurchaseItem;
import com.projects.springmarket.domain.service.ProductService;
import com.projects.springmarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseItem>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseItem> getProduct(@PathVariable("id") int productId){
        return purchaseService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody PurchaseItem purchaseItem){
        return new ResponseEntity<>(purchaseService.save(purchaseItem), HttpStatus.CREATED);
    }
}
