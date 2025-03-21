package com.harish.SpringBootRest.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sku_profile")
@IdClass(SkuProfileKey.class)
 public class SkuProfile {
        @Id
        private String sku;
        @Id
        private String companyNo;

        private String whseId;
        private String skuDesc;

        private String modifyTstamp;
        private String createTstamp;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getWhseId() {
        return whseId;
    }

    public void setWhseId(String whseId) {
        this.whseId = whseId;
    }

    public String getSkuDesc() {
        return skuDesc;
    }

    public void setSkuDesc(String skuDesc) {
        this.skuDesc = skuDesc;
    }

}
