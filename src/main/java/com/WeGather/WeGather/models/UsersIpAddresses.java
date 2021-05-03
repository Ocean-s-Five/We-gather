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

    //============== Relation =================

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;



    public UsersIpAddresses() {}

    @ElementCollection
    public List<String> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(List<String> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }



    public long getId() {
        return id;
    }
}


