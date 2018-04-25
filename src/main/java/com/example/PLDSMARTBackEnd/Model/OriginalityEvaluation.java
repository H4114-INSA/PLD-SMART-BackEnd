package com.example.PLDSMARTBackEnd.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OriginalityEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdEvaluation;

    private int note;

    private Date evaluationDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private PointOfInterest point;

    public OriginalityEvaluation(){ }

    public Integer getIdEvaluation() {
        return IdEvaluation;
    }

    public void setIdEvaluation(Integer idEvaluation) {
        IdEvaluation = idEvaluation;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
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
