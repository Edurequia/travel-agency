package com.requia.travelagency.domain.entities;

import jakarta.persistence.*;


import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_travelAgency")
public class TravelAgency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agencyId;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contactInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private Addres addres;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Destinations> destinations;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Client> clients;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employees;

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Contact contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Addres getAddres() {
        return addres;
    }

    public void setAddres(Addres addres) {
        this.addres = addres;
    }

    public Set<Destinations> getDestinations() {
        return destinations;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
