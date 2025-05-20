package com.PagBank.test.CheckoutPagbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
@Embeddable
public class Box {

    @Column(name = "weight")
    private Integer weight;

    @Embedded
    private Dimensions dimensions;
}
