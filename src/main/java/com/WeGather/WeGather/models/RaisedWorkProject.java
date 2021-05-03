package com.WeGather.WeGather.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class RaisedWorkProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    //============== Relation =================


    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location_id;

//    @OneToMany(mappedBy = "rasiedWorkFund_id", cascade = CascadeType.ALL)
//    private List<Comments> comments;


    //===================== Constructors ======================
    public RaisedWorkProject() {
    }

    public RaisedWorkProject(Long userId, Location location_id) {
        this.userId = userId;
        this.location_id = location_id;
    }

    //================ Getters And Setters =============


    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Location getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Location location_id) {
        this.location_id = location_id;
    }
//
//    public List<Comments> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comments> comments) {
//        this.comments = comments;
//    }
}
