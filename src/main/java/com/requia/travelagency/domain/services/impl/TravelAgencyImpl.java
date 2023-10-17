package com.requia.travelagency.domain.services.impl;

import com.requia.travelagency.domain.entities.TravelAgency;
import com.requia.travelagency.domain.repositories.TravelAgencyRepository;
import com.requia.travelagency.domain.services.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TravelAgencyImpl implements TravelAgencyService {

    @Autowired
    private TravelAgencyRepository travelAgencyRepository;

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
}
