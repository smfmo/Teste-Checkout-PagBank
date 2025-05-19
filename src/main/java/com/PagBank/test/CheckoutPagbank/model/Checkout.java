package com.PagBank.test.CheckoutPagbank.model;

import com.PagBank.test.CheckoutPagbank.model.Enum.CheckoutStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.*;

@Entity
@Data
@Table(name = "checkouts")
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "reference_id",
            length = 64)
    private String referenceId;

    @Column(name = "expiration_date")
    private Instant expirationDate;

    @Embedded
    private Customer customer;

    @Column(name = "customer_modifiable")
    private Boolean customerModifiable = true;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "checkout_id")
    private List<Item> items = new ArrayList<>();

    @Column(name = "additional_amount")
    private Integer additionalAmount = 0;

    @Column(name = "discount_amount")
    private Integer discountAmount = 0;

    @Embedded
    private Shipping shipping;

    @ElementCollection
    @CollectionTable(name = "checkout_payment_methods",
            joinColumns = @JoinColumn(name = "checkout_id"))
    @Column(name = "payment_method")
    private Set<String> paymentMethods = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "checkout_id")
    private List<PaymentMethodConfig> paymentMethodsConfig = new ArrayList<>();

    @Column(name = "redirect_url",
            length = 255)
    private String redirectUrl;

    @Column(name = "soft_descriptor",
            length = 17)
    private String softDescriptor;

    @Column(name = "return_url",
            length = 255)
    private String returnUrl;

    @ElementCollection
    @CollectionTable(name = "checkout_payment_notification_urls", joinColumns = @JoinColumn(name = "checkout_id"))
    @Column(name = "url")
    private Set<String> paymentNotificationUrls = new HashSet<>();

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @Enumerated(EnumType.STRING)
    private CheckoutStatus status = CheckoutStatus.ACTIVE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "checkout_id")
    private List<CheckoutLink> links = new ArrayList<>();
}
