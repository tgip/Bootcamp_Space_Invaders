package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

public class GetRndPlayerImg {
    private static String[] imageNames = {
            "antoninho",
            "antoninho1",
            "Rodrigo",
            "Francisco",
            "Francisco1"
    };
    public static String get() {
        return ("resources/images/"+imageNames[(int) (Math.random() * imageNames.length)]+".png");
    }
}
