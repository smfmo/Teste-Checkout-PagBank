package com.PagBank.test.CheckoutPagbank.model;

import com.PagBank.test.CheckoutPagbank.model.Enum.HttpMethod;
import com.PagBank.test.CheckoutPagbank.model.Enum.LinkRelation;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "checkout_links")
@Data
public class Links {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LinkRelation rel;

    private String href;

    @Enumerated(EnumType.STRING)
    private HttpMethod method;
}
