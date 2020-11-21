package com.example.frikial20;

import java.util.ArrayList;

public class Preguntas {

    static ArrayList<Pregunta> getQuestions(){
        ArrayList<Pregunta> questionList = new ArrayList<>();
        ArrayList<Integer> answerCorrect = new ArrayList<>();
        /*Pregunta P_Ejemplo = new Pregunta(
                -1, App.getResourcesStatic().getString(R.string.Q_1),R.drawable.image_q-1,,App.getResourcesStatic().getString(R.string.AW1_1), App.getResourcesStatic().getString(R.string.AW2_1),App.getResourcesStatic().getString(R.string.AW3_1), App.getResourcesStatic().getString(R.string.AW4_1), 1
        );
        */
        answerCorrect = new ArrayList<>();
        answerCorrect.add(1);
        Pregunta P_1 = new Pregunta(
                1, App.getResourcesStatic().getString(R.string.Q_1),App.getResourcesStatic().getString(R.string.AW1_1), App.getResourcesStatic().getString(R.string.AW2_1),App.getResourcesStatic().getString(R.string.AW3_1), App.getResourcesStatic().getString(R.string.AW4_1),answerCorrect
        );
        questionList.add(P_1);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(3);
        Pregunta P_2 = new Pregunta(
                2, App.getResourcesStatic().getString(R.string.Q_2), App.getResourcesStatic().getString(R.string.AW1_2), App.getResourcesStatic().getString(R.string.AW2_2), App.getResourcesStatic().getString(R.string.AW3_2), App.getResourcesStatic().getString(R.string.AW4_2),answerCorrect
        );
        questionList.add(P_2);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(4);
        Pregunta P_3 = new Pregunta(
                3, App.getResourcesStatic().getString(R.string.Q_3), App.getResourcesStatic().getString(R.string.AW2_3),App.getResourcesStatic().getString(R.string.AW3_3), App.getResourcesStatic().getString(R.string.AW4_3), App.getResourcesStatic().getString(R.string.AW1_3),answerCorrect
        );
        questionList.add(P_3);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(2);
        Pregunta P_4 = new Pregunta(
                4, App.getResourcesStatic().getString(R.string.Q_4), App.getResourcesStatic().getString(R.string.AW1_4), App.getResourcesStatic().getString(R.string.AW3_4),App.getResourcesStatic().getString(R.string.AW2_4), App.getResourcesStatic().getString(R.string.AW4_4), answerCorrect
        );
        questionList.add(P_4);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(2);
        Pregunta P_5 = new Pregunta(
                5, 1,R.drawable.image_q5 , App.getResourcesStatic().getString(R.string.Q_5), App.getResourcesStatic().getString(R.string.AW1_5),App.getResourcesStatic().getString(R.string.AW4_5), App.getResourcesStatic().getString(R.string.AW2_5),App.getResourcesStatic().getString(R.string.AW3_5),  answerCorrect
        );
        questionList.add(P_5);


        return  questionList;

    }

    public static class Pregunta {

        int type;
        int id;
        String question;
        int image = -1;
        int video = -1;
        int audio = -1;
        String AnsOne = "";
        String AnsTwo = "";
        String AnsThree = "";
        String AnsFour = "";
        int AnsImgOne = -1;
        int AnsImgTwo = -1;
        int AnsImgThree = -1;
        int AnsImgFour = -1;
        ArrayList<Integer> AnsCorrect;

        public Pregunta(int id, String question, String ansOne, String ansTwo, String ansThree, String ansFour, ArrayList<Integer> ansCorrect) {
            this.id = id;
            this.type = 0 ;
            this.question = question;
            this.AnsOne = ansOne;
            this.AnsTwo = ansTwo;
            this.AnsThree = ansThree;
            this.AnsFour = ansFour;
            this.AnsCorrect = ansCorrect;
        }

        public Pregunta(int id, int type, int media, String question, String ansOne, String ansTwo, String ansThree, String ansFour, ArrayList<Integer> ansCorrect) {

            this.id = id;
            this.type=type;

            switch (type){
                case 1:{
                    this.image = media;
                }
                case 2:{
                    this.audio = media;
                }
                case 3:{
                    this.video = media;
                }
            }
            this.question= question;
            this.AnsOne = ansOne;
            this.AnsTwo = ansTwo;
            this.AnsThree = ansThree;
            this.AnsFour = ansFour;
            this.AnsCorrect = ansCorrect;
        }
    }
}





