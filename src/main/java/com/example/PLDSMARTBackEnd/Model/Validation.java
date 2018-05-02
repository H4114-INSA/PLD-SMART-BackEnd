package com.example.PLDSMARTBackEnd.Model;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Validation")
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdValidation;

    private boolean validationNote;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date validationDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private PointOfInterest point;

    public Validation(){
    }

    public Integer getIdValidation() {
        return IdValidation;
    }

    public void setIdValidation(Integer idValidation) {
        IdValidation = idValidation;
    }

    public boolean isValidationNote() {
        return validationNote;
    }

    public void setValidationNote(boolean validationNote) {
        this.validationNote = validationNote;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PointOfInterest getPoint() {
        return point;
    }

    public void setPoint(PointOfInterest point) {
        this.point = point;
    }
}
