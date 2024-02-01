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
import com.nerdware.knecpastpapers.Adapter.fashParentAdapter;
import com.nerdware.knecpastpapers.Interstitial.Fash_Inter;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.Fash_child;
import com.nerdware.knecpastpapers.model.fashParent;
import java.util.ArrayList;

public class Fashion extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<fashParent> fashParentArrayList;
    ArrayList<Fash_child> module_1;
    ArrayList<Fash_child> module_2;
    ArrayList<Fash_child> module_3;
    ArrayList<Fash_child> module_4;
    ArrayList<Fash_child> module_5;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);
        MobileAds.initialize(this);
        AdView fash = findViewById(R.id.fash1);
        AdView fash_2 = findViewById(R.id.fash2);
        AdRequest adRequest = new AdRequest.Builder().build();
        fash.loadAd(adRequest);
        fash_2.loadAd(adRequest);
        AdView adView =  new AdView(this);
        adView.setAdSize(AdSize.BANNER);

        recyclerView = findViewById(R.id.fashion_mainRecycler);
        module_1 = new ArrayList<>();
        module_2 = new ArrayList<>();
        module_3 = new ArrayList<>();
        module_4 = new ArrayList<>();
        module_5 = new ArrayList<>();

        fashParentArrayList = new ArrayList<>();

        module_1.add(new Fash_child( "art1_dip.pdf", R.drawable.afs));
        module_1.add(new Fash_child("cloth1_dip.pdf", R.drawable.cc));
        module_1.add(new Fash_child("ict1_dip.pdf", R.drawable.ict));
        module_1.add(new Fash_child("pattern1_dip.pdf", R.drawable.pcp));
        module_1.add(new Fash_child("text1_dip.pdf", R.drawable.ts));

        fashParentArrayList.add(new fashParent(module_1, "Diploma: module 1"));

        module_2.add(new Fash_child("cloth2_dip.pdf", R.drawable.ccp));
        module_2.add(new Fash_child("fash2_dip.pdf", R.drawable.fds));
        module_2.add(new Fash_child("indust2_dip.pdf", R.drawable.iomqc));
        module_2.add(new Fash_child("pattern2_dip.pdf", R.drawable.pcp));
        module_2.add(new Fash_child("text2_dip.pdf", R.drawable.ts));

        fashParentArrayList.add(new fashParent(module_2, "Diploma: Module 2"));

        module_3.add(new Fash_child("cloth3_dip.pdf", R.drawable.ccp));
        module_3.add(new Fash_child("fash3_dip.pdf", R.drawable.fam));
        module_3.add(new Fash_child("indust3_dip.pdf", R.drawable.iomqc));
        module_3.add(new Fash_child("patter3_dip.pdf", R.drawable.pcp));
        module_3.add(new Fash_child("text3_dip.pdf", R.drawable.ts));
        module_3.add(new Fash_child("theory3_dip.pdf", R.drawable.cc));

        fashParentArrayList.add(new fashParent(module_3, "Diploma: module 3"));

        module_4.add(new Fash_child("art1_cert.pdf", R.drawable.afs));
        module_4.add(new Fash_child("comms_cert.pdf", R.drawable.comms));
        module_4.add(new Fash_child("fab1_cert.pdf",R.drawable.fcp));
        module_4.add(new Fash_child("ict1_cert.pdf", R.drawable.ict));
        module_4.add(new Fash_child("text1_cert.pdf", R.drawable.tmkf));
        module_4.add(new Fash_child("works1_cert.pdf", R.drawable.work));

        fashParentArrayList.add(new fashParent(module_4, "Certificate: Module 1"));

        module_5.add(new Fash_child("batik2_cert.pdf", R.drawable.bae));
        module_5.add(new Fash_child("gam2_cert.pdf", R.drawable.gcm));
        module_5.add(new Fash_child("gam2w_cert.pdf", R.drawable.gmw));
        module_5.add(new Fash_child("garm2_cert.pdf", R.drawable.gmm));

        fashParentArrayList.add(new fashParent(module_5, "Certificate: Module 2"));

        fashParentAdapter adapter = new fashParentAdapter(fashParentArrayList, Fashion.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Fash_Inter.loadads(this);


        imageView = findViewById(R.id.fashion_back);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Fashion.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}