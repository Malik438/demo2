package com.example.demo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@ApiModel(description = "Product model information")
@Data
public class ProductDto {


    @ApiModelProperty(value = "Blog product id")
    private  Long id ;

    @ApiModelProperty(value = "Blog product name")
    @NotEmpty
    private  String name ;

    @ApiModelProperty(value = "Blog product price")
    @NotEmpty
    private  double price ;


    @ApiModelProperty(value = "Blog product price")
    @NotEmpty
    private  boolean stockable;


    @ApiModelProperty(value = "Blog product stocks")
    private Set<ProductDto> productDtos;


}
