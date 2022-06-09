package com.example.demo.services;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrder();

    OrderDto getOrder(Long id) ;



    ResponseEntity<OrderDto> addOrder(OrderDto orderDto);

     OrderDto updateOrder(OrderDto orderDto, long id);

    void deleteOrder(Long id) ;
}
