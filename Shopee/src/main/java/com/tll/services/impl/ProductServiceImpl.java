package com.tll.services.impl;

import com.tll.pojo.Product;
import com.tll.repository.ProductRepository;
import com.tll.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return this.productRepository.getProducts(params);
    }

    @Override
    public void addOrUpdate(Product p) {
        this.productRepository.addOrUpdate(p);
    }

    @Override
    public Product getProductById(int id) {
        return this.productRepository.getProductById(id);
    }
}
