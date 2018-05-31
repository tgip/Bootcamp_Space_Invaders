package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Shot extends Check {

  private Rectangle rectangle;
  private int health;
  private Direction direction;
  private double posX;
  private double posY;
  private Sound sound = new Sound ("/resources/sounds/LaserShot.wav");

  public Shot (double originX, double originY
  ) {
    posY = originY;
    posX = originX;
    rectangle = new Rectangle (originX, originY, 5, 10);
    rectangle.setColor (Color.YELLOW
    );
    rectangle.draw (
    );
    rectangle.fill (
    );
    sound.play (true
    );

  } public void move (
  ) {
    if (posY > 0) {
      System.out.println ("PosX " + posX + "PosY " + posY);

      rectangle.translate (0, -10);
      setPosY (getPosY () - 10);
    }
  }

  public double getPosX (
  ) {
    return posX;
  }

  public double getPosY (
  ) {
    return posY;
  }

  public void setPosX (double posX
  ) {
    this.posX = posX;
  }

  public void setPosY (double posY
  ) {
    this.posY = posY;
  }

  public void setDirection (Direction direction
  ) {
    this.direction = Direction.UP;
  }
}
