package com.example.entrega1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Mostramos mensaje toast
        Context context = getApplicationContext();
        CharSequence text = "onCreate state";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        // Mostramos mensaje toast
        Context context = getApplicationContext();
        CharSequence text = "onPause state";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        // Mostramos mensaje toast
        Context context = getApplicationContext();
        CharSequence text = "onDestroy state";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        // Mostramos mensaje toast
        Context context = getApplicationContext();
        CharSequence text = "onStop state";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        // Mostramos mensaje toast
        Context context = getApplicationContext();
        CharSequence text = "onStart state";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        // Mostramos mensaje toast
        Context context = getApplicationContext();
        CharSequence text = "onResume state";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        // Mostramos mensaje toast
        Context context = getApplicationContext();
        CharSequence text = "onRestart state";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}