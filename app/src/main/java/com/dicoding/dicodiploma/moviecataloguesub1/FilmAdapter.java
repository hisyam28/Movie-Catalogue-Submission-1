package com.dicoding.dicodiploma.moviecataloguesub1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Films> films;

    public void  setFilms(ArrayList<Films> films){
        this.films = films;
    }

    public FilmAdapter(Context context){
        this.context = context;
        films = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Films films = (Films) getItem(i);
        viewHolder.bind(films);
        return view;
    }

    private class ViewHolder {
        private TextView txtTittle, txtScore, txtRelase, txtDescription;
        private ImageView imgFilm;

        ViewHolder(View view){
            txtTittle = view.findViewById(R.id.tv_tittle);
            txtScore = view.findViewById(R.id.tv_score);
            txtRelase = view.findViewById(R.id.tv_relase);
            txtDescription = view.findViewById(R.id.tv_description);
            imgFilm = view.findViewById(R.id.img_film);
        }

        void bind(Films films){
            txtTittle.setText(films.getTittle());
            txtScore.setText(films.getScore());
            txtRelase.setText(films.getRelase());
            txtDescription.setText(films.getDescription());
            imgFilm.setImageResource(films.getPoster());
        }
    }
}
