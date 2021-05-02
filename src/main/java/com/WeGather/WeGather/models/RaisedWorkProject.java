package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RaisedWorkProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long locationId;

    //===================== Constructors ======================
    public RaisedWorkProject(){}

    public RaisedWorkProject(Long userId, Long locationId) {
        this.userId = userId;
        this.locationId = locationId;
    }

    //================ Getters And Setters =============


    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
