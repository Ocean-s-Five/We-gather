package com.WeGather.WeGather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CharityWorkContributors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long workedRaiserId;
    private Long userWorkRaiserId;
    private Long contributedUserid;

    public CharityWorkContributors(Long workedRaiserId, Long userWorkRaiserId, Long contributedUserid) {
        this.workedRaiserId = workedRaiserId;
        this.userWorkRaiserId = userWorkRaiserId;
        this.contributedUserid = contributedUserid;
    }

    public Long getId() {
        return id;
    }

    public Long getWorkedRaiserId() {
        return workedRaiserId;
    }

    public void setWorkedRaiserId(Long workedRaiserId) {
        this.workedRaiserId = workedRaiserId;
    }

    public Long getUserWorkRaiserId() {
        return userWorkRaiserId;
    }

    public void setUserWorkRaiserId(Long userWorkRaiserId) {
        this.userWorkRaiserId = userWorkRaiserId;
    }

    public Long getContributedUserid() {
        return contributedUserid;
    }

    public void setContributedUserid(Long contributedUserid) {
        this.contributedUserid = contributedUserid;
    }
}
