package com.stepan.bokarev.pro_cao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import static com.stepan.bokarev.pro_cao.Constants.a3;
import static com.stepan.bokarev.pro_cao.MainActivity.fragmentIs;

public class Home extends Fragment {
    List<NewsForRecycler> news = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        fragmentIs = a3;
        //setInitialData();

       /* LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        recyclerView.setLayoutManager(layoutManager);*/
        // создаем адаптер
        DataAdapter adapter = new DataAdapter(getContext(), news);
        // устанавливаем для списка адаптер
        // recyclerView.setAdapter(adapter);
        ImageView v1 = rootView.findViewById(R.id.imageView1);
        ImageView v2 = rootView.findViewById(R.id.imageView2);
        ImageView v3 = rootView.findViewById(R.id.imageView3);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Голубое поле. Серебряный голубь.")
                        .setMessage("Серебряный голубь, символ Святого Духа, показывает расположение на территории муниципального образования церкви иконы Божией Матери «Знамение». Синий фон - небо. Однако в значении храма Знамения в Ховрино синий (лазурный) цвет – символизирует красоту, величие.")
                        .setCancelable(false)
                        .setNegativeButton("Назад",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Зеленое поле. Дуб с желудями.")
                        .setMessage("В зеленом поле герба изображен золотой дуб с серебряной кроной и золотыми желудями. Дуб в зеленом поле символизирует находящийся в муниципальном образовании лесной массив. ")
                        .setCancelable(false)
                        .setNegativeButton("Назад",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Золотое стропило. Х - Ховрино")
                        .setMessage("В красном треугольнике помещено изображение желтого укороченного косого креста в виде буквы «Х» символизирует первую букву названия муниципального образования «Ховрино». Красный цвет - цвет храбрости и отваги.")
                        .setCancelable(false)
                        .setNegativeButton("Назад",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        return rootView;
    }

    private void setInitialData() {

        news.add(new NewsForRecycler("В САО покажут спектакль по стихам Бёрнса", R.drawable.news1, getActivity()));
        news.add(new NewsForRecycler("На Смольной появится новый жилой комплекс", R.drawable.festivalpark_foto1, getActivity()));
        news.add(new NewsForRecycler("Мастер-класс о загадках лета прошёл на Зеленоградской", R.drawable.leto, getActivity()));
        news.add(new NewsForRecycler("Вблизи Ховрино пройдёт \"Медовый Спас\" для детей", R.drawable.tesr, getActivity()));

    }
}
