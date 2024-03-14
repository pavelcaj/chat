package com.example.chat.servise;


import com.example.chat.dto.UserDTO;
import com.example.chat.rep.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(String login) {
        UserDTO newUser = new UserDTO();
        newUser.setLogin(login);
        return userRepository.save(newUser);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserDTO> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public void updateUser(Integer id, String newLogin) {
        Optional<UserDTO> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserDTO user = existingUser.get();
            user.setLogin(newLogin);
            userRepository.save(user);
        }
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }}