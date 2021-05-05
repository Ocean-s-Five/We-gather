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
    private Long RaisedFundId;
    private Long userFundRaiserId;
    private Integer amountPaid;
    private String date;
    private Integer status;

    public CharityFundContributors() {

    }

    public CharityFundContributors(Long raisedFundId, Long userFundRaiserId, Integer amountPaid, String date, Integer status) {
        RaisedFundId = raisedFundId;
        this.userFundRaiserId = userFundRaiserId;
        this.amountPaid = amountPaid;
        this.date = date;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
