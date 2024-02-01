package com.nerdware.knecpastpapers.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.nerdware.knecpastpapers.Adapter.Agri_parent_adapter;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.agriChild;
import com.nerdware.knecpastpapers.model.Agri_parent;

import java.util.ArrayList;

public class Agriculture extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<Agri_parent> agriParentArrayList;
    ArrayList<agriChild> module_1;
    ArrayList<agriChild> module_2;
    ArrayList<agriChild> module_3;
    ArrayList<agriChild> module_4;
    ArrayList<agriChild> module_5;



    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture);

        recyclerView = findViewById(R.id.agri_mainRecycler);
        module_1 = new ArrayList<>();
        module_2 = new ArrayList<>();
        module_3 = new ArrayList<>();
        module_4 = new ArrayList<>();
        module_5 = new ArrayList<>();

        agriParentArrayList = new ArrayList<>();

        module_1.add(new agriChild("", ""));
        module_1.add(new agriChild("", ""));
        module_1.add(new agriChild("", ""));
        module_1.add(new agriChild("", ""));
        module_1.add(new agriChild("", ""));
        module_1.add(new agriChild("", ""));

        agriParentArrayList.add(new Agri_parent(module_1, "Diploma: module 1"));

        module_2.add(new agriChild("", ""));
        module_2.add(new agriChild("", ""));
        module_2.add(new agriChild("", ""));
        module_2.add(new agriChild("", ""));
        module_2.add(new agriChild("", ""));
        module_2.add(new agriChild("", ""));

        agriParentArrayList.add(new Agri_parent(module_2, "Diploma: Module 2"));

        module_3.add(new agriChild("", ""));
        module_3.add(new agriChild("", ""));
        module_3.add(new agriChild("", ""));
        module_3.add(new agriChild("", ""));
        module_3.add(new agriChild("", ""));
        module_3.add(new agriChild("", ""));

        agriParentArrayList.add(new Agri_parent(module_3, "Diploma: module 3"));

        module_4.add(new agriChild("", ""));
        module_4.add(new agriChild("", ""));
        module_4.add(new agriChild("", ""));
        module_4.add(new agriChild("", ""));
        module_4.add(new agriChild("", ""));
        module_4.add(new agriChild("", ""));

        agriParentArrayList.add(new Agri_parent(module_4, "Certificate: Module 1"));

        module_5.add(new agriChild("", ""));
        module_5.add(new agriChild("", ""));
        module_5.add(new agriChild("", ""));
        module_5.add(new agriChild("", ""));
        module_5.add(new agriChild("", ""));
        module_5.add(new agriChild("", ""));

        agriParentArrayList.add(new Agri_parent(module_5, "Certificate: Module 2"));



        Agri_parent_adapter adapter = new Agri_parent_adapter(agriParentArrayList, Agriculture.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        imageView = findViewById(R.id.agri_back);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Agriculture.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}