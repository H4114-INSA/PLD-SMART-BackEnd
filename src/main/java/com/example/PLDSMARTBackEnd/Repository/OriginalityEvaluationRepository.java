package com.example.PLDSMARTBackEnd.Repository;

import com.example.PLDSMARTBackEnd.Model.OriginalityEvaluation;
import com.example.PLDSMARTBackEnd.Model.PointOfInterest;
import com.example.PLDSMARTBackEnd.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OriginalityEvaluationRepository  extends CrudRepository<OriginalityEvaluation, Long> {
    @Query("SELECT oe FROM OriginalityEvaluation oe WHERE oe.user= :user AND oe.point= :point")
    OriginalityEvaluation check(@Param("user") User user, @Param("point")PointOfInterest point);

}
