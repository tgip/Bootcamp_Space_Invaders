package org.academiadecodigo.PopStarsSpaceInvaders.menu;

public class Menu implements Clickable {

    private MenuEvent menuEvent;
    private double mouseX;
    private double mouseY;
    private Buttons play;
    private Buttons tutorial;
    private Buttons credits;
    private Buttons back;
    private boolean startSelected;
    private boolean tutorialSelected;
    private boolean ceditsSelected;
    private Cursor cursor;

    public Menu(Cursor cursor) throws InterruptedException {
        this.cursor=cursor;
        menuEvent = new MenuEvent();

        play = ButtonFactory.getNewButton(ButtonType.PLAY);
        tutorial = ButtonFactory.getNewButton(ButtonType.TUTORIAL);
        credits = ButtonFactory.getNewButton(ButtonType.CREDITS);
        back = ButtonFactory.getNewButton(ButtonType.BACK);
        startSelected = false;
        tutorialSelected = false;
        ceditsSelected = false;
    }

    private double getMouseX() {
        return mouseX;
    }

    private double getMouseY() {
        return mouseY;
    }

    public void selection()  {

        menuEvent.soundMenu();
        menuEvent.mainMenu();

        System.out.println(cursor.getPosY()+ " "+ cursor.getPosX());

            if (tutorialSelected) {
                menuEvent.removeMenu();
                menuEvent.tutorial();
                System.out.println("In Secondary Menu ...");
                if ((mouseX >= back.getStartX() && mouseX <= back.getEndX()) &&
                        (mouseY >= back.getStartY() && mouseY <= back.getEndY())) {
                    System.out.println("Clicked on back");
                    menuEvent.removeCredits();
                    menuEvent.removeTutorial();

                    tutorialSelected = false;

                }
            }

            /*
             * If the player presses start
             *

             */

        if (ceditsSelected) {
            menuEvent.removeMenu();
            menuEvent.removeTutorial();
            menuEvent.credits();

            if ((cursor.getPosX() >= play.getStartX() && cursor.getPosX() <= play.getEndX()) &&
                    (cursor.getPosY() >= play.getStartY() && cursor.getPosY() <= play.getEndY())) {
                clearMouse();
                menuEvent.killSoundMenu();
                startSelected = true;
                System.out.println("Clicked on start");
            }
            /*
             * If the the Tutorial submenu is selected
             */
            if ((cursor.getPosY() >= tutorial.getStartX() && cursor.getPosX() <= tutorial.getEndX()) &&
                    (cursor.getPosY() >= tutorial.getStartY() && cursor.getPosY() <= tutorial.getEndY())) {
                clearMouse();
                tutorialSelected = true;

                menuEvent.tutorial();
               // menuEvent.removeTutorial();
                System.out.println("Clicked on tutorial");
            }
            /*
             * If the Credits submenu is selected
             */
            if ((cursor.getPosX() >= credits.getStartX() && cursor.getPosX() <= credits.getEndX()) &&
                    (cursor.getPosY() >= credits.getStartY() && cursor.getPosY() <= credits.getEndY())) {

                tutorialSelected = true;
                //credits();
                menuEvent.removeCredits();
                System.out.println("Clicked on credits");
            }

            System.out.println("Ultima parte");
        }


    private void tutorial() { menuEvent.tutorial(); }

    private void credits() { menuEvent.credits(); }

    private void mainMenu() { menuEvent.mainMenu(); }


    public void setX(double mouseX) {
        this.mouseX = mouseX;
    }

    public void setY(double mouseY) {
        this.mouseY = mouseY;
    }

    public double getX(){
        return mouseX;
    }

    public double getY(){
        return mouseY;
    }

    public void clearMouse(){
        mouseX=0;
        mouseY=0;
    }
}


