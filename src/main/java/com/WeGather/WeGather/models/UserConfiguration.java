
package com.WeGather.WeGather.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;

import javax.persistence.*;

@Entity

public class UserConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String language;
    private String timeZone;
    private String currency;

    // constructors
    public UserConfiguration(){}

    public UserConfiguration(String language, String timeZone, String currency) {

        this.language = language;
        this.timeZone = timeZone;
        this.currency = currency;
    }


    @OneToOne(mappedBy = "userConfiguration")
    private Users users;


    //getter & setters


    public
    Users getUsers() {
        return users;
    }

    public
    void setUsers(Users users) {
        this.users = users;
    }

    public String getLanguage() {
        return language;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getCurrency() {
        return currency;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getId() {
        return id;
    }
}