package com.example.gradsday2fullusersdatabase.repository;

import com.example.gradsday2fullusersdatabase.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findClientByClientId(String clientId);
}
