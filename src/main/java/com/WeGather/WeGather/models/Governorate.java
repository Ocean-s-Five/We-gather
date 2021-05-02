package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Governorate {
    //    ===========All PROPERTY=========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String governorateName;


    // ==========ALL CONSTRUCTORS============


    public Governorate() {
    }

    public Governorate(String governorateName) {
        this.governorateName = governorateName;
    }

    //    ==========GETTERS AND SETTERS=============

    public Long getId() {
        return id;
    }


    public String getGovernorateName() {
        return governorateName;
    }

    public void setGovernorateName(String governorateName) {
        this.governorateName = governorateName;
    }

    @Override
    public String toString() {
        return "Governorate{" +
                "id=" + id +
                ", governorateName='" + governorateName + '\'' +
                '}';
    }
}
