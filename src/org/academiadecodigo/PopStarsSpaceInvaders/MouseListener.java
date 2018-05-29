package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseListener implements MouseHandler{

    private static final MouseEventType[] ourMouseEvents = {
            MouseEventType.MOUSE_MOVED,
            MouseEventType.MOUSE_CLICKED
    };

    private Player player;

    public MouseListener(Player player) {
        this.player = player;

        Mouse event = new Mouse(this);

        for (MouseEventType eventType:  ourMouseEvents){
            event.addEventListener(eventType);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked ...");
        player.shoot();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("X = " + e.getX() + "- Y = " + e.getY());
        player.move(e.getX(), e.getY());
    }
}
