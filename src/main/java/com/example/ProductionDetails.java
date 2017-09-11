package com.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by shantanu on 5/8/16.
 */


@Entity
public class ProductionDetails  implements    Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int productionId;
    String productName;
    Date productionDate;
    int productionQuantity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "production_details_production_id")
    Set<RawMaterial> raws;

    public int getProductionId() {
        return productionId;
    }

    public void setProductionId(int productionId) {
        this.productionId = productionId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public int getProductionQuantity() {
        return productionQuantity;
    }

    public void setProductionQuantity(int productionQuantity) {
        this.productionQuantity = productionQuantity;
    }

    public Set<RawMaterial> getRaws() {
        return raws;
    }

    public void setRaws(Set<RawMaterial> raws) {
        this.raws = raws;
    }
}
