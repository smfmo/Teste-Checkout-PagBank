package com.PagBank.test.CheckoutPagbank.service;

import com.PagBank.test.CheckoutPagbank.model.Checkout;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PagBankService {

    private final RestTemplate restTemplate;

    // Token fornecido pelo sandbox do PagBank
    private static final String BEARER_TOKEN = "92de68c1-d123-42fa-be33-0d60def3958390c36cdc4a10956174a45186c40c0fd44a52-f543-43a7-8c65-edec58360c4a";

    // URL da API
    private static final String PAGBANK_URL = "https://sandbox.api.pagseguro.com/checkouts";

    public PagBankService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> criarCheckout(Checkout checkout) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(BEARER_TOKEN);

        HttpEntity<Checkout> request = new HttpEntity<>(checkout, headers);

        return restTemplate.postForEntity(PAGBANK_URL, request, String.class);
    }

    public ResponseEntity<String> getCheckoutById(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(BEARER_TOKEN);
        RequestEntity<Void> requestEntity = RequestEntity
                .get(PAGBANK_URL + "/" + id)
                .headers(headers)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        return restTemplate.exchange(requestEntity, String.class);
    }
}
