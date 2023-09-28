package ru.nyashinqa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Month {

    JANUARY("Января", 1),
    FEBRUARY("Февраля", 2),
    MARCH("Марта", 3),
    APRIL("Апреля", 4),
    MAY("Мая", 5),
    JUNE("Июня", 6),
    JULY("Июля", 7),
    AUGUST("Августа", 8),
    SEPTEMBER("Сентября", 9),
    OCTOBER("Октября", 10),
    NOVEMBER("Ноября", 11),
    DECEMBER("Декабря", 12);

    private final String nameMonth;
    private final int numberMonth;

    public static Month getInstance(int numberMonth) {
        for (Month month : values()) {
            if(month.getNumberMonth() == numberMonth) {
                return month;
            }
        }
        return null;
    }
}
