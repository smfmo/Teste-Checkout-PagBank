package com.PagBank.test.CheckoutPagbank.model;

import com.PagBank.test.CheckoutPagbank.model.Enum.PaymentMethodType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "payment_method_configs")
@Data
public class PaymentMethodConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethodType type;

    @ElementCollection
    @CollectionTable(name = "payment_method_config_options",
            joinColumns = @JoinColumn(name = "payment_method_config_id"))
    private Set<ConfigOptions> config_options;
}
