package ru.nyashinqa.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Данные пользователя")
public class UserRegisterRequest {

    @Schema(description = "Имя пользователя")
    private String userName;
    @Schema(description = "Пароль пользователя")
    private String password;
    @Schema(description = "Пол пользователя", example = "woman, man")
    private String sex;
}
