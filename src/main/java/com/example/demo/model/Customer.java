package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers")
public class Customer {
    @Id
    private Long id;

    @Column(
            name = "firstname"
    )
    private  String firstname ;

    @Column(
            name = "lastname"
    )
    private  String lastname ;

    @Column(
            name = "DataOfBirth"
    )
    Date bornAt ;

    @Column(
            name = "Password"
    )
    private  String password;

    @Column(
            name = "Email"
    )
    private  String email;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orderSet;



}
