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
import com.nerdware.knecpastpapers.Adapter.Auto_parent_adapter;
import com.nerdware.knecpastpapers.Interstitial.Auto_Inter;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Auto_child;
import com.nerdware.knecpastpapers.model.Auto_parent;
import java.util.ArrayList;

public class Automotive extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Auto_parent> autoParentArrayList;
    ArrayList<Auto_child> module_1;
    ArrayList<Auto_child> module_2;
    ArrayList<Auto_child> module_3;
    ArrayList<Auto_child> module_4;
    ArrayList<Auto_child> module_5;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automotive);

        MobileAds.initialize(this);
        AdView auto_1 = findViewById(R.id.auto1);
        AdView auto_2 = findViewById(R.id.auto2);
        AdRequest adRequest = new AdRequest.Builder().build();
        auto_1.loadAd(adRequest);
        auto_2.loadAd(adRequest);
        AdView adView =  new AdView(this);
        adView.setAdSize(AdSize.BANNER);

        recyclerView = findViewById(R.id.auto_recycler);
        autoParentArrayList = new ArrayList<>();
        module_1 = new ArrayList<>();
        module_2 = new ArrayList<>();
        module_3 = new ArrayList<>();
        module_4 = new ArrayList<>();
        module_5 = new ArrayList<>();

        module_1.add(new Auto_child("math_1_dip.pdf", R.drawable.math));
        module_1.add(new Auto_child( "td_1_dip.pdf", R.drawable.td));
        module_1.add(new Auto_child( "works _1_dip.pdf", R.drawable.work ));
        module_1.add(new Auto_child( "ms_eep_1_dip.pdf", R.drawable.ms));
        module_1.add(new Auto_child( "ict_ee_comms_1_dip.pdf", R.drawable.ict));
        module_1.add(new Auto_child("vehicle _tech_1_dip.pdf", R.drawable.vehicle));

        autoParentArrayList.add(new Auto_parent(module_1, "Diploma: Module 1"));

        module_2.add(new Auto_child( "math2_dip.pdf", R.drawable.math2));
        module_2.add(new Auto_child( "industrial_2_dip.pdf", R.drawable.indust));
        module_2.add(new Auto_child( "engine_2_dip.pdf", R.drawable.engine));
        module_2.add(new Auto_child( "strength_2_dip.pdf", R.drawable.mechs));
        module_2.add(new Auto_child( "td2_dip.pdf", R.drawable.td));

        autoParentArrayList.add(new Auto_parent(module_2, "Diploma: Module 2"));

        module_3.add(new Auto_child( "math3.pdf", R.drawable.td));
        module_3.add(new Auto_child( "auto_3_dip.pdf", R.drawable.aut));
        module_3.add(new Auto_child( "control_3_dip.pdf", R.drawable.control));
        autoParentArrayList.add(new Auto_parent(module_3, "Diploma: module 3"));

        module_4.add(new Auto_child( "math1_cert.pdf", R.drawable.math));
        module_4.add(new Auto_child( "as_eep_1_cert.pdf", R.drawable.ms));
        module_4.add(new Auto_child( "ict_ee_1_cert.pdf", R.drawable.ict));
        module_4.add(new Auto_child( "motor_1_cert.pdf", R.drawable.trade));
        module_4.add(new Auto_child( "td1_cert.pdf", R.drawable.td));
        module_4.add(new Auto_child( "vehicle_1_cert.pdf", R.drawable.vehicle));

        autoParentArrayList.add(new Auto_parent(module_4, "Certificate: Module 1"));

        module_5.add(new Auto_child("math3.pdf", R.drawable.math2));
        module_5.add(new Auto_child("comms_2_cert.pdf",  R.drawable.comms));
        module_5.add(new Auto_child("td2 _cert.pdf", R.drawable.td2));
        module_5.add(new Auto_child("works__2_cert.pdf", R.drawable.work));

        autoParentArrayList.add(new Auto_parent(module_5, "Certificate: Module 2"));

        Auto_parent_adapter adapter = new Auto_parent_adapter(autoParentArrayList, Automotive.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Auto_Inter.loadads(this);


        ImageView imageView = findViewById(R.id.auto_back);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Automotive.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
