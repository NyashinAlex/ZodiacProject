package ru.nyashinqa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ZodiacSing {

    ARIES(1, "Овен"),
    TAURUS(2, "Телец"),
    GEMINI(3, "Близнецы"),
    CANCER(4, "Рак"),
    LEO(5, "Лев"),
    VIRGO(6, "Дева"),
    LIBRA(7, "Весы"),
    SCORPIO(8, "Скорпион"),
    SAGITTARIUS(9, "Стрелец"),
    CAPRICORN(10, "Козерог"),
    AQUARIUS(11, "Водолей"),
    PISCES(12, "Рыбы");

    private final int idZodiac;
    private final String nameZodiac;
}
