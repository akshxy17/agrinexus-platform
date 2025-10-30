package com.example.Farmer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Farmer.entity.Land;
import com.example.Farmer.repository.LandRepo;

@Service
public class LandService {
    
    private final LandRepo repo;

    @Autowired
    public LandService(LandRepo repo){
        this.repo = repo;
    }

    //Get all Lands
    public List<Land> getAllLand(){
        return repo.findAll();  
    }

    //Get Land by id
    public Optional<Land> getLandById(Long id){
        return repo.findById(id);
    }

    //Add Land on
    public Land addLand(Land land){
      return repo.save(land);
    }

    //Delete Land
    public void deleteLand(Long id){
        repo.deleteById(id);
    }

    //Custom Query to find land by farmer id
    public Land findFarmerByLandId(Long id){
        return repo.CustomfindByLandId(id);
    }

    //Custom Query to find all lands
    public List<Land> findAllLands(){
        return repo.customFindAllLands();
    }

    

}
