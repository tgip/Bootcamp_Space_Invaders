package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.ImageStar;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.GenericBadGuy;

import java.util.LinkedList;
import java.util.List;

public class CollisionDetector {

    private Player player;
    private GenericBadGuy[] badGuys;
    private final List<Shot> shots;
    private ImageStar starImage;
    private LinkedList<ImageStar> arrayStars = new LinkedList<>();
    private int points;

    public CollisionDetector(Player player, GenericBadGuy[] badGuys) {
        this.player = player;
        this.badGuys = badGuys;
        this.shots = new LinkedList<>();
    }

    public void addShot(Shot shot) {
        synchronized (shots) {
            shots.add(shot);
        }
    }

    public void collide() {
        moveStars();
        for (GenericBadGuy badGuy : badGuys) {
            if (badGuy.isDestroyed()) {
                continue;
            }
            if (player.overlaps(badGuy)|| badGuy.getPosY() > (Config.BOARD_HEIGHT - Config.playerIcon_HEIGHT*2)) {
                player.hit();
            }
            synchronized (shots) {

                for (Shot shot : shots) {
                    if (shot.overlaps(badGuy) || badGuy.overlaps(shot)) {
                        shots.remove(shot);
                        badGuy.hit();
                        points+=150;
                        ImageStar aStar = new ImageStar(badGuy.getPosX(), badGuy.getPosY());
                        addStar(aStar);
                        break;
                    }
                }
            }
        }
    }

    private void reset(GenericBadGuy[] badGuys) {
        this.badGuys = badGuys;
        synchronized (shots) {
            shots.clear();
        }
    }

    private void moveStars() {
        for (ImageStar eachStar : arrayStars){
            if (eachStar != null){
                eachStar.move();
            }
        }
    }

    private void addStar(ImageStar star) {
        arrayStars.add(star);
    }

    private int getPoints() {
        return points;
    }

    private void setPoints(int points) {
        this.points = points;
    }
}