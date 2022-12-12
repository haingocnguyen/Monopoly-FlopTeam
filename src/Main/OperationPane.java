package Main;

import javax.swing.*;

import java.awt.*;

public class OperationPane {
    GamePanel gp;
    JButton buy;
    public OperationPane(GamePanel gp){
        this.gp = gp;
        buy = new JButton();
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(1100,0,gp.screenWidth-1150,750);
        g2.setColor(Color.red);
        g2.setFont(new Font("Times New Roman",Font.BOLD,50));
        g2.drawString("Console",1150,50);

    }
}
