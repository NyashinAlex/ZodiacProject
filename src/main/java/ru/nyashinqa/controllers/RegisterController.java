package ru.nyashinqa.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nyashinqa.models.UserRequest;
import ru.nyashinqa.models.UserResponse;
import ru.nyashinqa.support.WriterByDB;

@Validated
@RestController
@RequestMapping("v1/")
@Tag(name = "Регистрация нового пользователя")
public class RegisterController {

    WriterByDB db = new WriterByDB();

    @Operation(summary = "Регистрация нового пользователя")
    @PostMapping("/registerUser")
    public UserResponse registerUserPost(@RequestBody UserRequest userRequest) {
        db.registerNewUser(userRequest.getUserName(), userRequest.getPassword());
        UserResponse userResponse = new UserResponse(userRequest.getUserName(), "***", "Пользователь успешно зарегистрирован");
        return userResponse;
    }
}
