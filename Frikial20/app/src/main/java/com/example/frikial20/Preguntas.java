package com.example.frikial20;

import java.util.ArrayList;

public class Preguntas {

    public static String Total_Q="total_questions";
    public static String Correct_Answers="correct_answers";

    static ArrayList<Pregunta> getQuestions(){
        ArrayList<Pregunta> questionList = new ArrayList<Pregunta>();

        Pregunta P_1 = new Pregunta(
                1,"¿Qué personaje es el que tiene un jetpack y es capaz de dar saltos a gran altura?",0,"Boba Fett", "Darth Vader","Luke Skywalker", "Angelina Jolie", 1
        );
        questionList.add(P_1);


        return  questionList;

    }

    public static class Pregunta {

        int id = 0;
        String pregunta = "";
        int image = 0;
        String AnswOne = "";
        String AnswTwo = "";
        String AnswThree = "";
        String AnswFour = "";
        int AnswCorrect = 0;

        public Pregunta(int id, String pregunta, int image, String answOne, String answTwo, String answThree, String answFour, int answCorrect) {
            this.id = id;
            this.pregunta = pregunta;
            this.image = image;
            AnswOne = answOne;
            AnswTwo = answTwo;
            AnswThree = answThree;
            AnswFour = answFour;
            AnswCorrect = answCorrect;
        }
    }
}





