package com.example.demo.services;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto CustomerDto);

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(long id);

    CustomerDto getCustomerById(Long id);

    CustomerDto updateCustomer(CustomerDto CustomerDto, long id);

    void deleteCustomerById(long id);




}
