package com.WeGather.WeGather.models;

import javax.persistence.*;

@Entity
public class UserContactInfo {
    //    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String address;
    private String email;
    private String governorate;
    private String district;
    private String suburb;

    // ==========ALL CONSTRUCTORS============


    public UserContactInfo() {
    }

    public UserContactInfo(String phoneNumber, String address, String email, String governorate, String district, String suburb) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.governorate = governorate;
        this.district = district;
        this.suburb = suburb;
    }


    //    ==========GETTERS AND SETTERS=============

    public Long getId() {
        return id;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Override
    public String toString() {
        return "UserContactInfo{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", governorate='" + governorate + '\'' +
                ", district='" + district + '\'' +
                ", suburb='" + suburb + '\'' +
                '}';
    }
}
