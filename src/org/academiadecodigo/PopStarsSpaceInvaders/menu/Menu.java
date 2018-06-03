package org.academiadecodigo.PopStarsSpaceInvaders.menu;

public class Menu implements Clickable {

    private MenuEvent menuEvent;
    private double mouseX;
    private double mouseY;
    private Buttons play;
    private Buttons tutorial;
    private Buttons credits;
    private Buttons back;
    private Buttons creditback;
    private Buttons tuturialStart;
    private Buttons exit;
    private boolean startSelected;
    private boolean tutorialSelected;
    private boolean creditsSelected;
    private boolean mainMenuSelected;
    private Cursor cursor;

    public Menu(Cursor cursor){
        this.cursor = cursor;
        menuEvent = new MenuEvent();
        tuturialStart=ButtonFactory.getNewButton(ButtonType.TUTORIALSTART);
        play = ButtonFactory.getNewButton(ButtonType.PLAY);
        tutorial = ButtonFactory.getNewButton(ButtonType.TUTORIAL);
        credits = ButtonFactory.getNewButton(ButtonType.CREDITS);
        creditback = ButtonFactory.getNewButton(ButtonType.CREDITBACK);
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

                System.out.println(cursor.getPosX() + " " + cursor.getPosY());
                if ((cursor.getPosX() >= exit.getStartX() && cursor.getPosX() <= exit.getEndX()) &&
                        (cursor.getPosY() >= exit.getStartY() && cursor.getPosY() <= exit.getEndY())) {
                    System.out.println("Clicked on exit");
                    clearMouse();
                    // QUIT THE JVM
                }
                if ((cursor.getPosX() >= play.getStartX() && cursor.getPosX() <= play.getEndX()) &&
                        (cursor.getPosY() >= play.getStartY() && cursor.getPosY() <= play.getEndY())) {
                    System.out.println("Clicked on start");
                    clearMouse();
                    startSelected=true;
                    //tutorialSelected = false;
                    //startSelected = true;

                }
                if ((cursor.getPosX() >= tutorial.getStartX() && cursor.getPosX() <= tutorial.getEndX()) &&
                        (cursor.getPosY() >= tutorial.getStartY() && cursor.getPosY() <= tutorial.getEndY())) {
                    System.out.println("Clicked on tutorial");

                    tutorialSelected = true;
                    mainMenuSelected = false;
                    creditsSelected=false;
                    clearMouse();

                    // startSelected=false;

                }
                if ((cursor.getPosX() >= credits.getStartX() && cursor.getPosX() <= credits.getEndX()) &&
                        (cursor.getPosY() >= credits.getStartY() && cursor.getPosY() <= credits.getEndY())) {
                    System.out.println("Clicked on credits");
                    clearMouse();
                    creditsSelected = true;
                    mainMenuSelected = false;
                    tutorialSelected=false;

                }
            }

            if (tutorialSelected) {
                menuEvent.tutorial();
                menuEvent.removeMenu();

                if ((cursor.getPosX() >= back.getStartX() && cursor.getPosX() <= back.getEndX()) &&
                        (cursor.getPosY() >= back.getStartY() && cursor.getPosY() <= back.getEndY())) {
                    clearMouse();
                    System.out.println(cursor.getPosX() + " " + cursor.getPosY());
                    System.out.println("Clicked on back");
                    tutorialSelected = false;
                    mainMenuSelected = true;
                }
                if ((cursor.getPosX() >= tuturialStart.getStartX() && cursor.getPosX() <= tuturialStart.getEndX()) &&
                        (cursor.getPosY() >= tuturialStart.getStartY() && cursor.getPosY() <= tuturialStart.getEndY())) {
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
                if ((cursor.getPosX() >= creditback.getStartX() && cursor.getPosX() <= creditback.getEndX()) &&
                        (cursor.getPosY() >= creditback.getStartY() && cursor.getPosY() <= creditback.getEndY())) {
                    clearMouse();
                    mainMenuSelected = true;
                    creditsSelected = false;

                }
            }
        }
    }

    public void setX ( double mouseX){
        this.mouseX = mouseX;
    }

    public void setY ( double mouseY){
        this.mouseY = mouseY;
    }

    public double getX () {
        return mouseX;
    }

    public double getY () {
        return mouseY;
    }

    private double getMouseX() {
        return mouseX;
    }

    private double getMouseY() {
        return mouseY;
    }

    public void clearMouse () {
        cursor.resetPosX();
        cursor.resetPosy();
    }
}


