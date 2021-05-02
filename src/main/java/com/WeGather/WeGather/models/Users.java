package com.WeGather.WeGather.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public
class Users implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    @Column(unique = true)
    private String nationalNumber;
    @Column(unique = true)
    private String nationalCardNumber;
    @Column(unique = true)
    private String passportNumber;
    private String nameWrittenInPassport;
    private List<String> profilePictures;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // empty constructor
    public
    Users(){ }

    // parametrized constructor
    public
    Users(String userName, String password, String firstName, String middleName, String lastName, String nationalNumber, String nationalCardNumber, String nameWrittenInPassport, String passportNumber, List<String> profilePictures, Date createdAt) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nationalNumber = nationalNumber;
        this.nationalCardNumber = nationalCardNumber;
        this.nameWrittenInPassport = nameWrittenInPassport;
        this.passportNumber = passportNumber;
        this.profilePictures = profilePictures;
        this.createdAt = createdAt;
    }



    // getters and setters
    public
    Long getId() {
        return id;
    }

    public
    String getUserName() {
        return userName;
    }

    public
    void setUserName(String userName) {
        this.userName = userName;
    }

    public
    String getFirstName() {
        return firstName;
    }

    public
    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public
    String getMiddleName() {
        return middleName;
    }

    public
    void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public
    String getLastName() {
        return lastName;
    }

    public
    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public
    String getNationalNumber() {
        return nationalNumber;
    }

    public
    void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public
    String getNationalCardNumber() {
        return nationalCardNumber;
    }

    public
    void setNationalCardNumber(String nationalCardNumber) {
        this.nationalCardNumber = nationalCardNumber;
    }

    public
    String getNameWrittenInPassport() {
        return nameWrittenInPassport;
    }

    public
    void setNameWrittenInPassport(String nameWrittenInPassport) {
        this.nameWrittenInPassport = nameWrittenInPassport;
    }

    public
    String getPassportNumber() {
        return passportNumber;
    }

    public
    void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public
    List<String> getProfilePictures() {
        return profilePictures;
    }

    public
    void setProfilePictures(List<String> profilePictures) {
        this.profilePictures = profilePictures;
    }

    // authorities
    @Override
    public
    Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public
    String getPassword() {
        return this.password;
    }

    @Override
    public
    String getUsername() {
        return this.userName;
    }

    @Override
    public
    boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public
    boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public
    boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public
    boolean isEnabled() {
        return true;
    }
}
