package org.academiadecodigo.PopStarsSpaceInvaders.menu;

public class Menu implements Clickable {

    private MenuEvent menuEvent;
    private double mouseX;
    private double mouseY;
    private Buttons play;
    private Buttons tutorial;
    private Buttons credits;
    private Buttons back;
    private boolean startSelection;
    private boolean secondaryMenu;

    public Menu() throws InterruptedException {

        menuEvent = new MenuEvent();

        play = ButtonFactory.getNewButton(ButtonType.PLAY);
        tutorial = ButtonFactory.getNewButton(ButtonType.TUTORIAL);
        credits = ButtonFactory.getNewButton(ButtonType.CREDITS);
        back = ButtonFactory.getNewButton(ButtonType.BACK);
        startSelection = false;
        secondaryMenu = false;
    }

    private double getMouseX() {
        return mouseX;
    }

    private double getMouseY() {
        return mouseY;
    }

    public void selection() throws InterruptedException {

        menuEvent.soundMenu();
        menuEvent.mainMenuLoop(5);

        while (!startSelection) {
            Thread.sleep(1);
            if (secondaryMenu) {
                System.out.println("In Secondary Menu ...");
                if ((getMouseX() >= back.getStartX() && getMouseX() <= back.getEndX()) &&
                        (getMouseY() >= back.getStartY() && getMouseY() <= back.getEndY())) {
                    System.out.println("Clicked on back");
                    menuEvent.removeCredits();
                    menuEvent.removeTutorial();
                    Thread.sleep(200);
                    secondaryMenu = false;
                    mainMenu();
                }
            }

            /*
             * If the player presses start
             */
            if ((getMouseX() >= play.getStartX() && getMouseX() <= play.getEndX()) &&
                    (getMouseY() >= play.getStartY() && getMouseY() <= play.getEndY())) {
                menuEvent.killSoundMenu();
                startSelection = true;
                System.out.println("Clicked on start");
            }
            /*
             * If the the Tutorial submenu is selected
             */
            if ((mouseX >= tutorial.getStartX() && mouseX <= tutorial.getEndX()) &&
                    (mouseY >= tutorial.getStartY() && mouseY <= tutorial.getEndY())) {
                secondaryMenu = true;
                tutorial();
                menuEvent.removeTutorial();
                System.out.println("Clicked on tutorial");
            }
            /*
             * If the Credits submenu is selected
             */
            if ((mouseX >= credits.getStartX() && mouseX <= credits.getEndX()) &&
                    (mouseY >= credits.getStartY() && mouseY <= credits.getEndY())) {
                secondaryMenu = true;
                credits();
                menuEvent.removeCredits();
                System.out.println("Clicked on credits");
            }
        }
    }

    private void tutorial() { menuEvent.tutorial(); }

    private void credits() { menuEvent.credits(); }

    private void mainMenu() throws InterruptedException{ menuEvent.mainMenuLoop(5);
    }

    public void setX(double mouseX) {
        this.mouseX = mouseX;
    }

    public void setY(double mouseY) {
        this.mouseY = mouseY;
    }
}
