package org.academiadecodigo.PopStarsSpaceInvaders.BadGuys;

public class BadGuysFactory {
    private GenericBadGuy genericBadGuy;


    public static GenericBadGuy BadGuysFactory(){
        return new BadGuy01();
    }
}
