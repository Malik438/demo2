package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product_Order {

    @EmbeddedId
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private OrderProductPK pk;

    @Column(name = "Quantity",nullable = false)
    private  int  quantity ;

    @Column(
            name = "Price"
    )
    private  double price ;

    @Column(
            name = "Vat"
    )
    private  double vat ;

}
