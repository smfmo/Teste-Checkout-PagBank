package com.PagBank.test.CheckoutPagbank.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "customer_name",
            length = 120)
    private String name;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "tax_id",length = 14)
    private String tax_id;

    @Embedded
    private Phone phone;

}
