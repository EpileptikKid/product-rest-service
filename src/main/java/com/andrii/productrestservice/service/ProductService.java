package com.andrii.productrestservice.service;

import com.andrii.productrestservice.model.Product;
import com.andrii.productrestservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(String sortBy, String search) {
        List<Product> products;
        if (search != null) {
            products = productRepository.findByNameContaining(search);
        } else {
            products = productRepository.findAll();
        }

        switch (sortBy) {
            case "id" -> products.sort(Comparator.comparing(Product::getId));
            case "name" -> products.sort(Comparator.comparing(Product::getName));
            case "country" -> products.sort(Comparator.comparing(Product::getSupplierCountry));
            case "price" -> products.sort(Comparator.comparing(Product::getPricePerKg));
        }

        return products;
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    public Product delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return product.get();
        } else {
            return null;
        }
    }
}
