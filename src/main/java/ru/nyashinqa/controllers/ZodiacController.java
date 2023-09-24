package ru.nyashinqa.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nyashinqa.api.ZodiacSign;
import ru.nyashinqa.enums.Month;
import ru.nyashinqa.enums.ZodiacSing;
import ru.nyashinqa.models.CompatibilityZodiacResponse;

import javax.validation.constraints.Max;

@Validated
@RestController
@RequestMapping("v1/")
@Tag(name = "Все по дате рождения", description = "Обработка данных по дате рождения")
public class ZodiacController {

    ZodiacSign zodiacSign = new ZodiacSign();

    @Operation(summary = "Получение знака зодиака по дате рождения")
    @PostMapping("/zodiacsign")
    public String zodiacPost(
        @RequestParam("dayOfBirth") @Max(31) @Parameter(description = "День рождения") int day,
        @RequestParam("monthOfBirth") @Parameter(description = "Месяц рождения") Month month
    ) {
        return "Бедолага по знаку зодиака - " + zodiacSign.zodiacSignByMonth(month, day);
    }

    @Operation(summary = "Получение камня по дате рождения")
    @PostMapping("/zodiacsignstone")
    public String stonePost(
        @RequestParam("dayOfBirth") @Max(31) @Parameter(description = "День рождения") int day,
        @RequestParam("monthOfBirth") @Parameter(description = "Месяц рождения") Month month
    ) {
        String zodiacName = zodiacSign.zodiacSignByMonth(month, day);
        return "Камень бедолаги - " + zodiacSign.stoneByZodiac(zodiacName) + ". Знак зодиака бедолаги - " + zodiacName;
    }

    @Operation(summary = "Совместимость по знакам зодиака")
    @PostMapping("/zodiacsigncompatibility")
    public CompatibilityZodiacResponse compatibilityZodiacPost(
        @RequestParam("zodiacMen") @Parameter(description = "Зодиак Мужщина") ZodiacSing zodiacMen,
        @RequestParam("zodiacWomen") @Parameter(description = "Зодиак Женщины") ZodiacSing zodiacWomen
    ) {
        return zodiacSign.compatibilityManZodiacAndWomenZodiac(zodiacMen.getNameZodiac(), zodiacWomen.getNameZodiac());
    }
}
