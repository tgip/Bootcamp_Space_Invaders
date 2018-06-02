package org.academiadecodigo.PopStarsSpaceInvaders;

import java.util.LinkedList;
import java.util.List;


import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.GenericBadGuy;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.ImageStar;

public class CollisionDetector {

    private Player player;
    private GenericBadGuy[] badGuys;
    private List<Shot> shots;
    private ImageStar starImage;
    private LinkedList<ImageStar> arrayStars = new LinkedList<>();
    public static final Sound sound = new Sound("/resources/sounds/94185__nbs-dark__explosion.wav");


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
                        sound.play(true);
                        shots.remove(shot);
                        badGuy.hit();
                        ImageStar aStar = new ImageStar(badGuy.getPosX(), badGuy.getPosY());
                        addStar(aStar);
                        break;
                    }
                }
            }
        }
    }

    public void reset(GenericBadGuy[] badGuys) {
        this.badGuys = badGuys;
        synchronized (shots) {
            shots.clear();
        }
    }
    public void moveStars(){
        for (ImageStar eachStar : arrayStars){
            if (eachStar != null){
                eachStar.move();
            }
        }
    }

    public void addStar(ImageStar star){
        arrayStars.add(star);
    }

}