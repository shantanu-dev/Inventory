package com.example;

/**
 * Created by shantanu on 3/8/16.
 */
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@org.springframework.stereotype.Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {

    List<PurchaseOrder> findByPurchaseId(int purchaseId);

}
