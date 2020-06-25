package com.example.loopsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button whileLoop, doWhileLoop, forLoop, enhForLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whileLoop = (Button)findViewById(R.id.btnWhile);
        doWhileLoop = (Button)findViewById(R.id.btnDoWhile);
        forLoop = (Button)findViewById(R.id.btnFor);
        enhForLoop = (Button)findViewById(R.id.btnEnhanced);

        whileLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theWhileLoop();
            }
        });

        doWhileLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theDoWhileLoop();
            }
        });

        forLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theForLoop();
            }
        });

        enhForLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theEnhForLoop();
            }
        });

    }

    public void theWhileLoop() {
        int i = 0;
        while (i < 10){
            Log.i("testing", "i = " + i);
            i++;
        }

    }

    public void theDoWhileLoop() {
        int i = 0;
        do {
            Log.i("testing", "i = " + i);
            i++;
        } while (i < 10);

    }

    public void theForLoop() {
        for (int i = 0; i < 10; i++){
            Log.i("testing", "i = " + i);
        }
    }

    public void theEnhForLoop() {
        int[] integers = new int[]{
                0,1,2,3,4,5,6,7,8,9
        };
        for (int i: integers){
            Log.i("testing", "i = " + i);
        }

    }

}
