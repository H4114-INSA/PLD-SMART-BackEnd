package com.example.PLDSMARTBackEnd.Repository;

import com.example.PLDSMARTBackEnd.Model.PointOfInterest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PointOfInterestRepository extends CrudRepository<PointOfInterest, Long> {
    @Query("SELECT p FROM PointOfInterest p WHERE p.IdPoint= :idPoi ")
    PointOfInterest findById(@Param("idPoi") int idPoi);

    @Query("SELECT p FROM PointOfInterest p WHERE p.status = 'Validated'")
    Iterable<PointOfInterest> findAllValidatedPoint();

    //@Query("SELECT p FROM PointOfInterest p WHERE ")
    //Iterable<PointOfInterest> findPointWithFilters();
}
