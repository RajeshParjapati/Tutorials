package com.potters.userservice.services;

import com.potters.userservice.dto.UserDTO;
import com.potters.userservice.entity.User;
import com.potters.userservice.exceptions.bussiness.UserNotFoundException;
import com.potters.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public String saveUser(UserDTO userDTO) {
    User user =
        User.builder()
            .id(0)
            .age(userDTO.getAge())
            .email(userDTO.getEmail())
            .name(userDTO.getName())
            .phoneNo(userDTO.getPhoneNo())
            .build();
    userRepository.save(user);
    return "User created successfully with id : ";
  }

  public User getUserById(Integer id) {
    return userRepository
        .findById(id)
        .orElseThrow(() -> new UserNotFoundException("User Not Found.."));
  }
}
