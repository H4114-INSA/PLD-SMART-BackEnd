package com.example.PLDSMARTBackEnd.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String categoryName;

    @ManyToMany
    private List<PointOfInterest> points;
}
