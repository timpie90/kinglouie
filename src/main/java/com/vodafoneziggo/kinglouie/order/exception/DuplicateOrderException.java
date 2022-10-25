package com.vodafoneziggo.kinglouie.order.exception;

public class DuplicateOrderException extends RuntimeException {

    public DuplicateOrderException(String email, Long productId) {
        super("Order from customer with email: " + email + " and product with id: " + productId + " already exists");
    }
}

