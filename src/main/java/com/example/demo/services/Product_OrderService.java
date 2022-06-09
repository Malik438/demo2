package com.example.demo.services;

import com.example.demo.Repositories.OrderRepository;
import com.example.demo.Repositories.ProductRepository;
import com.example.demo.Repositories.Product_OrderRepository;
import com.example.demo.dto.ProductOrderDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Product_OrderService {




        public List<Product_Order> getAllProductOrders() ;
        public ProductOrderDto getProductOrderById(long id) ;



        public ResponseEntity<ProductOrderDto> addProductOrder(ProductOrderDto productOrderDTO) ;


        public ProductOrderDto updateProductOrder(ProductOrderDto productOrderDTO, long id) ;



        public void deleteProductOrderById(long id);


    }



