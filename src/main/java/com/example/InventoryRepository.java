package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory,String> {

   public List<Inventory> findByPName(String pName);

}
