package com.standapp.api.userservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.standapp.api.userservice.common.RestResponse;
import com.standapp.api.userservice.models.dto.UserDTO;
import com.standapp.api.userservice.models.entities.User;
import com.standapp.api.userservice.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Post methods to be prefixed with post 
 * Get methods to be prefixed with get
 * Put methods to be prefixed with put
 * Delete methods to be prefixed with delete
 * This terminology to be used throughout the service
 */

@RestController
@RequestMapping(value="/user")
class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value="")
    public RestResponse<UserDTO> postUser(@RequestBody User user) {
        return RestResponse.ok(userService.postUser(user));
    }

    @GetMapping(value="/{id}")
    public RestResponse<UserDTO> getUserById(@PathVariable Long id) {
        return RestResponse.ok(userService.getUserById(id));
    }

    // @GetMapping(value="")
    // public List<User> getAllUsers() {
    //     return repository.findAll();
    // }

    // @PutMapping(value="/{id}")
    // public User putUser(@PathVariable("id") Long id, @RequestBody User newUser) {
    //     return repository.findById(id)
    //     .map(user -> {
    //         user.setEmail(newUser.getEmail());
    //         user.setPassword(newUser.getPassword());
    //         user.setUsername(newUser.getUsername());
    //         user.setPhoneNumber(newUser.getPhoneNumber());
    //         user.setExtraContactDetails(newUser.getExtraContactDetails());
    //         return repository.save(user);
    //     }).get();
    // }

}