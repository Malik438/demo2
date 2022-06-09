package com.example.demo.services.imp;

import com.example.demo.Repositories.OrderRepository;
import com.example.demo.Repositories.ProductRepository;
import com.example.demo.Repositories.Product_OrderRepository;
import com.example.demo.dto.ProductOrderDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product_Order;
import com.example.demo.services.Product_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Product_OrderServiceImpl   implements Product_OrderService {

    @Autowired
    Product_OrderRepository productOrderRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    public List<Product_Order> getAllProductOrders() {
        return productOrderRepository.findAll();
    }

    public ProductOrderDto getProductOrderById(long id) {
//        Product_Order productOrder = productOrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product_order", "id", id));
//        return mapToDTO(productOrder);
return null;
    }

    public ResponseEntity<ProductOrderDto> addProductOrder(ProductOrderDto productOrderDTO) {

//        Product_Order productOrder = mapToEntity(productOrderDTO);
//        Product_Order newProductOrder = productOrderRepository.save(productOrder);
//         ProductOrderResponse = mapToDTO(productOrder);
//        return new ResponseEntity<productOrderDTO>(ProductOrderResponse, HttpStatus.CREATED);
return null;

    }

    @Override
    public ProductOrderDto updateProductOrder(ProductOrderDto productOrderDTO, long id) {
        return null;
    }


    public void deleteProductOrderById(long id) {
//        Product_Order productOrder = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product_order", "id", id));
//        productOrderRepository.delete(productOrder);
        return;
    }


    // convert Entity into DTO
    private ProductOrderDto mapToDTO(Product_Order productOrder) {
        ProductOrderDto productOrderDTO = new ProductOrderDto();

        productOrderDTO.setPrice(productOrder.getPrice());
        productOrderDTO.setQuantity(productOrder.getQuantity());
    ;

        return productOrderDTO;
    }

    // convert DTO to entity
    private Product_Order mapToEntity(ProductOrderDto productOrderDTO) {
        Product_Order productOrder = new Product_Order();
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setVat(productOrderDTO.getVat());
        return productOrder;
    }
}
