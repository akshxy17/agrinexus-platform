package com.example.Farmer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Farmer.entity.Crop;

@Repository
public interface CropRepo extends JpaRepository<Crop, Long> {

    @Query(value = "SELECT * FROM crop", nativeQuery = true)  // Custom query to get all crops
    List<Crop> customFindAllCrops();

    @Query(value = "SELECT * FROM crop WHERE id = :id", nativeQuery = true) // Custom query to get crop by id
    Crop customFindCropById(Long id);
    
}
