package org.academiadecodigo.PopStarsSpaceInvaders;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.GenericBadGuy;

public class CollisionDetector {

    private Player player;
    private GenericBadGuy[] badGuys;
    private List<Shot> shots;
    //private List<GameObject> gameObjects;

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

  /*public void remove(GameObject gameObject) {
    this.gameObjects.remove(gameObject);
  }*/

    public void collide() {

        for (GenericBadGuy badGuy : badGuys) {
            if (badGuy.isDestroyed()) {
                continue;
            }

            if (player.overlaps(badGuy)) {
                player.hit();
                return;
            }

            synchronized (shots) {

                for (Shot shot : shots) {

                    if (shot.overlaps(badGuy) || badGuy.overlaps(shot)) {
                        badGuy.hit();
                        shots.remove(shot);
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
}
