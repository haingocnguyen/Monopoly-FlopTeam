import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menu implements ActionListener {

    JFrame frame = new JFrame();
    JButton playButton = new JButton("Play");
    JButton helpButton = new JButton("Help");
    JButton quitButton = new JButton("Quit");
    Image img;
    public static void main(String[] args) {
        Menu menu = new Menu();

    }
    public Menu(){
        playButton.setBounds(1920 / 2 - 75, 530, 150, 80);
        playButton.setFocusable(false);
        playButton.addActionListener(this);
        helpButton.setBounds(1920 / 2 - 75, 680, 150, 80);
        helpButton.setFocusable(false);
        helpButton.addActionListener(this);
        quitButton.setBounds(1920 / 2 - 75, 830, 150, 80);
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);
        frame.add(playButton);
        frame.add(helpButton);
        frame.add(quitButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void draw (Graphics2D g2) {
        Font fnt0 = new Font("arial", Font.BOLD, 60);
        try {
            img = ImageIO.read(getClass().getResource("BackgroundMenu.png"));
        } catch (IOException e){

        }
        g2.setFont(fnt0);
        g2.setColor(Color.white);
        g2.drawString("MONOPOLY UNIVERSE", 600, 280);
        g2.drawImage(img, 0,0,1920,1080,null);

        Rectangle playButton = new Rectangle(1920 / 2 - 75, 530, 150, 80);
        Rectangle helpButton = new Rectangle(1920 / 2 - 75, 680, 150, 80);
        Rectangle quitButton = new Rectangle(1920 / 2 - 75, 830, 150, 80);
        Font fnt1 = new Font("Times New Roman", Font.BOLD, 50);
        g2.setFont(fnt1);
        g2.drawString("Play", playButton.x + 22, playButton.y + 55);
        g2.draw(playButton);
        g2.drawString("Help", helpButton.x + 22, helpButton.y + 55);
        g2.draw(helpButton);
        g2.drawString("Quit", quitButton.x + 22, quitButton.y + 55);
        g2.draw(quitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==playButton){
            frame.dispose();
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Monopoly window = new Monopoly();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if(e.getSource() == quitButton){
            System.exit(1);
        }
    }
}