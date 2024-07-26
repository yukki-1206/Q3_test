package com.example.q3_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product updateStock(Long id, int newStock) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            throw new Exception("Product not found");
        }
        Product product = optionalProduct.get();
        product.setStock(newStock);
        return productRepository.save(product);
    }
}
