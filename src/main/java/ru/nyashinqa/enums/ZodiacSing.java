package ru.nyashinqa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ZodiacSing {

    ARIES(1, "Овен", "21 марта - 20 апреля"),
    TAURUS(2, "Телец", "21 апреля - 20 мая"),
    GEMINI(3, "Близнецы", "21 мая - 21 июня"),
    CANCER(4, "Рак", "22 июня - 22 июля"),
    LEO(5, "Лев", "23 июля - 23 августа"),
    VIRGO(6, "Дева", "24 августа - 23 сентября"),
    LIBRA(7, "Весы", "24 сентября - 23 октября"),
    SCORPIO(8, "Скорпион", "24 октября - 22 ноября"),
    SAGITTARIUS(9, "Стрелец", "23 ноября - 21 декабря"),
    CAPRICORN(10, "Козерог", "22 декабря - 20 января"),
    AQUARIUS(11, "Водолей", "21 января - 19 февраля"),
    PISCES(12, "Рыбы", "20 февраля - 20 марта");

    private final int idZodiac;
    private final String nameZodiac;
    private final String periodDateOfBirth;

    public static String getInstance(String nameZodiac) {
        for (ZodiacSing zodiacSing : values()) {
            if(zodiacSing.getNameZodiac().equals(nameZodiac)) {
                return nameZodiac;
            }
        }
        return null;
    }
}
