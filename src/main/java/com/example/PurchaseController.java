package com.example;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shantanu on 4/8/16.
 */

@RestController

public class PurchaseController {
    @Autowired
    PurchaseServices purchaseServices;

    @Autowired
    InventoryService service;

    @RequestMapping(value = "/purchaseinsert", method = RequestMethod.POST)
    void Insert(@RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrder.setPurchaseDate(new Date());
        purchaseServices.Insert(purchaseOrder);

        Iterator<Purchase> pur =purchaseOrder.getPurchases().iterator();

        for(int i =0;i<purchaseOrder.getPurchases().size();i++){
            Purchase p= pur.next();

            System.out.println("hello java ");
            System.out.println(p.getpName());
            System.out.println(p.getpCount());

            service.Update(p.getpName(),p.getpCount());
            service.Update(p.getpName(),0);



        }

    }


    @RequestMapping("/purchasedisplay")
    public List<PurchaseOrder> PurchaseDisplay() {
        return purchaseServices.Display();
    }


}
