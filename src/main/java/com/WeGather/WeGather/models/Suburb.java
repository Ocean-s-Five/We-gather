package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Suburb {

//    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String suburbName;
    private Long district_id;
    // ==========ALL CONSTRUCTORS============

    public Suburb() {
    }

    public Suburb(String suburbName, Long district_id) {
        this.suburbName = suburbName;
        this.district_id = district_id;
    }

    //    ==========GETTERS AND SETTERS=============

    public Long getId() {
        return id;
    }

    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public Long getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Long district_id) {
        this.district_id = district_id;
    }

    @Override
    public String toString() {
        return "Suburb{" +
                "id=" + id +
                ", suburbName='" + suburbName + '\'' +
                ", district_id=" + district_id +
                '}';
    }
}
