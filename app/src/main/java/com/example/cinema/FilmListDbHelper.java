package com.example.cinema;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.cinema.FilmListContract.*;

public class FilmListDbHelper extends SQLiteOpenHelper {

    // The database name
    private static final String DATABASE_NAME = "filmsList.db";

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public FilmListDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create a table to hold filmList data
        final String SQL_CREATE_FILMLIST_TABLE = "CREATE TABLE " + FilmListEntry.TABLE_NAME + " (" +
                FilmListEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FilmListEntry.COLUMN_FILM_NAME + " TEXT NOT NULL, " +
                FilmListEntry.COLUMN_CRITIQUE + " TEXT NOT NULL, " +
                FilmListEntry.COLUMN_DATE + " TEXT NOT NULL, " +
                FilmListEntry.COLUMN_HOUR + " TEXT NOT NULL, " +
                FilmListEntry.COLUMN_NOTE_FILM + " FLOAT NOT NULL, " +
                FilmListEntry.COLUMN_NOTE_MUSIC + " FLOAT NOT NULL, " +
                FilmListEntry.COLUMN_NOTE_SCENARIO + " FLOAT NOT NULL, " +

                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_FILMLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // For now simply drop the table and create a new one. This means if you change the
        // DATABASE_VERSION the table will be dropped.
        // In a production app, this method might be modified to ALTER the table
        // instead of dropping it, so that existing data is not deleted.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FilmListEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}