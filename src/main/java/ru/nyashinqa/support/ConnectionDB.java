package ru.nyashinqa.support;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import ru.nyashinqa.db.Compatibility;

import java.util.List;

@Slf4j
public class ConnectionDB {

    public static <T> List<T> selectResult(String queryString, Class<T> resultClass) {
        try (Session session = JDBCDriver.getSessionFactory().openSession()) {
            return session.createNativeQuery(queryString, resultClass).getResultList();
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

    public String getCompatibility(int idManZodiac, int idWomanZodiac) {
        String queryString = String.format("select * from zodiac.compatibility where id_man_zodiac = %s and id_woman_zodiac = %s;", idManZodiac, idWomanZodiac);
        List<Compatibility> compatibilities = selectResult(queryString, Compatibility.class);
        if (compatibilities != null && !compatibilities.isEmpty()) {
            return compatibilities.get(0).getCompatibility();
        } else {
            int rowCount = (compatibilities != null) ? compatibilities.size() : 0;
            return "Я пока не знаю такого сочетания, Вы точно люди? Совместимость: 0%";
        }
    }
}
