package com.amryadam.sbms.services.administrator;

import com.amryadam.sbms.models.entities.administrator.User;
import com.amryadam.sbms.repository.administrator.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public ImmutablePair<User, String> save(User user) {
        try {
            var e = userRepository.saveAndFlush(user);
            return ImmutablePair.of(e, "");
        } catch (IllegalArgumentException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }


    @Override
    public ImmutablePair<User, String> findById(String id) {
        try {
            var u = userRepository.findById(id);
            if (u.isPresent()) {
                return ImmutablePair.of(u.get(), "");
            } else {
                return ImmutablePair.of(null, "Not Found");
            }
        } catch (IllegalArgumentException ex) {
            return ImmutablePair.of(null, ex.getMessage());

        }
    }

}
