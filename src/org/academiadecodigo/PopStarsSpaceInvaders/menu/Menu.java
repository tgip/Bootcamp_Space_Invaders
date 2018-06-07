package org.academiadecodigo.PopStarsSpaceInvaders.menu;

public class Menu implements Clickable {

    private MenuEvent menuEvent;
    private double mouseX;
    private double mouseY;
    private Buttons play;
    private Buttons tutorial;
    private Buttons credits;
    private Buttons back;
    private Buttons creditsBack;
    private Buttons tutorialStart;
    private Buttons exit;
    private boolean startSelected;
    private boolean tutorialSelected;
    private boolean creditsSelected;
    private boolean mainMenuSelected;
    private Cursor cursor;

    public Menu(Cursor cursor) {
        this.cursor = cursor;
        menuEvent = new MenuEvent();
        tutorialStart = ButtonFactory.getNewButton(ButtonType.TUTORIAL_START);
        play = ButtonFactory.getNewButton(ButtonType.PLAY);
        tutorial = ButtonFactory.getNewButton(ButtonType.TUTORIAL);
        credits = ButtonFactory.getNewButton(ButtonType.CREDITS);
        creditsBack = ButtonFactory.getNewButton(ButtonType.CREDITS_BACK);
        back = ButtonFactory.getNewButton(ButtonType.BACK);
        exit = ButtonFactory.getNewButton(ButtonType.EXIT);
        mainMenuSelected = true;
        startSelected = false;
        tutorialSelected = false;
        creditsSelected = false;
    }

    public void selection() {

        menuEvent.soundMenu();

        while (!startSelected) {
            // selectedMenu = Main / Credits / Tutorial

            if (mainMenuSelected) {
                menuEvent.mainMenu();
                menuEvent.removeCredits();
                menuEvent.removeTutorial();

                if ((cursor.getPosX() >= exit.getStartX() && cursor.getPosX() <= exit.getEndX()) &&
                        (cursor.getPosY() >= exit.getStartY() && cursor.getPosY() <= exit.getEndY())) {
                    System.out.println("Clicked on exit");
                    clearMouse();
                    System.exit(0);
                    // QUIT THE JVM
                }
                if ((cursor.getPosX() >= play.getStartX() && cursor.getPosX() <= play.getEndX()) &&
                        (cursor.getPosY() >= play.getStartY() && cursor.getPosY() <= play.getEndY())) {
                    System.out.println("Clicked on start");
                    clearMouse();
                    startSelected = true;
                }
                if ((cursor.getPosX() >= tutorial.getStartX() && cursor.getPosX() <= tutorial.getEndX()) &&
                        (cursor.getPosY() >= tutorial.getStartY() && cursor.getPosY() <= tutorial.getEndY())) {
                    System.out.println("Clicked on tutorial");
                    tutorialSelected = true;
                    mainMenuSelected = false;
                    creditsSelected = false;
                    clearMouse();
                }
                if ((cursor.getPosX() >= credits.getStartX() && cursor.getPosX() <= credits.getEndX()) &&
                        (cursor.getPosY() >= credits.getStartY() && cursor.getPosY() <= credits.getEndY())) {
                    System.out.println("Clicked on credits");
                    clearMouse();
                    creditsSelected = true;
                    mainMenuSelected = false;
                    tutorialSelected = false;
                }
            }

            if (tutorialSelected) {
                menuEvent.tutorial();
                menuEvent.removeMenu();

                if ((cursor.getPosX() >= back.getStartX() && cursor.getPosX() <= back.getEndX()) &&
                        (cursor.getPosY() >= back.getStartY() && cursor.getPosY() <= back.getEndY())) {
                    clearMouse();
                    System.out.println("Clicked on back");
                    tutorialSelected = false;
                    mainMenuSelected = true;
                }
                if ((cursor.getPosX() >= tutorialStart.getStartX() && cursor.getPosX() <= tutorialStart.getEndX()) &&
                        (cursor.getPosY() >= tutorialStart.getStartY() && cursor.getPosY() <= tutorialStart.getEndY())) {
                    clearMouse();
                    System.out.println("Clicked on start");
                    System.out.println(cursor.getPosX() + " " + cursor.getPosY());
                    tutorialSelected = false;
                    startSelected = true;
                }
            }

            if (creditsSelected) {
                menuEvent.removeMenu();
                menuEvent.credits();
                System.out.println("In credits Menu ...");
                if ((cursor.getPosX() >= creditsBack.getStartX() && cursor.getPosX() <= creditsBack.getEndX()) &&
                        (cursor.getPosY() >= creditsBack.getStartY() && cursor.getPosY() <= creditsBack.getEndY())) {
                    clearMouse();
                    mainMenuSelected = true;
                    creditsSelected = false;
                }
            }
        }
    }

    public double getX() {
        return mouseX;
    }

    public void setX(double mouseX) {
        this.mouseX = mouseX;
    }

    public double getY() {
        return mouseY;
    }

    public void setY(double mouseY) {
        this.mouseY = mouseY;
    }

    private double getMouseX() {
        return mouseX;
    }

    private double getMouseY() {
        return mouseY;
    }

    private void clearMouse() {
        cursor.resetPosX();
        cursor.resetPosy();
    }
}


