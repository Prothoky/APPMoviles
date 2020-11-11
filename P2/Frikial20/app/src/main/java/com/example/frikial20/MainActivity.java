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

    // View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* EJEMPLO DE USO SharedPreferences (descomentar View v atributo de clase y crear 2 widgets de texto)
        // Recibe input de usuario en un *supuesto* campo de texto y lo guarda en SharedPreferences
        // Después lee de esa SharedPreferences para mostrarlo por pantalla la próxima vez que se inicie
        v = findViewById(android.R.id.content); // obtiene view
        TextView textView1 = (TextView) v.findViewById(R.id.sharedPrefsTestWidget2);    // obtiene campo texto
        textView1.setText(SharedPrefs.getString(this, "name", "default"));  // setea el valor del campo de texto a lo almacenado (default si no hay nada)
        */
    }

    public void preguntas (View view){
        /* EJEMPLO DE USO SharedPreferences
        TextView textView = (TextView) v.findViewById(R.id.sharedPrefsTestWidget);  // obtiene *supuesto* campo de entrada de texto
        SharedPrefs.saveString(this, "name", textView.getText().toString());    // guarda el contenido en una sharedPref con clave "name"
        */

        Toast.makeText(this, "Empezamos", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, QuestionsActivity.class);
        startActivity(i);
        finish();
    }
}