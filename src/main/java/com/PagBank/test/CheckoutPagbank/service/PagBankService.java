package com.PagBank.test.CheckoutPagbank.service;

import com.PagBank.test.CheckoutPagbank.model.Checkout;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PagBankService {

    private final RestTemplate restTemplate;

    @Value("${pagBank.api.bearer_token}")
    private String bearerToken;

    @Value("${pagBank.api.url}")
    private String pagBankUrl;

    public ResponseEntity<String> criarCheckout(Checkout checkout) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(bearerToken);

        HttpEntity<Checkout> request = new HttpEntity<>(checkout, headers);


        return restTemplate.postForEntity(pagBankUrl, request, String.class);
    }

    public ResponseEntity<String> getCheckoutById(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(bearerToken);
        RequestEntity<Void> requestEntity = RequestEntity
                .get(pagBankUrl + "/" + id)
                .headers(headers)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        return restTemplate.exchange(requestEntity, String.class);
    }
}
