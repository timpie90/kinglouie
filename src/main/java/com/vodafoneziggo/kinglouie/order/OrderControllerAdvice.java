package com.vodafoneziggo.kinglouie.order;

import com.vodafoneziggo.kinglouie.order.exception.CustomerNotFound;
import com.vodafoneziggo.kinglouie.order.exception.DuplicateOrderException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class OrderControllerAdvice {

    @ResponseBody
    @ExceptionHandler(DuplicateOrderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String duplicateOrderHandler(DuplicateOrderException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CustomerNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String customerNotFoundHandler(CustomerNotFound ex) {
        return ex.getMessage();
    }
}