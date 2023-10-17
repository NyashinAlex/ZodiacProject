package ru.nyashinqa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HoroscopeResponse {

    private String zodiac;
    private String periodDateOfBirth;
    private String typeHoroscope;
    private String msgHoroscope;
}
