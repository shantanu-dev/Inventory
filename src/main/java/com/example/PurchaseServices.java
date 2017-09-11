package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shantanu on 4/8/16.
 */

@Service

public class PurchaseServices {
    @Autowired
    PurchaseOrderRepository orderRepository;


    @Transactional
    public List<PurchaseOrder> findByPurchaseId(int purchaseId)
    {
        return orderRepository.findByPurchaseId(purchaseId);
    }


    @Transactional
    public boolean Insert(PurchaseOrder order) {
        if (orderRepository.save(order) != null) {
            return true;
        }
        else
            return false;
    }

    @Transactional
    public List<PurchaseOrder> Display()
    {
        return orderRepository.findAll();
    }


}
