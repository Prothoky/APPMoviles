package com.example.frikial20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int intTotalAnswers = getIntent().getIntExtra("totalQuestions", 0);
        int intCorrectAnswers = getIntent().getIntExtra("correctAnswers", 0);
        int intScore = getIntent().getIntExtra("score", 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        View v = findViewById(android.R.id.content);

        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        if(intTotalAnswers != 0){
            TextView mTotalAnswers = v.findViewById(R.id.totalAnswers);
            TextView mCorrectAnswers = v.findViewById(R.id.correctAnswers);
            TextView mScore = v.findViewById(R.id.scoreFinal);
            mTotalAnswers.setText("Ha respondido un total de "+intTotalAnswers+" preguntas");
            mCorrectAnswers.setText("De las cuales "+ intCorrectAnswers+" han sido respuestas correctas");
            mScore.setText("Tu puntuación final ha sido de: "+ intScore);
        }

        saveInfoPlayer(intScore, intCorrectAnswers, intTotalAnswers);
    }

    public void restart(View view) {
        Toast.makeText(this, "Empezamos", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, QuestionsActivity.class);
        startActivity(i);
        finish();
    }

    public void exit(View view) {
        Intent i = new Intent(this, Intro.class);
        startActivity(i);
        finish();
    }

    private void saveInfoPlayer(int intScore , int intCorrectAnswers, int intTotalAnswers){

        String name  =  SharedPrefs.getString(this,"name");
        Score player = new Score(name, intScore, intCorrectAnswers, intTotalAnswers-intCorrectAnswers, intTotalAnswers);
        //SharedPrefs.saveScore(this, "player", player);
        HashSet<String> usersSet = (HashSet<String>) SharedPrefs.getStringSet(this, "users");    // Obtenemos la lista de nombres de usuario
        usersSet.add(name); // Añadimos el nombre (si no está ya)
        SharedPrefs.saveStringSet(this, "users", usersSet); // Actualizamos la lista
        if (SharedPrefs.getInt(this, name, -100) != -100) { // Comprobamos que hay datos guardados del usuario
            if (SharedPrefs.getInt(this, name) < intScore) {    // Comprobamos que es la mejor puntuación
                SharedPrefs.saveInt(this, name, intScore);  // Sobreescribimos puntuación con el nombre de usuario de key
            }
        } else {
            SharedPrefs.saveInt(this, name, intScore);  // Sobreescribimos puntuación con el nombre de usuario de key
        }
    }
}
