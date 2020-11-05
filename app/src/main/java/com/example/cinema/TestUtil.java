package com.example.cinema;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static void insertFakeData(SQLiteDatabase db){
        if(db == null){
            return;
        }
        //create a list of fake guests
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(FilmListContract.FilmListEntry.COLUMN_FILM_NAME, "Matrix");
        cv.put(FilmListContract.FilmListEntry.COLUMN_CRITIQUE, "Très bien");
        list.add(cv);

        cv = new ContentValues();
        cv.put(FilmListContract.FilmListEntry.COLUMN_FILM_NAME, "Mon voisin Totoro");
        cv.put(FilmListContract.FilmListEntry.COLUMN_CRITIQUE, "Le meilleur !");
        list.add(cv);

        cv = new ContentValues();
        cv.put(FilmListContract.FilmListEntry.COLUMN_FILM_NAME, "La plateforme");
        cv.put(FilmListContract.FilmListEntry.COLUMN_CRITIQUE, "nul nul nul.");
        list.add(cv);

        //insert all guests in one transaction
        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (FilmListContract.FilmListEntry.TABLE_NAME,null,null);
            //go through the list and add one by one
            for(ContentValues c:list){
                db.insert(FilmListContract.FilmListEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            //too bad :(
        }
        finally
        {
            db.endTransaction();
        }

    }
}
