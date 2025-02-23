package com.travel.aggregator.controller;

import com.travel.aggregator.model.TravelAgency;
import com.travel.aggregator.repository.TravelAgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/agencies")
public class TravelAgencyController {

    @Autowired
    private TravelAgencyRepository travelAgencyRepository;

    // 1. Get all travel agencies
    @GetMapping
    public List<TravelAgency> getAllAgencies() {
        return travelAgencyRepository.findAll();
    }

    // 2. Get travel agency by ID
    @GetMapping("/{id}")
    public ResponseEntity<TravelAgency> getAgencyById(@PathVariable Integer id) {
        Optional<TravelAgency> agency = travelAgencyRepository.findById(id);
        return agency.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. Create a new travel agency
    @PostMapping
    public ResponseEntity<TravelAgency> createAgency(@RequestBody TravelAgency agency) {
        TravelAgency savedAgency = travelAgencyRepository.save(agency);
        return ResponseEntity.ok(savedAgency);
    }

    // 4. Update an existing travel agency
    @PutMapping("/{id}")
    public ResponseEntity<TravelAgency> updateAgency(@PathVariable Integer id, @RequestBody TravelAgency updatedAgency) {
        return travelAgencyRepository.findById(id)
                .map(existingAgency -> {
                    existingAgency.setName(updatedAgency.getName());
                    existingAgency.setEmail(updatedAgency.getEmail());
                    existingAgency.setPhone(updatedAgency.getPhone());
                    existingAgency.setAddress(updatedAgency.getAddress());
                    existingAgency.setWebsite(updatedAgency.getWebsite());

                    TravelAgency savedAgency = travelAgencyRepository.save(existingAgency);
                    return ResponseEntity.ok(savedAgency);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 5. Delete a travel agency
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable Integer id) {
        return travelAgencyRepository.findById(id)
                .map(agency -> {
                    travelAgencyRepository.delete(agency);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
