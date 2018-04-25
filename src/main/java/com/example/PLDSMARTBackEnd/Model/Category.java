package com.example.PLDSMARTBackEnd.Model;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdCategory;

    private String categoryName;

    public Integer getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.IdCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
