package com.WeGather.WeGather.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    private String body;
    private Long raisedWorkFundId;

//    commentType_id(1/2)
    private int commentTypeId;


    //================== Constructors =====================
    public Comments(){}

//    public Comments(String body) {
//        this.body = body;
//    }

    public Comments(Long userId, Date createdAt, String body, Long raisedWorkFundId, int commentTypeId) {
        this.userId = userId;
        this.createdAt = createdAt;
        this.body = body;
        this.raisedWorkFundId = raisedWorkFundId;
        this.commentTypeId = commentTypeId;
    }
    //=============== Getters And Setters =================


    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTimeStamp() {
        return createdAt;
    }

    public void setTimeStamp(Date timeStamp) {
        this.createdAt = timeStamp;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getRaisedWorkFundId() {
        return raisedWorkFundId;
    }

    public void setRaisedWorkFundId(Long raisedWorkFundId) {
        this.raisedWorkFundId = raisedWorkFundId;
    }

    public int getCommentTypeId() {
        return commentTypeId;
    }

    public void setCommentTypeId(int commentTypeId) {
        this.commentTypeId = commentTypeId;
    }
}