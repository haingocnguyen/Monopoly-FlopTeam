import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        Menu menu = new Menu();
        // User when close the game screen when click the X button
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(1920, 1080));
        // Not allow to resize the game screen
        window.setResizable(false);
        // Set the title of the game
        window.setTitle("Monopoly Universe");
        window.add(menu);
        window.pack();
        // Causes this window to be sized to fit the preferred size and layouts of its subcomponents (GamePanels)
        // Displayed at the center of the screen due to null parameter.
        window.setLocationRelativeTo(null);
        // Set to see this window
        window.setVisible(true);
    }
}