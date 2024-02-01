package com.nerdware.knecpastpapers.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.nerdware.knecpastpapers.Adapter.CourseRecycler;
import com.nerdware.knecpastpapers.MainActivity;
import com.nerdware.knecpastpapers.R;
import com.nerdware.knecpastpapers.model.CourseModel;
import java.util.ArrayList;

public class Courses extends AppCompatActivity {
    Activity activity;
    RecyclerView recyclerView;
    ArrayList <CourseModel> courseModelArrayList;
    CourseRecycler courseRecycler;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses2);

        imageView = findViewById(R.id.course_back);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Courses.this, MainActivity.class);
            startActivity(intent);
        });
        recyclerView = findViewById(R.id.course_recycler);
        courseModelArrayList = new ArrayList<>();

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        courseModelArrayList.add(new CourseModel(R.drawable.autos));
        courseModelArrayList.add(new CourseModel(R.drawable.mech));
        courseModelArrayList.add(new CourseModel(R.drawable.elect));
        courseModelArrayList.add(new CourseModel(R.drawable.build));
        courseModelArrayList.add(new CourseModel(R.drawable.ict));
        courseModelArrayList.add(new CourseModel(R.drawable.fashios));
        courseModelArrayList.add(new CourseModel(R.drawable.hr));
        courseModelArrayList.add(new CourseModel(R.drawable.cater));



        courseRecycler = new CourseRecycler(activity,courseModelArrayList);
        recyclerView.setLayoutManager(layoutManager);

        courseRecycler.setOnItemClickListener(position -> {
            switch (position){
                case 0:
                    Intent intent1 = new Intent(Courses.this, Automotive.class);
                    startActivity(intent1);
                    break;
                case 1:
                    Intent intent2 = new Intent(Courses.this, Mechanical.class);
                    startActivity(intent2);
                    break;
                case 2:
                    Intent intent3 = new Intent(Courses.this, Electrical.class);
                    startActivity(intent3);
                    break;
                case 3:
                    Intent intent4 = new Intent(Courses.this, Building.class);
                    startActivity(intent4);
                    break;
                case 4:
                    Intent intent5 = new Intent(Courses.this, ICT.class);
                    startActivity(intent5);
                    break;
                case 5:
                    Intent intent6 = new Intent(Courses.this, Fashion.class);
                    startActivity(intent6);
                    break;
                case 6:
                    Intent intent7 = new Intent(Courses.this, Human.class);
                    startActivity(intent7);
                    break;
                case 7:
                    Intent intent8 = new Intent(Courses.this, Catering.class);
                    startActivity(intent8);
                    break;
                case 8:
                    Intent intent9 = new Intent(Courses.this, Agriculture.class);
                    startActivity(intent9);
                    break;
            }
        });
        recyclerView.setAdapter(courseRecycler);


    }
}