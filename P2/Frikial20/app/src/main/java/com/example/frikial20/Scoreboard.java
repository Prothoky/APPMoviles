package com.example.frikial20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashSet;

public class Scoreboard extends AppCompatActivity {

    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        v = findViewById(android.R.id.content);
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        TextView textView = v.findViewById(R.id.textViewScoreboard);

        // Obtenemos las puntuaciones
        // userNamesArray[i] nombre, scoresArray[i] su puntuación
        HashSet<String> userNames = (HashSet<String>) SharedPrefs.getStringSet(this, "users");
        String[] userNamesArray = new String[userNames.size()];
        userNames.toArray(userNamesArray);
        int[] scoresArray = new int[userNames.size()];
        for (int i = 0; i < userNames.size(); i++) {
            scoresArray[i] = SharedPrefs.getInt(this, userNamesArray[i], 0);
        }

        // Ordenamos de mayor a menor por bubble sort en ambos array
        for (int i = 0; i < userNamesArray.length; i++) {
            for (int j = 0; j < userNamesArray.length - i - 1; j++) {
                if (scoresArray[j] < scoresArray [j + 1]) {
                    int auxInt = scoresArray[j + 1];
                    scoresArray[j + 1] = scoresArray[i];
                    scoresArray[j] = auxInt;
                    String auxString = userNamesArray[j + 1];
                    userNamesArray[j + 1] = userNamesArray[j];
                    userNamesArray[j] = auxString;
                }
            }
        }

        // Pintamos el array en el layout (con máximo 5)
        textView.setText("");
        int numberOfEntries = 5;
        if (userNamesArray.length < 5) {
            numberOfEntries = userNamesArray.length;
        }
        for (int i = 0; i < numberOfEntries; i++) {
            textView.append(userNamesArray[i] + ": " + scoresArray[i]);
            textView.append("\n");
        }
    }


    public void goIntro (View view){

        Intent i = new Intent(this, Intro.class);
        startActivity(i);
        finish();

    }
}