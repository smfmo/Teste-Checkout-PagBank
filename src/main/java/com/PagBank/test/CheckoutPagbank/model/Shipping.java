package com.PagBank.test.CheckoutPagbank.model;

import com.PagBank.test.CheckoutPagbank.model.Enum.ShippingType;
import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class Shipping {

    @Enumerated(EnumType.STRING)
    private ShippingType type;

    @Column(name = "shipping_amount")
    private Integer amount;

    @Embedded
    private Address address;

    @Embedded
    private Box box;
}
