package com.nerdware.knecpastpapers.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nerdware.knecpastpapers.Adapter.Mech_parent_adapter;
import com.nerdware.knecpastpapers.Interstitial.Mech_Inter;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Mech_child;
import com.nerdware.knecpastpapers.model.Mech_parent;

import java.util.ArrayList;

public class Mechanical extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<Mech_parent> mechParentArrayList;
    ArrayList<Mech_child> module_1;
    ArrayList<Mech_child> module_2;
    ArrayList<Mech_child> module_3;
    ArrayList<Mech_child> module_4;
    ArrayList<Mech_child> module_5;
    private AdView mech1,mech2;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanical);
        MobileAds.initialize(this);
        mech1 = findViewById(R.id.mech1);
        mech2 = findViewById(R.id.mech2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mech1.loadAd(adRequest);
        mech2.loadAd(adRequest);
        AdView adView =  new AdView(this);
        adView.setAdSize(AdSize.BANNER);

        recyclerView = findViewById(R.id.mechanical_mainRecycler);
        module_1 = new ArrayList<>();
        module_2 = new ArrayList<>();
        module_3 = new ArrayList<>();
        module_4 = new ArrayList<>();
        module_5 = new ArrayList<>();

        mechParentArrayList = new ArrayList<>();

        module_1.add(new Mech_child( "math1_dip.pdf", R.drawable.math));
        module_1.add(new Mech_child( "comms1_dip.pdf",R.drawable.comms));
        module_1.add(new Mech_child( "ms1_dip.pdf",R.drawable.ms));
        module_1.add(new Mech_child( "structure1_dip.pdf",R.drawable.fab));
        module_1.add(new Mech_child( "td1_dip.pdf",R.drawable.td));
        module_1.add(new Mech_child( "works1_dip.pdf", R.drawable.work));

        mechParentArrayList.add(new Mech_parent(module_1, "Diploma: module 1"));

        module_2.add(new Mech_child( "tool2_dip.pdf",R.drawable.tool));
        module_2.add(new Mech_child( "td2_dip.pdf",R.drawable.td2));
        module_2.add(new Mech_child( "structure2_dip.pdf",R.drawable.fab));
        module_2.add(new Mech_child( "strenth2_dip.pdf",R.drawable.mechs));
        module_2.add(new Mech_child( "math2_dip.pdf",R.drawable.math2));
        module_2.add(new Mech_child( "indust2_dip.pdf", R.drawable.indust));

        mechParentArrayList.add(new Mech_parent(module_2, "Diploma: Module 2"));

        module_3.add(new Mech_child("math3_dip.pdf",R.drawable.math3));
        module_3.add(new Mech_child("cad.pdf",R.drawable.cad));
        module_3.add(new Mech_child("control.pdf",R.drawable.control));
        module_3.add(new Mech_child("foundry.pdf",R.drawable.prod));
        module_3.add(new Mech_child("thermo.pdf",R.drawable.fluid));

        mechParentArrayList.add(new Mech_parent(module_3, "Diploma: module 3"));

        module_4.add(new Mech_child( "ict1_cert.pdf",R.drawable.ict));
        module_4.add(new Mech_child( "td1_cert.pdf",R.drawable.td));
        module_4.add(new Mech_child("cft1_cert.pdf",R.drawable.fab));

        mechParentArrayList.add(new Mech_parent(module_4, "Certificate: Module 1"));

        module_5.add(new Mech_child( "td2_cert.pdf",R.drawable.td2));
        module_5.add(new Mech_child( "math2_cert.pdf",R.drawable.math2));

        mechParentArrayList.add(new Mech_parent(module_5, "Certificate: Module 2"));

        Mech_parent_adapter adapter = new Mech_parent_adapter(mechParentArrayList, Mechanical.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Mech_Inter.loadads(this);


        imageView = findViewById(R.id.mechanical_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mechanical.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}