package com.requia.travelagency.domain.controllers;


import com.requia.travelagency.domain.DTOS.TravelAgencyDTO;
import com.requia.travelagency.domain.entities.Client;
import com.requia.travelagency.domain.entities.TravelAgency;
import com.requia.travelagency.domain.services.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/travelAgency")
public class TravelAgencyController {

    @Autowired
    private TravelAgencyService travelAgencyService;

    @GetMapping("/{id}")
    public ResponseEntity<TravelAgencyDTO> findById(@PathVariable Long id){
        TravelAgency travelAgency = travelAgencyService.getTravelAgency(id);
        TravelAgencyDTO travelAgencyDTO = new TravelAgencyDTO();
        travelAgencyDTO.convert(travelAgency);
        return ResponseEntity.ok(travelAgencyDTO);
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

    @GetMapping("/{agencyId}/clients")
    public ResponseEntity<List<Client>> getClientsFromAgency(Long agencyId){
        List<Client> clients = travelAgencyService.getAllClients(agencyId);
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/{agencyId}/clients")
    public ResponseEntity<?> addClientToAgency(@PathVariable Long agencyId, @RequestBody Client client){
        travelAgencyService.addClientToAgency(agencyId, client);
        return ResponseEntity.ok("Client added to agency");
    }

    @DeleteMapping("/{agencyId}/clients/{clientId}")
    public ResponseEntity<?> removeClientFromAgency(@PathVariable Long agencyId, @PathVariable Long clientId){
        travelAgencyService.removeClientFromAgency(agencyId, clientId);
        return ResponseEntity.ok("Client removed from agency");
    }

}
