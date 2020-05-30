package com.example.tictt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import static java.lang.Thread.sleep;

public class SplashScreenActivity extends AppCompatActivity {
    Thread thread=new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                sleep(3000);
                Intent intent=new Intent(SplashScreenActivity.this,Input_names.class);
                startActivity(intent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_ss);
thread.start();
    }
}
