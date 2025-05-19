package com.PagBank.test.CheckoutPagbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Phone {
    @Column(name = "phone_area_code")
    private String areaCode;

    @Column(name = "phone_number")
    private String number;
}
