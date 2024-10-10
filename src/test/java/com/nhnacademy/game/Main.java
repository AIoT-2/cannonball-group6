package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Main extends JFrame {
    PaintableBall ball = new PaintableBall(100, 100, 50, Color.RED);

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ball.paint(g);
    }

    public static void main(String[] args) {
        JFrame frame = new Main();

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
    
}
