package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private static final int[] keys = {
            KeyboardEvent.KEY_SPACE,
            KeyboardEvent.KEY_LEFT,
            KeyboardEvent.KEY_RIGHT
    };
    private Player player;
    private boolean active;

    public KeyboardListener(Player player) {
        this.player = player;
        Keyboard keyboard = new Keyboard(this);

        for (int key : keys) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKey(key);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        if (active) {
            return;
        }

        switch (e.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                player.shoot();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
    }

    public void activate() {
        this.active = true;
    }
}
