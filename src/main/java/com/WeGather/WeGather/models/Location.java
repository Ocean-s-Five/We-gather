package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
//    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long longitude;
    private long latitude;
    private String description;
    private Long governorate_id;
    private Long district_id;
    private Long suburb_id;

    // ==========ALL CONSTRUCTORS============

    public Location() {
    }

    public Location(long longitude, long latitude, String description, Long governorate_id, Long district_id, Long suburb_id) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.governorate_id = governorate_id;
        this.district_id = district_id;
        this.suburb_id = suburb_id;
    }

    //    ==========GETTERS AND SETTERS=============

    public Long getId() {
        return id;
    }


    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGovernorate_id() {
        return governorate_id;
    }

    public void setGovernorate_id(Long governorate_id) {
        this.governorate_id = governorate_id;
    }

    public Long getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Long district_id) {
        this.district_id = district_id;
    }

    public Long getSuburb_id() {
        return suburb_id;
    }

    public void setSuburb_id(Long suburb_id) {
        this.suburb_id = suburb_id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", description='" + description + '\'' +
                ", governorate_id=" + governorate_id +
                ", district_id=" + district_id +
                ", suburb_id=" + suburb_id +
                '}';
    }
}
