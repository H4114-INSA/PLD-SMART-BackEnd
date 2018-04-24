package com.example.PLDSMARTBackEnd.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

enum Status{
    Proposed,
    Validated,
    Deprecated;
}

@Entity
@DiscriminatorColumn(name = "Temp")
@Inheritance (strategy = InheritanceType.JOINED)
public class PointOfInterest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer IdPoint;

    @NotNull
    protected String title;

    protected String description;

    protected String pathToPicture;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    protected Date createDate;

    protected Status status;

    @ManyToOne
    protected User owner;

    @ManyToOne
    protected GeographicalCoordinates coordinates;

    @ManyToMany
    protected List<Category> categories;

    public PointOfInterest(){}

    public Integer getIdPoint() {
        return IdPoint;
    }

    public void setIdPoint(Integer idPoint) {
        IdPoint = idPoint;
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
