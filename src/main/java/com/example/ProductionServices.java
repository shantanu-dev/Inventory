package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shantanu on 5/8/16.
 */

@Service
public class ProductionServices {

    @Autowired
    ProductionRepository prodRepo;


    @Transactional
    public List<ProductionDetails> findByProductionId(int productionId)
    {
        return prodRepo.findByProductionId(productionId);
    }


    @Transactional
    public boolean Insert(ProductionDetails detail) {
        if (prodRepo.save(detail) != null)
            return true;
        else
            return false;
    }

    @Transactional
    public List<ProductionDetails> Display()
    {
        return prodRepo.findAll();
    }


}

