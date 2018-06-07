package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseListener implements MouseHandler {
    private static final MouseEventType[] ourMouseEvents = {
            MouseEventType.MOUSE_CLICKED,
            MouseEventType.MOUSE_MOVED
    };
    private MouseUser user;

    public MouseListener(MouseUser user) {
        this.user = user;
        Mouse event = new Mouse(this);
        for (MouseEventType eventType : ourMouseEvents) {
            event.addEventListener(eventType);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        user.mouseClicked(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        user.mouseMoved(e);
    }

    public void SetMouseUser(MouseUser user) {
        this.user = user;
    }
}


