package ru.nyashinqa.support;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.nyashinqa.db.Compatibility;
import ru.nyashinqa.db.Users;

import java.util.List;

@Slf4j
public class WriterByDB {

    public static <T> List<T> selectResult(String queryString, Class<T> resultClass) {
        try (Session session = JDBCDriver.getSessionFactory().openSession()) {
            return session.createNativeQuery(queryString, resultClass).getResultList();
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }

    public static void updateQuery(String queryString) {
        try (Session session = JDBCDriver.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery(queryString).executeUpdate();
            transaction.commit();
        }
    }

    public String getCompatibility(int idManZodiac, int idWomanZodiac) {
        String queryString = String.format("select * from zodiac.compatibility where id_man_zodiac = %s and id_woman_zodiac = %s;", idManZodiac, idWomanZodiac);
        List<Compatibility> compatibilities = selectResult(queryString, Compatibility.class);
        if (compatibilities != null && !compatibilities.isEmpty()) {
            return compatibilities.get(0).getCompatibility();
        } else {
            return "Я пока не знаю такого сочетания, Вы точно люди? Совместимость: 0%";
        }
    }

    public String[] registerNewUser(String userName, String password) {
        int countUser = checkUserForRegister(userName,password);
        String msg;
        String status;

        if(countUser == 0) {
            String queryString = String.format("insert into zodiac.users (user_name, password) values ('%s', '%s');", userName, password);
            updateQuery(queryString);
            msg = "Пользователь успешно зарегистрирован";
            status = "OK";
        } else {
            msg = "Пользователь есть в системе, регистрация невозможна";
            status = "ERROR";
        }
        return new String[]{status, msg};
    }

    public void deleteUser(String userName) {
        String queryString = String.format("insert into zodiac.users (user_name, password) values ('%s', '%s');", userName);
        updateQuery(queryString);
    }

    public int checkUserForRegister(String userName, String password) {
        String queryString = String.format("select * from zodiac.users where user_name = '%s';", userName);
        List<Users> user = selectResult(queryString, Users.class);
        return user.size();
    }
}
