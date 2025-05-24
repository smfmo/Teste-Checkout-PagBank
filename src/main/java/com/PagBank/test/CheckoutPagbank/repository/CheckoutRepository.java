package com.PagBank.test.CheckoutPagbank.repository;

import com.PagBank.test.CheckoutPagbank.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckoutRepository extends JpaRepository<Checkout, UUID> {
}
