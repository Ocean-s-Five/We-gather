package com.WeGather.WeGather.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity

public class UserConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String language;
    private String timeZone;
    private String currency;

    //============== Relation =================

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;


    public UserConfiguration(){}

    public UserConfiguration(String language, String timeZone, String currency) {

        this.language = language;
        this.timeZone = timeZone;
        this.currency = currency;
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
