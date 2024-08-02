package com.api.api_user.controller;

import java.util.List;

//import javax.validation.Valid;

import com.api.api_user.domain.dto.ResponseDto;
import com.api.api_user.domain.dto.UserDto;
import com.api.api_user.domain.entity.User;
import com.api.api_user.domain.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  //http://localhost:8080/user/
  @PostMapping 
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseDto saveUser(@Valid @RequestBody User user) {
    return userService.saveUser(user);
  }

  // http://localhost:8080/user/list
  @GetMapping(value = "/list") 
  public List<UserDto> getAllUser() {
    return userService.getAllUserOrderByName();
  }

  // http://localhost:8080/user/{id}
  @GetMapping(value = "/{id}") 
  public UserDto getUserById(@Valid @PathVariable Long id) {
    return userService.getUserById(id);
  }

  //http://localhost:8080/user/
  @PutMapping
  public ResponseDto updateUser(@Valid @RequestBody User user) 
  {
    return userService.updateUser(user);
  }

  // http://localhost:8080/user/{id}
  @DeleteMapping(value = "/{id}")
  public ResponseDto deleteUser(@Valid @PathVariable Long id) {
    return userService.deleteUser(id);
  }

  // http://localhost:8080/user/validarLogin/{login}/{password}
  @PostMapping(value = "/validarLogin/{login}/{password}")
  public UserDto validateLogin(@Valid @PathVariable String login, @PathVariable String password) {
    return userService.validateLogin(login, password);
  }
}