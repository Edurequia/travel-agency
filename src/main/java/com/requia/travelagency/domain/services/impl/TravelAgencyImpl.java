package com.requia.travelagency.domain.services.impl;

import com.requia.travelagency.domain.entities.Client;
import com.requia.travelagency.domain.entities.TravelAgency;
import com.requia.travelagency.domain.repositories.ClientRepository;
import com.requia.travelagency.domain.repositories.TravelAgencyRepository;
import com.requia.travelagency.domain.services.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TravelAgencyImpl implements TravelAgencyService {

    @Autowired
    private TravelAgencyRepository travelAgencyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public TravelAgency getTravelAgency(Long id) {
        Optional<TravelAgency> agency = travelAgencyRepository.findById(id);
        return agency.orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public TravelAgency create(TravelAgency travelAgency) {
        if(travelAgencyRepository.existsByName(travelAgency.getName())){
            throw new IllegalArgumentException("This name already exists");
        }
        return travelAgencyRepository.save(travelAgency);
    }

    @Override
    public List<Client> getAllClients(Long agencyId) {
        TravelAgency agency = getTravelAgency(agencyId);
        return agency.getClients();
    }


    @Override
    @Transactional
    public void addClientToAgency(Long agencyId, Client client) {
        TravelAgency agency = getTravelAgency(agencyId);
        agency.addClient(client);
        travelAgencyRepository.save(agency);
    }

    @Override
    @Transactional
    public void removeClientFromAgency(Long agencyId, Long clientId) {
        TravelAgency agency = getTravelAgency(agencyId);
        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isPresent()){
            clientRepository.deleteById(clientId);
            agency.deleteClient(clientId);
            travelAgencyRepository.save(agency);
        } else {
            throw new NoSuchElementException();
        }
    }
}
