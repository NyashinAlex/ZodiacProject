package ru.nyashinqa.models;

import lombok.Getter;
import lombok.Setter;
import ru.nyashinqa.enums.ZodiacSing;

@Getter
@Setter
public class HoroscopeRequest {

    private ZodiacSing zodiac;
    private String typeHoroscope;
}
