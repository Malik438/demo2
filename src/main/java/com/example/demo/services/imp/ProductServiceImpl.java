package com.example.demo.services.imp;

import com.example.demo.Repositories.ProductRepository;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl  implements ProductService {

  private    ProductRepository productRepository ;





    @Override
    public List<ProductDto> findIsStockable(long id) {
        List<Product> products = productRepository.findIsStockable(id);

        return products.stream().map(prod -> mapToDTO(prod)).collect(Collectors.toList());
    }
    @Override
    public ProductDto insertProduct(ProductDto product_Dto) {

        Product prod = mapToEntity(product_Dto);
        Product newProduct = productRepository.save(prod);

        ProductDto productResponse = mapToDTO(newProduct);
        return productResponse;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> prods = productRepository.findAll();
        return prods.stream().map(prod -> mapToDTO(prod)).collect(Collectors.toList());

    }

    @Override
    public ProductDto getProductById(long id) {
        Product prods = productRepository.findById(id).orElseThrow();
        return mapToDTO(prods);
    }

    @Override
    public ProductDto updateProduct(ProductDto product_Dto, long id) {
        Product prod = productRepository.findById(id).orElseThrow();
        prod.setName(product_Dto.getName());
        prod.setPrice(product_Dto.getPrice());

        prod.setStockable(product_Dto.isStockable());

        Product updatedProduct = productRepository.save(prod);
        return mapToDTO(updatedProduct);
    }

    @Override
    public void deleteProductById(long id) {
        Product prods = productRepository.findById(id).orElseThrow();
        productRepository.delete(prods);
    }

    private ProductDto mapToDTO(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    // convert DTO to entity
    private Product mapToEntity(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
