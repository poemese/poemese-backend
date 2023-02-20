package com.poemese.poemese.services;

import java.util.ArrayList;
import java.util.Optional;

import com.poemese.poemese.daos.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository<com.poemese.poemese.models.User, String> userRepository;

    public JwtUserDetailsService(UserRepository<com.poemese.poemese.models.User, String> userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.poemese.poemese.models.User> tempUser = userRepository.findById(username);

        if(tempUser.isPresent()) {
            return new User(tempUser.get().getEmail(), tempUser.get().getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}