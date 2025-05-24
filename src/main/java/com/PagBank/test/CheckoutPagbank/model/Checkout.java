package com.PagBank.test.CheckoutPagbank.model;

import com.PagBank.test.CheckoutPagbank.model.Enum.CheckoutStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@Table(name = "checkouts")
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID checkout_id;

    @Column(name = "reference_id",
            length = 64)
    private String reference_id;

    @CreatedDate
    @Column(name = "expiration_date")
    private LocalDateTime expiration_date;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "customer_modifiable")
    private Boolean customer_modifiable = true;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "checkout_id")
    private List<Item> items = new ArrayList<>();

    @Column(name = "additional_amount")
    private Integer additional_amount;

    @Column(name = "discount_amount")
    private Integer discount_amount;

    @Embedded
    private Shipping shipping;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @CollectionTable(name = "checkout_payment_methods",
            joinColumns = @JoinColumn(name = "checkout_id"))
    @Column(name = "payment_method")
    private List<PaymentMethods> payment_methods = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "checkout_id")
    private List<PaymentMethodConfig> payment_methods_configs = new ArrayList<>();

    @Column(name = "redirect_url",
            length = 255)
    private String redirect_url;

    @Column(name = "soft_descriptor",
            length = 17)
    private String soft_descriptor;

    @Column(name = "return_url",
            length = 255)
    private String return_url;

    @ElementCollection
    @CollectionTable(name = "notification_urls", joinColumns = @JoinColumn(name = "checkout_id"))
    @Column(name = "notification_url")
    private List<String> notification_urls = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "checkout_payment_notification_urls", joinColumns = @JoinColumn(name = "checkout_id"))
    @Column(name = "payment_notification_url")
    private List<String> payment_notification_urls = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Enumerated(EnumType.STRING)
    private CheckoutStatus status = CheckoutStatus.ACTIVE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "checkout_id")
    private List<Links> links = new ArrayList<>();
}
