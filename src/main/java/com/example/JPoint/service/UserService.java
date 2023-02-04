package com.example.JPoint.service;

import com.example.JPoint.exception.AllException;
import com.example.JPoint.model.User;
import com.example.JPoint.repository.DepartmentRepository;
import com.example.JPoint.repository.UserRepository;
import com.example.JPoint.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final PostRepository postRepository;

    @Transactional
    public User createNewUser(@Validated User _user) {
        return userRepository.save(_user);

    }
    @Transactional
    public User createUserAndDepartmentAndPost(@Validated User _user,
                                                 Long departmentId,
                                                 Long postId) {
        _user.addDepartment(departmentRepository.findById(departmentId).get());
        _user.addPost(postRepository.findById(postId).get());
        return userRepository.save(_user);
    }

    public User getUsersById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new AllException("Пользователя с " + id + " не существует"));

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    @Transactional
    public void update(@Validated User user, Long id) {
        User _users = getUsersById(id);
        _users.setLogin(user.getLogin());
        _users.setPassword(user.getPassword());
        _users.setFirstName(user.getFirstName());
        _users.setLastName(user.getLastName());
        _users.setBirth(user.getBirth());
        _users.setPhoneNumber(user.getPhoneNumber());
        _users.setEmail(user.getEmail());
        _users.setCreation(user.getCreation());
        _users.setUpdate(user.getUpdate());
        _users.setDepartments(user.getDepartments());
        _users.setPosts(user.getPosts());
        userRepository.save(_users);


    }

    @Transactional
    public void delete(@Validated Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        }
        throw new AllException("Пользователя с " + id + " не существует");
    }

    public List<User> getNames(String _nameF, String _nameL) {
        return userRepository.findByFirstNameOrLastName(_nameF, _nameL);
    }

    public List<User> startStartingWithNames(String _name) {
        return userRepository.findByFirstNameIsStartingWith(_name);
    }

}
