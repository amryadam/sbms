package com.amryadam.sbms.repository.administration;

import com.amryadam.sbms.model.administration.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);

}
