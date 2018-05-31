package org.academiadecodigo.simplegraphics.test;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameKeyboard implements KeyboardHandler {

    public GameKeyboard() {
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

        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(event);
    }

    public void keyPressed(KeyboardEvent event) {

        switch (event.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                System.out.println("You pressed Space");

                break;
            case KeyboardEvent.KEY_RIGHT:
                Text text = new Text(10, 10, "R");

                break;

            case KeyboardEvent.KEY_LEFT:
                Text textLeft = new Text(20, 20, "R");

                break;
            case KeyboardEvent.KEY_UP:
                Text textUp = new Text(30, 30, "R");

                break;

            case KeyboardEvent.KEY_DOWN:
                Text textDown = new Text(40, 40, "R");

                break;
        }

    }

    public void keyReleased(KeyboardEvent event) {
        System.out.println(event);
    }

}
