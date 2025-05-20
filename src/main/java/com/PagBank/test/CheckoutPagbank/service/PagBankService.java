package com.PagBank.test.CheckoutPagbank.service;

import com.PagBank.test.CheckoutPagbank.model.Checkout;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PagBankService {

    private final WebClient webClient;

    public PagBankService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://sandbox.api.pagseguro.com/checkouts")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer 92de68c1-d123-42fa-be33-0d60def3958390c36cdc4a10956174a45186c40c0fd44a52-f543-43a7-8c65-edec58360c4a")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<String> criarCheckout(Checkout checkout){
        return webClient.post()
                .uri("/checkouts")
                .bodyValue(checkout)
                .retrieve()
                .bodyToMono(String.class);
    }
}
