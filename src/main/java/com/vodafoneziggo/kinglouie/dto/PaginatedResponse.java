package com.vodafoneziggo.kinglouie.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vodafoneziggo.kinglouie.customer.Customer;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;

public class PaginatedResponse extends PageImpl<Customer> {
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PaginatedResponse(@JsonProperty("data") List<Customer> content,
                             @JsonProperty("page") int page,
                             @JsonProperty("per_page") int size,
                             @JsonProperty("total") Long totalElements) {
        super(content, PageRequest.of(page - 1, size), totalElements);
    }
}