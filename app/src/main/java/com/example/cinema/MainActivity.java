package com.example.cinema;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //private FilmsList mAdapter;
    // le titre du film
    private EditText mTitle;
    // la date et l'heure de la projection
    private EditText mDate;
    private EditText mHour;
    // une note pour la realisation
    private RatingBar mRate;
    // une note pour la musique
    private RatingBar mMusic;
    // une note pour le scenario
    private RatingBar mScenario;
    // une zone de description
    private EditText mDescription;
    // database declaration
    private SQLiteDatabase mDb;
    private Button mAddFilm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set local attributes to corresponding views
        mTitle = (EditText) this.findViewById(R.id.film_title_edit_text);
        mDate = (EditText) this.findViewById(R.id.film_date_edit_text);
        mHour = (EditText) this.findViewById(R.id.film_hour_edit_text);
        mRate = (RatingBar) this.findViewById(R.id.film_rate);
        float numberOfStars = mRate.getNumStars();
        mMusic = (RatingBar) this.findViewById(R.id.music_rate);
        mScenario = (RatingBar) this.findViewById(R.id.scenario_rate);
        mDescription = (EditText) this.findViewById(R.id.film_description_edit_text);
        mAddFilm = (Button) this.findViewById(R.id.add_to_filmsList_button);


        mRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalStars = "Total Stars:: " + numberOfStars;
                String rating = "Rating :: " + mRate.getRating();
            }

        });

        // database creation

        // Create a DB helper (this will create the DB if run for the first time)
        FilmListDbHelper dbHelper = new FilmListDbHelper(this);
        // Keep a reference to the mDb until paused or killed. Get a writable database
        // because you will be adding restaurant customers
        mDb = dbHelper.getWritableDatabase();

        //Fill the database with fake data
        TestUtil.insertFakeData(mDb);

    }


    // add film to list

    public void addToFilmList(View view) {

        if(mTitle.getText().length() == 0 || mDate.getText().length() == 0 ||
        mHour.getText().length() == 0 || mRate.getRating() == 0 || mMusic.getRating() == 0 || mScenario.getRating() == 0 ||
        mDescription.getText().length() == 0){
            return;
        }
        else {
            //clear UI text fields
            mTitle.getText().clear();
            mDate.getText().clear();
            mHour.getText().clear();
            mRate.setRating(0);
            mMusic.setRating(0);
            mScenario.setRating(0);
            mDescription.getText().clear();
        }
    }

}