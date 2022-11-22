package main;

import javax.swing.*;

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
