package screens;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import org.academiadecodigo.PopStarsSpaceInvaders.Game;

public class GameOverScreen extends Screen{

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(BufferedImageResource.GameOverScreen, null, 0, 0);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                Game.endProgram();
            case KeyEvent.VK_ENTER:
                Game.setScreen(Game.startScreen);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
