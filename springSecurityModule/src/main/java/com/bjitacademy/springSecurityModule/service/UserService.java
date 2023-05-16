package com.bjitacademy.springSecurityModule.service;


import com.bjitacademy.springSecurityModule.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> register(UserRequestModel requestModel);

    ResponseEntity<Object> getDetails(Long id);
}
