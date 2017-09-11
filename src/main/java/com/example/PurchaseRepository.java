package com.example;

/**
 * Created by shantanu on 3/8/16.
 */
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@org.springframework.stereotype.Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
   List<Purchase> findByPId(int pId);
  List<Purchase>findByPName(String pName);
}
