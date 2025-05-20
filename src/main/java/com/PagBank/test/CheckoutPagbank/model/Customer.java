package com.PagBank.test.CheckoutPagbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

@Embeddable
@Data
public class Customer {

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
