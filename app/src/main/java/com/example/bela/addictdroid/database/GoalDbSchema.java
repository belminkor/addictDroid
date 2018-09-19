package com.example.bela.addictdroid.database;

public class GoalDbSchema {
    public static final class GoalTable {
        public static final String NAME = "goals";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String STARTDATE = "startdate";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}
