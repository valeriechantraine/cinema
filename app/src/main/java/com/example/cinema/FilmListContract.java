package com.example.cinema;

import android.provider.BaseColumns;

public class FilmListContract {

    public static final class FilmListEntry implements BaseColumns {
        public static final String TABLE_NAME = "filmList";
        public static final String COLUMN_FILM_NAME = "filmName";
        public static final String COLUMN_CRITIQUE = "filmCritique";
        public static final String COLUMN_DATE = "filmDate";
        public static final String COLUMN_HOUR = "filmHour";
        public static final String COLUMN_NOTE_FILM = "noteFilm";
        public static final String COLUMN_NOTE_MUSIC = "noteMusic";
        public static final String COLUMN_NOTE_SCENARIO = "noteScenario";
    }
}
