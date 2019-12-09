package com.stepan.bokarev.pro_cao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import static com.stepan.bokarev.pro_cao.Constants.a13;
import static com.stepan.bokarev.pro_cao.MainActivity.fragmentIs;

public class Rechnoi extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private DatabaseReference myRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rechnoi, container, false);

        fragmentIs = a13;
        final TextView v1 = view.findViewById(R.id.tv7);

        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.child("Путеводитель").child("По станциям метро").child("общие сведения").getValue(String.class);
                v1.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ImageView avatarImageView = (ImageView) view.findViewById(R.id.imageView16);
        /*Picasso.LoadedFrom("https://vk.com/albums-44153302?z=photo-44153302_456243943%2Fphotos-44153302").in;
        Picasso.with(getContext())
                .load("https://vk.com/albums-44153302?z=photo-44153302_456243943%2Fphotos-44153302")
                .into(avatarImageView);*/
       /* Button but = view.findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Tour();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });*/
        Button butret = view.findViewById(R.id.button_return);
        butret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Tour();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        return view;


    }

}
