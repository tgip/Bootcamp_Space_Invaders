package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ImageStar {
    int posX;
    int posY;
    Picture picStar;


    public ImageStar(int x, int y) {
            this.posX=x;
            this.posY=y;
            picStar = new Picture(x, y, "resources/images/Star.png");
            picStar.draw();
    }


    public void hide(){
        picStar.delete();
    }

    public void move(){
        picStar.translate(0,-10);
        posY-=1;
        if(posY<=10){
            hide();
        }
    }
}
