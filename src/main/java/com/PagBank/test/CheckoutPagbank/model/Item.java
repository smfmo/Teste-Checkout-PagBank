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
            length = 64)
    private String referenceId;

    @Column(name = "name",length = 256)
    private String name;

    @Column(name = "description")
    private String description;

    private Integer quantity;

    @Column(name = "unit_amount")
    private Integer unit_amount;
}
