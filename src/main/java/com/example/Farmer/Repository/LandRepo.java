package com.example.Farmer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Farmer.entity.Land;

@Repository
public interface LandRepo extends JpaRepository<Land, Long> {

    // find land by id
    @Query(value = "SELECT * FROM land WHERE id = ?1", nativeQuery = true)
    Land CustomfindByLandId(Long id);

    // find all lands
    @Query(value = "SELECT * FROM land", nativeQuery = true)
    List<Land> customFindAllLands();

}
