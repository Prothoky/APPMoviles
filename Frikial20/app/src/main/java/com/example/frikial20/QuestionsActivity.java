package com.example.frikial20;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);
        View v = findViewById(android.R.id.content);
        TextView question = (TextView) v.findViewById(R.id.textView3);
        question.setText(getResources().getResourceName(v.getId()));
    }

    public void checkAnswer(View view) {
        String answer = getResources().getResourceName(view.getId());
        if(answer=="AC") {
            Context context = getApplicationContext();
            CharSequence text = "CORRECTO";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = answer;
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}