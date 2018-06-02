package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

public class GetRndBadGuyImg {
    private static String[] imageNames = {
            "Adriano",
            "Alexandre",
            "Alfredo",
            "Andre",
            "Barbara",
            "Duarte",
            "Filipe",
            "Gabriela",
            "Humberto",
            "Julio",
            "Luis",
            "Marcolino",
            "mariana",
            "Monica",
            "Nuno",
            "Ruben",
            "Teresa"
    };
    public static String get() {
        return ("resources/images/"+imageNames[(int) (Math.random() * imageNames.length)]+".png");
    }

    public static String badGuy02() {
        return ("resources/images/"+imageNames[(int) (Math.random() * imageNames.length)]+".png");
    }
}
