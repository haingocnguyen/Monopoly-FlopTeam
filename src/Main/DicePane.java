package Main;

import Input.MouseInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class DicePane extends JFrame implements Runnable {
    private String[] images = {
            "src/DiceImages/ResultFace/Face1.png",
            "src/DiceImages/ResultFace/Face2.png",
            "src/DiceImages/ResultFace/Face3.png",
            "src/DiceImages/ResultFace/Face4.png",
            "src/DiceImages/ResultFace/Face5.png",
            "src/DiceImages/ResultFace/Face6.png",
    };
    private JButton rollBtn = new JButton("ROLL THE DICE");
    private int num1 = 5;
    private int num2 = 5;
    GamePanel gp;
    MouseListener mouse = new MouseInput(gp);


    public DicePane(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.cyan);
        g2.fillRect(400, 400, 250, 250);
        g2.drawImage(new ImageIcon(images[num1]).getImage(), 400, 400, null);
        g2.drawImage(new ImageIcon(images[num2]).getImage(), 550 , 400, null);
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                //System.out.println(x + y);
                if (x > 400 && x < 650 && y > 400 && y < 650) {
                    Random rand = new Random();

                    num1 = rand.nextInt(6);
                    num2 = rand.nextInt(6);

                    System.out.println(num1 + 1);
                    System.out.println(num2 + 1);

                    g2.drawImage(new ImageIcon(images[num1]).getImage(), 200, 200, null);
                    g2.drawImage(new ImageIcon(images[num2]).getImage(), 350, 200, null);
                    g2.drawString("You have to move" + (num1 + num2 + 2), 250, 300);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {


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
        });


    }

    @Override
    public void run() {

    }
}