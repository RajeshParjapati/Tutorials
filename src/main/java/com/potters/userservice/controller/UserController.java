package com.potters.userservice.controller;

import com.potters.userservice.dto.UserDTO;
import com.potters.userservice.entity.User;
import com.potters.userservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

  @Autowired private UserService userService;

  @GetMapping("all")
  public ResponseEntity<List<User>> getUser() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @PostMapping("create")
  public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO userDTO) {
    return ResponseEntity.ok(userService.saveUser(userDTO));
  }

  @GetMapping("user/{id}")
  public ResponseEntity<User> findById(@PathVariable Integer id){
    return ResponseEntity.ok(userService.getUserById(id));
  }
}
