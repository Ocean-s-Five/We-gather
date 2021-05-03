package com.WeGather.WeGather.models;


import javax.persistence.*;
import java.util.List;

@Entity

public class RaisedFundUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String requiredAmount;
    private String topic;
    private String description;
    private String createdDate;
    private String startFrom;
    private String endAt;
    @ElementCollection
    private List<String> images;


    public RaisedFundUser(){

    }

    public RaisedFundUser(String requiredAmount, String topic, String description, String createdDate, String strartFrom, String endAt, List<String> images) {
        this.requiredAmount = requiredAmount;
        this.topic = topic;
        this.description = description;
        this.createdDate = createdDate;
        this.startFrom = strartFrom;
        this.endAt = endAt;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public String getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(String requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(String startFrom) {
        this.startFrom = startFrom;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
