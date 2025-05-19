package com.PagBank.test.CheckoutPagbank.model;

import com.PagBank.test.CheckoutPagbank.model.Enum.ShippingType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Embeddable
@Data
public class Shipping {

    @Enumerated(EnumType.STRING)
    private ShippingType type;

    @Column(name = "shipping_amount")
    private Integer amount;
}
