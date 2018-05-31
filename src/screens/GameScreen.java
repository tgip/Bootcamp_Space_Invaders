package screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.Shot;
import org.academiadecodigo.PopStarsSpaceInvaders.Game;
import org.academiadecodigo.PopStarsSpaceInvaders.Config;

public class GameScreen extends Screen implements Config {
/*
    private static final long serialVersionUID = 1L;
    public int GameClock;
    public int Level;
    private int score = 0;

    // GameObjects:
    public Player player;
    public List<Shot> playerBullets;
    public List<Shot> badGuysShot;
    public GenericBadGuy badGuys;
    public int life;

    // GameState
    private enum GameState {
        RUNNING, PAUSE
    }

    private GameState gameState;

    /*
     * Constructor
     */
   /* public GameScreen() {
        this.GameClock = 0;
        // Initialize the GameState
        this.gameState = GameState.RUNNING;
        // Initialize the player
        this.player = new Player(0, 0, 0, 0, BufferedImageResource.Spaceship);
        this.player.setX(Game.frame.getWidth() / 2
                - player.getImage().getWidth() / 2);
        this.player.setY(Game.frame.getHeight() / 2
                - player.getImage().getHeight() / 2);
        // Initialize other GameObjects
        this.playerBullets = new LinkedList<Shot>();
        this.badGuys = new GenericBadGuy() {};

        // Player's life
        life = Config.PLAYER_START_HEALTH;

    } */

    /*
     * PaintComponent
     */
  /*  public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if (this.gameState == GameState.RUNNING) { // if running
            // Reset the screen
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, Game.frame.getWidth(),
                    Game.frame.getHeight());

            /*
             * Draw the GameObjects
             */
       /*     player.draw(g2);
            for (Shot sh : playerBullets) {
                if (!sh.equals(null))
                    sh.draw(g2);
            }
            for (GenericBadGuy a : badGuys) {
                if (!a.equals(null))
                    a.draw(g2);
            }

            // Print level title
            if (GameClock >= 0 && GameClock < 500) {
                // System.out.println("Printing level 1");
                paintString(g2, "Level 1");
            } else if (GameClock >= 1300 && GameClock < 1500) {
                paintString(g2, "Level 2");
            } else if (GameClock >= 2300 && GameClock < 2500) {
                paintString(g2, "Level 3");
            }

        } else { // if paused
            BufferedImage pausepopup = BufferedImageResource.PausePopup;
            g2.drawImage(pausepopup, null,
                    (int) this.getWidth() - pausepopup.getWidth() * 2,
                    (int) this.getHeight() - pausepopup.getHeight() * 2);
        }

        // Draw the Player's UI:
        this.drawPlayerUI(g2);
    }

    private void drawPlayerUI(Graphics2D g2) { // XXX check if string placement
        g2.setColor(Color.WHITE); // works
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        g2.drawString("Score: " + String.valueOf(score), 10, 20);
        g2.drawString("Level: " + String.valueOf(Level), 10, 40);
        g2.drawString("Weapon: " + player.playerweapon.getWeaponName(), 10, 60);

        int width = 20;
        int height = 20;

        if (BufferedImageResource.FullHealth != null) {
            height = BufferedImageResource.FullHealth.getHeight();
            width = BufferedImageResource.FullHealth.getWidth();
        }

        for (int i = 1; i <= Config.PLAYER_START_HEALTH; i++)
            if (i <= player.getHealth()) {
                if (BufferedImageResource.FullHealth != null) {
                    g2.drawImage(BufferedImageResource.FullHealth,
                            Game.frame.getWidth() - 50 - width
                                    * Config.PLAYER_START_HEALTH + width * i,
                            50, null);
                } else {
                    g2.setColor(Color.RED);
                    g2.fillOval(Game.frame.getWidth() - 50 - width
                                    * Config.PLAYER_START_HEALTH + width * i, 50,
                            width, height);
                }
            } else {
                if (BufferedImageResource.LostHealth != null) {
                    g2.drawImage(BufferedImageResource.LostHealth,
                            Game.frame.getWidth() - 50 - width
                                    * Config.PLAYER_START_HEALTH + width * i,
                            50, null);
                } else {
                    g2.setColor(Color.GRAY);
                    g2.drawOval(Game.frame.getWidth() - 50 - width
                                    * Config.PLAYER_START_HEALTH + width * i, 50,
                            width, height);
                }
            }

    }

    private void paintString(Graphics2D g2, String string) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g2.drawString(string, 200, 200);
    }

    /*
     * KeyEvents
     */

