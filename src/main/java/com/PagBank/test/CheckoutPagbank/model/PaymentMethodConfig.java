package com.PagBank.test.CheckoutPagbank.model;

import com.PagBank.test.CheckoutPagbank.model.Enum.PaymentMethodType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "payment_method_configs")
@Data
public class PaymentMethodConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethodType type;

    @Column(name = "max_installments")
    private Integer maxInstallments;

    @Column(name = "min_installments_amount")
    private Integer minInstallmentsAmount;
}
