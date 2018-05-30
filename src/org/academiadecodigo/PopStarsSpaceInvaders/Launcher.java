package org.academiadecodigo.PopStarsSpaceInvaders;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Launcher extends JFrame implements Config {

    private static final int IMG_WIDTH = 100;
    private static final int IMG_HEIGHT = 100;

    public Launcher(){
        initUI();
    }

    public void initUI(){
        add(new Game());
        setTitle("SPACE INVADERS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(100,100);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args)  {

        EventQueue.invokeLater(() ->{
            Launcher ex = new Launcher(); //inside () say if MouseAdapter or KeyAdaptor
            ex.setVisible(true);
        });
    }
}
