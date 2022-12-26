package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Help{

    public void displayHelp() {
        JFrame helper = new JFrame("HOUSE RULES");
        helper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("/Resources/help.png"));
        } catch (
                IOException er) {
            er.printStackTrace();
            System.exit(1);
        }
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel jlb = new JLabel();
        jlb.setIcon(imgIcon);
        helper.getContentPane().add(jlb, BorderLayout.CENTER);
        helper.pack();
        helper.setLocationRelativeTo(null);
        helper.setVisible(true);
    }
}
