package com.WeGather.WeGather.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class feedbackModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String title;
    private String body;

    @DateTimeFormat(pattern="yyyy-mm-dd HH:mm:ss")
    private  Date timeStamp;

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
}