    // User's KeyInput: Moving the Player
 /*   @Override
    public void keyPressed(KeyEvent e) {
        doKeyPressedEventUpdates(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        doKeyReleasedEventUpdates(e);
    }

    public void doKeyPressedEventUpdates(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                if (gameState.equals(GameState.RUNNING)) {
                    pauseGame();
                } else if (gameState.equals(GameState.PAUSE)) {
                    Game.setScreen(new StartScreen());
                }
                break;
            case KeyEvent.VK_ENTER:
                if (gameState.equals(GameState.PAUSE)) {
                    resumeGame();
                }
                break;
        }
        // If Running Gamestate:
        if (gameState.equals(GameState.RUNNING)) {
            // Player
            player.keyPressedEventUpdate(e.getKeyCode());
        } else if (gameState.equals(GameState.PAUSE)) {

        }
    }

    public void doKeyReleasedEventUpdates(KeyEvent e) {
        // If Running Gamestate:
        if (gameState.equals(GameState.RUNNING)) {
            // Player
            player.keyReleaseEventUpdate(e.getKeyCode());
        } else if (gameState.equals(GameState.PAUSE)) {

        }
    }

    /*
     * Pause popup
     */
 /*   public void pauseGame() {
        this.gameState = GameState.PAUSE;
    }

    /*
     * Resume Game
     */
 /*   public void resumeGame() {
        this.gameState = GameState.RUNNING;
    }

    /*
     * ActionPerformed
     */

    // Constant Timer Updates
/*    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.gameState == GameState.RUNNING) {
            doGameLogic();

            // Set what level it is now
            if (GameClock >= 500 && GameClock < 1500) {
                Level = 1;
            } else if (GameClock >= 1500 && GameClock < 2500) {
                Level = 2;
            } else if (GameClock >= 2500 && GameClock < 3500) {
                Level = 3;
            }

            GameClock++;
        } else if (this.gameState == GameState.PAUSE) {

        }
        repaint();
    }

    // GameLogic
    private void doGameLogic() {
        // Iterator<PlayerBullet> pbIterate= playerBullets.iterator();

        @SuppressWarnings("unused")

        List<Shot> removeBullets = new LinkedList<Shot>();

        BulletCollisionsHandler handler = new BulletCollisionsHandler(this);
        handler.update();

        // Update all GameObject Positions
        player.moveUpdate();

        for (Shot pb : shots) {
            if (!pb.equals(null)) {
                pb.moveUpdate();
                if (!pb.exists()) {
                    removeBullets.add(pb);
                }
            }
        }
        for (PlayerBullet bullet : removeBullets)
            playerBullets.remove(bullet);

        for (AlienBullet ab : alienBullets) {
            if (!ab.equals(null))
                ab.moveUpdate();
        }
        if (!(alienBoss == null))
            alienBoss.moveUpdate();
        for (Upgrade u : upgrades) {
            if (!u.equals(null))
                u.moveUpdate();
        }

        // Check if the game is over (life is 0)
        if (this.life <= 0) {
            gameOver();
        }
    }

    /*
     * Remove objects methods
     */
 /*   private void gameOver() {
        Game.setScreen(Game.gameOverScreen);
    }

    public void remove(BadGuysShot object) {
        badGuysShot.remove(object);
    }

    public void remove(GenericBadGuy object) {
        badGuys.remove(object);
    }

    public void remove(Shot object) {
        playerBullets.remove(object);
    }

    public void remove(Object object) {
        playerBullets.remove(object);
    }

    public void endGame() {
        Game.log("Ending game...");
    }

    public void addScore(int addition) {
        score += addition;

    }
    **/
}
