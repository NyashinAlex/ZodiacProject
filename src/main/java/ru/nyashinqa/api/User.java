package ru.nyashinqa.api;

import ru.nyashinqa.enums.Month;
import ru.nyashinqa.enums.ZodiacSing;
import ru.nyashinqa.support.WriterByDB;

public class User {

    WriterByDB db = new WriterByDB();
    ZodiacSign zodiacSign = new ZodiacSign();

    public String[] registerNewUser(String userName, String password) {
        int countUser = db.checkUserForRegister(userName);
        String msg;
        String status;

        if(countUser == 0) {
            db.registerNewUser(userName, password);
            msg = "Пользователь успешно зарегистрирован";
            status = "OK";
        } else {
            msg = "Пользователь есть в системе, регистрация невозможна";
            status = "ERROR";
        }
        return new String[]{status, msg};
    }

    public String[] deleteUser(String userName) {
        int countUser = db.checkUserForRegister(userName);
        String msg;
        String status;

        if(countUser == 1) {
            db.deleteUser(userName);
            msg = "Пользователь успешно удален";
            status = "OK";
        } else {
            msg = "Пользователь не найден";
            status = "ERROR";
        }
        return new String[]{status, msg};
    }

    public String[] updateZodiacByUser(String userName, int dayOfBirth, Month monthOfBirth) {
        int countUser = db.checkUserForRegister(userName);
        String zodiacByUser = zodiacSign.zodiacSignByMonth(monthOfBirth, dayOfBirth);
        String msg;
        String status;

        if(countUser == 1 && ZodiacSing.getInstance(zodiacByUser) != null) {
            db.updateZodiacByUser(zodiacByUser, userName);
            msg = "Зодиак у пользователя успешно обновлен";
            status = "SUCCESS";
        } else {
            msg = "Пользователь не найден или неверная день рождения";
            status = "ERROR";
        }

        return new String[]{status, msg};
    }
}
