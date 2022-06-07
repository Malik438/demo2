package com.example.demo.services.imp;


import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl  {

    @Autowired
    private  final CustomerRepository customerRepository ;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;




    }






}
