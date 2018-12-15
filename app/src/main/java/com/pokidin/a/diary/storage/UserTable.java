package com.pokidin.a.diary.storage;

/* The UserTable class contains fields for creating the database. */

public class UserTable {

    public static final String TABLE = "users";

    static final String CREATE_DB = String.format("create table %s ("
                    + "%s integer primary key autoincrement,"
                    + "%s text,"
                    + "%s text,"
                    + "%s text,"
                    + "%s text"
                    + ");",
            TABLE, COLUMN.ID, COLUMN.EMAIL, COLUMN.PASS, COLUMN.NAME, COLUMN.SURNAME);

    public static class COLUMN {
        static final String ID = "_id";
        static final String EMAIL = "email";
        static final String PASS = "pass";
        static final String NAME = "name";
        static final String SURNAME = "surname";
    }
}
