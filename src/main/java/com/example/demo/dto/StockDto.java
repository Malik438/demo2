package com.example.demo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@ApiModel(description = "Stock model information")
@Data
public class StockDto {
    @ApiModelProperty(value = "Blog stock id")
    private  Long id ;

    @ApiModelProperty(value = "Blog stock quantity")
    @NotEmpty
    private  int quantity ;

    @ApiModelProperty(value = "Blog stock updateDate")
    @NotEmpty
    private Date updateAt ;




}
