package com.bjitacademy.springSecurityModule.controller;

import com.bjitacademy.springSecurityModule.entity.UserEntity;
import com.bjitacademy.springSecurityModule.model.UserRequestModel;
import com.bjitacademy.springSecurityModule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRequestModel requestModel){
        return userService.register(requestModel);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Object> getUserServiceDetails(@PathVariable Long id) {
        return userService.getDetails(id);
    }

}
