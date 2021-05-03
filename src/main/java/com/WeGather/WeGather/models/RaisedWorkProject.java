package com.WeGather.WeGather.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class RaisedWorkProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long locationId;

    //============== Relation =================


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToMany(mappedBy = "RaisedWorkProject", cascade = CascadeType.ALL)
    private List<Comments> comments;


    //===================== Constructors ======================
    public RaisedWorkProject() {
    }

    public RaisedWorkProject(Long userId, Long locationId) {
        this.userId = userId;
        this.locationId = locationId;
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
