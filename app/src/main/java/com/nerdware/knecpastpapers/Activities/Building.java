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
import com.nerdware.knecpastpapers.Adapter.Building_parent_adapter;
import com.nerdware.knecpastpapers.Interstitial.Build_Inter;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Building_child;
import com.nerdware.knecpastpapers.model.Building_parent;
import java.util.ArrayList;

public class Building extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<Building_parent> buildingParentArrayList;
    ArrayList<Building_child> module_1;
    ArrayList<Building_child> module_2;
    ArrayList<Building_child> module_3;
    ArrayList<Building_child> module_4;
    ArrayList<Building_child> module_5;
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        MobileAds.initialize(this);
        AdView buld = findViewById(R.id.buld1);
        AdView buld_2 = findViewById(R.id.buld2);
        AdRequest adRequest = new AdRequest.Builder().build();
        buld.loadAd(adRequest);
        buld_2.loadAd(adRequest);
        AdView adView =  new AdView(this);
        adView.setAdSize(AdSize.BANNER);

        recyclerView = findViewById(R.id.building_mainRecyclerview);
        module_1 = new ArrayList<>();
        module_2 = new ArrayList<>();
        module_3 = new ArrayList<>();
        module_4 = new ArrayList<>();
        module_5 = new ArrayList<>();

        buildingParentArrayList = new ArrayList<>();

        module_1.add(new Building_child( "building_1_dip.pdf",R.drawable.bdc));
        module_1.add(new Building_child("ict_1_dip.pdf",R.drawable.ict));
        module_1.add(new Building_child( "math_1_dip.pdf",R.drawable.math));
        module_1.add(new Building_child( "structures_1_dip.pdf",R.drawable.st));
        module_1.add(new Building_child( "survey_1_dip.pdf",R.drawable.suv));
        module_1.add(new Building_child( "physical_science_1_dip.pdf",R.drawable.ps));

        buildingParentArrayList.add(new Building_parent(module_1, "Diploma: module 1"));

        module_2.add(new Building_child( "building_2.pdf",R.drawable.bdc));
        module_2.add(new Building_child("construction_2.pdf", R.drawable.wok));
        module_2.add(new Building_child( "measurements_2_dip.pdf",R.drawable.mesa));
        module_2.add(new Building_child( "structures_2.pdf",R.drawable.geo));
        module_2.add(new Building_child("survey_2.pdf",R.drawable.math2));


        buildingParentArrayList.add(new Building_parent(module_2, "Diploma: Module 2"));

        module_3.add(new Building_child("construction_3_dip.pdf",R.drawable.bdc));
        module_3.add(new Building_child( "math_3_dip.pdf",R.drawable.math3));
        module_3.add(new Building_child( "structures_3_dip.pdf",R.drawable.str));

        buildingParentArrayList.add(new Building_parent(module_3, "Diploma: module 3"));

        module_4.add(new Building_child( "capentry_1_cert.pdf",R.drawable.cap));
        module_4.add(new Building_child( "construction_1_cert.pdf",R.drawable.bdc));
        module_4.add(new Building_child( "ict_1_cert.pdf",R.drawable.ict));
        module_4.add(new Building_child( "math_1_cert.pdf",R.drawable.math));
        module_4.add(new Building_child( "site_1_cert.pdf",R.drawable.site));

        buildingParentArrayList.add(new Building_parent(module_4, "Certificate: Module 1"));

        module_5.add(new Building_child( "comms_2_cert.pdf",R.drawable.comms));
        module_5.add(new Building_child("construction_2_cert.pdf",R.drawable.bdc));
        module_5.add(new Building_child ("math_2_cert.pdf",R.drawable.math2));
        module_5.add(new Building_child( "service_2_cert.pdf",R.drawable.serv));

        buildingParentArrayList.add(new Building_parent(module_5, "Certificate: Module 2"));


        Building_parent_adapter adapter = new Building_parent_adapter(buildingParentArrayList, Building.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Build_Inter.loadads(this);

        imageView = findViewById(R.id.build_back);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Building.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}