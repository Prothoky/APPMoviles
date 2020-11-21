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

        answerCorrect = new ArrayList<>();
        answerCorrect.add(2);
        Pregunta P_6 = new Pregunta(
                6, App.getResourcesStatic().getString(R.string.Q_6), App.getResourcesStatic().getString(R.string.AW1_6), App.getResourcesStatic().getString(R.string.AW2_6),App.getResourcesStatic().getString(R.string.AW3_6), App.getResourcesStatic().getString(R.string.AW4_6), answerCorrect
        );
        questionList.add(P_6);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(2);
        answerCorrect.add(3);
        answerCorrect.add(4);
        Pregunta P_7 = new Pregunta(
                7, App.getResourcesStatic().getString(R.string.Q_7), App.getResourcesStatic().getString(R.string.AW1_7),App.getResourcesStatic().getString(R.string.AW2_7), App.getResourcesStatic().getString(R.string.AW3_7),App.getResourcesStatic().getString(R.string.AW4_7),  answerCorrect
        );
        questionList.add(P_7);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(1);
        answerCorrect.add(2);
        Pregunta P_8 = new Pregunta(
                8, App.getResourcesStatic().getString(R.string.Q_8), App.getResourcesStatic().getString(R.string.AW1_8),App.getResourcesStatic().getString(R.string.AW2_8), App.getResourcesStatic().getString(R.string.AW3_8),App.getResourcesStatic().getString(R.string.AW4_8),  answerCorrect
        );
        questionList.add(P_8);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(3);
        Pregunta P_9 = new Pregunta(
                9, 1, R.drawable.image_rebel, App.getResourcesStatic().getString(R.string.Q_9), App.getResourcesStatic().getString(R.string.AW1_9),App.getResourcesStatic().getString(R.string.AW2_9), App.getResourcesStatic().getString(R.string.AW3_9),App.getResourcesStatic().getString(R.string.AW4_9),  answerCorrect
        );
        questionList.add(P_9);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(4);
        Pregunta P_10 = new Pregunta(
                10, 1, R.drawable.image_boba, App.getResourcesStatic().getString(R.string.Q_10), App.getResourcesStatic().getString(R.string.AW1_10),App.getResourcesStatic().getString(R.string.AW2_10), App.getResourcesStatic().getString(R.string.AW3_10),App.getResourcesStatic().getString(R.string.AW4_10),  answerCorrect
        );
        questionList.add(P_10);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(1);
        answerCorrect.add(2);
        Pregunta P_11 = new Pregunta(
                11, App.getResourcesStatic().getString(R.string.Q_11), App.getResourcesStatic().getString(R.string.AW1_11),App.getResourcesStatic().getString(R.string.AW2_11), App.getResourcesStatic().getString(R.string.AW3_11),App.getResourcesStatic().getString(R.string.AW4_11),  answerCorrect
        );
        questionList.add(P_11);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(3);
        answerCorrect.add(4);
        Pregunta P_12 = new Pregunta(
                12, App.getResourcesStatic().getString(R.string.Q_12), App.getResourcesStatic().getString(R.string.AW1_12),App.getResourcesStatic().getString(R.string.AW2_12), App.getResourcesStatic().getString(R.string.AW3_12),App.getResourcesStatic().getString(R.string.AW4_12),  answerCorrect
        );
        questionList.add(P_12);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(4);
        Pregunta P_13 = new Pregunta(
                13, App.getResourcesStatic().getString(R.string.Q_13), App.getResourcesStatic().getString(R.string.AW1_13),App.getResourcesStatic().getString(R.string.AW2_13), App.getResourcesStatic().getString(R.string.AW3_13),App.getResourcesStatic().getString(R.string.AW4_13),  answerCorrect
        );
        questionList.add(P_13);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(1);
        answerCorrect.add(2);
        answerCorrect.add(3);
        Pregunta P_14 = new Pregunta(
                14, App.getResourcesStatic().getString(R.string.Q_14), App.getResourcesStatic().getString(R.string.AW1_14),App.getResourcesStatic().getString(R.string.AW2_14), App.getResourcesStatic().getString(R.string.AW3_14),App.getResourcesStatic().getString(R.string.AW4_14),  answerCorrect
        );
        questionList.add(P_14);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(2);
        Pregunta P_15 = new Pregunta(
                15, App.getResourcesStatic().getString(R.string.Q_15), App.getResourcesStatic().getString(R.string.AW1_15),App.getResourcesStatic().getString(R.string.AW2_15), App.getResourcesStatic().getString(R.string.AW3_15),App.getResourcesStatic().getString(R.string.AW4_15),  answerCorrect
        );
        questionList.add(P_15);

        // MULTIMEDIA
        /*
        answerCorrect = new ArrayList<>();
        answerCorrect.add(1);
        Pregunta P_16 = new Pregunta(
                16, 3, R.raw.video_father, App.getResourcesStatic().getString(R.string.Q_16), App.getResourcesStatic().getString(R.string.AW1_16),App.getResourcesStatic().getString(R.string.AW2_16), App.getResourcesStatic().getString(R.string.AW3_16),App.getResourcesStatic().getString(R.string.AW4_16),  answerCorrect
        );
        questionList.add(P_16);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(4);
        Pregunta P_17 = new Pregunta(
                17, 3, R.raw.video_jabba, App.getResourcesStatic().getString(R.string.Q_17), App.getResourcesStatic().getString(R.string.AW1_17),App.getResourcesStatic().getString(R.string.AW2_17), App.getResourcesStatic().getString(R.string.AW3_17),App.getResourcesStatic().getString(R.string.AW4_17),  answerCorrect
        );
        questionList.add(P_17);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(1);
        answerCorrect.add(3);
        Pregunta P_18 = new Pregunta(
                18, 3, R.raw.video_jedi, App.getResourcesStatic().getString(R.string.Q_18), App.getResourcesStatic().getString(R.string.AW1_18),App.getResourcesStatic().getString(R.string.AW2_18), App.getResourcesStatic().getString(R.string.AW3_18),App.getResourcesStatic().getString(R.string.AW4_18),  answerCorrect
        );
        questionList.add(P_18);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(3);
        Pregunta P_19 = new Pregunta(
                19, 3, R.raw.video_naboo, App.getResourcesStatic().getString(R.string.Q_19), App.getResourcesStatic().getString(R.string.AW1_19),App.getResourcesStatic().getString(R.string.AW2_19), App.getResourcesStatic().getString(R.string.AW3_19),App.getResourcesStatic().getString(R.string.AW4_19),  answerCorrect
        );
        questionList.add(P_19);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(4);
        Pregunta P_20 = new Pregunta(
                20, 3, R.raw.video_pod, App.getResourcesStatic().getString(R.string.Q_20), App.getResourcesStatic().getString(R.string.AW1_20),App.getResourcesStatic().getString(R.string.AW2_20), App.getResourcesStatic().getString(R.string.AW3_20),App.getResourcesStatic().getString(R.string.AW4_20),  answerCorrect
        );
        questionList.add(P_20);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(1);
        Pregunta P_21 = new Pregunta(
                21, 2, R.raw.audio_imperial, App.getResourcesStatic().getString(R.string.Q_21), App.getResourcesStatic().getString(R.string.AW1_21),App.getResourcesStatic().getString(R.string.AW2_21), App.getResourcesStatic().getString(R.string.AW3_21),App.getResourcesStatic().getString(R.string.AW4_21),  answerCorrect
        );
        questionList.add(P_21);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(3);
        Pregunta P_22 = new Pregunta(
                22, 2, R.raw.audio_intro, App.getResourcesStatic().getString(R.string.Q_22), App.getResourcesStatic().getString(R.string.AW1_22),App.getResourcesStatic().getString(R.string.AW2_22), App.getResourcesStatic().getString(R.string.AW3_22),App.getResourcesStatic().getString(R.string.AW4_22),  answerCorrect
        );
        questionList.add(P_22);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(2);
        Pregunta P_23 = new Pregunta(
                23, 2, R.raw.audio_jawa, App.getResourcesStatic().getString(R.string.Q_23), App.getResourcesStatic().getString(R.string.AW1_23),App.getResourcesStatic().getString(R.string.AW2_23), App.getResourcesStatic().getString(R.string.AW3_23),App.getResourcesStatic().getString(R.string.AW4_23),  answerCorrect
        );
        questionList.add(P_23);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(1);
        Pregunta P_24 = new Pregunta(
                24, 2, R.raw.audio_lightsaber, App.getResourcesStatic().getString(R.string.Q_24), App.getResourcesStatic().getString(R.string.AW1_24),App.getResourcesStatic().getString(R.string.AW2_24), App.getResourcesStatic().getString(R.string.AW3_24),App.getResourcesStatic().getString(R.string.AW4_24),  answerCorrect
        );
        questionList.add(P_24);

        answerCorrect = new ArrayList<>();
        answerCorrect.add(1);
        Pregunta P_25 = new Pregunta(
                25, 2, R.raw.audio_r2d2, App.getResourcesStatic().getString(R.string.Q_25), App.getResourcesStatic().getString(R.string.AW1_25),App.getResourcesStatic().getString(R.string.AW2_25), App.getResourcesStatic().getString(R.string.AW3_25),App.getResourcesStatic().getString(R.string.AW4_25),  answerCorrect
        );
        questionList.add(P_25);
        */
        // FIN PREGUNTAS MULTIMEDIA

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





