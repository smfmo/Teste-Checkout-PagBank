package com.PagBank.test.CheckoutPagbank.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_id",
            length = 100)
    private String reference_id;

    @Column(name = "name",length = 256)
    private String name;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_amount")
    private Integer unit_amount;

    @Column(name = "image_url")
    private String image_url;
}
