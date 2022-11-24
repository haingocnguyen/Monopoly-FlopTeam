package main;

import java.awt.*;

public class PlayerPane {
    GamePanel gp;
    public PlayerPane(GamePanel gp){
        this.gp = gp;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.blue);
        g2.fillRect(1100,780,360,100);
        g2.fillRect(1510,780,360,100);
        g2.fillRect(1100,930,360,100);
        g2.fillRect(1510,930,360,100);

        g2.setFont(new Font("Times New Roman",Font.BOLD,25));
        g2.setColor(Color.red);
        g2.drawString("Player 1",1110,800);
        g2.setColor(Color.pink);
        g2.drawString("Player 2",1520,800);
        g2.setColor(Color.magenta);
        g2.drawString("Player 3",1110,960);
        g2.setColor(Color.yellow);
        g2.drawString("Player 4",1520,960);

        g2.setColor(Color.white);

        g2.drawString("Galy: ",1110,830);
        g2.drawString("Mana: ",1110,860);

        g2.drawString("Galy: ",1520,830);
        g2.drawString("Mana: ",1520,860);

        g2.drawString("Galy: ",1110,990);
        g2.drawString("Mana: ",1110,1020);

        g2.drawString("Galy: ",1520,990);
        g2.drawString("Mana: ",1520,1020);

    }
}