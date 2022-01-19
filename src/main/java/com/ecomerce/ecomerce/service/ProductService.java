package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.model.Product;

import java.util.List;

public interface ProductService{

    Product createProduct(Product product);
    List<Product> findAll();
}
