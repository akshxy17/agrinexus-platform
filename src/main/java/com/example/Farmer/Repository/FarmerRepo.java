package com.example.Farmer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Farmer.entity.Farmer;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Long> {

    List<Farmer> findByName(String name);

    @Query(value = "SELECT * FROM farmer WHERE farming_type = :farmingType", nativeQuery = true)
    List<Farmer> findByFarmingType(@Param("farmingType") String farmingType);

    @Query(value = "SELECT * FROM farmer", nativeQuery = true)  // Custom query to get all farmers
    List<Farmer> customFindAllFarmers();

    @Query(value = "SELECT * FROM farmer WHERE id = :id", nativeQuery = true) // Custom query to get farmer by id
    Farmer customFindFarmerById(@Param("id") Long id);

}