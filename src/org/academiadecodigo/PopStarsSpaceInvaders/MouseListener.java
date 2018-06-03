package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.menu.Cursor;
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
    private Cursor cursor;
    private Player player;
    private int x_pos;
    private boolean state;


    public MouseListener(Cursor cursor) {
        this.cursor = cursor;
        Mouse event = new Mouse(this);

        for (MouseEventType eventType : ourMouseEvents) {
            event.addEventListener(eventType);
        }


    }

    public MouseListener(Player player) {
        this.player = player;
        state=true;
        Mouse event = new Mouse(this);

        for (MouseEventType eventType : ourMouseEvents) {
            event.addEventListener(eventType);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (state) {
            cursor.click(e.getX(), e.getY());
        } else {
            player.shoot();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(state) {
            cursor.move((e.getX()), e.getY());
        }else {
            x_pos = (int) e.getX();
            player.move(x_pos, (Config.BOARD_HEIGHT - Config.playerIcon_HEIGHT));
       /*
        if (x_pos > (Config.BOARD_WIDTH - Config.playerIcon_WIDTH + 10)) {
            x_pos = Config.BOARD_WIDTH - Config.playerIcon_WIDTH + 10;
        } else if (x_pos < 10) {
            x_pos = 10;
        }*/

    }
    }
}

