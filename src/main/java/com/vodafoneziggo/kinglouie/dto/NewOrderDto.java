package com.vodafoneziggo.kinglouie.dto;

public class NewOrderDto {

    private Long productId;
    private String email;

    public NewOrderDto(Long productId, String email) {
        this.productId = productId;
        this.email = email;
    }

    public Long getProductId() {
        return productId;
    }
    public String getEmail() {
        return email;
    }

}