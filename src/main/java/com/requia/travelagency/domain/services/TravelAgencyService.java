package com.requia.travelagency.domain.services;

import com.requia.travelagency.domain.entities.TravelAgency;

public interface TravelAgencyService {


    public TravelAgency getTravelAgency(Long id);

    public TravelAgency create(TravelAgency travelAgency);
}
