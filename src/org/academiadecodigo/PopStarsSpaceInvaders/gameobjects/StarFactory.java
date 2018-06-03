package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StarFactory {

    private static Picture star = new Picture(0,0,"resources/images/Star.png");

    public Picture makeStar(){
        return star;
    }
}
