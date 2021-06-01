package com.example.assignment.service;


import com.example.assignment.entity.ProductEntity;
import com.example.assignment.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<ProductEntity> getAllProduct(Pageable pageable) {
        return productRepo.findAll(pageable).getContent();
    }

    @Override
    public int getTotalPage(Pageable pageable) {
        return productRepo.findAll(pageable).getTotalPages();
    }

    @Override
    public ProductEntity getProductById(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public ProductEntity createProduct(ProductEntity p) {
        return productRepo.save(p);
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity p) {
        return productRepo.save(p);
    }
}
