package com.murach.dailyplanner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DailyPlannerActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);     
        
        // use fragment manager to display tip calc frag
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new DailyPlannerFragment())
                .commit();
    }
}