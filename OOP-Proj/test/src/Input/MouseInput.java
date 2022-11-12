package Input;

import Main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
            if(my >= 430 && my <= 510){
                // Press Play Button
                GamePanel.State = GamePanel.STATE.GAME;
                gp.playMusic(0);
            }
        }
        // Quit Button
        if(mx >= gp.screenWidth / 2 - 75 && mx <= gp.screenWidth / 2 + (75 + 150)){
            if(my >= 730 && my <= 810){
                // Press Quit Button
                System.exit(1);
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
