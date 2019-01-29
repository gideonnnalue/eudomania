package com.example.tojuzone.eudomania.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tojuzone.eudomania.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread timer = new Thread() {
            @Override
            public void run () {
                try {
                    sleep(3000);
                    Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                    startActivity(i);
                    finish();
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }
}
