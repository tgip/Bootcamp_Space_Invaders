package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.util.LinkedList;
import java.util.List;

public class MouseListener implements MouseHandler {

    private static final MouseEventType[] ourMouseEvents = {
            MouseEventType.MOUSE_CLICKED,
            MouseEventType.MOUSE_MOVED
    };

    private Player player;
    private int x_pos;

    public MouseListener(Player player) {
        this.player = player;

        Mouse event = new Mouse(this);

        for (MouseEventType eventType : ourMouseEvents) {
            event.addEventListener(eventType);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        player.shoot();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x_pos = (int) e.getX();
        if (x_pos > (Config.BOARD_WIDTH - Config.playerIcon_WIDTH + 10)) {
            x_pos = Config.BOARD_WIDTH - Config.playerIcon_WIDTH + 10;
        } else if (x_pos < 10) {
            x_pos = 10;
        }
        player.move(x_pos, (Config.BOARD_HEIGHT - Config.playerIcon_HEIGHT));
    }
}
