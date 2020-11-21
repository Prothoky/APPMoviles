package com.example.frikial20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity {

    //Estas variables serán utilizadas para mostrar un determinado numero y tipo de pregunta

    private String name;
    private int numberQuestions;
    private boolean hardcore;
    private boolean image;
    private boolean sound;

    //Estas variables serán utilizadas para mostrar un determinado numero y tipo de pregunta

    private ArrayList<Preguntas.Pregunta> mQuestionsList;
    private int mCurrentPosition = 0;
    private int mCorrectAnswers = 0;
    private int mScore =0;

    private TextView mQuestion;
    private TextView mPosition;
    private TextView mCorrect_Incorrect;
    private ImageView mImage;
    private Button mAns1;
    private Button mAns2;
    private Button mAns3;
    private Button mAns4;
    private int mCorrect_answer;
    private int mTotal_questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String Nombre = getIntent().getStringExtra("name");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_activity);
        View v = findViewById(android.R.id.content);

        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        //Estas variables serán utilizadas para mostrar un determinado numero y tipo de pregunta
        //Estas variables se modifican en el activity config

        name = SharedPrefs.getString(this, "name" ,"");
        numberQuestions = SharedPrefs.getInt(this, "numberQuestions",5);
        hardcore = SharedPrefs.getBoolean(this, "hardcore",false);
        image = SharedPrefs.getBoolean(this, "image",true);
        sound = SharedPrefs.getBoolean(this, "sound",true);

        //Estas variables serán utilizadas para mostrar un determinado numero y tipo de pregunta

        mPosition = v.findViewById(R.id.questions_pos);
        mCorrect_Incorrect = v.findViewById(R.id.C_W);
        mQuestion = v.findViewById(R.id.q_question);
        mImage = v.findViewById(R.id.q_image);
        mAns1 = v.findViewById(R.id.q_AnswOne);
        mAns2 = v.findViewById(R.id.q_AnswTwo);
        mAns3 = v.findViewById(R.id.q_AnswThree);
        mAns4 = v.findViewById(R.id.q_AnswFour);
        mQuestionsList = Preguntas.getQuestions();
        mTotal_questions = numberQuestions;
        setQuestion();
    }

    public void checkAnswer(View view){
        int answer=-1;
        //Hago 4 if porque no me deja hacerlo con un switch
        if (view.getId()== mAns1.getId()) answer=1;
        else if (view.getId()== mAns2.getId()) answer=2;
        else if (view.getId()== mAns3.getId()) answer=3;
        else if (view.getId()== mAns4.getId()) answer=4;

        if(answer==-1){
            Toast.makeText(this, "ALGO HA IDO MAL", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            mCurrentPosition++;
            if (mCorrect_answer == answer) {
                mScore+=3;
                mCorrectAnswers++;
                Toast.makeText(this, "CORRECTO", Toast.LENGTH_SHORT).show();
            } else {
                mScore-=2;
                Toast.makeText(this, "INCORRECTO", Toast.LENGTH_SHORT).show();
                if(hardcore){
                    Intent intent = new Intent(this, EndActivity.class);
                    intent.putExtra("totalQuestions", mCurrentPosition);
                    intent.putExtra("correctAnswers", mCorrectAnswers);
                    intent.putExtra("score", mScore);
                    startActivity(intent);
                    finish();
                }
            }
            if (mCurrentPosition < mTotal_questions) {
                setQuestion();
            } else {
                Intent intent = new Intent(this, EndActivity.class);
                intent.putExtra("totalQuestions", mTotal_questions);
                intent.putExtra("correctAnswers", mCorrectAnswers);
                intent.putExtra("score", mScore);
                startActivity(intent);
                finish();
            }
        }

    }

    private void setQuestion() {

        mPosition.setText("Pregunta: "+ (mCurrentPosition+1) + "/" + mTotal_questions);
        mCorrect_Incorrect.setText("Correctas: " + mCorrectAnswers + " - Fallidas:" + (mCurrentPosition-mCorrectAnswers));

        Preguntas.Pregunta question = mQuestionsList.get(mCurrentPosition);

        mQuestion.setText(question.question);
        mImage.setImageResource(question.image);
        mAns1.setText(question.AnsOne);
        mAns2.setText(question.AnsTwo);
        mAns3.setText(question.AnsThree);
        mAns4.setText(question.AnsFour);
        mCorrect_answer = question.AnsCorrect[0];
    }

    public void optionsSelected(View view){
        Intent i = new Intent(this, Config.class);
        i.putExtra("prevActivity", "QuestionsActivity.class");
        startActivity(i);
        finish();
    }
}