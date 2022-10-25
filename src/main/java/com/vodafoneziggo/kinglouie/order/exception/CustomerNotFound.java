package com.vodafoneziggo.kinglouie.order.exception;

public class CustomerNotFound extends RuntimeException {

    public CustomerNotFound(String email) {
        super("Customer with email: " + email + " does not exist");
    }
}
