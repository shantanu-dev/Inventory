package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by shantanu on 3/8/16.
 */

@Entity

public class Purchase implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int pId;
    String pName;
    int pCount;
    double pCost;



    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpCount() {
        return pCount;
    }

    public void setpCount(int pCount) {
        this.pCount = pCount;
    }

    public double getpCost() {
        return pCost;
    }

    public void setpCost(double pCost) {
        this.pCost = pCost;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

}
