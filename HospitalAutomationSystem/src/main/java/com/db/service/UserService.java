package com.db.service;

import com.db.enums.Role;
import com.db.models.User;
import com.db.repository.IUserRepository;
import com.db.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findUserByRole(Role role) {
        return userRepository.findUserByRole(role);
    }
}
