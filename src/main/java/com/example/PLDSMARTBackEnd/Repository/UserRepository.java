package com.example.PLDSMARTBackEnd.Repository;

import com.example.PLDSMARTBackEnd.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>  {
}
