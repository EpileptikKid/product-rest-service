package com.andrii.productrestservice.controller;

import com.andrii.productrestservice.dto.ProductDTO;
import com.andrii.productrestservice.model.Product;
import com.andrii.productrestservice.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> getAllGroups(@RequestParam(defaultValue = "id") String sortBy,
                                                      @RequestParam(required = false) String search) {
        return ResponseEntity.ok(productService.getAllProducts(sortBy, search).stream().map(this::convertToProductDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getById(id);
        return product.map(prod -> ResponseEntity.ok(convertToProductDTO(prod)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(convertToProductDTO(productService.save(product)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id,
                                                      @RequestBody Product product) {
        Product updatedProduct = productService.update(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(convertToProductDTO(updatedProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product deletedProduct = productService.delete(id);
        if (deletedProduct != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private ProductDTO convertToProductDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
}
