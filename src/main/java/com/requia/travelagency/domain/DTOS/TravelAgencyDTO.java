package com.requia.travelagency.domain.DTOS;

import com.requia.travelagency.domain.entities.Addres;
import com.requia.travelagency.domain.entities.Contact;
import com.requia.travelagency.domain.entities.TravelAgency;
import org.springframework.beans.BeanUtils;

public class TravelAgencyDTO {

    private String name;
    private Contact contactInfo;
    private Addres addres;

    public TravelAgencyDTO convert(TravelAgency travelAgency){
        BeanUtils.copyProperties(travelAgency, this, "id", "destinations", "clients", "employees");
        return this;
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
}
