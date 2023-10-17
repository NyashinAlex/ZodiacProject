package ru.nyashinqa.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nyashinqa.api.User;
import ru.nyashinqa.models.*;

import java.util.HashMap;

@Validated
@RestController
@RequestMapping("v1/")
@Tag(name = "Регистрация нового пользователя")
public class RegisterController {

    User user = new User();

    @Operation(summary = "Регистрация нового пользователя")
    @PostMapping("/registerUser")
    public UserResponse registerUserPost(@RequestBody UserRegisterRequest userRegisterRequest) {
        String[] msgAndStatus = user.registerNewUser(userRegisterRequest.getUserName(), userRegisterRequest.getPassword(), userRegisterRequest.getSex());
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

    @Operation(summary = "Обновление у пользователя данных, связанные с знаком зодиака")
    @PutMapping("/updateZodiacByUser")
    public UserFullResponse updateZodiacByUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        HashMap<String, String> msg = user.updateInfoByUser(userUpdateRequest.getUserName(), userUpdateRequest.getDayOfBirth(), userUpdateRequest.getMonthOfBirth());
        UserFullResponse userFullResponse = new UserFullResponse(
                userUpdateRequest.getUserName(),
                msg.get("status"),
                msg.get("msg"),
                msg.get("stoneByUser"),
                msg.get("zodiacByUser"));
        return userFullResponse;
    }
}
