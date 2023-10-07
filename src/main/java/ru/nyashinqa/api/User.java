package ru.nyashinqa.api;

import ru.nyashinqa.support.WriterByDB;

public class User extends WriterByDB{

    public String[] registerNewUser(String userName, String password) {
        return super.registerNewUser(userName, password);
    }

    public String[] deleteUser(String userName) {
        return super.deleteUser(userName);
    }
}
