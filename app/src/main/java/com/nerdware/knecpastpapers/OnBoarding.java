package com.nerdware.knecpastpapers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.nerdware.knecpastpapers.Adapter.BoardAdapter;

public class OnBoarding extends AppCompatActivity {

    ViewPager slideViewPager;
    LinearLayout dotIndicator;
    ImageView backButton, nextButton;
    TextView skipButton;
    TextView[] dots;
    BoardAdapter viewPagerAdapter;

    SharedPreferences preferences;

    ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        @Override
        public void onPageSelected(int position) {

            setDotIndicator(position);

            if (position > 0) {
                backButton.setVisibility(View.VISIBLE);
            } else {
                backButton.setVisibility(View.INVISIBLE);
            }

        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize SharedPreferences
        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Check if onboarding has already been completed
        boolean onboardingCompleted = preferences.getBoolean("onboarding_completed", false);

        if (onboardingCompleted) {
            // Onboarding has already been completed, navigate to the main activity
            Intent intent = new Intent(this, Get_Started.class);
            startActivity(intent);
            finish();
        } else {
            // Onboarding has not been completed, show onboarding screens
            setContentView(R.layout.activity_on_boarding);

            backButton = findViewById(R.id.back_btn);
            nextButton = findViewById(R.id.nextButton);
            skipButton = findViewById(R.id.skipButton);

            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getItem(0) > 0) {
                        slideViewPager.setCurrentItem(getItem(-1), true);
                    }
                }
            });

            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getItem(0) < 2)
                        slideViewPager.setCurrentItem(getItem(1), true);
                    else {
                        // Set a flag to indicate that onboarding has been completed
                        preferences.edit().putBoolean("onboarding_completed", true).apply();

                        // Navigate to the main activity
                        Intent i = new Intent(OnBoarding.this, Get_Started.class);
                        startActivity(i);
                        finish();
                    }
                }
            });

            skipButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Set a flag to indicate that onboarding has been completed
                    preferences.edit().putBoolean("onboarding_completed", true).apply();

                    // Navigate to the main activity
                    Intent i = new Intent(OnBoarding.this, Get_Started.class);
                    startActivity(i);
                    finish();
                }
            });

            slideViewPager = findViewById(R.id.slideViewPager);
            dotIndicator = findViewById(R.id.dotIndicator);

            viewPagerAdapter = new BoardAdapter(this);
            slideViewPager.setAdapter(viewPagerAdapter);

            setDotIndicator(0);
            slideViewPager.addOnPageChangeListener(viewPagerListener);
        }
    }

    public void setDotIndicator(int position) {

        dots = new TextView[3];
        dotIndicator.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226", Html.FROM_HTML_MODE_LEGACY));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.black, getApplicationContext().getTheme()));
            dotIndicator.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.lavender, getApplicationContext().getTheme()));
    }

    private int getItem(int i) {
        return slideViewPager.getCurrentItem() + i;
    }
}
