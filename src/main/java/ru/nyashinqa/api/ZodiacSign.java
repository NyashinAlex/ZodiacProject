package ru.nyashinqa.api;

import org.apache.commons.collections4.map.LinkedMap;
import org.apache.commons.collections4.map.MultiKeyMap;
import ru.nyashinqa.enums.Month;
import ru.nyashinqa.models.CompatibilityZodiacResponse;

import java.util.Calendar;
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

    public CompatibilityZodiacResponse compatibilityManZodiacAndWomenZodiac(String zodiacMan, String zodiacWomen) {

        MultiKeyMap<String, String> multiKeyMap = MultiKeyMap.multiKeyMap(new LinkedMap<>());
        multiKeyMap.put(ARIES.getNameZodiac(), ARIES.getNameZodiac(), "Оба Овна могут находить общий язык благодаря их энергичности и страсти. Совместимость: 80%");
        multiKeyMap.put(ARIES.getNameZodiac(), TAURUS.getNameZodiac(), "Эти два знака могут привносить в отношения страсть и уверенность, но иногда могут возникать конфликты из-за упрямства Тельца. Совместимость: 60%");
        multiKeyMap.put(ARIES.getNameZodiac(), GEMINI.getNameZodiac(), "Овен и Близнецы оба ценят разнообразие и разговоры, их отношения могут быть интересными и динамичными. Совместимость: 75%");
        multiKeyMap.put(ARIES.getNameZodiac(), CANCER.getNameZodiac(), "Эти два знака могут иметь различные потребности в отношениях, но если оба готовы к компромиссам, отношения могут успешно развиваться. Совместимость: 55%");
        multiKeyMap.put(ARIES.getNameZodiac(), LEO.getNameZodiac(), "Это сильная пара, которая может создать страстные и динамичные отношения, полные приключений. Совместимость: 90%");
        multiKeyMap.put(ARIES.getNameZodiac(), VIRGO.getNameZodiac(), "Дева может придать структуру и порядок в жизни Овна, что может быть полезным для обоих. Совместимость: 70%");
        multiKeyMap.put(ARIES.getNameZodiac(), LIBRA.getNameZodiac(), "Весы могут приносить баланс и гармонию в отношения с Овном. Совместимость: 80%");
        multiKeyMap.put(ARIES.getNameZodiac(), SCORPIO.getNameZodiac(), "Эта пара может создать интенсивные и страстные отношения, но иногда могут возникать конфликты из-за сильных характеров. Совместимость: 85%");
        multiKeyMap.put(ARIES.getNameZodiac(), SAGITTARIUS.getNameZodiac(), "Оба знака ценят независимость и приключения, их отношения могут быть веселыми и захватывающими. Совместимость: 90%");
        multiKeyMap.put(ARIES.getNameZodiac(), CAPRICORN.getNameZodiac(), "Козерог может придать стабильность и реализм в жизнь Овна. Совместимость: 75%");
        multiKeyMap.put(ARIES.getNameZodiac(), AQUARIUS.getNameZodiac(), "Эта пара может разделять интересы в области инноваций и общественных вопросов. Совместимость: 70%");
        multiKeyMap.put(ARIES.getNameZodiac(), PISCES.getNameZodiac(), "Рыбы могут добавить эмоциональность и интуицию в жизнь Овна, но иногда могут возникать разногласия. Совместимость: 65%");

        multiKeyMap.put(TAURUS.getNameZodiac(), ARIES.getNameZodiac(), "Оба знака обладают стойкостью и стабильностью, но могут возникнуть конфликты из-за упрямства. Совместимость: 75%");
        multiKeyMap.put(TAURUS.getNameZodiac(), TAURUS.getNameZodiac(), "Оба знака Тельца обладают практичностью и чувственностью, что создает прочную связь. Совместимость: 90%");
        multiKeyMap.put(TAURUS.getNameZodiac(), GEMINI.getNameZodiac(), "Мужчина Телец и женщина Близнецы могут привнести разнообразие в отношения, но могут возникнуть разногласия из-за различий в характерах. Совместимость: 60%");
        multiKeyMap.put(TAURUS.getNameZodiac(), CANCER.getNameZodiac(), "Тельцы и Раки создают теплые и заботливые отношения, но иногда Тельцы могут казаться слишком упрямыми. Совместимость: 80%");
        multiKeyMap.put(TAURUS.getNameZodiac(), LEO.getNameZodiac(), "Оба знака имеют сильный характер, что может привести к конфликтам, но также создать страстные отношения. Совместимость: 70%");
        multiKeyMap.put(TAURUS.getNameZodiac(), VIRGO.getNameZodiac(), "Тельцы и Девы оба практичны и заботливы, что делает их отношения гармоничными. Совместимость: 90%");
        multiKeyMap.put(TAURUS.getNameZodiac(), LIBRA.getNameZodiac(), " Оба знака обладают чувственностью и эстетическим вкусом, но могут иногда теряться в размышлениях. Совместимость: 75%");
        multiKeyMap.put(TAURUS.getNameZodiac(), SCORPIO.getNameZodiac(), "Мужчина Телец и женщина Скорпион создают страстные и интенсивные отношения, но иногда могут возникать ревности. Совместимость: 80%");
        multiKeyMap.put(TAURUS.getNameZodiac(), SAGITTARIUS.getNameZodiac(), "Тельцы и Стрельцы могут создать интересные отношения, но различия во взглядах на жизнь могут вызвать конфликты. Совместимость: 65%");
        multiKeyMap.put(TAURUS.getNameZodiac(), CAPRICORN.getNameZodiac(), "Оба знака Тельца и Козерога ориентированы на цели и создают стабильные отношения. Совместимость: 85%");
        multiKeyMap.put(TAURUS.getNameZodiac(), AQUARIUS.getNameZodiac(), "Тельцы и Водолеи могут вдохновлять друг друга, но иногда могут возникнуть разногласия из-за независимости Водолеев. Совместимость: 70%");
        multiKeyMap.put(TAURUS.getNameZodiac(), PISCES.getNameZodiac(), "Оба знака обладают чувствительностью, но иногда могут возникать недопонимания из-за разных способов выражения чувств. Совместимость: 75%");

        multiKeyMap.put(GEMINI.getNameZodiac(), ARIES.getNameZodiac(), "Оба знака обладают энергией, но могут возникнуть разногласия из-за желания быть лидером. Совместимость: 70%");
        multiKeyMap.put(GEMINI.getNameZodiac(), TAURUS.getNameZodiac(), "Мужчина Близнец и женщина Телец создают интересное сочетание интеллекта и стабильности. Совместимость: 85%");
        multiKeyMap.put(GEMINI.getNameZodiac(), GEMINI.getNameZodiac(), "Оба знака Близнецы могут легко понимать друг друга и создавать разнообразие в отношениях. Совместимость: 90%");
        multiKeyMap.put(GEMINI.getNameZodiac(), CANCER.getNameZodiac(), "Мужчина Близнец и женщина Рак могут иметь разные потребности в отношениях, что может вызвать конфликты. Совместимость: 65%");
        multiKeyMap.put(GEMINI.getNameZodiac(), LEO.getNameZodiac(), "Оба знака обладают уверенностью, но могут конкурировать за внимание. Совместимость: 75%");
        multiKeyMap.put(GEMINI.getNameZodiac(), VIRGO.getNameZodiac(), "Мужчина Близнец и женщина Дева могут создать гармоничные отношения, учитывая детали. Совместимость: 80%");
        multiKeyMap.put(GEMINI.getNameZodiac(), LIBRA.getNameZodiac(), "Мужчина Близнец и женщина Весы оба ценят гармонию и красоту, что делает их отношения уравновешенными. Совместимость: 95%");
        multiKeyMap.put(GEMINI.getNameZodiac(), SCORPIO.getNameZodiac(), "Мужчина Близнец и женщина Скорпион могут создать страстные отношения, но иногда могут возникнуть ревности. Совместимость: 70%");
        multiKeyMap.put(GEMINI.getNameZodiac(), SAGITTARIUS.getNameZodiac(), "Оба знака могут разделять интерес к приключениям и новым опытам. Совместимость: 80%");
        multiKeyMap.put(GEMINI.getNameZodiac(), CAPRICORN.getNameZodiac(), "Мужчина Близнец и женщина Козерог могут поддерживать друг друга в достижении целей. Совместимость: 75%");
        multiKeyMap.put(GEMINI.getNameZodiac(), AQUARIUS.getNameZodiac(), "Оба знака могут разделять интерес к необычным идеям и инновациям. Совместимость: 85%");
        multiKeyMap.put(GEMINI.getNameZodiac(), PISCES.getNameZodiac(), "Мужчина Близнец и женщина Рыбы могут иметь разные способы общения и могут возникнуть недопонимания. Совместимость: 60%");

        CompatibilityZodiacResponse compatibilityZodiacResponse = new CompatibilityZodiacResponse();
        compatibilityZodiacResponse.setZodiacMan(zodiacMan);
        compatibilityZodiacResponse.setZodiacWomen(zodiacWomen);
        compatibilityZodiacResponse.setCompatibility(multiKeyMap.get(zodiacMan, zodiacWomen));

        CompatibilityZodiacResponse compatibilityZodiacErrorResponse = new CompatibilityZodiacResponse();
        compatibilityZodiacErrorResponse.setZodiacMan(zodiacMan);
        compatibilityZodiacErrorResponse.setZodiacWomen(zodiacWomen);
        compatibilityZodiacErrorResponse.setCompatibility("Я пока не знаю такого сочетания, Вы точно люди? Совместимость: 0%");

        if (multiKeyMap.get(zodiacMan, zodiacWomen) != null) {
            return compatibilityZodiacResponse;
        } else {
            return compatibilityZodiacErrorResponse;
        }
    }

    public String todayZodiac() {
        return zodiacSignByMonth(Month.getInstance(Calendar.MONTH), Calendar.DAY_OF_MONTH);
    }
}
