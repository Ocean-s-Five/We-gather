package com.WeGather.WeGather.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class userConfigurationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String language;
    private String timeZone;
    private String currency;

    public userConfigurationModel(){}

    public userConfigurationModel(String language, String timeZone, String currency) {
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
}
