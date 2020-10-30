package com.example.frikial20;

import android.content.Context;
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

    private int mCurrentPosition = 1;
    private ArrayList<Preguntas.Pregunta> mQuestionsList = null;

    private int mSelectedOptionPosition =0;
    private int mCorrectAnswers = 0;

    private TextView tv_question;
    private ImageView iv_image;
    private TextView tv_option_two;
    private TextView tv_option_three;
    private TextView tv_option_one;
    private TextView tv_option_four;
    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_activity);
        View v = findViewById(android.R.id.content);

        tv_question = v.findViewById(R.id.tv_question);
        iv_image = v.findViewById(R.id.iv_image);
        tv_option_one = v.findViewById(R.id.tv_option_one);
        tv_option_two = v.findViewById(R.id.tv_option_two);
        tv_option_three = v.findViewById(R.id.tv_option_three);
        tv_option_four = v.findViewById(R.id.tv_option_four);
        btn_submit = v.findViewById(R.id.btn_submit);
        mQuestionsList = Preguntas.getQuestions();

        setQuestion();

    }

    public void checkAnswer(View view) {
        String answer = getResources().getResourceName(view.getId());
        if(answer=="AC") {
            Context context = getApplicationContext();
            CharSequence text = "CORRECTO";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = answer;
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }


    public void comprobacion_Answer(){

        if (mSelectedOptionPosition == 0) {

            mCurrentPosition++;

            if(mCurrentPosition <= mQuestionsList.size())
                    setQuestion();
            else{

                Intent intent = new Intent(this , EndActivity.class);

                intent.putExtra(Preguntas.Correct_Answers, mCorrectAnswers);
                intent.putExtra(Preguntas.Total_Q, mQuestionsList.size());
                startActivity(intent);
                finish();
            }

        } else {
            Preguntas.Pregunta question = mQuestionsList.get(mCurrentPosition - 1);

            // This is to check if the answer is wrong
            if (question.AnswCorrect != mSelectedOptionPosition) {
                //Answer wrong
            }
            else {
                mCorrectAnswers++;
            }

            if (mCurrentPosition == mQuestionsList.size()) {
                btn_submit.setText("FINISH");
            } else {
                btn_submit.setText("GO TO NEXT QUESTION");
            }

            mSelectedOptionPosition = 0;
        }
    }

    /**
     * A function for setting the question to UI components.
     */
    private void setQuestion() {

        Preguntas.Pregunta question = mQuestionsList.get(mCurrentPosition - 1);

        tv_question.setText(question.pregunta);
        iv_image.setImageResource(question.image);
        tv_option_one.setText(question.AnswOne);
        tv_option_two.setText(question.AnswTwo);
        tv_option_three.setText(question.AnswThree);
        tv_option_four.setText(question.AnswFour);
    }

}