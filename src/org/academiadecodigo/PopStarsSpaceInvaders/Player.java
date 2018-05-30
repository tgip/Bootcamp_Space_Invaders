package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player extends Check implements Moveable {

  private Rectangle rectangle;
  private int health;
  private Direction direction;

  private double gun_pos = 25;
  private Shot shot;

  public Player ()
  {
    rectangle = new Rectangle (100, 100, 50, 50);
    rectangle.setColor (Color.RED);
    rectangle.fill ();
  }

  public void move ()
  {
    if (direction == Direction.RIGHT)
      {
	rectangle.translate (10, 0);
      }
    if (direction == Direction.LEFT)
      {
	rectangle.translate (-10, 0);
      }

  }

  public void move (double x, double y)
  {
    rectangle.translate (x - rectangle.getX (), y - rectangle.getY ());

  }

    public Shot shoot() {
        Sound sound= new Sound("resources/LaserShot.wav");
        sound.play(true);
        Shot shot = new Shot(rectangle.getX() + gun_pos, rectangle.getY());
        return shot;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
