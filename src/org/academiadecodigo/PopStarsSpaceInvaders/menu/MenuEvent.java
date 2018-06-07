package org.academiadecodigo.PopStarsSpaceInvaders.menu;

import org.academiadecodigo.PopStarsSpaceInvaders.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuEvent {
    private Picture mainMenu;
    private Picture tutorial;
    private Picture credits;
    private Sound menu;

    public MenuEvent() {
        this.mainMenu = new Picture(0, 0, "resources/images/menu/main_menu.png");
        this.tutorial = new Picture(0, 0, "resources/images/menu/tutorial.png");
        this.credits = new Picture(0, 0, "resources/images/menu/credits.png");
    }

    public void killSoundMenu() {
        menu.stop();
    }

    public void soundMenu() {
        menu = new Sound("/resources/sounds/MN84Theme.wav");
        menu.setLoop(5);
        menu.play(true);
    }

    public void tutorial() {
        tutorial.draw();
    }

    public void removeTutorial() {
        tutorial.delete();
    }

    public void credits() {
        credits.draw();
    }

    public void removeCredits() {
        credits.delete();
    }

    public void mainMenu() {
        mainMenu.draw();
    }

    public void removeMenu() {
        mainMenu.delete();
    }
}


