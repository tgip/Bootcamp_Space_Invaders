package SounTest;

import org.academiadecodigo.PopStarsSpaceInvaders.Sound;
public class SoundTest {

    public static void main(String[] args) {
        Sound sound = new Sound("resouces/LaserShot.wav");
        sound.play(true);
    }
}
