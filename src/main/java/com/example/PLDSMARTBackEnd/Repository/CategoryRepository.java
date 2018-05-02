package com.example.PLDSMARTBackEnd.Repository;

import com.example.PLDSMARTBackEnd.Model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.IdCategory = :id")
    Category findById(@Param("id")int id);

    @Query("SELECT c FROM Category c WHERE c.categoryName = :name")
    Category findByName(@Param("name") String name);
}
