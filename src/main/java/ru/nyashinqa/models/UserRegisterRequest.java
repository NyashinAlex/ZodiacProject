package ru.nyashinqa.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {

    private String userName;
    private String password;
}