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

import com.example.Farmer.service.LandService;
import com.example.Farmer.entity.Land;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/land")
@Tag(name = "land", description = "land management APIs")
public class LandController {

    private final LandService ls;

    @Autowired
    public LandController(LandService ls) {
        this.ls = ls;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Land> getLand() {
        // log.info("Fetching all lands");
        return ls.getAllLand();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Land> getLand(@PathVariable Long id) {
        // log.info("Fetching land with id: {}", id);
        return ls.getLandById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Land addLand(@Valid @RequestBody Land land) {
        // log.info("Adding a new land: {}", land);
        return ls.addLand(land);
    }

    @DeleteMapping("/remove/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteLand(Long id) {
        // log.info("Deleting land with id: {}", id);
        ls.deleteLand(id);
    }

    // customquery to find all lands
    @GetMapping("/custom/all")
    public List<Land> getAllLands() {
        // log.info("Fetching all lands (custom)");
        return ls.findAllLands();
    }

    // customquery to find land by farmer id
    @GetMapping("/custom/{id}")
    public Land getLandByFarmerId(@PathVariable Long id) {
        // log.info("Fetching land with farmer id: {}", id);
        return ls.findFarmerByLandId(id);
    }

}
