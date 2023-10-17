package com.requia.travelagency.domain.repositories;

import com.requia.travelagency.domain.entities.TravelAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelAgencyRepository extends JpaRepository<TravelAgency, Long> {

    public boolean existsByName(String name);
}
