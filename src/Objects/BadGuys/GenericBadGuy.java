package Objects.BadGuys;

import Objects.Direction;
import Objects.Image;
import Objects.Position;

public abstract class GenericBadGuy {
        private int health = 10;
        private int speed = 10;
        private boolean isDead;
        private Image image = null;
        private static BadGuysTypes type;
        private Position position = new Position(0,0);

        /**
         * Constructor for Generic BadGuy
         * */

        public GenericBadGuy(){
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

    public Image getImage() {
        return image;
    }

    public boolean getisDead() {
        return isDead;
    }

    public void kill() {isDead = true;}


    public void move(Direction direction){
        this.position = Position(0,0);

    }
}
