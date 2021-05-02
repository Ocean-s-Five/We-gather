package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CharityFundContributors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long RaisedFundId ;
    private Long userFundRaiserId ;
    private String amountPaid ;
    private String date ;

    public CharityFundContributors(){

    }
    public CharityFundContributors(Long raisedFundId, Long userFundRaiserId, String amountPaid, String date) {
        RaisedFundId = raisedFundId;
        this.userFundRaiserId = userFundRaiserId;
        this.amountPaid = amountPaid;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getRaisedFundId() {
        return RaisedFundId;
    }

    public void setRaisedFundId(Long raisedFundId) {
        RaisedFundId = raisedFundId;
    }

    public Long getUserFundRaiserId() {
        return userFundRaiserId;
    }

    public void setUserFundRaiserId(Long userFundRaiserId) {
        this.userFundRaiserId = userFundRaiserId;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
