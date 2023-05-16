package com.bjitacademy.springSecurityModule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseModel {
    private String userName;
    private String email;
    private String firstName;
}
