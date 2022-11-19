package Input;

import Main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MouseInput implements MouseListener {
    GamePanel gp;
    public MouseInput(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

//        Rectangle helpButton = new Rectangle(gp.screenWidth / 2 - 75, 580, 150, 80);
//        Rectangle quitButton = new Rectangle(gp.screenWidth / 2 - 75, 730, 150, 80);
        // Play Button
        if(mx >= gp.screenWidth / 2 - 75 && mx <= gp.screenWidth / 2 + (75 + 150)){
            if(my >= 530 && my <= 610){
                // Press Play Button
                GamePanel.State = GamePanel.STATE.GAME;
                gp.playMusic(0);
            }
        }
        // Quit Button
        if(mx >= gp.screenWidth / 2 - 75 && mx <= gp.screenWidth / 2 + (75 + 150)){
            if(my >= 830 && my <= 910){
                // Press Quit Button
                System.exit(1);
            }
        }
        // Help Button
        if(mx >= gp.screenWidth / 2 - 75 && mx <= gp.screenWidth / 2 + (75 + 150)){
            if(my >= 730 && my <= 810){
                // Press Help Button
                JFrame helper = new JFrame("HOUSE RULES");
                helper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(getClass().getResource("/Resources/helper.png"));
                } catch (IOException er) {
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
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
