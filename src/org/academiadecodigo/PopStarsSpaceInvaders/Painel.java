package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Painel {

    private String toString;
    private Rectangle rectangle;
    private Text score;
    private int points;
    private Text level;
    private String toString2;


    public Painel() {
        rectangle = new Rectangle(Config.PADDING, Config.PADDING, 200, 50);
        rectangle.setColor(Color.WHITE);
        rectangle.draw();
        this.score = new Text(Config.PADDING * 4, Config.PADDING * 4, "0");
        score.setColor(Color.WHITE);
        score.grow(10, 10);
        score.draw();
        level=new Text(Config.PADDING * 9, Config.PADDING * 9, "1");
        level.setColor(Color.RED);
        level.grow(10, 10);
        level.draw();


    }


    public void addPoint(int points) {
        toString = Integer.toString(points);
        score.delete();
        score = new Text(Config.PADDING * 4, Config.PADDING * 4, toString);
        score.setColor(Color.WHITE);
        score.grow(10, 10);
        score.draw();


    }

    public void addLevel(int levelUp){
        toString2 = Integer.toString(levelUp);
        level.delete();
        level = new Text(Config.PADDING * 9, Config.PADDING * 9, toString2);
        level.setColor(Color.RED);
        level.grow(10, 10);
        level.draw();


    }
}










