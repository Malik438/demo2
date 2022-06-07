package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "orders")
public class Order {
    @Id
    @Column(name = "orderId")
    private Long orderId ;

    @Column(
            name = "DateTime"
    )
    private  Date date ;

    @ManyToOne
    @JoinColumn(name ="customerId" , nullable = false)
    private  Customer  customer ;
}
