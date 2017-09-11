package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by shantanu on 5/8/16.
 */

@org.springframework.stereotype.Repository
    public interface ProductionRepository extends JpaRepository<ProductionDetails,Integer> {

        List<ProductionDetails> findByProductionId(int productionId);

    }
