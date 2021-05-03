package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class usersIpAddressesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private List<String> ipAddresses;

    public usersIpAddressesModel() {
    }

    public List<String> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(List<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    public long getId() {
        return id;
    }
}


