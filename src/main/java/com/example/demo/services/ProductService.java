package com.example.demo.services;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {


    ProductDto insertProduct(ProductDto product_Dto);

    List<Product> getAllProducts();

    ProductDto getProductById(long id);

    ProductDto updateProduct(ProductDto ProductDto, long id);

    void deleteProductById(long id);

    List<ProductDto> findIsStockable(long id);





}
