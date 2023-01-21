package com.example.JPoint.service;

import com.example.JPoint.exception.AllException;
import com.example.JPoint.model.User;
import com.example.JPoint.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public User createNewUsers(User user) {
        return adminRepository.save(user);
    }

    public Optional<User> getUsersById(Long id) {
        Optional<User> user = adminRepository.findById(id);
        if (user.isEmpty()) {
            throw new AllException("Пользователя с " + id + " не существует");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return adminRepository.findAll();
    }

    public Optional<User> update(User user, Long id) {
        Optional<User> users = adminRepository.findById(id);
        if (users.isPresent()) {
            users.get().setFirstName(user.getFirstName());
            users.get().setLastName(user.getLastName());
            users.get().setPhoneNumber(user.getPhoneNumber());
            users.get().setEmail(user.getEmail());
            users.get().setRole(user.getRole());
            users.get().setStatusRole(user.getStatusRole());
            users.get().setDepartament(user.getDepartament());
            users.get().setPassword(user.getPassword());
            users.get().setBirth(user.getBirth());
            adminRepository.save(users.get());
        } else {
            throw new AllException("Пользователя с " + id + " не существует");
        }
        return Optional.empty();
    }

    public void delete(Long id) {
        Optional<User> user = adminRepository.findById(id);
        if (user.isPresent()) {
            adminRepository.deleteById(id);
        }
        throw new AllException("Пользователя с " + id + " не существует");
    }
}
