package com.example.frikial20;

import java.util.ArrayList;

public class Preguntas {

    public static String Total_Q="total_questions";
    public static String Correct_Answers="correct_answers";

    static ArrayList<Pregunta> getQuestions(){
        ArrayList<Pregunta> questionList = new ArrayList<Pregunta>();
        /*Pregunta P_Ejemplo = new Pregunta(
                -1, App.getResourcesStatic().getString(R.string.Q_1),R.drawable.image_q-1,,App.getResourcesStatic().getString(R.string.AW1_1), App.getResourcesStatic().getString(R.string.AW2_1),App.getResourcesStatic().getString(R.string.AW3_1), App.getResourcesStatic().getString(R.string.AW4_1), 1
        );
        */
        Pregunta P_1 = new Pregunta(
                1, App.getResourcesStatic().getString(R.string.Q_1),0,App.getResourcesStatic().getString(R.string.AW1_1), App.getResourcesStatic().getString(R.string.AW2_1),App.getResourcesStatic().getString(R.string.AW3_1), App.getResourcesStatic().getString(R.string.AW4_1), 1
        );
        questionList.add(P_1);
        Pregunta P_2 = new Pregunta(
                2, App.getResourcesStatic().getString(R.string.Q_2),0,App.getResourcesStatic().getString(R.string.AW1_2), App.getResourcesStatic().getString(R.string.AW2_2),App.getResourcesStatic().getString(R.string.AW3_2), App.getResourcesStatic().getString(R.string.AW4_2), 3
        );
        questionList.add(P_2);
        Pregunta P_3 = new Pregunta(
                3, App.getResourcesStatic().getString(R.string.Q_3),0, App.getResourcesStatic().getString(R.string.AW2_3),App.getResourcesStatic().getString(R.string.AW3_3), App.getResourcesStatic().getString(R.string.AW4_3), App.getResourcesStatic().getString(R.string.AW1_3),4
        );
        questionList.add(P_3);
        Pregunta P_4 = new Pregunta(
                4, App.getResourcesStatic().getString(R.string.Q_4),0, App.getResourcesStatic().getString(R.string.AW1_4), App.getResourcesStatic().getString(R.string.AW3_4),App.getResourcesStatic().getString(R.string.AW2_4), App.getResourcesStatic().getString(R.string.AW4_4), 2
        );
        questionList.add(P_4);
        Pregunta P_5 = new Pregunta(
                5, App.getResourcesStatic().getString(R.string.Q_5),R.drawable.image_q5 , App.getResourcesStatic().getString(R.string.AW1_5),App.getResourcesStatic().getString(R.string.AW4_5), App.getResourcesStatic().getString(R.string.AW2_5),App.getResourcesStatic().getString(R.string.AW3_5),  2
        );
        questionList.add(P_5);


        return  questionList;

    }

    public static class Pregunta {

        int id;
        String question;
        int image;
        String AnsOne;
        String AnsTwo;
        String AnsThree;
        String AnsFour;
        int AnsCorrect;

        public Pregunta(int id, String question, int image, String ansOne, String ansTwo, String ansThree, String ansFour, int ansCorrect) {
            this.id = id;
            this.question = question;
            this.image = image;
            AnsOne = ansOne;
            AnsTwo = ansTwo;
            AnsThree = ansThree;
            AnsFour = ansFour;
            AnsCorrect = ansCorrect;
        }
    }
}





