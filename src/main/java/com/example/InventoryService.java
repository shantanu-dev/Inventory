package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shantanu on 2/8/16.
 */

@Service
public class InventoryService {


    @Autowired
    InventoryRepository repository;



    @Transactional
    public List<Inventory> findByPName(String pName)
    {
        return repository.findByPName(pName);
    }

    @Transactional
    public boolean Insert(Inventory inventory) {
        if (repository.save(inventory) != null)
            return true;
        else
            return false;
    }

    @Transactional
    public List<Inventory> Display()
    {
                return repository.findAll();
    }

    @Transactional
    public boolean Delete(String pName) {
        if (repository.findByPName(pName).size()>0) {
            Inventory s = repository.findByPName(pName).get(0);
         repository.delete(s);
            return true;
        }
        return false;
    }

    @Transactional
    public void Update(String pName,int pCount )
    {
        System.out.println(pCount);
        System.out.println(pName);

        if (repository.findByPName(pName).size() > 0) {

           Inventory invent = repository.findByPName(pName).get(0);
            System.out.println(invent.getpName());

            invent.setpCount(invent.getpCount() + pCount);

        }



//
//        System.out.println(pCount+" "+pName);
//        int x=0;
//       List<Inventory> list= repository.findByPName(pName);
//        if(list.size()>0) {
//
//            Inventory s= list.get(0);
//
//            x=s.getpCount();
//            x=x+pCount;
//            s.setpCount(x);
//
//            return true;
//        }
//        return false;
    }

}
