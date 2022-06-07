package com.example.demo.Repositories;

import com.example.demo.model.OrderProductPK;
import com.example.demo.model.Product_Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product_OrderRepository extends JpaRepository<Product_Order, OrderProductPK> {
}
