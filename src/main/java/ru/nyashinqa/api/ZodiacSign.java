package ru.nyashinqa.api;

import ru.nyashinqa.db.Coffe;
import ru.nyashinqa.enums.Horoscope;
import ru.nyashinqa.enums.Month;
import ru.nyashinqa.enums.ZodiacSing;
import ru.nyashinqa.models.CompatibilityZodiacResponse;
import ru.nyashinqa.models.HoroscopeResponse;
import ru.nyashinqa.support.WriterByDB;

import java.util.Calendar;
import java.util.HashMap;

import static ru.nyashinqa.enums.Month.*;
import static ru.nyashinqa.enums.Stones.*;
import static ru.nyashinqa.enums.ZodiacSing.*;

public class ZodiacSign {

    WriterByDB writerByDB = new WriterByDB();

    public ZodiacSing zodiacSignByMonth(Month month, int day) {
        ZodiacSing returnZodiac = null;

        if ((month == JANUARY && 1 <= day && day <= 20) || (month == DECEMBER && 23 <= day && day <= 31) ) {
            returnZodiac = CAPRICORN;
        } else if ((month == JANUARY && 21 <= day && day <= 31) || (month == FEBRUARY && 1 <= day && day <= 19) ) {
            returnZodiac = AQUARIUS;
        } else if ((month == FEBRUARY && 20 <= day && day <= 28) || (month == MARCH && 1 <= day && day <= 20) ) {
            returnZodiac = PISCES;
        } else if ((month == MARCH && 21 <= day && day <= 31) || (month == APRIL && 1 <= day && day <= 20) ) {
            returnZodiac = ARIES;
        } else if ((month == APRIL && 21 <= day && day <= 30) || (month == MAY && 1 <= day && day <= 21) ) {
            returnZodiac = TAURUS;
        } else if ((month == MAY && 22 <= day && day <= 31) || (month == JUNE && 1 <= day && day <= 21) ) {
            returnZodiac = GEMINI;
        } else if ((month == JUNE && 22 <= day && day <= 30) || (month == JULY && 1 <= day && day <= 22) ) {
            returnZodiac = CANCER;
        } else if ((month == JULY && 23 <= day && day <= 31) || (month == AUGUST && 1 <= day && day <= 21) ) {
            returnZodiac = LEO;
        } else if ((month == AUGUST && 22 <= day && day <= 31) || (month == SEPTEMBER && 1 <= day && day <= 23) ) {
            returnZodiac = VIRGO;
        } else if ((month == SEPTEMBER && 24 <= day && day <= 30) || (month == OCTOBER && 1 <= day && day <= 23) ) {
            returnZodiac = LIBRA;
        } else if ((month ==OCTOBER && 24 <= day && day <= 31) || (month == NOVEMBER && 1 <= day && day <= 22) ) {
            returnZodiac = SCORPIO;
        } else if ((month == NOVEMBER && 23 <= day && day <= 30) || (month == DECEMBER && 1 <= day && day <= 22) ) {
            returnZodiac = SAGITTARIUS;
        }
//        else {
//            returnZodiac = returnErrorByZodiac(month, day);
//        }

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

    public CompatibilityZodiacResponse compatibilityManZodiacAndWomenZodiac(ZodiacSing zodiacMan, ZodiacSing zodiacWomen) {
        CompatibilityZodiacResponse compatibilityZodiacResponse = new CompatibilityZodiacResponse(
                zodiacMan.getNameZodiac(),
                zodiacWomen.getNameZodiac(),
                writerByDB.getCompatibility(zodiacMan.getIdZodiac(), zodiacWomen.getIdZodiac()));

        return compatibilityZodiacResponse;
    }

    public String todayZodiac() {
        return zodiacSignByMonth(Month.getInstance(Calendar.MONTH), Calendar.DAY_OF_MONTH).getNameZodiac();
    }

    public HoroscopeResponse getHoroscope(ZodiacSing zodiac, String typeHoroscope) {

        String nameZodiac = zodiac.getNameZodiac();
        String msgHoroscope = switch (typeHoroscope) {
            case ("GeneralDescription") -> Horoscope.getInstance(zodiac).getGeneralDescription();
            case ("ElementSign") -> Horoscope.getInstance(zodiac).getElementSign();
            default -> "Неизвестный тип гороскопа";
        };
        return new HoroscopeResponse(nameZodiac, "Когда рождается этот зодиак: " + zodiac.getPeriodDateOfBirth(), typeHoroscope, msgHoroscope);
    }

    public Coffe getCoffeByZodiacSing(ZodiacSing zodiacSing) {
        Coffe coffe = writerByDB.getCoffeByZodiacSing(zodiacSing);
        return coffe;
    }
}
