package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;
import org.academiadecodigo.PopStarsSpaceInvaders.Direction;
import org.academiadecodigo.PopStarsSpaceInvaders.Sound;

public class Shot extends GameObject {

    private static final Sound sound = new Sound("/resources/sounds/LaserShot.wav");
    private boolean isDead;
    private int health;
    private Direction direction;
    private double posX;
    private double posY;
    private int level;

    public Shot(double originX, double originY) {
        super(0, 0, "resources/images/potato.png");
        posY = originY;
        posX = originX;
        sound.play(true);
        picture.translate(originX, originY);
        show();
    }

    public void move() {
        if (posY > 10) {
            picture.translate(0, -20 - (level));
            setPosY(getPosY() - 20 - (level));
        } else {
            hide();
        }
    }

    @Override
    public void destroy(GameObject target) {
        target.hit();
        target.hide();
    }

    @Override
    public boolean isDestroyed() {
        return isDead;
    }

    @Override
    public void hit() {
        isDead = true;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setLevelt(int a) {
        level += a;
    }

    public void setDirection(Direction direction) {
        this.direction = Direction.UP;
    }
}
