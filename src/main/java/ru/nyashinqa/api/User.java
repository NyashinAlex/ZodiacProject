package ru.nyashinqa.api;

import ru.nyashinqa.enums.Month;
import ru.nyashinqa.enums.ZodiacSing;
import ru.nyashinqa.support.WriterByDB;

import java.util.HashMap;

public class User {

    WriterByDB db = new WriterByDB();
    ZodiacSign zodiacSign = new ZodiacSign();

    public String[] registerNewUser(String userName, String password, String sex) {
        int countUser = db.checkUserForRegister(userName);
        String msg;
        String status;

        if(!sex.equals("woman") && !sex.equals("man")) {
            sex = "unknown";
        }

        if(countUser == 0) {
            db.registerNewUser(userName, password, sex);
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

    public HashMap<String, String> updateInfoByUser(String userName, int dayOfBirth, Month monthOfBirth) {
        int countUser = db.checkUserForRegister(userName);
        String zodiacByUser = zodiacSign.zodiacSignByMonth(monthOfBirth, dayOfBirth);
        String stoneByUser = zodiacSign.stoneByZodiac(zodiacByUser);
        String msg;
        String status;

        if(countUser == 1 && ZodiacSing.getInstance(zodiacByUser) != null) {
            db.updateZodiacByUser(zodiacByUser, userName);
            db.updateStoneByUser(stoneByUser, userName);
            msg = "Данные пользователя успешно обновлены";
            status = "SUCCESS";
        } else {
            msg = "Пользователь не найден или неверная день рождения";
            status = "ERROR";
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("msg", msg);
        map.put("status", status);
        map.put("zodiacByUser", zodiacByUser);
        map.put("stoneByUser", stoneByUser);

        return map;
    }
}
