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
            "Pedrof",
            "Pedrov",
            "Ruben",
            "Seringas",
            "Teresa"
    };
    public static String get() {
        return ("resources/images/round/"+imageNames[(int) (Math.random() * imageNames.length)]+".png");
    }

    public static String badGuy02() {
        return ("resources/images/round/"+imageNames[(int) (Math.random() * imageNames.length)]+".png");
    }
}
