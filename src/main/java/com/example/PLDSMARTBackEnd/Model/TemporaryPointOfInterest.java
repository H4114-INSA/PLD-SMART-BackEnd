package com.example.PLDSMARTBackEnd.Model;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity(name = "TemporaryPointOfInterest")
public class TemporaryPointOfInterest extends PointOfInterest {
    @Temporal(value = TemporalType.DATE)
    private Date endDate;

    public TemporaryPointOfInterest(){
        super();
    }

    public TemporaryPointOfInterest(PointOfInterest poi){
        this.title = poi.getTitle();
        this.description = poi.getDescription();
        this.pathToPicture = poi.getPathToPicture();
        this.createDate = poi.getCreateDate();
        this.status = poi.getStatus();
        this.categories = poi.getCategories();
        this.owner = poi.getOwner();
        this.longitude = poi.getLongitude();
    }
    public TemporaryPointOfInterest(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
