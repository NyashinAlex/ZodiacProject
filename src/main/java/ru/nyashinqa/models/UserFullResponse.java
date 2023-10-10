package ru.nyashinqa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserFullResponse {

    private String userName;
    private String status;
    private String msg;
    private String stone;
    private String zodiac;
}
