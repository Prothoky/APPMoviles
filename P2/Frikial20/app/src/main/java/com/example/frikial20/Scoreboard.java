package com.example.frikial20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        for (int i = 0; i < userNamesArray.length - 1; i++) {
            for (int j = 0; j < userNamesArray.length - i - 1; j++) {
                if (scoresArray[i] < scoresArray [i + 1]) {
                    int auxInt = scoresArray[i + 1];
                    scoresArray[i + 1] = scoresArray[i];
                    scoresArray[i] = auxInt;
                    String auxString = userNamesArray[i + 1];
                    userNamesArray[i + 1] = userNamesArray[i];
                    userNamesArray[i] = auxString;
                }
            }
        }

        // Pintamos el array en el layout
        textView.setText("");
        for (int i = 0; i < userNamesArray.length; i++) {
            textView.append(userNamesArray[i] + ": " + scoresArray[i]);
            textView.append("\n");
        }
    }
}