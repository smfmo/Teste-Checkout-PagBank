package com.PagBank.test.CheckoutPagbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PagamentoViewController {

    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }
}
