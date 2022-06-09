package com.example.demo.Controllers;

import com.example.demo.dto.OrderDto;
import com.example.demo.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

      OrderService orderService ;
    @GetMapping
    public List<OrderDto> getAllOrder(){
        return  orderService.getAllOrder();

    }
    @GetMapping("/id")
    public  OrderDto gerorder(Long id){
         return  orderService.getOrder(id);
    }
    @PostMapping("add")
    public OrderDto updaterOrder(OrderDto orderDto,long id){
        return  orderService.updateOrder(orderDto,id);
    }
@DeleteMapping("/id")
    public  void deleteorder(Long id){
        orderService.deleteOrder(id);
    }





}
