package org.academiadecodigo.PopStarsSpaceInvaders;

public class ScoreToText {
    String numberAsString = "";
    public static String intToScore(int score){
        return (String.format ("%09d",score));
    }
}