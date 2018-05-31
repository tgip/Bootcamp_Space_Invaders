package org.academiadecodigo.simplegraphics.test;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.net.CacheResponse;

public class Move implements KeyboardHandler {

    private Rectangle rectangle;
    private Ellipse elipse;

    public Move() {
        this.elipse = new Ellipse(200, 0, 50, 50);
        this.rectangle = new Rectangle(10, 10, 30, 30);




        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(event);
    }


    public void keyPressed(KeyboardEvent event) {
        try {

            switch (event.getKey()) {
                case KeyboardEvent.KEY_SPACE:

                    shoot();
                    break;
                case KeyboardEvent.KEY_RIGHT:

                    moveRight();
                    break;

                case KeyboardEvent.KEY_LEFT:
                    moveLeft();
                    break;
                case KeyboardEvent.KEY_UP:
                    rectangle.fill();
                    moveUp();
                    break;

                case KeyboardEvent.KEY_DOWN:

                    moveDown();
                    break;
            }
        } catch (InterruptedException e) {

        }

    }
    public void keyReleased(KeyboardEvent event) {
        System.out.println(event);
    }

    public void moveDown() {
        rectangle.draw();
        rectangle.setColor(Color.BLACK);
        rectangle.fill();
        rectangle.translate(0, 20);
    }

    public void moveUp() {
        rectangle.draw();
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
        rectangle.translate(0, -20);
    }

    public void moveRight() {
        rectangle.draw();
        rectangle.setColor(Color.RED);
        rectangle.fill();
        rectangle.translate(20, 0);
    }

    public void moveLeft() {
        rectangle.draw();
        rectangle.setColor(Color.YELLOW);
        rectangle.fill();
        rectangle.translate(-20, 0);
    }


    public void shoot() throws InterruptedException {

            elipse.draw();
            elipse.translate(0, 10);
          //  Thread.sleep(2000);


        }

    }






