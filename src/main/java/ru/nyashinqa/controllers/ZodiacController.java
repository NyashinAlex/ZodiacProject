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
import ru.nyashinqa.models.HoroscopeRequest;
import ru.nyashinqa.models.HoroscopeResponse;

import javax.validation.constraints.Max;

@Validated
@RestController
@RequestMapping("v1/")
@Tag(name = "Все по дате рождения", description = "Обработка данных по дате рождения")
public class ZodiacController {

    ZodiacSign zodiacSign = new ZodiacSign();

    @Operation(summary = "Получение знака зодиака по дате рождения")
    @GetMapping("/zodiacsign")
    public String zodiacPost(
        @RequestParam("dayOfBirth") @Max(31) @Parameter(description = "День рождения (числом 1-30)") int day,
        @RequestParam("monthOfBirth") @Parameter(description = "Месяц рождения") Month month
    ) {
        return "Бедолага по знаку зодиака - " + zodiacSign.zodiacSignByMonth(month, day);
    }

    @Operation(summary = "Получение камня по дате рождения")
    @GetMapping("/zodiacsignstone")
    public String stonePost(
        @RequestParam("dayOfBirth") @Max(31) @Parameter(description = "День рождения (числом 1-30)") int day,
        @RequestParam("monthOfBirth") @Parameter(description = "Месяц рождения") Month month
    ) {
        String zodiacName = zodiacSign.zodiacSignByMonth(month, day);
        return "Камень бедолаги - " + zodiacSign.stoneByZodiac(zodiacName) + ". Знак зодиака бедолаги - " + zodiacName;
    }

    @Operation(summary = "Совместимость по знакам зодиака")
    @GetMapping("/zodiacsigncompatibility")
    public CompatibilityZodiacResponse compatibilityZodiacPost(
        @RequestParam("zodiacMen") @Parameter(description = "Зодиак Мужщина") ZodiacSing zodiacMen,
        @RequestParam("zodiacWomen") @Parameter(description = "Зодиак Женщины") ZodiacSing zodiacWomen
    ) {
        return zodiacSign.compatibilityManZodiacAndWomenZodiac(zodiacMen.getNameZodiac(), zodiacWomen.getNameZodiac());
    }

    @Operation(summary = "Зодиак по сегодняшнему дню")
    @GetMapping("/zodiactoday")
    public String zodiacTodayGet() {
        return zodiacSign.todayZodiac();
    }

    @Operation(summary = "Получение гороскопа по знаку зодиака")
    @PostMapping("/horoscope")
    public HoroscopeResponse getHoroscope(@RequestBody HoroscopeRequest horoscopeRequest) {
        return zodiacSign.getHoroscope(horoscopeRequest.getZodiac(), horoscopeRequest.getTypeHoroscope());
    }
}
