package com.PagBank.test.CheckoutPagbank.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Dimensions {

    private Integer lenght;
    private Integer width;
    private Integer height;
}
