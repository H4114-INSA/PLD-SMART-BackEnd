package com.example.PLDSMARTBackEnd.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "PointOfInterest")
@Inheritance (strategy = InheritanceType.JOINED)
public class PointOfInterest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdPoint")
    protected Integer IdPoint;

    protected String title;

    protected String description;

    @Lob
    protected byte[] picture;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    protected Date createDate;

    protected Status status;

    @ManyToOne
    protected User owner;

    @ManyToMany
    protected List<Category> categories;

    protected double longitude;

    protected double latitude;

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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

}
