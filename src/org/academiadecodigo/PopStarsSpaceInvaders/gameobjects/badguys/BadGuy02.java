package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.PopStarsSpaceInvaders.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BadGuy02 extends GenericBadGuy  {



        // private Rectangle rectangle;
        private Picture badIcon;
        private int health;
        private Direction direction;
        private int pos_x;
        private int pos_y;
        private boolean isDead;

        // private int gun_pos = 25;
        // private Shot shot;

        public BadGuy02(int pos_x, int pos_y) {
            this.pos_x = pos_x;
            this.pos_y = pos_y;

            badIcon = new Picture(pos_x,pos_y,"resources/images/Adriano.png");
            badIcon.draw();
            isDead=false;

        }


        @Override
        public void hide(){
            badIcon.delete();

        }
        @Override
        public void move(){
            badIcon.translate(0, 10);
            pos_y+=10;
        }

        //public Shot shoot(){
        //    Shot shot = new  Shot(pos_x +gun_pos,pos_y);
        //     return shot;
        // }

        @Override

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        @Override
        public boolean isDead(){
            return isDead;
        }

        @Override
        public int getPos_y(){
            return pos_y;
        }
    }

/**
 * Defines a BadGuy
 * Has Health
 * Has a Speed (increases with skill)
 * can move in Direction
 * can die
 * */


