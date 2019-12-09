package com.stepan.bokarev.pro_cao;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

//маршруты
public class Tour extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tour, container, false);
        ImageView im3 = view.findViewById(R.id.imageView3);
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Xrams();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            //  https://yandex.ru/maps/?um=constructor%3Acf179b2341f8f9e002d2d3dabc32eb9a3870f44346605da7be763e16f763465a&source=constructorLink
            }
        });
        ImageView im4 = view.findViewById(R.id.imageView2);
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Cycling();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                //  https://yandex.ru/maps/?um=constructor%3Acf179b2341f8f9e002d2d3dabc32eb9a3870f44346605da7be763e16f763465a&source=constructorLink
            }
        });
        ImageView im7 = view.findViewById(R.id.imageView7);
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Rechnoi();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                //  https://yandex.ru/maps/?um=constructor%3Acf179b2341f8f9e002d2d3dabc32eb9a3870f44346605da7be763e16f763465a&source=constructorLink
            }
        });
        ImageView im5 = view.findViewById(R.id.imageView4);
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MetroToMetro();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                //  https://yandex.ru/maps/?um=constructor%3Acf179b2341f8f9e002d2d3dabc32eb9a3870f44346605da7be763e16f763465a&source=constructorLink
            }
        });
        ImageView im6 = view.findViewById(R.id.imageView6);
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FamileTour();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                //  https://yandex.ru/maps/?um=constructor%3Acf179b2341f8f9e002d2d3dabc32eb9a3870f44346605da7be763e16f763465a&source=constructorLink
            }
        });
        ImageView im17 = view.findViewById(R.id.imageView1);
        im17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ParkTour();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                //  https://yandex.ru/maps/?um=constructor%3Acf179b2341f8f9e002d2d3dabc32eb9a3870f44346605da7be763e16f763465a&source=constructorLink
            }
        });

        ImageView im127 = view.findViewById(R.id.imageView5);
        im127.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Sport();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                //  https://yandex.ru/maps/?um=constructor%3Acf179b2341f8f9e002d2d3dabc32eb9a3870f44346605da7be763e16f763465a&source=constructorLink
            }
        });
        return view;


    }

}