package com.example.listapaises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    public String data[] = {"Cuba: 11 millones", "China: 1400 millones", "Rusia: 146 millones", "Palestina: 5 millones",  "Corea del Norte: 25 millones", "Suazilandia: 1 millón", "Brasil: 210 millones"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        ArrayList<Country> arrayCountry = new ArrayList<>();
        Country country;

        //Introducimos los países
        country = new Country("Cuba", getResources().getDrawable(R.drawable.flag_cuba));
        arrayCountry.add(country);

        country = new Country("China", getResources().getDrawable(R.drawable.flag_china));
        arrayCountry.add(country);

        country = new Country("Russia", getResources().getDrawable(R.drawable.flag_russia));
        arrayCountry.add(country);

        country = new Country("Palestine", getResources().getDrawable(R.drawable.flag_palestine));
        arrayCountry.add(country);

        country = new Country("North Korea", getResources().getDrawable(R.drawable.flag_northkorea));
        arrayCountry.add(country);

        country = new Country("Swaziland", getResources().getDrawable(R.drawable.flag_swaziland));
        arrayCountry.add(country);

        country = new Country("Brazil", getResources().getDrawable(R.drawable.flag_brazil));
        arrayCountry.add(country);

        AdapterCountry adapter = new AdapterCountry(this, arrayCountry);
        list.setAdapter(adapter);
        //list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toastPopulation = Toast.makeText(getApplicationContext(), data[position], Toast.LENGTH_SHORT);
                toastPopulation.show();
            }
        });
    }
}