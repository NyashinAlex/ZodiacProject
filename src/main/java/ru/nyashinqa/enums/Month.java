package ru.nyashinqa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Month {

    JANUARY("Января"),
    FEBRUARY("Февраля"),
    MARCH("Марта"),
    APRIL("Апреля"),
    MAY("Мая"),
    JUNE("Июня"),
    JULY("Июля"),
    AUGUST("Августа"),
    SEPTEMBER("Сентября"),
    OCTOBER("Октября"),
    NOVEMBER("Ноября"),
    DECEMBER("Декабря");

    private final String nameMonth;
}
