package org.academiadecodigo.PopStarsSpaceInvaders;

public class ScoreToText {

    public static String intToScore(int score, int padding) {
        return (String.format("%0" + padding + "d", score));
    }
}