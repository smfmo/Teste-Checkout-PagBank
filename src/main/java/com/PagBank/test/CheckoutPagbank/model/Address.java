package com.PagBank.test.CheckoutPagbank.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    private String street;
    private String number;
    private String complement;
    private String locality;
    private String city;
    private String region_code;
    private String country;
    private String postal_code;
}
