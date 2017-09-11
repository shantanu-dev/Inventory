package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/**
 * Created by shantanu on 5/8/16.
 */


@RestController

public class ProductionController{
    @Autowired
    ProductionServices prodService;

    @Autowired
    InventoryService service;


    @RequestMapping(value = "/productioninsert", method = RequestMethod.POST)
    void Insert(@RequestBody ProductionDetails productionDetails) {
        productionDetails.setProductionDate(new java.sql.Date(new java.util.Date().getTime()));
        prodService.Insert(productionDetails);

        Iterator<RawMaterial> x = productionDetails.getRaws().iterator();

        for(int i=0;i<productionDetails.getRaws().size();i++)
        {

            RawMaterial r=x.next();
            System.out.println(r.getpName());
            System.out.println(r.getpCount());

            service.Update(r.getpName(),-(r.getpCount()));
        }

    }


    @RequestMapping("/productiondisplay")
    public List<ProductionDetails> ProductionDisplay() {
        return prodService.Display();
    }


}