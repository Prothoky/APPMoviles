package com.example.frikial20;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void preguntas (View view){
        Toast.makeText(this, "Empezamos", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, QuestionsActivity.class);
        startActivity(i);
        finish();
    }
}