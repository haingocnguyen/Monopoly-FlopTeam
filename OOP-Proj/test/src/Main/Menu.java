package Main;

import java.awt.*;

public class Menu {
    GamePanel gp;
    public Menu(GamePanel gp){
        this.gp = gp;
    }
    public void draw (Graphics2D g2) {
        Font fnt0 = new Font("arial", Font.BOLD, 60);
        g2.setFont(fnt0);
        g2.setColor(Color.white);
        g2.drawString("MONOPOLY UNIVERSE", 600, 280);

        Rectangle playButton = new Rectangle(gp.screenWidth / 2 - 75, 430, 150, 80);
        Rectangle helpButton = new Rectangle(gp.screenWidth / 2 - 75, 580, 150, 80);
        Rectangle quitButton = new Rectangle(gp.screenWidth / 2 - 75, 730, 150, 80);
        Font fnt1 = new Font("arial", Font.BOLD, 50);
        g2.setFont(fnt1);
        g2.drawString("Play", playButton.x + 22, playButton.y + 55);
        g2.draw(playButton);
        g2.drawString("Help", helpButton.x + 22, helpButton.y + 55);
        g2.draw(helpButton);
        g2.drawString("Quit", quitButton.x + 22, quitButton.y + 55);

        g2.draw(quitButton);
    }
}
