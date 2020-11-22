package com.example.frikial20;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class Config extends AppCompatActivity {

    View v;
    TextInputEditText textInput;
    Switch hardcoreSwitch;
    Switch soundSwitch;
    Switch imageSwitch;
    RadioGroup radioGroup;
    RadioButton radioButton;
    int numberQuestions=0;
    boolean hardcore=false;
    boolean sound=true;
    boolean video=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        v = findViewById(android.R.id.content);
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        textInput = v.findViewById(R.id.InputText_name);
        radioGroup = v.findViewById(R.id.radioGroup);
        hardcoreSwitch = v.findViewById(R.id.switchHardcore);
        soundSwitch = v.findViewById(R.id.switchSound);
        imageSwitch= v.findViewById(R.id.switchImage);

        numberQuestions = SharedPrefs.getInt(this, "numberQuestions");
        hardcore = SharedPrefs.getBoolean(this, "hardcore");
        video = SharedPrefs.getBoolean(this, "video");
        sound = SharedPrefs.getBoolean(this, "sound");
        textInput.setText(SharedPrefs.getString(this, "name"));

        switch (numberQuestions){
            case 5:
                radioButton = v.findViewById(R.id.radioButtonAns5);
                break;
            case 10:
                radioButton = v.findViewById(R.id.radioButtonAns10);
                break;
            case 15:
                radioButton = v.findViewById(R.id.radioButtonAns15);
                break;
            default:
                radioButton = v.findViewById(R.id.radioButtonAns15);
                break;
        }
        radioGroup.clearCheck();
        radioButton.setChecked(true);

        hardcoreSwitch.setChecked(hardcore);
        imageSwitch.setChecked(video);
        soundSwitch.setChecked(sound);
    }

    public void saveConfig(View v){
        checkSwitchs();
        SharedPrefs.saveInt(this, "numberQuestions", numberQuestions);
        SharedPrefs.saveBoolean(this, "hardcore", hardcore);
        SharedPrefs.saveBoolean(this, "image", video);
        SharedPrefs.saveBoolean(this, "sound", sound);
        if(!textInput.getText().toString().isEmpty()){
            SharedPrefs.saveString(this, "name", textInput.getText().toString());
        }
        String prevScene = getIntent().getStringExtra("prevActivity");

        switch (prevScene){
            case "Intro.class":{
                Intent i = new Intent(this, Intro.class);
                startActivity(i);
                finish();
                break;
            }
            case "QuestionsActivity.class":{
                Intent i = new Intent(this, QuestionsActivity.class);
                startActivity(i);
                finish();
                break;
            }
            default:{
                Intent i = new Intent(this, Intro.class);
                startActivity(i);
                finish();
            }
        }

    }

    private void checkSwitchs(){
        hardcore = hardcoreSwitch.isChecked();
        video = imageSwitch.isChecked();
        sound = soundSwitch.isChecked();
    }

    public void changeNumberQuestions(View v){
        radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        radioGroup.clearCheck();
        radioButton.setChecked(true);
        switch(v.getId()) {
            case R.id.radioButtonAns5:
                numberQuestions=5;
                break;
            case R.id.radioButtonAns10:
                numberQuestions=10;
                break;
            case R.id.radioButtonAns15:
                numberQuestions=15;
                break;
        }
    }
}