package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

public class GetRndPlayerImg {
    private static String[] imageNames = {
            "antoninho",
            "Rodrigo",
            "Francisco",
            "antoninho1",
            "Francisco1"
    };
    public static String get() {
        return ("resources/images/round/"+imageNames[(int) (Math.random() * imageNames.length)]+".png");
    }

}
