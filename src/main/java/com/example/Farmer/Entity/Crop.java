package com.example.Farmer.entity;

import com.example.Farmer.entity.Enums.CropType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cropId;

    private String CropName;

    private Long quantity;

    @Enumerated(EnumType.STRING)
    private CropType Type;

    @ManyToOne
    @JoinColumn(name = "farmer_id") // This creates the 'farmer_id' column in the Crop table
    @JsonBackReference // This annotation is crucial for JSON serialization, breaks the loop, bi-directional relationship
    private Farmer farmer; // Each Crop belongs to one Farmer

}