package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class usersIpAddressesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private ArrayList<String> ipAddresses;

    public usersIpAddressesModel(){}

    public usersIpAddressesModel(ArrayList<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    public ArrayList<String> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(ArrayList<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }
}
