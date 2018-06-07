package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Painel {

    private Rectangle rectangle;
    private Text scoreText;
    private Text scoreValue;
    private Text levelText;
    private Text levelValue;

    public Painel() {
        rectangle = new Rectangle(Config.PADDING, Config.PADDING, 200, 50);
        rectangle.setColor(Color.MAGENTA);
        rectangle.draw();

        scoreText = new Text(Config.PADDING * 4, Config.PADDING * 4, "Score");
        scoreText.setColor(Color.WHITE);
        scoreText.grow(10, 10);
        scoreText.draw();

        levelText = new Text(Config.PADDING + 450, Config.PADDING * 4, "Level");
        levelText.setColor(Color.WHITE);
        levelText.grow(10, 10);
        levelText.draw();

        this.scoreValue = new Text(Config.PADDING + 100, Config.PADDING + 4, "00");
        scoreValue.setColor(Color.WHITE);
        scoreValue.grow(10, 10);
        scoreValue.draw();

        levelValue = new Text(Config.PADDING + 550, Config.PADDING * 4, "01");
        levelValue.setColor(Color.WHITE);
        levelValue.grow(10, 10);
        levelValue.draw();
    }

    public void addPoint(int points) {
        scoreValue.delete();
        scoreValue = new Text(Config.PADDING * 10, Config.PADDING * 4, ScoreToText.intToScore(points, 9));
        scoreValue.setColor(Color.WHITE);
        scoreValue.grow(10, 10);
        scoreValue.draw();
    }

    public void addLevel(int levelUp) {
        levelValue.delete();
        levelValue = new Text(Config.PADDING + 550, Config.PADDING * 4, ScoreToText.intToScore(levelUp, 2));
        levelValue.setColor(Color.WHITE);
        levelValue.grow(10, 10);
        levelValue.draw();
    }
}