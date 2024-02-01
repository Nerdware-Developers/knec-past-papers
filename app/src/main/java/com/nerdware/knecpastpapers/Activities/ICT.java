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
import com.nerdware.knecpastpapers.Adapter.Ict_parent_adapter;
import com.nerdware.knecpastpapers.Interstitial.Ict_Inter;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Ict_child;
import com.nerdware.knecpastpapers.model.Ict_parent;
import java.util.ArrayList;

public class ICT extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<Ict_parent> ictParentArrayList;
    ArrayList<Ict_child> module_1;
    ArrayList<Ict_child> module_2;
    ArrayList<Ict_child> module_3;
    ArrayList<Ict_child> module_4;
    ArrayList<Ict_child> module_5;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ict);
        MobileAds.initialize(this);
        AdView ict_1 = findViewById(R.id.ict1);
        AdView ict_2 = findViewById(R.id.ict2);
        AdRequest adRequest = new AdRequest.Builder().build();
        ict_1.loadAd(adRequest);
        ict_2.loadAd(adRequest);
        AdView adView =  new AdView(this);
        adView.setAdSize(AdSize.BANNER);

        recyclerView = findViewById(R.id.ict_mainRecycler);
        module_1 = new ArrayList<>();
        module_2 = new ArrayList<>();
        module_3 = new ArrayList<>();
        module_4 = new ArrayList<>();
        module_5 = new ArrayList<>();

        ictParentArrayList = new ArrayList<>();

        module_1.add(new Ict_child( "math_1_dip.pdf", R.drawable.math));
        module_1.add(new Ict_child( "icte_dip.pdf",R.drawable.icte));
        module_1.add(new Ict_child( "os_1_dip.pdf",R.drawable.os));
        module_1.add(new Ict_child( "comms_dip.pdf",R.drawable.comms));
        module_1.add(new Ict_child( "CA_theory_1_dip.pdf", R.drawable.ca));
        module_1.add(new Ict_child( "CA_prac_1_dip.pdf", R.drawable.caa));
        module_1.add(new Ict_child("sp_1_dip.pdf",R.drawable.sp));
        module_1.add(new Ict_child("system_1_dip.pdf",R.drawable.info));

        ictParentArrayList.add(new Ict_parent(module_1, "Diploma: module 1"));

        module_2.add(new Ict_child( "OB_2_dip.pdf",R.drawable.oop));
        module_2.add(new Ict_child( "visual_2_dip.pdf",R.drawable.vb));
        module_2.add(new Ict_child( "ca_2_dip.pdf",R.drawable.ca));
        module_2.add(new Ict_child( "ca_prac_2_ dip.pdf",R.drawable.caa));
        module_2.add(new Ict_child( "DBMS_2_dip.pdf",R.drawable.dbms));

        ictParentArrayList.add(new Ict_parent(module_2, "Diploma: Module 2"));

        module_5.add(new Ict_child( "data_comms_3_dip.pdf",R.drawable.data));
        module_5.add(new Ict_child( "IBP_3_dip.pdf",R.drawable.ibp));
        module_5.add(new Ict_child( "management_info_3_dip.pdf",R.drawable.mis));
        module_5.add(new Ict_child( "principle_practice_3_dip.pdf",R.drawable.ppm));

        ictParentArrayList.add(new Ict_parent(module_5, "Diploma: Module 3"));

        module_3.add(new Ict_child( "comms_1_cert.pdf",R.drawable.comms));
        module_3.add(new Ict_child( "basic_elect_1_cert.pdf",R.drawable.be));
        module_3.add(new Ict_child( "ca_prac_1_cert.pdf",R.drawable.caa));
        module_3.add(new Ict_child( "ca_theory_1_cert.pdf",R.drawable.ca));
        module_3.add(new Ict_child( "ICTE_1_cert.pdf",R.drawable.icte));
        module_3.add(new Ict_child( "OS_1_cert.pdf",R.drawable.os));

        ictParentArrayList.add(new Ict_parent(module_3, "Certificate: module 1"));

        module_4.add(new Ict_child( "ca_prac_2_cert.pdf",R.drawable.caa));
        module_4.add(new Ict_child( "ca_theory_2_cert.pdf",R.drawable.ca));
        module_4.add(new Ict_child( "comp_maintenance_2_cert.pdf",R.drawable.sm));
        module_4.add(new Ict_child( "SP_2_cert.pdf",R.drawable.sp));

        ictParentArrayList.add(new Ict_parent(module_4, "Certificate: Module 2"));





        Ict_parent_adapter adapter = new Ict_parent_adapter(ictParentArrayList, ICT.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Ict_Inter.loadads(this);

        imageView = findViewById(R.id.ict_back);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(ICT.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}