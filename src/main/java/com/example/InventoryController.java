package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by shantanu on 2/8/16.
 */
@EnableAutoConfiguration

@RestController
public class InventoryController {

    @Autowired
    InventoryService service;

    @RequestMapping(value = "/create" ,method = RequestMethod.GET)

    public Inventory createInventory(
            @RequestParam("pName") String pName,
            @RequestParam("unit") String unit,
            @RequestParam("initCount") int initCount,
            @RequestParam("pCount") int pCount,
            @RequestParam("pCost") int pCost
    )

    {
        Inventory inventory = new Inventory();
        inventory.setpName(pName);
        inventory.setUnit(unit);
        inventory.setInitCount(initCount);
        inventory.setpCount(pCount);
        inventory.setpCost(pCost);



        if (service.Insert(inventory))
            return inventory;
        return inventory;
    }


    @RequestMapping("/display")
    public List<Inventory> display() {
        return service.Display();
    }




    @RequestMapping("/delete")
    public Inventory deleteInventory(HttpServletRequest request) {
        String name = request.getParameter("pName");

        if (service.findByPName(name).size()>0) {

            Inventory s = service.findByPName(name).get(0);
          service.Delete(name);
            return s;
        }
        return null;
    }


    @RequestMapping("Search")
    public Inventory searchInventory(HttpServletRequest request) {
       String name = request.getParameter("pName");
        if (service.findByPName(name).size() > 0)
            return service.findByPName(name).get(0);

        return null;

    }


//    @RequestMapping("Update")
//    public Inventory updateInventory(HttpServletRequest request, @RequestParam("pCount") int pCount) {
//        String name = request.getParameter("pName");
//
//        if (service.Update(name, pCount))
//        {
//            return service.findByPName(name).get(0);
//        }
//
//        return null;
//    }




}