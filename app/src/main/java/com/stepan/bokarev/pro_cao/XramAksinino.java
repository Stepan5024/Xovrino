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

import static com.stepan.bokarev.pro_cao.Constants.a1;
import static com.stepan.bokarev.pro_cao.MainActivity.fragmentIs;

public class XramAksinino extends Fragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private DatabaseReference myRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xram_aksinino, container, false);
        fragmentIs = a1;
     final   TextView v1 = view.findViewById(R.id.tv1);
     final   TextView v2 = view.findViewById(R.id.tv2);
        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.child("Плитки").child("Аксинино часть 1").getValue(String.class);
                v1.setText(value);
                String value2 = dataSnapshot.child("Плитки").child("Аксинино часть 2").getValue(String.class);
                v2.setText(value2);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        TextView tv = view.findViewById(R.id.tv12);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri adress = Uri.parse("http://aksinino-hram.ru/?page_id=76");
                Intent browser = new Intent(Intent.ACTION_VIEW, adress);
                startActivity(browser);
            }
        });

        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ListPlace();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });

        return view;
    }
}