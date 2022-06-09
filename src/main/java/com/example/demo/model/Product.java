package com.example.demo.model;

import com.example.demo.Repositories.ProductRepository;
import com.example.demo.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class Product   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId")
    long productId;

    private  String slug ;

    private  String name ;

    private  String reference ;

    private  double price ;

    private  double vat ;

    private  boolean stockable ;

    @OneToMany(mappedBy = "product")
    private Set<Stock> stocks;





}
