package com.example.gradsday2fullusersdatabase.service;

import com.example.gradsday2fullusersdatabase.model.SecurityClient;
import com.example.gradsday2fullusersdatabase.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class JpaClientDetailsService implements ClientDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return clientRepository.findClientByClientId(clientId)
                .map(SecurityClient::new)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }
}
