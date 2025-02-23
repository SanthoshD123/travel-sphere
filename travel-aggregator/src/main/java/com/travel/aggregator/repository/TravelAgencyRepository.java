package com.travel.aggregator.repository;

import com.travel.aggregator.model.TravelAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelAgencyRepository extends JpaRepository<TravelAgency, Integer> {
}
