package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class District {

    //    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String districtName;
    private Long governorate_id;

    // ==========ALL CONSTRUCTORS============

    public District() {
    }

    public District(String districtName, Long governorate_id) {
        this.districtName = districtName;
        this.governorate_id = governorate_id;
    }

    //    ==========GETTERS AND SETTERS=============

    public Long getId() {
        return id;
    }


    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Long getGovernorate_id() {
        return governorate_id;
    }

    public void setGovernorate_id(Long governorate_id) {
        this.governorate_id = governorate_id;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", districtName='" + districtName + '\'' +
                ", governorate_id=" + governorate_id +
                '}';
    }
}
