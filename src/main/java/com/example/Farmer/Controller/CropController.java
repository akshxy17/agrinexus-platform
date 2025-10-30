package com.example.Farmer.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Farmer.service.CropService;
import com.example.Farmer.entity.Crop;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/crop")
@Tag(name = "crop", description = "crop management APIs")
public class CropController {


    private final CropService service;

    @Autowired
    public CropController(CropService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Crop> getAllCrops(){
            // log.info("Fetching all crops");
        return service.getAllCrops();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Crop> getCrop(@PathVariable Long id){
        // log.info("Fetching crop with id: {}", id);
        return service.getCropById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Crop addCrop(@Valid @RequestBody Crop crop) {
        // log.info("Adding a new crop: {}", crop);
        return service.addCrop(crop);
    }

    @DeleteMapping("/remove/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCrop(@PathVariable Long id){
        // log.info("Deleting crop with id: {}", id);
        service.removeCrop(id);
    }

    // Custom endpoint to get all crops using custom query
    @GetMapping("/custom/all")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Crop> getAllCropsCustom() {
        // log.info("Fetching all crops (custom)");
        return service.getAllCropsCustom();
    }

    // Custom endpoint to get crop by id using custom query
    @GetMapping("/custom/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Crop getCropByIdCustom(@PathVariable Long id) {
        // log.info("Fetching crop with id (custom): {}", id);
        return service.getCropByIdCustom(id);
    }
    
}
