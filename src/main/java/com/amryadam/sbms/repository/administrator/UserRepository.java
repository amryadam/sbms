package com.amryadam.sbms.repository.administrator;

import com.amryadam.sbms.models.entities.administrator.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,String> {

}
