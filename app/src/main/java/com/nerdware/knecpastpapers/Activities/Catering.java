package com.nerdware.knecpastpapers.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nerdware.knecpastpapers.Adapter.Catering_parent_adapter;
import com.nerdware.knecpastpapers.Interstitial.Cater_Inter;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Catering_child;
import com.nerdware.knecpastpapers.model.Catering_parent;
import java.util.ArrayList;

public class
Catering extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<Catering_parent> cateringParentArrayList;
    ArrayList<Catering_child> module_1;
    ArrayList<Catering_child> module_2;
    ArrayList<Catering_child> module_3;
    ArrayList<Catering_child> module_4;
    ArrayList<Catering_child> module_5;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catering);
        MobileAds.initialize(this);
        AdView cat_1 = findViewById(R.id.cat1);
        AdView cat_2 = findViewById(R.id.cat2);
        AdRequest adRequest = new AdRequest.Builder().build();
        cat_1.loadAd(adRequest);
        cat_2.loadAd(adRequest);
        AdView adView =  new AdView(this);
        adView.setAdSize(AdSize.BANNER);

        recyclerView = findViewById(R.id.catering_mainRecycler);
        module_1 = new ArrayList<>();
        module_2 = new ArrayList<>();
        module_3 = new ArrayList<>();
        module_4 = new ArrayList<>();
        module_5 = new ArrayList<>();

        cateringParentArrayList = new ArrayList<>();

        module_1.add(new Catering_child("accom_1_dip.pdf", R.drawable.ao));
        module_1.add(new Catering_child("food_dip.pdf", R.drawable.fs));
        module_1.add(new Catering_child("ict_1_dip.pdf", R.drawable.ict));
        module_1.add(new Catering_child("math_1_dip.pdf", R.drawable.math));

        cateringParentArrayList.add(new Catering_parent(module_1, "Diploma: module 1"));

        module_2.add(new Catering_child("accom2_dip.pdf", R.drawable.ao));
        module_2.add(new Catering_child("diet2_dip.pdf", R.drawable.dt));
        module_2.add(new Catering_child( "food2_dip.pdf", R.drawable.fod));

        cateringParentArrayList.add(new Catering_parent(module_2, "Diploma: Module 2"));

        module_3.add(new Catering_child( "account3_dip.pdf", R.drawable.ac));
        module_3.add(new Catering_child( "food3_dip.pdf", R.drawable.fdm));
        module_3.add(new Catering_child( "principe3_dip.pdf", R.drawable.pmp));

        cateringParentArrayList.add(new Catering_parent(module_3, "Diploma: module 3"));

        module_4.add(new Catering_child( "aid_1_cert.pdf",R.drawable.fbs));
        module_4.add(new Catering_child( "food_1_cert.pdf",R.drawable.fs));
        module_4.add(new Catering_child( "ict_1_cert.pdf",R.drawable.ict));

        cateringParentArrayList.add(new Catering_parent(module_4, "Certificate: Module 1"));

        module_5.add(new Catering_child( "office_2_cert.pdf", R.drawable.hkfo));
        module_5.add(new Catering_child( "laundry_2_cert.pdf",R.drawable.lou));

        cateringParentArrayList.add(new Catering_parent(module_5, "Certificate: Module 2"));


        Catering_parent_adapter adapter = new Catering_parent_adapter(cateringParentArrayList, Catering.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Cater_Inter.loadads(this);

        imageView = findViewById(R.id.catering_back);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Catering.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}