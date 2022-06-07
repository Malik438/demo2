package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "stocks")
public class Stock {
    @Id
    Long stockId ;

    private  int quantity ;

    private Date updateAt ;
    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;






}
