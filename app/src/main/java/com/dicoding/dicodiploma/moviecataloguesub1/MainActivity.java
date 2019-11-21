package com.dicoding.dicodiploma.moviecataloguesub1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] dataTitle;
    private String[] dataScore;
    private String[] dataStatus;
    private String[] dataRelase;
    private String[] dataRuntime;
    private String[] dataLenguage;
    private String[] dataGenre;
    private String[] dataDescription;
    private TypedArray dataPoster;
    private FilmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveWithObject = new Intent(MainActivity.this, DetailActivity.class);

                ArrayList<Films> films = new ArrayList<Films>();

                Films film = new Films();
                film.setPoster(dataPoster.getResourceId(i, -1));
                film.setTittle(dataTitle[i]);
                film.setScore(dataScore[i]);
                film.setStatus(dataStatus[i]);
                film.setRelase(dataRelase[i]);
                film.setRuntime(dataRuntime[i]);
                film.setLanguage(dataLenguage[i]);
                film.setGenre(dataGenre[i]);
                film.setDescription(dataDescription[i]);
                films.add(film);

                moveWithObject.putParcelableArrayListExtra(DetailActivity.EXTRA_FILM, films);
                startActivity(moveWithObject);

            }
        });

    }

    @Override
    public void onClick(View view) {

    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_tittle);
        dataScore = getResources().getStringArray(R.array.data_score);
        dataStatus = getResources().getStringArray(R.array.data_status);
        dataRelase = getResources().getStringArray(R.array.data_relase);
        dataLenguage = getResources().getStringArray(R.array.data_lenguage);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataDescription = getResources().getStringArray(R.array.data_overview);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }

    private void addItem() {
        ArrayList<Films> films = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++){
            Films film = new Films();
            film.setPoster(dataPoster.getResourceId(i, -1));
            film.setTittle(dataTitle[i]);
            film.setScore(dataScore[i]);
            film.setStatus(dataStatus[i]);
            film.setRelase(dataRelase[i]);
            film.setRuntime(dataRuntime[i]);
            film.setLanguage(dataLenguage[i]);
            film.setGenre(dataGenre[i]);
            film.setDescription(dataDescription[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }
}
