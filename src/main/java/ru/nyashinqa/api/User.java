package ru.nyashinqa.api;

import ru.nyashinqa.support.WriterByDB;

public class User {

    WriterByDB db = new WriterByDB();

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
}
