package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

public class GetRndBadGuyImg {
    String[] imageNames = {
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
    public String get() {
        return ("resources/images/"+imageNames[(int) (Math.random() * imageNames.length)]+".png");
    }
}
