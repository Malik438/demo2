package com.example.demo.Controllers;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
     private    ProductService productService;




    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @PostMapping("/add")
    public ResponseEntity<ProductDto> insertProduct(@Valid @RequestBody ProductDto product_Dto) {

        return new ResponseEntity<>(productService.insertProduct(product_Dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto product_Dto, @PathVariable long id) {

        return new ResponseEntity<>(productService.updateProduct(product_Dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }


 }
