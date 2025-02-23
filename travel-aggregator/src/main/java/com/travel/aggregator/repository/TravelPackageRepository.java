package com.travel.aggregator.repository;

import com.travel.aggregator.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Integer> {
    List<TravelPackage> findByAgencyId(Integer agencyId);
}
