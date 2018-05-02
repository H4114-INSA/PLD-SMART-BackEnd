package com.example.PLDSMARTBackEnd.Repository;

import com.example.PLDSMARTBackEnd.Model.PointOfInterest;
import com.example.PLDSMARTBackEnd.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PointOfInterestRepository extends CrudRepository<PointOfInterest, Long> {
    @Query("SELECT p FROM PointOfInterest p WHERE p.IdPoint= :idPoi ")
    PointOfInterest findById(@Param("idPoi") int idPoi);

    @Query("SELECT p FROM PointOfInterest p WHERE p.status = 1")
    Iterable<PointOfInterest> findAllValidatedPoint();

    @Query("SELECT p FROM PointOfInterest p WHERE p.owner= :user")
    Iterable<PointOfInterest> findByUser(@Param("user") User user);

    @Query("SELECT p FROM PointOfInterest p WHERE p.owner= :user AND p.status = 1")
    Iterable<PointOfInterest> findValidatedPointByUser(@Param("user")User user);

    @Query("SELECT DISTINCT p FROM PointOfInterest p JOIN FETCH p.categories c WHERE c.categoryName IN :categories")
    Iterable<PointOfInterest> findPointWithFilters(@Param("categories")List<String> category);

    @Query("SELECT p FROM PointOfInterest p WHERE p.owner <> :user AND p.status = 0")
    Iterable<PointOfInterest> findListPointToValidate(@Param("user") User user);

    @Query("SELECT p FROM PointOfInterest p WHERE p.title LIKE :name AND p.status = 1")
    Iterable<PointOfInterest> findSearchedPoints (@Param("name")String name);
}