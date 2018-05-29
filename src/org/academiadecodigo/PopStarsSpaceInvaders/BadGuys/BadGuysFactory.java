package org.academiadecodigo.PopStarsSpaceInvaders.BadGuys;

public class BadGuysFactory {

    private GenericBadGuy genericBadGuy;


    public static GenericBadGuy BadGuysFactory(int x, int y){
        return new BadGuy01(x,y);
    }

}
