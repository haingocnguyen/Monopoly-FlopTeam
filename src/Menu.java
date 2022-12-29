import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Menu extends JPanel implements MouseListener {

    JPanel menu = new JPanel();
    JButton playButton = new JButton("Play");
    JButton helpButton = new JButton("Help");
    JButton quitButton = new JButton("Quit");
    BufferedImage img;

    public Menu(){
        this.add(playButton);
        this.add(helpButton);
        this.add(quitButton);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(menu);
        addMouseListener(this);
    }
    @Override
    public void paint (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("BackgroundMenu.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
        g2.drawImage(img, 0,0,1920,1080,null);

        Rectangle playButton = new Rectangle(1920 / 2 - 75, 530, 150, 80);
        Rectangle helpButton = new Rectangle(1920 / 2 - 75, 680, 150, 80);
        Rectangle quitButton = new Rectangle(1920 / 2 - 75, 830, 150, 80);
        Font fnt1 = new Font("Times New Roman", Font.BOLD, 50);
        g2.setFont(fnt1);
        g2.drawString("Play", playButton.x + 22, playButton.y + 55);
        g2.setColor(Color.BLACK);
        g2.drawRect(playButton.x,playButton.y,playButton.width,playButton.height);

        g2.setFont(fnt1);
        g2.drawString("Help", helpButton.x + 22, helpButton.y + 55);
        g2.setColor(Color.BLACK);
        g2.drawRect(helpButton.x,helpButton.y,helpButton.width,helpButton.height);

        g2.setFont(fnt1);
        g2.drawString("Quit", quitButton.x + 22, quitButton.y + 55);
        g2.setColor(Color.BLACK);
        g2.drawRect(quitButton.x,quitButton.y,quitButton.width,quitButton.height);
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(x >= 1920 / 2 - 75 && x <= 1920 / 2 + 75){
            if(y >= 530 && y <= 610){
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Monopoly window = new Monopoly();
                            window.frame.setVisible(true);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
            else if( y >= 680 && y<= 760){
                Help help = Help.getInstance();
            }
            else if( y >= 830 && y <= 910){
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