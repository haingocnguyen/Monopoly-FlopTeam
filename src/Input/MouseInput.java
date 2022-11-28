package Input;

import Main.GamePanel;
import Main.Help;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Main.GamePanel.STATE.MENU;

public class MouseInput implements MouseListener {
    GamePanel gp;
    public MouseInput(GamePanel gp){
        this.gp = gp;
    }
    public Help helpScreen = new Help();

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();



        // Play Button
        if(mx >= gp.screenWidth / 2 - 75 && mx <= gp.screenWidth / 2 + (75 + 150)){
            if(my >= 530 && my <= 610 && GamePanel.State == MENU ){
                // Press Play Button
                GamePanel.State = GamePanel.STATE.GAME;
                gp.stopMusic();
                gp.playMusic(0);
            }
        }
        // Quit Button
        if(mx >= gp.screenWidth / 2 - 75 && mx <= gp.screenWidth / 2 + (75 + 150)){
            if(my >= 830 && my <= 910 && GamePanel.State == MENU ){
                // Press Quit Button
                System.exit(1);
            }
        }
        // Help Button
        if(mx >= gp.screenWidth / 2 - 75 && mx <= gp.screenWidth / 2 + (75 + 150)){
            if(my >= 730 && my <= 810 && GamePanel.State == MENU ){
                // Press Help Button
                helpScreen.displayHelp();
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
