package com.example.gradsday2fullusersdatabase.service;

import com.example.gradsday2fullusersdatabase.model.SecurityUser;
import com.example.gradsday2fullusersdatabase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(userName)
                .map(SecurityUser::new)
                .orElseThrow(() -> new RuntimeException("User not found!!!"));
    }
}
