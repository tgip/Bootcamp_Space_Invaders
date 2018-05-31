package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.
  GenericBadGuy;

import java.util.LinkedList;

public class CollisionDetector {

  private Player player;
  private GenericBadGuy[] badGuys;
  private LinkedList < Shot > shot;

  public CollisionDetector (
  ) {
    this.badGuys = badGuys;
    this.player = player;
    this.shot = shot;
  } public void check (GenericBadGuy badGuys
  ) {
    /*
     * if (badGuys == badGuys){
     * continue;
     * }
     * for(i = 0; i < badGuys.length; i++){
     * if(badGuys.getPos().equals(shot.getPos())){
     * badGuys.isDying();
     * shot.isVisible(false);
     * 
     * }
     * }
     * 
     * }
     * 
     * public void fatality(Player player){
     * if(player.getPos().equals(badGuys.getPos())) {
     * player.isDying();
     * }
     */
  }

}
