package com.requia.travelagency.domain.repositories;

import com.requia.travelagency.domain.entities.TravelAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TravelAgencyRepository extends JpaRepository<TravelAgency, Long> {

    boolean existsByName(String name);

    @Modifying
    @Query("DELETE FROM TravelAgency t WHERE t.id = :agencyId AND EXISTS (SELECT c FROM t.clients c WHERE c.id = :clientId)")
    void deleteClientById(@Param("agencyId") Long agencyId, @Param("clientId") Long clientId);
}
