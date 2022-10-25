package com.vodafoneziggo.kinglouie.order;

import com.vodafoneziggo.kinglouie.order.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.function.Function;

public interface OrderRepository extends JpaRepository<Order, Long> {


    Order findByEmailAndAndProductId(String email, Long productId);
}
