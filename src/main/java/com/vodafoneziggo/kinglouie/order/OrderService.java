package com.vodafoneziggo.kinglouie.order;

import com.vodafoneziggo.kinglouie.customer.Customer;
import com.vodafoneziggo.kinglouie.dto.NewOrderDto;
import com.vodafoneziggo.kinglouie.dto.PaginatedResponse;
import com.vodafoneziggo.kinglouie.order.exception.CustomerNotFound;
import com.vodafoneziggo.kinglouie.order.exception.DuplicateOrderException;
import com.vodafoneziggo.kinglouie.util.WebRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;
    private static final String USER_API_URL = "https://reqres.in";
    private static final int PER_PAGE = 6;

    public OrderService(OrderRepository repository){
        this.repository = repository;
    }
    public List<Order> findAll(){
        return repository.findAll();
    }

    public UUID create(NewOrderDto newOrder) {
        int currentPage = 1;
        WebRequest webrequest = new WebRequest();
        PaginatedResponse response;
        Customer customer;

        if(repository.findByEmailAndAndProductId(newOrder.getEmail(), newOrder.getProductId()) != null){
            throw new DuplicateOrderException(newOrder.getEmail(), newOrder.getProductId());
        }

        do {
             response = webrequest.makePaginatedRequest(USER_API_URL, "api/users", currentPage++, PER_PAGE);
             customer = response.getContent().stream().filter(
                     c -> c.getEmail().equals(newOrder.getEmail())
             ).findFirst().orElse(null);
        } while(response.hasNext() && customer == null);

        if(customer == null){
            throw new CustomerNotFound(newOrder.getEmail());
        }

        return repository.save(new Order(customer.getEmail(), customer.getFirstName(), customer.getLastName(), newOrder.getProductId())).getOrderId();
    }
}