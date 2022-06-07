package com.example.demo.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Api(value = "Customer model information")
@Data
public class CustomerDto {

    @ApiModelProperty(value = "Customer id")
    private  Long id ;

    @ApiModelProperty(value = "Customer Firstname")
    @NotEmpty(message = "Name should not be null or empty")
    private  String Firstname ;


    @ApiModelProperty(value = "Customer Lastname")
    @NotEmpty(message = "LastName should not be null or empty")
    private  String Lastname ;


    @ApiModelProperty(value = "Customer DATE")
    @NotEmpty(message = "BornAt should not be null or empty")
    private  String BornAt ;



    @ApiModelProperty(value = "Blog Custoer orders")
    private Set<CustomerDto>  orders;








}
