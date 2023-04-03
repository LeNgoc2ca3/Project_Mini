package com.java4.ngoclbph26472.service;

import com.java4.ngoclbph26472.dto.ProductDTO;
import com.java4.ngoclbph26472.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAll();

    ResponseEntity<Product> create(ProductDTO dto);

    ResponseEntity<Product> update(ProductDTO dto);

    ProductDTO findById(Long id);

    ResponseEntity<Product> delete(ProductDTO productDTO);
}
