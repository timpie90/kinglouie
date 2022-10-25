package com.vodafoneziggo.kinglouie.util;

import com.vodafoneziggo.kinglouie.dto.PaginatedResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class WebRequest {

    public PaginatedResponse makePaginatedRequest(String url, String path, int currentPage, int limit){
        return WebClient.builder()
                .baseUrl(url).build().get()
                .uri(builder -> builder.path(path)
                        .queryParam("page", currentPage)
                        .queryParam("per_page", limit).build())
                .retrieve()
                .bodyToMono(PaginatedResponse.class)
                .block();
    }

}
