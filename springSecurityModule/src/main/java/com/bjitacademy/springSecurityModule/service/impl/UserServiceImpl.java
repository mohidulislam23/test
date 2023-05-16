package com.bjitacademy.springSecurityModule.service.impl;

import com.bjitacademy.springSecurityModule.entity.UserEntity;
import com.bjitacademy.springSecurityModule.model.UserRequestModel;
import com.bjitacademy.springSecurityModule.model.UserResponseModel;
import com.bjitacademy.springSecurityModule.repository.UserRepository;
import com.bjitacademy.springSecurityModule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// UserDetailsService is build in
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return null;
    }
    @Override
    public ResponseEntity<Object> register(UserRequestModel requestModel){
        UserEntity userEntity = UserEntity.builder()
                .email(requestModel.getEmail())
                .userName(requestModel.getUserName())
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .password(requestModel.getPassword())
                .build()
                ;
        UserEntity savedUserEntity  = userRepository.save(userEntity);

        UserResponseModel userResponseModel = UserResponseModel.builder()
                .email(requestModel.getEmail())
                .userName(requestModel.getUserName())
                .firstName(requestModel.getFirstName())
                .build();
        return new ResponseEntity<>(userResponseModel, HttpStatus.CREATED);

        //return new ResponseEntity<>(savedUserEntity, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getDetails(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent()){
            UserEntity user_end = user.get();
            UserResponseModel responseModel = UserResponseModel.builder()
                    .userName(user_end.getUserName())
                    .email(user_end.getEmail())
                    .firstName(user_end.getFirstName())
                    .build()
                    ;
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } else {
            return null;
        }

    }
}
