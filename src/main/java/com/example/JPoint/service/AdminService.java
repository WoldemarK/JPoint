package com.example.JPoint.service;


import com.example.JPoint.dto.AdminDto;
import com.example.JPoint.exception.AllException;
import com.example.JPoint.mapper.AdminMapper;
import com.example.JPoint.model.Department;
import com.example.JPoint.model.Post;
import com.example.JPoint.model.User;
import com.example.JPoint.repository.AdminRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper mapper;

    public User createNewUsers(User user) {
        Post post = new Post();
        user.addPost(post);

        Department department = new Department();
        user.addDepartment(department);

        return adminRepository.save(user);
    }

    public AdminDto getUsersById(Long id) {
        User user = adminRepository.findById(id)
                .orElseThrow(() -> new AllException("Пользователя с " + id + " не существует"));
        return mapper.convertUserToDto(user);
    }

    public List<AdminDto> getAllUsers() {

        List<User> personList = adminRepository.findAll();
        return personList.stream()
                .map(mapper::convertUserToDto)
                .collect(Collectors.toList());
    }

    public AdminDto update(User user, Long id) {
        user = adminRepository.findById(id)
                .orElseThrow(() -> new AllException("Пользователя с " + id + " не существует"));
        user = User.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .departments(user.getDepartments())
                .posts(user.getPosts())
                .roles(user.getRoles())
                .isProject(user.isProject())
                .isTask(user.isTask())
                .creation(user.getCreation())
                .update(user.getUpdate())
                .build();
        return mapper.convertUserToDto(user);
//        users.setFirstName(user.getFirstName());
//        users.setLastName(user.getLastName());
//        users.setPhoneNumber(user.getPhoneNumber());
//        users.setEmail(user.getEmail());
//        users.setRole(user.getRole());
//        users.setStatusRole(user.getStatusRole());
//        users.setDepartment(user.getDepartment());
//        users.setPassword(user.getPassword());
//        users.setBirth(user.getBirth());
//        adminRepository.save(users);

    }

    public void delete(Long id) {
        Optional<User> user = adminRepository.findById(id);
        if (user.isPresent()) {
            adminRepository.deleteById(id);
        }
        throw new AllException("Пользователя с " + id + " не существует");
    }
}
