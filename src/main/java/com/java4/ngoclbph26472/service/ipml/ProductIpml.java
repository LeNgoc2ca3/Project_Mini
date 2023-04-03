package com.java4.ngoclbph26472.service.ipml;

import com.java4.ngoclbph26472.dto.ProductDTO;
import com.java4.ngoclbph26472.entity.Product;
import com.java4.ngoclbph26472.repositories.ProductRepo;
import com.java4.ngoclbph26472.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductIpml implements ProductService {

    @Autowired
    ProductRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<ProductDTO> getAll() {
        List<Product> listProduct = repo.findAll();
        TypeToken<List<ProductDTO>> typeToken = new TypeToken<>() {
        };
        List<ProductDTO> listProductDTO = mapper.map(listProduct, typeToken.getType());
        return listProductDTO;
    }

    @Override
    public ResponseEntity<Product> create(ProductDTO dto) {
//        Product product = mapper.map(dto,Product.class);
//        return repo.save(mapper.map(dto,Product.class));
        Product product = mapper.map(dto, Product.class);
        product.setCreateDate(LocalDateTime.now());
        if (!repo.existsById(product.getId())) {

            return ResponseEntity.ok(repo.save(product));
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Product> update(ProductDTO dto) {
        Product product = mapper.map(dto, Product.class);
        product.setLastModifiedDate(LocalDateTime.now());
        if (repo.existsById(product.getId())) {
            return ResponseEntity.ok(repo.save(product));
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> optional = repo.findById(id);
        if (optional.isPresent()) {
            ProductDTO productDTO = mapper.map(optional.get(), ProductDTO.class);
            return productDTO;
        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity<Product> delete(ProductDTO dto) {
//        Product product1 = new Product();
//        for (Product product : repo.findAll()) {
//            if(product.getId().equals(id)){
//                product1 = product;
//            }
//        }
        Product product = mapper.map(dto, Product.class);
        product.setDeleted(true);
        if (repo.existsById(product.getId())) {
            return ResponseEntity.ok(repo.save(product));
        }
        return ResponseEntity.badRequest().build();
    }
}
