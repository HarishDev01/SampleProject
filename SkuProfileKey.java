package com.harish.SpringBootRest.model;



import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@Embeddable  // Mark this class as embeddable for composite key
public class SkuProfileKey implements Serializable {

    // Getters and Setters
    private String sku;
    private String companyNo;

    // Default constructor
    public SkuProfileKey() {}

    // Constructor
    public SkuProfileKey(String sku, String companyNo) {
        this.sku = sku;
        this.companyNo = companyNo;
    }

    // hashCode and equals methods (required for composite keys)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkuProfileKey that = (SkuProfileKey) o;
        return Objects.equals(sku, that.sku) &&
                Objects.equals(companyNo, that.companyNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, companyNo);
    }
}
