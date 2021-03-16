package com.example.gradsday2fullusersdatabase.repository;

import com.example.gradsday2fullusersdatabase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Integer> {
    Optional<User> findUserByUsername(String userName);
}
