package com.andrii.productrestservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price_per_kg", nullable = false)
    private BigDecimal pricePerKg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subgroup_id")
    private Subgroup subgroup;

    @Column(name = "supplier_country", nullable = false)
    private String supplierCountry;
}
