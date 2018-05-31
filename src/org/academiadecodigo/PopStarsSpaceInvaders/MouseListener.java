package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.util.LinkedList;
import java.util.List;

public class MouseListener extends Check implements MouseHandler {

  private static final MouseEventType[] ourMouseEvents = {
    MouseEventType.MOUSE_CLICKED,
    MouseEventType.MOUSE_MOVED
  };

  private Player player;

  public MouseListener (Player player
  ) {
    this.player = player;

    Mouse event = new Mouse (this);

 for (MouseEventType eventType:ourMouseEvents) {
      event.addEventListener (eventType);
    }
  }

  @Override public void mouseClicked (MouseEvent e
  ) {
    player.shoot ();
  }

  @Override public void mouseMoved (MouseEvent e
  ) {
    player.move (e.getX (), 50);
    //player.move(e.getX(), e.getY());
  }
}
