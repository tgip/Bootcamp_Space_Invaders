package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ImageStar {
    int posX;
    int posY;
    Picture picStar;


    public ImageStar(int x, int y) {
            this.posX=x;
            this.posY=y;
            picStar = new Picture(x,y,"resources/images/Star.png");
            picStar.draw();
    }


    //public void hide(){
     //   picStar.delete();
    //}

    public void move(){
        picStar.translate(0,-10);
        posY-=10;
        if(posY<=20){
            picStar.delete();
        }
    }

    public int getPosY() {
        return posY;
    }
}
