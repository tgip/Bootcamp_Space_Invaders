package org.academiadecodigo.PopStarsSpaceInvaders.menu;

import org.academiadecodigo.PopStarsSpaceInvaders.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuEvent {

    private int menuLoops = 5;
    private Picture menuBG;
    private Picture menuBG2;
    private Picture tutorial;
    private Picture credits;
    private Sound menu;


    public MenuEvent() {

        this.menuBG = new Picture(0, 0, "resources/images/menu/menu1.png");
        this.menuBG2 = new Picture(0,0,"resources/images/menu/menu2.png");
        this.tutorial = new Picture(0,0, "resources/images/menu/tutorial.png");
        this.credits = new Picture(0,0, "resources/images/menu/credits.png");
    }

    public void mainMenuLoop(int menuLoops) throws  InterruptedException {

        while (menuLoops > 0) {

           /* menuBG.draw();
            menuBG2.delete();
            Thread.sleep(1500);*/

            menuBG2.draw();
            menuBG.delete();
            Thread.sleep(1500);

            menuBG.draw();
            menuBG2.delete();
            Thread.sleep(1500);

            menuBG2.draw();
            menuBG.delete();
            Thread.sleep(1500);

            menuBG.draw();
            menuBG2.delete();
            Thread.sleep(1500);
            menuLoops--;
        }
    }

    public void killSoundMenu(){ menu.stop(); }

    public void soundMenu(){
        menu = new Sound ("/resources/sounds/MN84Theme.wav");
        menu.setLoop(5);
        menu.play(true);
    }

    public void tutorial() { tutorial.draw(); }

    public void credits() { credits.draw(); }

    public void removeCredits() { credits.delete(); }

    public void removeTutorial() { tutorial.delete(); }
}


