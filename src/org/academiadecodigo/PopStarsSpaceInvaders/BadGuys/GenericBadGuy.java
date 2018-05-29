package org.academiadecodigo.PopStarsSpaceInvaders.BadGuys;

import Objects.Direction;
import Objects.Image;
import org.academiadecodigo.PopStarsSpaceInvaders.Direction;

public abstract class GenericBadGuy {
        private int health = 10;
        private int speed = 10;
        private boolean isDead;
        private static BadGuysTypes type;
        private Direction direction = null;

        /**
         * Constructor for Generic BadGuy
         * */

        public GenericBadGuy(){
            this.direction = direction;
            this.speed = speed;
        }
    /**
     * Methods for BadGuys
     * */

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    /*public Image getImage() {
        return image;
    }
 */
    public boolean getisDead() {
        return isDead;
    }

    public void kill() {isDead = true;}

    public Direction getDirection() {
        return direction;
    }

    public Direction setDirection () {

    }

    public void move(){
        if (!this.getisDead()) {
            switch (this.getDirection()){
                /* change direction if we hit a wall */
                case UP:
                    if ((this.getPos().getRow() - 1) == 0) {
                        this.setPos(this.getPos().getCol(),0);
                        this.setDirection(Direction.values()[((int) (Math.random()* Direction.values().length))]);
                    }else{
                        this.setPos(this.getPos().getCol(), (this.getPos().getRow() - 1));
                    }
                    break;
                case DOWN:
                    if ((this.getPos().getRow() + 1) == Field.getHeight()) {
                        this.setPos(this.getPos().getCol(),Field.getHeight());
                        this.setDirection(Direction.values()[((int) (Math.random()* Direction.values().length))]);
                    }else{
                        this.setPos(this.getPos().getCol(),(this.getPos().getRow() + 1));
                    }
                    break;
                case RIGHT:
                    if ((this.getPos().getCol() - 1) == 0) {
                        this.setPos(0,this.getPos().getCol());
                        this.setDirection(Direction.values()[((int) (Math.random()* Direction.values().length))]);
                    } else {
                        this.setPos((this.getPos().getCol() - 1),0);
                    }
                    break;
                case LEFT:
                    if ((this.getPos().getCol() + 1) == Field.getWidth()) {
                        this.setPos(Field.getWidth(),this.getPos().getCol());
                        this.setDirection(Direction.values()[((int) (Math.random()* Direction.values().length))]);
                    }else{
                        this.setPos((this.getPos().getCol() + 1),this.getPos().getRow());
                    }
                    break;
            }
        }
    }
}
