
package com.nextshop.product.service;

import com.nextshop.product.dto.*;
import com.nextshop.product.entity.Product;
import com.nextshop.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    public List<ProductResponse> getAll() {
        return repo.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public ProductResponse getById(Long id) {
        return repo.findById(id).map(this::toResponse).orElseThrow();
    }

    public List<ProductResponse> search(String keyword) {
        return repo.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(keyword, keyword)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    public ProductResponse create(ProductRequest request) {
        Product p = new Product();
        updateEntity(p, request);
        return toResponse(repo.save(p));
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product p = repo.findById(id).orElseThrow();
        updateEntity(p, request);
        return toResponse(repo.save(p));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private void updateEntity(Product p, ProductRequest req) {
        p.setName(req.getName());
        p.setDescription(req.getDescription());
        p.setPrice(req.getPrice());
        p.setStock(req.getStock());
        p.setCategory(req.getCategory());
    }

    private ProductResponse toResponse(Product p) {
        ProductResponse res = new ProductResponse();
        res.setId(p.getId());
        res.setName(p.getName());
        res.setDescription(p.getDescription());
        res.setPrice(p.getPrice());
        res.setStock(p.getStock());
        res.setCategory(p.getCategory());
        res.setImageUrl(p.getImageUrl());
        return res;
    }
}
