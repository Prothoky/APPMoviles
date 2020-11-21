package com.example.frikial20;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionsActivity extends AppCompatActivity {

    //Estas variables serán utilizadas para mostrar un determinado numero y tipo de pregunta

    private int cQuestions;
    private boolean cHardcore;
    private boolean cVideo;
    private boolean cSound;

    //Estas variables serán utilizadas para mostrar un determinado numero y tipo de pregunta

    private ArrayList<Preguntas.Pregunta> mQuestionsList;
    private int mCurrentPosition = 0;
    private ArrayList<Integer> mCorrect_answer;
    private int mCorrectAnswers = 0;
    private int mWrongAnswers;
    private int mScore = 0;
    private int mCurrent_question=1;
    private int mTotal_questions;

    private TextView TVQuestion;
    private TextView TVPosition;
    private TextView TVCorrect_Incorrect;
    private ImageView TVImage;
    private VideoView TVVideo;
    private Button TVAns1;
    private Button TVAns2;
    private Button TVAns3;
    private Button TVAns4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_activity);
        View v = findViewById(android.R.id.content);

        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        //Estas variables serán utilizadas para mostrar un determinado numero y tipo de pregunta
        //Estas variables se modifican en el activity config

        cQuestions = SharedPrefs.getInt(this, "numberQuestions",5);
        cHardcore = SharedPrefs.getBoolean(this, "hardcore",false);
        cVideo = SharedPrefs.getBoolean(this, "video",true);
        cSound = SharedPrefs.getBoolean(this, "sound",true);

        //Estas variables serán utilizadas para mostrar un determinado numero y tipo de pregunta

        TVPosition = v.findViewById(R.id.questions_pos);
        TVCorrect_Incorrect = v.findViewById(R.id.C_W);
        TVQuestion = v.findViewById(R.id.q_question);
        TVImage = v.findViewById(R.id.q_image);
        TVAns1 = v.findViewById(R.id.q_AnswOne);
        TVAns2 = v.findViewById(R.id.q_AnswTwo);
        TVAns3 = v.findViewById(R.id.q_AnswThree);
        TVAns4 = v.findViewById(R.id.q_AnswFour);

        mQuestionsList = Preguntas.getQuestions();
        mTotal_questions = mQuestionsList.size();

        Collections.shuffle(mQuestionsList);

        setQuestion();
    }

    public void checkAnswer(View view){

        ArrayList<Integer> AnswerChecked= new ArrayList<>();
        //Hago 4 if porque no me deja hacerlo con un switch
        if (view.getId()== TVAns1.getId()) AnswerChecked.add(1);
        else if (view.getId()== TVAns2.getId()) AnswerChecked.add(2);
        else if (view.getId()== TVAns3.getId()) AnswerChecked.add(3);
        else if (view.getId()== TVAns4.getId()) AnswerChecked.add(4);

        if (mCorrect_answer.equals(AnswerChecked)) {
            mScore+=3;
            mCorrectAnswers++;
            Toast.makeText(this, "CORRECTO", Toast.LENGTH_SHORT).show();
        } else {
            mScore-=2;
            mWrongAnswers++;
            Toast.makeText(this, "INCORRECTO", Toast.LENGTH_SHORT).show();
            if(cHardcore){
                Intent intent = new Intent(this, EndActivity.class);
                intent.putExtra("totalQuestions", mCurrentPosition);
                intent.putExtra("correctAnswers", mCorrectAnswers);
                intent.putExtra("wrongAnsewers", mWrongAnswers);
                intent.putExtra("score", mScore);
                startActivity(intent);
                finish();
            }
        }
        if (mCurrent_question-1 < cQuestions) {
            mCurrentPosition++;
            mCurrent_question++;
            setQuestion();
        } else {
            Intent intent = new Intent(this, EndActivity.class);
            intent.putExtra("totalQuestions", mTotal_questions);
            intent.putExtra("correctAnswers", mCorrectAnswers);
            intent.putExtra("wrongAnsewers", mWrongAnswers);
            intent.putExtra("score", mScore);
            startActivity(intent);
            finish();
        }

    }

    @SuppressLint("SetTextI18n")
    private void setQuestion() {

        TVPosition.setText("Pregunta: "+ mCurrent_question + "/" + cQuestions);
        TVCorrect_Incorrect.setText("Correctas: " + mCorrectAnswers + " - Fallidas:" + (mWrongAnswers));

        Preguntas.Pregunta question = mQuestionsList.get(mCurrentPosition);

        if(!cSound && !cVideo){
            while (question.type == 2 || question.type == 3 ){
                mCurrentPosition++;
                question = mQuestionsList.get(mCurrentPosition);
            }
        }
        if(!cSound){
            while (question.type == 2 ){
                mCurrentPosition++;
                question = mQuestionsList.get(mCurrentPosition);
            }
        }
        if(!cVideo){
            while (question.type == 3 ){
                mCurrentPosition++;
                question = mQuestionsList.get(mCurrentPosition);
            }
        }

        TVQuestion.setText(question.question);
        mCorrect_answer = question.AnsCorrect;


        if(mCorrect_answer.size()>1){

        }
        if(question.type == 1){
            TVImage.setImageResource(question.image);
            TVImage.setVisibility(View.VISIBLE);
        }
        else{
            TVImage.setVisibility(View.GONE);
        }
        if(question.type == 2){
            //TVAudio.setAudioResource(question.audio);
            //TVAudio.setActivated(true);
        }
        else{
            //TVAudio.setActivated(false);
        }
        if(question.type == 3){
            //TVVideo.setMediaController();
            //TVVideo.setActivated(true);
        }
        else{
            //TVVideo.setActivated(false);
        }
        if(question.type == 4){
            TVAns1.setActivated(false);
            TVAns2.setActivated(false);
            TVAns3.setActivated(false);
            TVAns4.setActivated(false);
        }
        else{
            TVAns1.setText(question.AnsOne);
            TVAns2.setText(question.AnsTwo);
            TVAns3.setText(question.AnsThree);
            TVAns4.setText(question.AnsFour);
            TVAns1.setActivated(true);
            TVAns2.setActivated(true);
            TVAns3.setActivated(true);
            TVAns4.setActivated(true);
        }

    }

    public void optionsSelected(View view){
        Intent i = new Intent(this, Config.class);
        i.putExtra("prevActivity", "QuestionsActivity.class");
        startActivity(i);
        finish();
    }
}