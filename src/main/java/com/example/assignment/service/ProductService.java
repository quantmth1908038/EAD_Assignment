package com.example.assignment.service;

import com.example.assignment.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProduct(Pageable pageable);
    int getTotalPage(Pageable pageable);
    ProductEntity getProductById(int id);
    ProductEntity createProduct(ProductEntity p);
    void deleteProduct(int id);
    ProductEntity updateProduct(ProductEntity p);
}
