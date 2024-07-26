package com.example.q3_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping("/{id}/stock")
    public ResponseEntity<?> updateStock(@PathVariable Long id, @RequestBody StockUpdateRequest request) {
        try {
            Product updatedProduct = productService.updateStock(id, request.getStock());
            return ResponseEntity.ok(new StockUpdateResponse("Stock updated successfully", updatedProduct));
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Product not found");
        }
    }
}

class StockUpdateRequest {
    private int stock;

    // Getters and Setters

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

class StockUpdateResponse {
    private String message;
    private Product product;

    public StockUpdateResponse(String message, Product product) {
        this.message = message;
        this.product = product;
    }

    // Getters

    public String getMessage() {
        return message;
    }

    public Product getProduct() {
        return product;
    }
}
