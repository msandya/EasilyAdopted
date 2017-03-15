package com.example.benji.myratp;

import android.support.v7.app.AppCompatActivity;

public class Questions extends AppCompatActivity{

    public String mQuestions[] = {
            "Quel est le fleuve principal de la Norvège ?",
            "Quel est le nom du système d'exploitation mis au point par Google ?",
            "Laquelle de ces barbies n'existent pas ?",
            "Quelle est la planète la plus loin du sytème solaire ?",
            "Quel est le résulat de 4+6*2-1*0 ?",
            "Combien de personnes y a t'il dans la communauté de l'anneau ?",
            "Quel est le nom de la société qui a créé le jeu Pokémon Go ?",
            "Quel footballeur a été élu Ballon d’or 2015 ?",
            "Dans quelle ville s’est tenue la COP22 en novembre 2016 ?",
            "Dans quel pays se sont déroulés les Jeux olympiques d’été 2016 ?"



    };

    private String mChoices[][] = {
            {"Skjern", "Gota alv", "Gloma", "La Seine"},
            {"Chrome", "Chrome OS", "Chrobuntu", "Chro home"},
            {"Barbie caissière au Mcdo", "Barbie secrétaire", "Barbie présidente des USA", "Barbie nutritioniste"},
            {"Jupiter", "Mars","Pluton","Mmercure"},
            {"0", "1", "19", "16"},
            {"11", "13", "10", "9"},
            {"Microsoft", "Konani", "Ubisoft", "Niantic"},
            {"Cristiano Ronaldo", "Neymar", "Lionel Messi", "Thomas Müller"},
            {"Marrakech", "Londres", "Paris", "Toronto"},
            {"En Allemagne", "Au Qatar", "Au Canada", "Au Brésil"}

    };

    private String mCorrectAnswer[]= {
"Gloma", "Chrome OS", "Barbie nutritioniste","Pluton","16","10","Niantic","Lionel Messi",
"Marrakech","Au Brésil"
    };

    public String getQuestion (int a) {
        String question = mQuestions[a];

        return question;
    }

    public String  getChoice1(int a) {
        String choice = mChoices[a] [0];
        return choice;

    }

    public String  getChoice2(int a) {
        String choice = mChoices[a] [1];
        return choice;

    }

    public String  getChoice3(int a) {
        String choice = mChoices[a] [2];
        return choice;

    }

    public String  getChoice4(int a) {
        String choice = mChoices[a] [3];
        return choice;

    }
    public String  getChoice5(int a) {
        String choice = mChoices[a] [4];
        return choice;

    }

    public String getmCorrectAnswer(int a) {
        String answer = mCorrectAnswer[a];
        return answer;
    }
}
