package com.nerdware.knecpastpapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nerdware.knecpastpapers.Activities.Agriculture;
import com.nerdware.knecpastpapers.Activities.Automotive;
import com.nerdware.knecpastpapers.Activities.Building;
import com.nerdware.knecpastpapers.Activities.Catering;
import com.nerdware.knecpastpapers.Activities.Courses;
import com.nerdware.knecpastpapers.Activities.Electrical;
import com.nerdware.knecpastpapers.Activities.Fashion;
import com.nerdware.knecpastpapers.Activities.Human;
import com.nerdware.knecpastpapers.Activities.ICT;
import com.nerdware.knecpastpapers.Activities.Mechanical;
import com.nerdware.knecpastpapers.Adapter.HomeAdapter;
import com.nerdware.knecpastpapers.model.Home_model;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Activity activity;
    RecyclerView recyclerView, populary;
    ArrayList<Home_model> homeModelArrayList;
    TextView textView, text;
    RelativeLayout popular, trending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.viewall2);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Courses.class);
                startActivity(intent);
                finish();
            }
        });


        // Retrieve the username from the Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        TextView usernameTextView = findViewById(R.id.hom_username);
        usernameTextView.setText(username);

        recyclerView = findViewById(R.id.home_recycler);
        homeModelArrayList = new ArrayList<>();

            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        homeModelArrayList.add(new Home_model(R.drawable.autos));
        homeModelArrayList.add(new Home_model(R.drawable.mech));
        homeModelArrayList.add(new Home_model(R.drawable.elect));
        homeModelArrayList.add(new Home_model(R.drawable.build));

        HomeAdapter adapter = new HomeAdapter(activity, activity, homeModelArrayList);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        Intent intent1 = new Intent(MainActivity.this, Automotive.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2 = new Intent(MainActivity.this, Mechanical.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(MainActivity.this, Electrical.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(MainActivity.this, Building.class);
                        startActivity(intent4);
                        break;
                }
            }
        });

        recyclerView.setAdapter(adapter);

    }
}