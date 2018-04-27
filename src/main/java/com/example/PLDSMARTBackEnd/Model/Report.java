package com.example.PLDSMARTBackEnd.Model;

import javax.persistence.*;

@Entity(name = "Report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdReport;

    @ManyToOne
    private User user;

    @ManyToOne
    private PointOfInterest point;

    private Cause cause;

    public Report(){
    }

    public Integer getIdReport() {
        return IdReport;
    }

    public void setIdReport(Integer idReport) {
        IdReport = idReport;
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

    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }
}
