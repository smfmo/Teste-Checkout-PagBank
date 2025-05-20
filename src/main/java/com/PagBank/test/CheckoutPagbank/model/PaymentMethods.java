package com.PagBank.test.CheckoutPagbank.model;

import com.PagBank.test.CheckoutPagbank.model.Enum.Brands;
import com.PagBank.test.CheckoutPagbank.model.Enum.PaymentMethodType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table
@Data
public class PaymentMethods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethodType type;

    @ElementCollection
    @CollectionTable(name = "payment_method_brands",
            joinColumns = @JoinColumn(name = "payment_method_id"))
    private Set<Brands> brands;
}
