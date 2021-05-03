package com.WeGather.WeGather.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class feedbackModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String title;
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    private String email;


    public feedbackModel(){}

    public feedbackModel(String title, String body, Date timeStamp, String email) {
        this.title = title;
        this.body = body;
        this.timeStamp = timeStamp;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getEmail() {
        return email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }
}