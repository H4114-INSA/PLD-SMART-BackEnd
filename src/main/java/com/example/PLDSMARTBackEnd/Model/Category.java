package com.example.PLDSMARTBackEnd.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdCategory")
    private Integer IdCategory;

    @Column(nullable = false, unique = true)
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

    public String toString(){
        return "Id Category : "+IdCategory+" - Category name : "+categoryName;
    }
}
