package com.WeGather.WeGather.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public
class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    @ElementCollection
    private List<String> profilePictures;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String authority;

    //    relation between Users & raisedFund
    @OneToMany(mappedBy = "raisedFund", cascade = CascadeType.ALL)
    private List<RaisedFundUser> funds;

    public Users(String userName, String password, String firstName, String middleName, String lastName, List<String> profilePictures, Date createdAt, String authority) {
        this.username = userName;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.profilePictures = profilePictures;
        this.createdAt = createdAt;
        this.authority = authority;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }


    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getProfilePictures() {
        return profilePictures;
    }

    public void setProfilePictures(List<String> profilePictures) {
        this.profilePictures = profilePictures;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
