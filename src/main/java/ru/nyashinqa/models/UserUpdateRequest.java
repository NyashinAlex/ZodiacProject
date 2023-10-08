package ru.nyashinqa.models;

import lombok.Getter;
import lombok.Setter;
import ru.nyashinqa.enums.Month;

@Getter
@Setter
public class UserUpdateRequest {

    private String userName;
    private int dayOfBirth;
    private Month monthOfBirth;
}
