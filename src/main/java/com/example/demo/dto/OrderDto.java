package com.example.demo.dto;


import com.example.demo.model.Customer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@ApiModel(description = "Order model information")
@Data
public class OrderDto {



    @ApiModelProperty(value = "Blog order id ")
    private Long id ;


    @ApiModelProperty(value = "blog orders customers")
    @NotEmpty
    private Long customer;


    @ApiModelProperty(value = "blog order date")
    @NotEmpty
    private Date date;




}
