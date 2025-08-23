package com.db.service;

import com.db.dto.UserDTO;
import com.db.enums.Role;
import com.db.exceptions.BaseException;
import com.db.exceptions.ErrorMessage;
import com.db.exceptions.exepciton_enums.MessageType;
import com.db.models.User;
import com.db.repository.IUserRepository;
import com.db.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findUserByRole(Role role) {
        return userRepository.findUserByRole(role);
    }

    public UserDTO registerUser(UserDTO userDTO) {

        if (userRepository.existsUserByEmail(userDTO.getEmail())) {
            throw new BaseException(new ErrorMessage(MessageType.EXIST_BY_EMAIL));
        }
        if (userDTO.getName() == null) {
            throw new BaseException(new ErrorMessage(MessageType.USER_FIRSTNAME_CANNOT_BE_NULL));
        }
        if (userDTO.getLastName() == null) {
            throw new BaseException(new ErrorMessage(MessageType.USER_LASTNAME_CANNOT_BE_NULL));
        }
        if (userDTO.getEmail() == null) {
            throw new BaseException(new ErrorMessage(MessageType.USER_EMAIL_CANNOT_BE_NULL));
        }

        User user = new User();
        user.setFirstName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());


        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encodedPassword);

        user.setRole(Role.PATIENT);

        User savedUser = userRepository.save(user);

        return mapToUserResponseDto(savedUser);
    }

    public UserDTO loginUser(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BaseException(
                        new ErrorMessage(MessageType.USER_EMAIL_CANNOT_FOUND)
                ));

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new BaseException(new ErrorMessage(MessageType.INVALID_PASSWORD));
        }

        return mapToUserResponseDto(user);
    }


    private UserDTO mapToUserResponseDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        return userDTO;
    }


}
