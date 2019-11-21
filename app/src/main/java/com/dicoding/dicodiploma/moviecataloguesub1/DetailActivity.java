package com.dicoding.dicodiploma.moviecataloguesub1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    String title;
    String score;
    String status;
    String relase;
    String runtime;
    String lenguage;
    String genre;
    String description;

    int pathPhoto;

    public static  final String EXTRA_FILM = "extra_film";

    TextView tTitle, tScore, tStatus, tRelase, tRuntime, tLenguage, tGenre, tDescription;

    ImageView iPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tTitle = findViewById(R.id.tv_tittle);
        tScore = findViewById(R.id.tv_score);
        tStatus = findViewById(R.id.tv_status);
        tRelase = findViewById(R.id.tv_relase);
        tRuntime = findViewById(R.id.tv_runtime);
        tLenguage = findViewById(R.id.tv_lenguage);
        tGenre = findViewById(R.id.tv_genre);
        tDescription = findViewById(R.id.tv_description);
        iPoster = findViewById(R.id.img_film);

        ArrayList<Films> films = this.getIntent().getParcelableArrayListExtra(EXTRA_FILM);

        title = films.get(0).getTittle();
        tTitle.setText(title);

        score = films.get(0).getScore();
        tScore.setText(score);

        status = films.get(0).getStatus();
        tStatus.setText(status);

        relase = films.get(0).getRelase();
        tRelase.setText(relase);

        runtime = films.get(0).getRuntime();
        tRuntime.setText(runtime);

        lenguage = films.get(0).getLanguage();
        tLenguage.setText(lenguage);

        genre = films.get(0).getGenre();
        tGenre.setText(genre);

        description = films.get(0).getDescription();
        tDescription.setText(description);

        pathPhoto = films.get(0).getPoster();
        iPoster.setImageResource(pathPhoto);

    }
}
