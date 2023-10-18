package com.requia.travelagency.domain.services;

import com.requia.travelagency.domain.entities.Client;
import com.requia.travelagency.domain.entities.Employee;
import com.requia.travelagency.domain.entities.TravelAgency;

import java.util.List;

public interface TravelAgencyService {


    public TravelAgency getTravelAgency(Long id);

    public TravelAgency create(TravelAgency travelAgency);

    public List<Client> getAllClients(Long agencyId);

    public void addClientToAgency(Long agencyId, Client client);

    public void removeClientFromAgency(Long agencyId, Long clientId);

    // public void addEmployeeToAgency(Long agencyId, Employee employee);

    // public void removeEmployeeToAgency(Long agencyId, Employee employeeId);
}
