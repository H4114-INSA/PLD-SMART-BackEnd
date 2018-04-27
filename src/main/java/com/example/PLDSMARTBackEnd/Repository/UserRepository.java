package com.example.PLDSMARTBackEnd.Repository;

import com.example.PLDSMARTBackEnd.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email= :mail ")
    User findByMail(@Param("mail") String mail);

    @Query("SELECT u FROM User u WHERE u.IdUser= :idPoi ")
    User findById(@Param("idPoi") int idPoi);
}
