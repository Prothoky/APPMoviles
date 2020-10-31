package com.example.frikial20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int intTotalAnswers = getIntent().getIntExtra("totalQuestions", 0);
        int intCorrectAnswers = getIntent().getIntExtra("correctAnswers", 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        View v = findViewById(android.R.id.content);

        if(intTotalAnswers != 0){
            TextView mTotalAnswers = v.findViewById(R.id.totalAnswers);
            TextView mCorrectAnswers = v.findViewById(R.id.correctAnswers);
            mTotalAnswers.setText("Ha respondido un total de "+intTotalAnswers+" preguntas");
            mCorrectAnswers.setText("De las cuales "+ intCorrectAnswers+" han sido respuestas correctas");
        }
    }
}
