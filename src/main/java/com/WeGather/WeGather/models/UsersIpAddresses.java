package com.WeGather.WeGather.models;

import javax.persistence.*;
import java.util.List;

@Entity

public class UsersIpAddresses {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ElementCollection
    private List<String> ipAddresses;


    public UsersIpAddresses() {

    }

    @ElementCollection
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


