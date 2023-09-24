package ru.nyashinqa.api;

import ru.nyashinqa.enums.Month;

import java.util.HashMap;

import static ru.nyashinqa.enums.Month.*;
import static ru.nyashinqa.enums.Stones.*;
import static ru.nyashinqa.enums.ZodiacSing.*;

public class ZodiacSign {

    public String zodiacSignByMonth(Month month, int day) {
        String returnZodiac = null;

        if ((month == JANUARY && 1 <= day && day <= 20) || (month == DECEMBER && 23 <= day && day <= 31) ) {
            returnZodiac = CAPRICORN.getNameZodiac();
        } else if ((month == JANUARY && 21 <= day && day <= 31) || (month == FEBRUARY && 1 <= day && day <= 19) ) {
            returnZodiac = AQUARIUS.getNameZodiac();
        } else if ((month == FEBRUARY && 20 <= day && day <= 28) || (month == MARCH && 1 <= day && day <= 20) ) {
            returnZodiac = PISCES.getNameZodiac();
        } else if ((month == MARCH && 21 <= day && day <= 31) || (month == APRIL && 1 <= day && day <= 20) ) {
            returnZodiac = ARIES.getNameZodiac();
        } else if ((month == APRIL && 21 <= day && day <= 30) || (month == MAY && 1 <= day && day <= 21) ) {
            returnZodiac = TAURUS.getNameZodiac();
        } else if ((month == MAY && 22 <= day && day <= 31) || (month == JUNE && 1 <= day && day <= 21) ) {
            returnZodiac = GEMINI.getNameZodiac();
        } else if ((month == JUNE && 22 <= day && day <= 30) || (month == JULY && 1 <= day && day <= 22) ) {
            returnZodiac = CANCER.getNameZodiac();
        } else if ((month == JULY && 23 <= day && day <= 31) || (month == AUGUST && 1 <= day && day <= 21) ) {
            returnZodiac = LEO.getNameZodiac();
        } else if ((month == AUGUST && 22 <= day && day <= 31) || (month == SEPTEMBER && 1 <= day && day <= 23) ) {
            returnZodiac = VIRGO.getNameZodiac();
        } else if ((month == SEPTEMBER && 24 <= day && day <= 30) || (month == OCTOBER && 1 <= day && day <= 23) ) {
            returnZodiac = LIBRA.getNameZodiac();
        } else if ((month ==OCTOBER && 24 <= day && day <= 31) || (month == NOVEMBER && 1 <= day && day <= 22) ) {
            returnZodiac = SCORPIO.getNameZodiac();
        } else if ((month == NOVEMBER && 23 <= day && day <= 30) || (month == DECEMBER && 1 <= day && day <= 22) ) {
            returnZodiac = SAGITTARIUS.getNameZodiac();
        } else {
            returnZodiac = returnErrorByZodiac(month, day);
        }

        return returnZodiac;
    }

    private String returnErrorByZodiac(Month month, int day) {
        String returnText = null;

        if(month == FEBRUARY && day > 29) {
            returnText = "В " + month.getNameMonth() + " не может быть более 29 дней";
        } else if((month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) && day > 30) {
            returnText = "В " + month.getNameMonth() + " не может быть более 30 дней";
        }

        return returnText;
    }

    public String stoneByZodiac(String zodiac) {

        HashMap<String, String> zodiacAndStone = new HashMap<>();
        zodiacAndStone.put(ARIES.getNameZodiac(), CRYSTAL.getNameStone());
        zodiacAndStone.put(TAURUS.getNameZodiac(), DIAMOND.getNameStone());
        zodiacAndStone.put(GEMINI.getNameZodiac(), SAPPHIRE.getNameStone());
        zodiacAndStone.put(CANCER.getNameZodiac(), AGATE.getNameStone());
        zodiacAndStone.put(LEO.getNameZodiac(), TOPAZ.getNameStone());
        zodiacAndStone.put(VIRGO.getNameZodiac(), MAGNETITE.getNameStone());
        zodiacAndStone.put(LIBRA.getNameZodiac(), JADE.getNameStone());
        zodiacAndStone.put(SCORPIO.getNameZodiac(), GARNET.getNameStone());
        zodiacAndStone.put(SAGITTARIUS.getNameZodiac(), EMERALD.getNameStone());
        zodiacAndStone.put(CAPRICORN.getNameZodiac(), CHALCEDONY.getNameStone());
        zodiacAndStone.put(AQUARIUS.getNameZodiac(), AMETHYST.getNameStone());
        zodiacAndStone.put(PISCES.getNameZodiac(), HYACINTH.getNameStone());

        return zodiacAndStone.get(zodiac);
    }
}
