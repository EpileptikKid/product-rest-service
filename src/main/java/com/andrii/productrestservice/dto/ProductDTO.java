package com.andrii.productrestservice.dto;

import com.andrii.productrestservice.model.Subgroup;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal pricePerKg;
    private Long subgroup;
    private String supplierCountry;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public BigDecimal getPricePerKg() { return pricePerKg; }

    public void setPricePerKg(BigDecimal pricePerKg) { this.pricePerKg = pricePerKg; }

    public long getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Subgroup subgroup) {
        this.subgroup = subgroup.getId();
    }

    public String getSupplierCountry() { return supplierCountry; }

    public void setSupplierCountry(String supplierCountry) { this.supplierCountry = supplierCountry; }
}
