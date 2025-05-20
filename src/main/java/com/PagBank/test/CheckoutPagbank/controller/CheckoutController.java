package com.PagBank.test.CheckoutPagbank.controller;

import com.PagBank.test.CheckoutPagbank.model.Checkout;
import com.PagBank.test.CheckoutPagbank.service.PagBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/checkouts")
@RequiredArgsConstructor
public class CheckoutController {

    private final PagBankService pagBankService;

    @PostMapping
    public Mono<String> criarCheckout(@RequestBody Checkout checkout){
        return pagBankService.criarCheckout(checkout);
    }

}
