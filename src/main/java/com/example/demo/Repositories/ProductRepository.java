package com.example.demo.Repositories;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

     @Query(value="SELECT * FROM product p where p.stockable = 1 and p.id= :pid",nativeQuery = true)
     List<Product> findIsStockable(long pid);






}
