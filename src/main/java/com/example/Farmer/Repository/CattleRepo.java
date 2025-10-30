package com.example.Farmer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Farmer.entity.Cattle;

@Repository
public interface CattleRepo extends JpaRepository<Cattle, Long> {
    
    @Query(value = "SELECT * FROM cattle", nativeQuery = true)  // Custom query to get all cattles
    List<Cattle> customFindAllCattles();

    @Query(value = "SELECT * FROM cattle WHERE id = :id", nativeQuery = true) // Custom query to get cattle by id
    Cattle CustomFindAllCattles(Long id);
}
