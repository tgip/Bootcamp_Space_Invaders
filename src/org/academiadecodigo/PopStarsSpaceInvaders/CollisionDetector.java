package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.ImageStar;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Shot;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.GenericBadGuy;

import java.util.LinkedList;
import java.util.List;

public class CollisionDetector {
    private Player player;
    private int points;
    private ImageStar starImage;
    private GenericBadGuy[] badGuys;
    public List<Shot> shots = new LinkedList<>();
    private LinkedList<ImageStar> arrayStars = new LinkedList<>();

    public CollisionDetector(Player player, GenericBadGuy[] badGuys) {
        this.player = player;
        this.badGuys = badGuys;
        this.shots = new LinkedList<>();
    }

    public void addShot(Shot shot) {
        synchronized (shots) {
            if (shots.size() < (player.getPlayerLevel() * 20)) {
                shots.add(shot);
            }
        }
    }

    public void removeShot(Shot shot) {
        shots.remove(shot);
    }

    public void collide() {
        moveStars();
        for (GenericBadGuy badGuy : badGuys) {
            if (badGuy.isDestroyed()) {
                continue;
            }

            if (player.overlaps(badGuy) || badGuy.getPosY() > (Config.BOARD_HEIGHT - Config.playerIcon_HEIGHT * 2)) {
                player.hit();
            }

            synchronized (shots) {
                for (Shot shot : shots) {
                    if (shot.overlaps(badGuy) || badGuy.overlaps(shot)) {
                        shots.remove(shot);
                        badGuy.hit();
                        points += 150;
                        ImageStar aStar = new ImageStar(badGuy.getPosX(), badGuy.getPosY());
                        addStar(aStar);
                        break;
                    }
                    if (shot.getPosY() < 5) {
                        shots.remove(shot);
                    }
                }
            }
        }
    }

    public void resetBadguys(GenericBadGuy[] badGuys) {
        this.badGuys = badGuys;
        synchronized (shots) {
            shots.clear();
        }
    }

    public void moveStars() {
        for (ImageStar eachStar : arrayStars) {
            if (eachStar != null) {
                eachStar.move();
            }
        }
    }

    public void moveShots() {
        for (Shot shot : shots) {
            shot.move();
        }
    }

    public void addStar(ImageStar star) {
        arrayStars.add(star);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}