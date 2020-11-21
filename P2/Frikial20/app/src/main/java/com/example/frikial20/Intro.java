package com.example.frikial20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void goPlay (View view){

        Intent i = new Intent(this, QuestionsActivity.class);
        startActivity(i);
        finish();

    }
    public void goConfig (View view){

        Intent i = new Intent(this, Config.class);
        startActivity(i);
        finish();

    }
    public void goScoreboard (View view){

        Intent i = new Intent(this, Scoreboard.class);
        startActivity(i);
        finish();

    }
}