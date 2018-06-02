package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Painel {

    private String toString;
    private Rectangle rectangle;




    public Painel(){
        rectangle= new Rectangle(Config.PADDING, Config.PADDING, 200,50);
        rectangle.setColor(Color.WHITE);

        rectangle.draw();
        Text score= new Text(Config.PADDING*4,Config.PADDING*4,"SCORE");
        score.setColor(Color.WHITE);
        score.grow(10,10);
        score.draw();


    }
    //toString= Integer.toString(scoreIncrease);





}
