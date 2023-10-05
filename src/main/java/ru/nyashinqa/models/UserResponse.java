package ru.nyashinqa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {

    private String userName;
    private String password;
    private String msg;
}
