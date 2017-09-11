package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by shantanu on 5/8/16.
 */
public interface RawRepository extends JpaRepository<RawMaterial, Integer> {

    List<RawMaterial> findByPId(int pId);

}
