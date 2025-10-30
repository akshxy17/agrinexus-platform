package com.example.Farmer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Farmer.entity.Crop;
import com.example.Farmer.repository.CropRepo;


@Service
public class CropService {

    private final CropRepo cropRepo;

    @Autowired
    public CropService(CropRepo cropRepo) {
        this.cropRepo = cropRepo;
    }

    // Get All Crops
    public List<Crop> getAllCrops() {
        return cropRepo.findAll();
    }

    // Get Crop by Id
    public Optional<Crop> getCropById(Long id) {
        return cropRepo.findById(id);
    }

    // Add Crops
    public Crop addCrop(Crop crops) {
        return cropRepo.save(crops);
    }

    // Delete Crop
    public void removeCrop(Long id) {
        cropRepo.deleteById(id);
    }

    // Update Crop
    public Crop updateCrop(Long id, Crop newCrop) {
        Crop crop = cropRepo.findById(id).orElseThrow();

        crop.setCropName(newCrop.getCropName());
        crop.setQuantity(newCrop.getQuantity());
        crop.setType(newCrop.getType());
        crop.setFarmer(newCrop.getFarmer());

        return cropRepo.save(crop);
    }

    // Update partial Crop
    public Crop patchCrop(Long id, Crop newCrop) {
        Crop crop = cropRepo.findById(id).orElseThrow();

        if (newCrop.getCropName() != null) {
            crop.setCropName(newCrop.getCropName());
        }
        if (newCrop.getQuantity() != null) {
            crop.setQuantity(newCrop.getQuantity());
        }
        if (newCrop.getType() != null) {
            crop.setType(newCrop.getType());
        }
        if (newCrop.getFarmer() != null) {
            crop.setFarmer(newCrop.getFarmer());
        }

        return cropRepo.save(crop);
    }

    //Custom Query to get all Crops
    public List<Crop> getAllCropsCustom() {
        return cropRepo.customFindAllCrops();
    }

    //Custom Query to get Crop by Id
    public Crop getCropByIdCustom(Long id) {
        return cropRepo.customFindCropById(id);
    }

}
