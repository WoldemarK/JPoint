package com.example.JPoint.service;

import com.example.JPoint.dto.UserDto;
import com.example.JPoint.model.User;
import com.example.JPoint.repository.UserRepository;
import com.example.JPoint.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks private UserService userService;
    @Mock private UserRepository userRepository;

    @Test
    void usersEmptyIfNoUserAdded() {
        List<User> users = userService.getAllUsers();
        assertTrue(users.isEmpty());
    }
    @Test
    public void shouldReturnUserById(){
        long desiredId = 1;
        String nickname = "boba";
        String email = "boba@boba.com";
        String password = "1234";
        String aboutMe = "I am boba!";
        User mockUser = User
                .builder()
                .id(desiredId)
                .firstName(nickname)
                .email(email)
                .password(password)
                .lastName(aboutMe)
                .build();
        Mockito.when(userRepository.findById(desiredId))
                .thenReturn(Optional.of(mockUser));

        User user = userService.getUsersById(desiredId);

        Assertions.assertEquals(desiredId, user.getId());
        Assertions.assertEquals(nickname, user.getFirstName());
        Assertions.assertEquals(email, user.getEmail());
        Assertions.assertEquals(password, user.getPassword());
        Assertions.assertEquals(aboutMe, user.getLastName());
    }

}
