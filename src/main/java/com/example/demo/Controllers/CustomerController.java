package com.example.demo.Controllers;

import com.example.demo.dto.CustomerDto;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
      private CustomerService customerService;
    @GetMapping
    public List<CustomerDto> getAllCustomers(){
        return    customerService.getAllCustomers();

    }

    @PostMapping("/add")
    public CustomerDto addCustomer(CustomerDto customerDto){
      return   customerService.createCustomer(customerDto);
    }



}
