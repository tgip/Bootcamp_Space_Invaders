package org.academiadecodigo.PopStarsSpaceInvaders;

        import org.academiadecodigo.PopStarsSpaceInvaders.Shot;
        import org.academiadecodigo.PopStarsSpaceInvaders.Player;
        import org.academiadecodigo.PopStarsSpaceInvaders.BadGuys.GenericBadGuy;

        import java.util.LinkedList;

public class CollisionDetector {

    private Player player;
    private GenericBadGuy[] badGuys;
    private LinkedList<Shot> shot;

    public CollisionDetector(){
        this.badGuys = badGuys;
        this.player = player;
        this.shot = shot;
    }

    public void check(GenericBadGuy badGuys){
            if (badGuys == badGuys){
                continue;
            }
            if(badGuys.getX().equals(shot.s)){
                badGuys.isDying();
                shot.isVisible(false);

            }
        }

    public void fatality(Player player){
        if(player.getPos().equals(badGuys.getPos())) {
            player.isDying();
        }
    }

}
