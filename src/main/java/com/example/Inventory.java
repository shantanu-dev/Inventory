package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by shantanu on 2/8/16.
 */

@Entity

public class Inventory implements Serializable{
    @Id
    String pName;
    String unit;
    int initCount;
    int pCount;
    int pCost;


    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getInitCount() {
        return initCount;
    }

    public void setInitCount(int initCount) {
        this.initCount = initCount;
    }

    public int getpCount() {
        return pCount;
    }

    public void setpCount(int pCount) {
        this.pCount = pCount;
    }

    public int getpCost() {
        return pCost;
    }

    public void setpCost(int pCost) {
        this.pCost = pCost;
    }
}
