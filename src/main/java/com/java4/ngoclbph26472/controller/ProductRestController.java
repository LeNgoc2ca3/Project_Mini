package com.java4.ngoclbph26472.controller;

import com.java4.ngoclbph26472.dto.ProductDTO;
import com.java4.ngoclbph26472.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductDTO> listProductDTO = productService.getAll();
        return ResponseEntity.ok(listProductDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id) {
        ProductDTO productDTO = productService.findById(id);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> post(@RequestBody ProductDTO productDTO) {
        productService.create(productDTO);
        return ResponseEntity.ok(productDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> put (@PathVariable("id") Long id , @RequestBody ProductDTO productDTO){
//        if(!productService.existsById(id)){
//            return ResponseEntity.notFound().build();
//        }
        productService.update(productDTO);
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO){
//        if(!productService.existsById(id)){
//            return ResponseEntity.notFound().build();
//        }
//        ProductDTO dto = new ProductDTO();
//        dto.setId(id);
        System.out.println(productDTO);
        productService.delete(productDTO);
        return ResponseEntity.ok().build();
    }
}
