package ru.nyashinqa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Stones {

    CRYSTAL("Овен", "Хрусталь"),
    DIAMOND("Телец", "Алмаз"),
    SAPPHIRE("Близнецы", "Сапфир"),
    AGATE("Рак", "Агат"),
    TOPAZ("Лев", "Топаз"),
    MAGNETITE("Дева", "Магнетит"),
    JADE("Весы", "Яшма"),
    GARNET("Скорпион", "Гранат"),
    EMERALD("Стрелец", "Изумруд"),
    CHALCEDONY("Козерог", "Халцедон"),
    AMETHYST("Водолей", "Аметист"),
    HYACINTH("Рыбы", "Гиацинт");

    private final String nameZodiac;
    private final String nameStone;
}
