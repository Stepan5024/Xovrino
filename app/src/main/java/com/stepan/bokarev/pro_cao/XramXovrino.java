package com.stepan.bokarev.pro_cao;

import android.content.Intent;
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

import static com.stepan.bokarev.pro_cao.Constants.a6;
import static com.stepan.bokarev.pro_cao.MainActivity.fragmentIs;

public class XramXovrino extends Fragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private DatabaseReference myRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_xram_xovrino, container, false);
        fragmentIs = a6;
       final TextView v1 = (TextView) view.findViewById(R.id.tv7);
       final TextView v2 = (TextView) view.findViewById(R.id.tv8);
        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.child("Плитки").child("Храм знамения в Ховрино часть 1").getValue(String.class);
                v1.setText(value);
                String value2 = dataSnapshot.child("Плитки").child("Храм знамения в Ховрино часть 2").getValue(String.class);
                v2.setText(value2);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Button button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ListPlace();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        TextView tv = view.findViewById(R.id.tv12);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri adress = Uri.parse("https://znamenie-hovrino.ru/3d/Khram-Ikony-Bozhiyey-Materi-Znameniye-v-Khovrine/tour.html");
                Intent browser = new Intent(Intent.ACTION_VIEW, adress);
                startActivity(browser);
            }
        });
        TextView tv2 = view.findViewById(R.id.tv13);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri adress = Uri.parse("https://znamenie-hovrino.ru/index.php/zhizn-prikhoda/o-khrama/istoriya-khrama");
                Intent browser = new Intent(Intent.ACTION_VIEW, adress);
                startActivity(browser);
            }
        });

        return view;
    }
}