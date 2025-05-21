package com.PagBank.test.CheckoutPagbank.controller;

import com.PagBank.test.CheckoutPagbank.model.Checkout;
import com.PagBank.test.CheckoutPagbank.service.PagBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pagbank")
public class CheckoutController {

    private final PagBankService pagBankService;

    @PostMapping("/checkout")
    public ResponseEntity<String> criarCheckout(@RequestBody Checkout checkout) {
        return pagBankService.criarCheckout(checkout);
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getCheckout(@PathVariable String id){
        return pagBankService.getCheckoutById(id);
    }



}
