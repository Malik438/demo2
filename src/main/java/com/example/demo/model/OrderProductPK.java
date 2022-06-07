package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Optional;
@Setter
@Getter

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "order")
public class OrderProductPK implements Serializable {
    private  static  final  long serialVersionID = 476151177562655457l;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private  Order order ;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private  Product product;


}
