package com.WeGather.WeGather.models;

import javax.persistence.*;

@Entity
public class Suburb {

//    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String suburbName;
    private Long district_id;


    //    ======= TABLE RELATIONS ===============

    @ManyToOne
    private District district;

    // ==========ALL CONSTRUCTORS============

    public Suburb() {
    }

    public Suburb(String suburbName, Long district_id, District district) {
        this.suburbName = suburbName;
        this.district_id = district_id;
        this.district = district;
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

}
