package com.gabrielczar.bootmicroservices.services;

import com.gabrielczar.bootmicroservices.repositories.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailService {
    private ProductDetailRepository repository;

    @Autowired
    public ProductDetailService(ProductDetailRepository repository) {
        this.repository = repository;
    }

    public boolean isValidInventory(String inventoryId) {
        return !repository.existsByInventoryId(inventoryId);
    }
}
