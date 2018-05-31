package org.academiadecodigo.PopStarsSpaceInvaders;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.GenericBadGuy;

public class CollisionDetector {

  private Player player;
  private GenericBadGuy[] badGuys;
  private LinkedList < Shot > arrayofShots;
  private List<GameObject> gameObject;

  public CollisionDetector () {
    this.badGuys = badGuys;
    this.player = player;
    this.arrayofShots = shot;
  }

  public CollisionDetector(GameObject gameObject) {
    arrayofShots = new Vector<GameObject>();
    this.gameObject = gameObject;
  }

  public void add(GameObject gameObject) {
    this.gameObject.add(gameObject);
  }

  public void remove(GameObject gameObject) {
    this.gameObject.remove(gameObject);
  }

  public void collide() {
    for (GameObject object1 : gameObject) {
      if (object1.isDestroyed()) {
        continue;
      }

      for (GameObject object2 : gameObject) {
        if (object2.isDestroyed()) {
          continue;
        }

        if (object1 instanceof Shot && object2 instanceof GenericBadGuy) {
          if (object1.overlaps(object2)) {
            ((Shot) object1).destroy((GenericBadGuy) object2);
          }
        }

        if (object1 instanceof GenericBadGuy && object2 instanceof Player) {
          if (object1.overlaps(object2)) {
            ((Player) object2).hit();
            ((GenericBadGuy) object1).hit();
          }
        }
      }
    }

  }

  public void check (GameObject shot) {
    for(GameObject go : badGuys){
      if(go == shot){
        continue;
      }
      if(go.getX().equals(shot.getX())){
        go.destroy();
        shot.destroy();
      }
    }
  }

}
