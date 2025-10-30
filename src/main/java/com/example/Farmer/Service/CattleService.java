package com.example.Farmer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Farmer.entity.Cattle;
import com.example.Farmer.repository.CattleRepo;

@Service
public class CattleService {

    private final CattleRepo repo;

    //Constructor injection
    @Autowired
    public CattleService(CattleRepo repo){
        this.repo = repo;
    }

    //Get All Cattles
    public List<Cattle> getAllCattle(){
        return repo.findAll();
    }

    //Get Cattles by Id
    public Optional<Cattle> getCattle(Long id){
        return repo.findById(id);
    }

    //Add Cattle
    public Cattle addCattle(Cattle c){
        return repo.save(c);
    }

    //Remove cattles
    public void removeCattle(Long id){
        repo.deleteById(id);
    }

    //Custom Query to get cattles
    public List<Cattle> customGetAllCattle(){
        return repo.customFindAllCattles();
    }

    //Custom Query to get cattles by id
    public Cattle customGetCattle(Long id){
        return repo.CustomFindAllCattles(id);
    }
}
