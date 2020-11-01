package com.example.frikial20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int intTotalAnswers = getIntent().getIntExtra("totalQuestions", 0);
        int intCorrectAnswers = getIntent().getIntExtra("correctAnswers", 0);
        int intScore = getIntent().getIntExtra("score", 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        View v = findViewById(android.R.id.content);

        if(intTotalAnswers != 0){
            TextView mTotalAnswers = v.findViewById(R.id.totalAnswers);
            TextView mCorrectAnswers = v.findViewById(R.id.correctAnswers);
            TextView mScore = v.findViewById(R.id.scoreFinal);
            mTotalAnswers.setText("Ha respondido un total de "+intTotalAnswers+" preguntas");
            mCorrectAnswers.setText("De las cuales "+ intCorrectAnswers+" han sido respuestas correctas");
            mScore.setText("Tu puntuación final ha sido de: "+ intScore);
        }
    }

    public void restart(View view) {
        Toast.makeText(this, "Empezamos", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, QuestionsActivity.class);
        startActivity(i);
        finish();
    }

    public void exit(View view) {
        Toast.makeText(this, "¡Gracias por jugar!", Toast.LENGTH_SHORT).show();
        finishAndRemoveTask();
    }
}
