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

    private ArrayList<Preguntas.Pregunta> mQuestionsList = null;
    private int mCurrentPosition = 0;
    private int mCorrectAnswers = 0;

    private TextView mQuestion;
    private ImageView mImage;
    private Button mAnsw1;
    private Button mAnsw2;
    private Button mAnsw3;
    private Button mAnsw4;
    private int mCorrect_answer;
    private int mTotal_questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_activity);
        View v = findViewById(android.R.id.content);


        mQuestion = v.findViewById(R.id.q_question);
        mImage = v.findViewById(R.id.q_image);
        mAnsw1 = v.findViewById(R.id.q_AnswOne);
        mAnsw2 = v.findViewById(R.id.q_AnswTwo);
        mAnsw3 = v.findViewById(R.id.q_AnswThree);
        mAnsw4 = v.findViewById(R.id.q_AnswFour);
        mQuestionsList = Preguntas.getQuestions();
        mTotal_questions = mQuestionsList.size();
        setQuestion();
    }

    public void checkAnswer(View view){
        int answer=-1;
        //Hago 4 if porque no me deja hacerlo con un switch
        if (view.getId()==mAnsw1.getId()) answer=1;
        else if (view.getId()==mAnsw2.getId()) answer=2;
        else if (view.getId()==mAnsw3.getId()) answer=3;
        else if (view.getId()==mAnsw4.getId()) answer=4;

        if(answer==-1){
            Toast.makeText(this, "ALGO HA IDO MAL", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            mCurrentPosition++;
            if (mCorrect_answer == answer) {
                mCorrectAnswers++;
                Toast.makeText(this, "CORRECTO", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "INCORRECTO", Toast.LENGTH_SHORT).show();
            }
            if (mCurrentPosition < mTotal_questions) {
                setQuestion();
            } else {
                Intent intent = new Intent(this, EndActivity.class);
                intent.putExtra("totalQuestions", mTotal_questions);
                intent.putExtra("correctAnswers", mCorrectAnswers);
                startActivity(intent);
                finish();
            }
        }

    }

    private void setQuestion() {

        Preguntas.Pregunta question = mQuestionsList.get(mCurrentPosition);

        mQuestion.setText(question.pregunta);
        mImage.setImageResource(question.image);
        mAnsw1.setText(question.AnswOne);
        mAnsw2.setText(question.AnswTwo);
        mAnsw3.setText(question.AnswThree);
        mAnsw4.setText(question.AnswFour);
        mCorrect_answer = question.AnswCorrect;
    }

}