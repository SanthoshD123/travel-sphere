package com.travel.aggregator.controller;

import com.travel.aggregator.model.TravelPackage;
import com.travel.aggregator.repository.TravelPackageRepository;
import com.travel.aggregator.repository.TravelAgencyRepository;
import com.travel.aggregator.model.TravelAgency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/packages")
public class TravelPackageController {

    private final TravelPackageRepository packageRepository;
    private final TravelAgencyRepository agencyRepository;

    public TravelPackageController(TravelPackageRepository packageRepository, TravelAgencyRepository agencyRepository) {
        this.packageRepository = packageRepository;
        this.agencyRepository = agencyRepository;
    }

    // Get all travel packages
    @GetMapping
    public List<TravelPackage> getAllPackages() {
        return packageRepository.findAll();
    }

    // Get a single package by ID
    @GetMapping("/{id}")
    public ResponseEntity<TravelPackage> getPackageById(@PathVariable Integer id) {
        return packageRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all packages for a specific agency
    @GetMapping("/agency/{agencyId}")
    public List<TravelPackage> getPackagesByAgency(@PathVariable Integer agencyId) {
        return packageRepository.findByAgencyId(agencyId);
    }

    // Create a new travel package
    @PostMapping
    public ResponseEntity<TravelPackage> createPackage(@RequestBody TravelPackage travelPackage) {
        Optional<TravelAgency> agency = agencyRepository.findById(travelPackage.getAgency().getId());

        if (agency.isPresent()) {
            travelPackage.setAgency(agency.get());
            return ResponseEntity.ok(packageRepository.save(travelPackage));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Update an existing package
    @PutMapping("/{id}")
    public ResponseEntity<TravelPackage> updatePackage(@PathVariable Integer id, @RequestBody TravelPackage updatedPackage) {
        return packageRepository.findById(id).map(existingPackage -> {
            existingPackage.setTitle(updatedPackage.getTitle());
            existingPackage.setDescription(updatedPackage.getDescription());
            existingPackage.setDestination(updatedPackage.getDestination());
            existingPackage.setPrice(updatedPackage.getPrice());
            existingPackage.setStartDate(updatedPackage.getStartDate());
            existingPackage.setEndDate(updatedPackage.getEndDate());

            return ResponseEntity.ok(packageRepository.save(existingPackage));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete a package
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Integer id) {
        return packageRepository.findById(id).map(packageToDelete -> {
            packageRepository.delete(packageToDelete);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
