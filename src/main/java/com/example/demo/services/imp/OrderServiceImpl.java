package com.example.demo.services.imp;

import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.dto.OrderDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    CustomerRepository customerRepository;
    @Override
    public List<OrderDto> getAllOrder() {

        List <Order> orderList = orderRepository.findAll();

        if(orderList.size() == 0) throw new RuntimeException();
        return  orderList.stream().map(order -> mapToDTO(order)).collect(Collectors.toList());

    }

    @Override
    public OrderDto getOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return mapToDTO(order);


    }


    @Override
    public ResponseEntity<OrderDto> addOrder(OrderDto orderDto) {
        Order order = mapToEntity(orderDto);
        Order newOrder = orderRepository.save(order);
        OrderDto orderResponse = mapToDTO(order);//to do
        return new ResponseEntity<OrderDto>(orderResponse, HttpStatus.CREATED);

    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("order", "id", id);
        });

        order.setDate(orderDto.getDate());
        order.setCustomer(customerRepository.getById(orderDto.getCustomer()));
        Order updatedOrder = orderRepository.save(order);
        return mapToDTO(order);


    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("order", "id", id));
        orderRepository.delete(order);

    }


    private OrderDto mapToDTO(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getOrderId());
        orderDto.setDate(new Date());
        orderDto.setCustomer(order.getCustomer().getId());

        return orderDto;
    }

    // convert DTO to entity
    private Order mapToEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderId(orderDto.getId());
        order.setCustomer(new Customer(orderDto.getCustomer()));
        order.setDate(new Date());

        return order;
    }
}
