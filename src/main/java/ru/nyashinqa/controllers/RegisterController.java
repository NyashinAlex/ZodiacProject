package ru.nyashinqa.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nyashinqa.api.User;
import ru.nyashinqa.models.UserRequest;
import ru.nyashinqa.models.UserRegisterRequest;
import ru.nyashinqa.models.UserResponse;
import ru.nyashinqa.models.UserUpdateRequest;

@Validated
@RestController
@RequestMapping("v1/")
@Tag(name = "Регистрация нового пользователя")
public class RegisterController {

    User user = new User();

    @Operation(summary = "Регистрация нового пользователя")
    @PostMapping("/registerUser")
    public UserResponse registerUserPost(@RequestBody UserRegisterRequest userRegisterRequest) {
        String[] msgAndStatus = user.registerNewUser(userRegisterRequest.getUserName(), userRegisterRequest.getPassword());
        UserResponse userResponse = new UserResponse(userRegisterRequest.getUserName(), msgAndStatus[0], msgAndStatus[1]);
        return userResponse;
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping("/deleteUser")
    public UserResponse deleteUser(@RequestBody UserRequest userRequest) {
        String[] msgAndStatus = user.deleteUser(userRequest.getUserName());
        UserResponse userResponse = new UserResponse(userRequest.getUserName(), msgAndStatus[0], msgAndStatus[1]);
        return userResponse;
    }

    @Operation(summary = "Обновление у пользователя знака зодиака")
    @PutMapping("/updateZodiacByUser")
    public UserResponse updateZodiacByUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        String[] msgAndStatus = user.updateZodiacByUser(userUpdateRequest.getUserName(), userUpdateRequest.getDayOfBirth(), userUpdateRequest.getMonthOfBirth());
        UserResponse userResponse = new UserResponse(userUpdateRequest.getUserName(), msgAndStatus[0], msgAndStatus[1]);
        return userResponse;
    }
}
