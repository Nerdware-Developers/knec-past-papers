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
import com.nerdware.knecpastpapers.Adapter.Human_parent_adapter;
import com.nerdware.knecpastpapers.Interstitial.Human_Inter;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Human_child;
import com.nerdware.knecpastpapers.model.Human_parent;
import java.util.ArrayList;

public class Human extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<Human_parent> humanParentArrayList;
    ArrayList<Human_child> module_1;
    ArrayList<Human_child> module_2;
    ArrayList<Human_child> module_3;
    ArrayList<Human_child> module_4;
    ArrayList<Human_child> module_5;
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human);

        MobileAds.initialize(this);
        AdView hrm1 = findViewById(R.id.hr1);
        AdView hrm2 = findViewById(R.id.hr2);
        AdRequest adRequest = new AdRequest.Builder().build();
        hrm1.loadAd(adRequest);
        hrm2.loadAd(adRequest);
        AdView adView =  new AdView(this);
        adView.setAdSize(AdSize.BANNER);

        recyclerView = findViewById(R.id.human_mainRecycler);
        module_1 = new ArrayList<>();
        module_2 = new ArrayList<>();
        module_3 = new ArrayList<>();
        module_4 = new ArrayList<>();
        module_5 = new ArrayList<>();

        humanParentArrayList = new ArrayList<>();

        module_1.add(new Human_child( "ict_1_dip.pdf",R.drawable.ict));
        module_1.add(new Human_child( "financial_1_dip.pdf",R.drawable.fa));
        module_1.add(new Human_child( "comms_1_dip.pdf",R.drawable.comms));
        module_1.add(new Human_child( "bussiness_law_1_dip.pdf",R.drawable.bl));
        module_1.add(new Human_child( "fundamentals_1_dip.pdf",R.drawable.fhr));
        module_1.add(new Human_child("office_admin_1_dip.pdf",R.drawable.oam));


        humanParentArrayList.add(new Human_parent(module_1, "Diploma: module 1"));

        module_2.add(new Human_child( "HR_2_dip.pdf",R.drawable.hrm));
        module_2.add(new Human_child( "labour_2_dip.pdf",R.drawable.lil));
        module_2.add(new Human_child( "office_2_admin_dip.pdf",R.drawable.oam));
        module_2.add(new Human_child( "principle_practice_2_dip.pdf",R.drawable.ppom));
        module_2.add(new Human_child( "public _relation_2_dip.pdf",R.drawable.pr));
        module_1.add(new Human_child( "quant_tec_2_dip.pdf",R.drawable.qt));
        module_1.add(new Human_child( "Quantative_methods_2_dip.pdf",R.drawable.qm));

        humanParentArrayList.add(new Human_parent(module_2, "Diploma: Module 2"));

        module_3.add(new Human_child( "accounting_3_dip.pdf",R.drawable.ac));
        module_3.add(new Human_child( "financial_3_dip.pdf",R.drawable.fm));
        module_3.add(new Human_child( "labour_3_dip.pdf",R.drawable.lir));
        module_3.add(new Human_child( "manegerial_acc_3_dip.pdf",R.drawable.ma));
        module_3.add(new Human_child( "org_behaviour_3_dip.pdf",R.drawable.ob));
        module_3.add(new Human_child( "org_theory_3_dip.pdf",R.drawable.ob));
        module_1.add(new Human_child("principle_practice_3_dip.pdf",R.drawable.ppm));

        humanParentArrayList.add(new Human_parent(module_3, "Diploma: module 3"));

        //module_4.add(new Human_child( "bs_finance_1_cert.pdf",R.drawable.bf));
        module_4.add(new Human_child("bs_statistics_1_cert.pdf",R.drawable.bcs));
        module_4.add(new Human_child("commerce_1_cert.pdf",R.drawable.c));
        module_4.add(new Human_child( "comms_1_cert.pdf",R.drawable.comms));
        module_4.add(new Human_child( "elements_1_cert.pdf",R.drawable.ehrm));
        module_4.add(new Human_child( "fundamentals_2_cert.pdf",R.drawable.fme));
        module_1.add(new Human_child( "ict_1_cert.pdf",R.drawable.ict));
        module_1.add(new Human_child( "office_1_cert.pdf",R.drawable.oam));

        humanParentArrayList.add(new Human_parent(module_4, "Certificate: Module 1"));

        module_5.add(new Human_child( "economics_2_cert.pdf",R.drawable.e));
        module_5.add(new Human_child("elements_2_cert.pdf", R.drawable.r));
        module_5.add(new Human_child("h.r_prac_2_cert.pdf",R.drawable.phrm));
        module_5.add(new Human_child("law_2_cert.pdf",R.drawable.bl));
        module_1.add(new Human_child("office_2_cert.pdf",R.drawable.fo));

        humanParentArrayList.add(new Human_parent(module_5, "Certificate: Module 2"));

        Human_parent_adapter adapter = new Human_parent_adapter(humanParentArrayList, Human.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Human_Inter.loadads(this);
        imageView = findViewById(R.id.human_back);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Human.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}