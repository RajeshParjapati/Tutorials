package com.potters.userservice.services;

import com.potters.userservice.dto.UserDTO;
import com.potters.userservice.entity.Address;
import com.potters.userservice.entity.User;
import com.potters.userservice.exceptions.bussiness.UserNotFoundException;
import com.potters.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public String saveUser(UserDTO userDTO) {
    Set<Address> addressSet = new HashSet<>();
    userDTO
        .getAddresses()
        .forEach(
            addressDTO ->
                addressSet.add(
                    Address.builder()
                        .id(0)
                        .street(addressDTO.getStreet())
                        .city(addressDTO.getCity())
                        .country(addressDTO.getCountry())
                        .pinCode(addressDTO.getPinCode())
                        .build()));
    final User user =
        User.builder()
            .id(0)
            .age(userDTO.getAge())
            .email(userDTO.getEmail())
            .name(userDTO.getName())
            .phoneNo(userDTO.getPhoneNo())
            .addresses(addressSet)
            .build();
    //user.getAddresses().forEach(address -> address.setUser(user));
    int id = userRepository.save(user).getId();
    return "User created successfully with id : " + id;
  }

  public User getUserById(Integer id) {
    return userRepository
        .findById(id)
        .orElseThrow(() -> new UserNotFoundException("User Not Found.."));
  }
}
