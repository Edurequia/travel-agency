package com.requia.travelagency.domain.repositories;

import com.requia.travelagency.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
