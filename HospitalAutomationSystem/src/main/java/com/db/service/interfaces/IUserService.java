package com.db.service.interfaces;

import com.db.enums.Role;
import com.db.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {

    Optional<User> findByUsername(String username);

    List<User> findUserByRole(Role role);


}
