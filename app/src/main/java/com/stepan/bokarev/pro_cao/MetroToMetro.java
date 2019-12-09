package com.stepan.bokarev.pro_cao;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.stepan.bokarev.pro_cao.Constants.a5;
import static com.stepan.bokarev.pro_cao.MainActivity.fragmentIs;

public class MetroToMetro extends Fragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private DatabaseReference myRef;
    Button play,pause;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_metro_tour, container, false);

        fragmentIs = a5;

        play = (Button) view.findViewById(R.id.play);
        pause = (Button) view.findViewById(R.id.pause);

        final TextView v1 = view.findViewById(R.id.tv7);

        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.child("Путеводитель").child("метро Речной-Ховрино").child("История района Ховрино").getValue(String.class);
                v1.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new HouseLebedi();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        TextView texttest = view.findViewById(R.id.textVie4);
        texttest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Uri adress= Uri.parse("https://yandex.ru/map-widget/v1/?um=constructor%3A3a909013d076d72f93b35d5975945b893f9e1842727f7bd26de1595609240ba1&amp;source=constructor");
                Intent browser= new Intent(Intent.ACTION_VIEW, adress);
                startActivity(browser);
            }

        });
        Button button2 = view.findViewById(R.id.button_return);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Tour();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        final MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.xovrino);
        //
        // MediaPlayer mediaPlayer = new MediaPlayer();
        /*try {
            mediaPlayer.setDataSource(String.valueOf(Uri.parse("gs://procao.appspot.com/AUDIO/dido_-_life_for_rent_(zvukoff.ru).mp3")));
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                  mp.start();
                }
            });
        } catch (IOException e) {
           Toast.makeText(getContext(), "fdg", Toast.LENGTH_LONG).show();
        }*/
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
               /* try {
                    mediaPlayer.setDataSource(String.valueOf(Uri.parse("https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/AUDIO%2Fdido_-_life_for_rent_(zvukoff.ru).mp3?alt=media&token=c0919a8a-385f-4cfb-8b02-3a0a556c6be2")));
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                            Toast.makeText(getContext(), "start", Toast.LENGTH_SHORT).show();

                            //mediaPlayer = MediaPlayer.create(getContext(), R.raw.xovrino);
                        }
                    });*/


            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
            }
        });
        return view;
    }

    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}