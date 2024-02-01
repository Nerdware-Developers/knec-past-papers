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
import com.nerdware.knecpastpapers.Adapter.Elect_parent_adapter;
import com.nerdware.knecpastpapers.Interstitial.Elect_Inter;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Elect_child;
import com.nerdware.knecpastpapers.model.Elect_parent;

import java.util.ArrayList;

public class Electrical extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<Elect_parent> electParentArrayList;
    ArrayList<Elect_child> module_1;
    ArrayList<Elect_child> module_2;
    ArrayList<Elect_child> module_3;
    ArrayList<Elect_child> module_4;
    ArrayList<Elect_child> module_5;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical);

        MobileAds.initialize(this);
        AdView elect = findViewById(R.id.elect1);
        AdView elect2 = findViewById(R.id.elect2);
        AdRequest adRequest = new AdRequest.Builder().build();
        elect.loadAd(adRequest);
        elect2.loadAd(adRequest);
        AdView adView =  new AdView(this);
        adView.setAdSize(AdSize.BANNER);

        recyclerView = findViewById(R.id.electric_mainRecycler);
        electParentArrayList = new ArrayList<>();
        module_1 = new ArrayList<>();
        module_2 = new ArrayList<>();
        module_3 = new ArrayList<>();
        module_4 = new ArrayList<>();
        module_5 = new ArrayList<>();



        module_1.add(new Elect_child("analoge1_dip.pdf", R.drawable.ana));
        module_1.add(new Elect_child("ict1_dip.pdf", R.drawable.ict));
        module_1.add(new Elect_child("install1_dip.pdf", R.drawable.solar));
        module_1.add(new Elect_child("math1_dip.pdf", R.drawable.math));
        module_1.add(new Elect_child("ps1_dip.pdf", R.drawable.ps));
        module_1.add(new Elect_child("td1_dip.pdf", R.drawable.td));

        electParentArrayList.add(new Elect_parent(module_1, "Diploma: module 1"));

        module_2.add(new Elect_child("analoge2_dip.pdf", R.drawable.digit));
        module_2.add(new Elect_child("control2_dip.pdf", R.drawable.control));
        module_2.add(new Elect_child("math2_dip.pdf", R.drawable.math2));
        module_2.add(new Elect_child("power2_dip.pdf", R.drawable.pow));
        module_2.add(new Elect_child("td2_dip.pdf", R.drawable.td2));

        electParentArrayList.add(new Elect_parent(module_2, "Diploma: Module 2"));

        module_3.add(new Elect_child("estimate3_dip.pdf", R.drawable.indust));
        module_3.add(new Elect_child("math3_dip.pdf", R.drawable.math3));
        module_3.add(new Elect_child("micro3_dip.pdf", R.drawable.micro));
        module_3.add(new Elect_child("power3_dip.pdf", R.drawable.pow));

        electParentArrayList.add(new Elect_parent(module_3, "Diploma: module 3"));

        module_4.add(new Elect_child("comms_cert.pdf", R.drawable.comms));
        module_4.add(new Elect_child("eep1_cert.pdf", R.drawable.ps));
        module_4.add(new Elect_child("ict_cert.pdf", R.drawable.ict));
        module_4.add(new Elect_child("install1_cert.pdf", R.drawable.solar));
        module_4.add(new Elect_child("math1_cert.pdf", R.drawable.math));
        module_4.add(new Elect_child("td1_cert.pdf", R.drawable.td));
        module_4.add(new Elect_child("trade1_cert.pdf", R.drawable.trd));

        electParentArrayList.add(new Elect_parent(module_4, "Certificate: Module 1"));

        module_5.add(new Elect_child("eep2_cert.pdf",R.drawable.micro ));
        module_5.add(new Elect_child("industrial2_cert.pdf", R.drawable.mes));
        module_5.add(new Elect_child("math2_cert.pdf", R.drawable.math));
        module_5.add(new Elect_child("trade2_cert.pdf", R.drawable.trd));
        module_5.add(new Elect_child("works2_cert.pdf", R.drawable.work));

        electParentArrayList.add(new Elect_parent(module_5, "Certificate: Module 2"));




        Elect_parent_adapter adapter = new Elect_parent_adapter(electParentArrayList, Electrical.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Elect_Inter.loadads(this);

        imageView = findViewById(R.id.elct_back);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Electrical.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}