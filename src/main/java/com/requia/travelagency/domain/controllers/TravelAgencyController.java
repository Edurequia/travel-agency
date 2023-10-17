package com.requia.travelagency.domain.controllers;


import com.requia.travelagency.domain.entities.TravelAgency;
import com.requia.travelagency.domain.services.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/travelAgency")
public class TravelAgencyController {

    @Autowired
    private TravelAgencyService travelAgencyService;

    @GetMapping("/{id}")
    public ResponseEntity<TravelAgency> findById(@PathVariable Long id){
        TravelAgency agency = travelAgencyService.getTravelAgency(id);
        return ResponseEntity.ok(agency);
    }

    @PostMapping
    public ResponseEntity<TravelAgency> create(@RequestBody TravelAgency travelAgency){
        TravelAgency travelAgencyCreated = travelAgencyService.create(travelAgency);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(travelAgencyCreated.getAgencyId())
                .toUri();
        return ResponseEntity.created(location).body(travelAgencyCreated);
    }

}
