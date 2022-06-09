package com.example.demo.dto;


import com.example.demo.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderDto {

    private Long order_id;
    private Long product_id;
    private Integer quantity;
    private Double price;
    private Integer vat;
    }
