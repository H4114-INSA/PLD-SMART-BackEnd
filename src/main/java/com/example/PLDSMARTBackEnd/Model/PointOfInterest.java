package com.example.PLDSMARTBackEnd.Model;


import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

enum Status{
    Proposed,
    Validated,
    Deprecated;
}

@Entity
public class PointOfInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String title;

    private String description;

    private String pathToPicture;

    private Date createDate;

    private Status status;
    //TODO : Réflechir à la direction des associations
    @ManyToOne
    private User owner;

    @ManyToOne
    private GeographicalCoordinates coordinates;

    @ManyToMany
    private List<Category> categories;

    public PointOfInterest(){}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathToPicture() {
        return pathToPicture;
    }

    public void setPathToPicture(String pathToPicture) {
        this.pathToPicture = pathToPicture;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public GeographicalCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(GeographicalCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
