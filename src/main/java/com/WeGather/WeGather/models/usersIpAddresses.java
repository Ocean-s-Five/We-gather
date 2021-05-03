package com.WeGather.WeGather.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class usersIpAddresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ElementCollection
    private List<String> ipAddresses;

    public usersIpAddresses() {
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


