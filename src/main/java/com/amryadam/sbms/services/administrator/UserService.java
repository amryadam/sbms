package com.amryadam.sbms.services.administrator;

import com.amryadam.sbms.models.entities.administrator.User;
import org.apache.commons.lang3.tuple.ImmutablePair;

public interface UserService {
    ImmutablePair<User, String> save(User user);
    ImmutablePair<User, String> findById(String id);
}
