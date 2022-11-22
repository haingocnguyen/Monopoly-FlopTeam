package main;

import Card.FortuneCard;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        // User when close the game screen when click the X button
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Not allow to resize the game screen
        window.setResizable(false);

        // Set the title of the game
        window.setTitle("Monopoly Universe");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); // Causes this window to be sized to fit the preferred size and layouts of its subcomponents (GamePanels)

        // Displayed at the center of the screen due to null parameter.
        window.setLocationRelativeTo(null);

        // Set to see this window
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
