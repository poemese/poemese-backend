package com.poemese.poemese.services;

import com.poemese.poemese.daos.UserRepository;
import com.poemese.poemese.exceptions.UserAlreadyExistsException;
import com.poemese.poemese.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository<User, String> userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository<User, String> userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public void signup(User user) {
        Optional<User> tempUser = userRepository.findById(user.getEmail());
        if(!tempUser.isPresent()) {
            String password = passwordEncoder.encode(user.getPassword());
            user.setPassword(password);
            userRepository.save(user);
        } else {
            throw new UserAlreadyExistsException("Email already present in database: " + user.getEmail());
        }
    }
}
