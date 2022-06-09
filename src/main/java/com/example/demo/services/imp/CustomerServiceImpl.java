package com.example.demo.services.imp;


import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements  CustomerService  {

    @Autowired
    private  final CustomerRepository customerRepository ;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;


    }


    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer=mapToEntity(customerDto);
        Customer newCustomer = customerRepository.save(customer);
        CustomerDto customerResponse =mapToDTO(newCustomer);
        return customerResponse;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> cutomers = customerRepository.findAll();
        return cutomers.stream().map(customer -> mapToDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return mapToDTO(customer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return mapToDTO(customer);
    }


    @Override
    public CustomerDto updateCustomer(CustomerDto CustomerDto, long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setFirstname(CustomerDto.getFirstname());
        customer.setLastname(CustomerDto.getLastname());
        customer.setBornAt(CustomerDto.getBornAt());
        Customer updatedCustomer = customerRepository.save(customer);

        return mapToDTO(updatedCustomer);
    }

    @Override
    public void deleteCustomerById(long id) {
        Customer customer=customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customer);

    }

    private CustomerDto mapToDTO(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstname(customer.getFirstname());
        customerDto.setLastname(customer.getLastname());
        customerDto.setBornAt(customer.getBornAt());

        return customerDto;
    }

    // convert DTO to entity
    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());
        customer.setBornAt(customerDto.getBornAt());

        return customer;
    }
}
