package com.example.JPoint.service;

import com.example.JPoint.model.Company;
import com.example.JPoint.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Company> getAllClients() {
        return clientRepository.findAll();
    }
    public Optional<Company> findById(Long id){
        return clientRepository.findById(id);
    }
}
