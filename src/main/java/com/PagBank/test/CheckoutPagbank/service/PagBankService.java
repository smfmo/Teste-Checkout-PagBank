package com.PagBank.test.CheckoutPagbank.service;

import com.PagBank.test.CheckoutPagbank.model.Checkout;
import com.PagBank.test.CheckoutPagbank.model.Enum.CheckoutStatus;
import com.PagBank.test.CheckoutPagbank.repository.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PagBankService {

    private final RestTemplate restTemplate;
    private final CheckoutRepository checkoutRepository;

    @Value("${pagBank.api.bearer_token}")
    private String bearerToken;

    @Value("${pagBank.api.url}")
    private String pagBankUrl;

    public ResponseEntity<String> criarCheckout(Checkout checkout) {

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBearerAuth(bearerToken);

        HttpEntity<Checkout> request = new HttpEntity<>(checkout, header);

        return restTemplate
                .postForEntity(
                        pagBankUrl,
                        request,
                        String.class
                );
    }

    public ResponseEntity<String> getCheckoutById(String id){
        HttpHeaders header = new HttpHeaders();
        header.setBearerAuth(bearerToken);
        RequestEntity<Void> requestEntity = RequestEntity
                .get(pagBankUrl + "/" + id)
                .headers(header)
                .accept(MediaType.APPLICATION_JSON)
                .build();
        return restTemplate.exchange(requestEntity, String.class);
    }

    public ResponseEntity<String> inactivateCheckout(String id){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBearerAuth(bearerToken);
        RequestEntity<Void> requestEntity = RequestEntity
                .post(pagBankUrl + "/" + id + "/inactivate")
                .headers(header)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        return restTemplate.exchange(requestEntity, String.class);
    }

    public ResponseEntity<String> activateCheckout(String id){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBearerAuth(bearerToken);
        RequestEntity<Void> requestEntity = RequestEntity
                .post(pagBankUrl + "/" + id + "/activate")
                .headers(header)
                .accept(MediaType.APPLICATION_JSON)
                .build();
        return restTemplate.exchange(requestEntity, String.class);
    }
}
