package com.vodafoneziggo.kinglouie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodafoneziggo.kinglouie.dto.NewOrderDto;
import com.vodafoneziggo.kinglouie.order.OrderController;
import com.vodafoneziggo.kinglouie.order.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//TODO create integration tests, not enough time right now

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OrderController.class)
class CreateOrderTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private OrderService orderService;

    @Test
    void whenValidInput_thenReturns201() throws Exception {
        NewOrderDto newOrder = new NewOrderDto(1234L, "emma.wng@reqres.in");
        mockMvc.perform(post("/orders")
                        .contentType(MediaType.valueOf("application/json"))
                        .content(objectMapper.writeValueAsString(newOrder)))
                .andExpect(status().isCreated());
    }

    @Test
    void whenValidRequest_thenReturns200() throws Exception {
        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk());
    }

}

