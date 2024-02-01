package com.nerdware.knecpastpapers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.nerdware.knecpastpapers.Activities.ChatActivity;
import com.nerdware.knecpastpapers.Registration.LogIn;
import com.nerdware.knecpastpapers.Registration.Sign_Up;

public class Get_Started extends AppCompatActivity {
    RelativeLayout logIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        logIn = findViewById(R.id.logIn_btn);
        signUp = findViewById(R.id.sign_btn);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Get_Started.this, LogIn.class);
                startActivity(intent);
                finish();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Get_Started.this, Sign_Up.class);
                startActivity(i);
                finish();
            }
        });
    }
}