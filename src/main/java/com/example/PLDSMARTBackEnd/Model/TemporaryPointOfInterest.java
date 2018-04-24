package com.example.PLDSMARTBackEnd.Model;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class TemporaryPointOfInterest extends PointOfInterest {
    @Temporal(value = TemporalType.DATE)
    private Date endDate;

    public TemporaryPointOfInterest(){
        super();
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
