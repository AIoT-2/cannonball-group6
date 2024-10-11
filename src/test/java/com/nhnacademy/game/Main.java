package com.nhnacademy.game;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
    PaintableBall ball = new PaintableBall(100, 100, 50, Color.RED);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.paint(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paintable Ball Example");
        Main panel = new Main();
        
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}