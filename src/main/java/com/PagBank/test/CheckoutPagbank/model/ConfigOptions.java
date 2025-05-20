package com.PagBank.test.CheckoutPagbank.model;

import com.PagBank.test.CheckoutPagbank.model.Enum.Option;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class ConfigOptions {

    @Enumerated(EnumType.STRING)
    private Option option;

    @Column(name = "value")
    private String value;
}
