package com.example.Farmer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Farmer.entity.Farmer;
import com.example.Farmer.repository.FarmerRepo;

@Service
public class FarmerService {

    private final FarmerRepo farmerRepo;

    @Autowired
    public FarmerService(FarmerRepo farmerRepo) {
        this.farmerRepo = farmerRepo;
    }

    //Get All Farmers
    public List<Farmer> getAllFarmers() {
        return farmerRepo.findAll();
    }

    //Add Farmer
    public Farmer addFarmer(Farmer farmer) {
        return farmerRepo.save(farmer);
    }

    //Get Farmer by id
    public Optional<Farmer> getFarmerById(Long id) {
        return farmerRepo.findById(id);
    }

    //Delete Farmer
    public void deleteFarmer(Long id) {
        farmerRepo.deleteById(id);
    }

    //Update Farmer
    public Farmer updateFarmer(Long id, Farmer newFarmer) {
        Farmer oldFarmer = farmerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        oldFarmer.setName(newFarmer.getName());
        oldFarmer.setGender(newFarmer.getGender());
        oldFarmer.setAddress(newFarmer.getAddress());
        oldFarmer.setContactNumber(newFarmer.getContactNumber());
        oldFarmer.setFarmingType(newFarmer.getFarmingType());

        // crops
        if (newFarmer.getCrops() != null) {
            oldFarmer.getCrops().clear();
            newFarmer.getCrops().forEach(c -> {
                c.setFarmer(oldFarmer);
                oldFarmer.getCrops().add(c);
            });

        }

        // Cattles
        if (newFarmer.getCattles() != null) {
            oldFarmer.getCattles().clear(); // clear old list
            newFarmer.getCattles().forEach(c -> {
                c.setFarmer(oldFarmer);
                oldFarmer.getCattles().add(c); // add one by one
            });
        }

        // lands
        if (newFarmer.getLands() != null) {
            oldFarmer.getLands().clear();
            newFarmer.getLands().forEach(l -> {
                l.setFarmer(oldFarmer);
                oldFarmer.getLands().add(l);
            });
        }

        return farmerRepo.save(oldFarmer);
    }

    // PATCH = Update only given fields
    public Farmer partialUpdate(Long id, Farmer newFarmer) {
        Farmer oldFarmer = farmerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        if (newFarmer.getName() != null)
            oldFarmer.setName(newFarmer.getName());
        if (newFarmer.getGender() != null)
            oldFarmer.setGender(newFarmer.getGender());
        if (newFarmer.getAddress() != null)
            oldFarmer.setAddress(newFarmer.getAddress());
        if (newFarmer.getContactNumber() != null)
            oldFarmer.setContactNumber(newFarmer.getContactNumber());
        if (newFarmer.getFarmingType() != null)
            oldFarmer.setFarmingType(newFarmer.getFarmingType());

        // crops (merge instead of replace)
        if (newFarmer.getCrops() != null) {
            newFarmer.getCrops().forEach(c -> {
                c.setFarmer(oldFarmer);
                oldFarmer.getCrops().add(c); // add to existing list
            });
        }

        // Cattles
        if (newFarmer.getCattles() != null) {
            newFarmer.getCattles().forEach(c -> {
                c.setFarmer(oldFarmer);
                oldFarmer.getCattles().add(c);
            });
        }

        // lands
        if (newFarmer.getLands() != null) {
            newFarmer.getLands().forEach(l -> {
                l.setFarmer(oldFarmer);
                oldFarmer.getLands().add(l);
            });
        }

        return farmerRepo.save(oldFarmer);
    }

    //Custom Query to get Farmers by name
    public List<Farmer> getFarmersByName(String name) {
        return farmerRepo.findByName(name);
    }

    //Custom Query to get Farmers by farming type
    public List<Farmer> getFarmersByFarmingType(String farmingType) {
        return farmerRepo.findByFarmingType(farmingType);
    }


    //custom query to get all farmers
    public List<Farmer> getAllFarmersCustom() {
        return farmerRepo.customFindAllFarmers();
    }

    //custom query to get farmer by id
    public Farmer getFarmerByIdCustom(Long id) {
        return farmerRepo.customFindFarmerById(id);
    }

}
