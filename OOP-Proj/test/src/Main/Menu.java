package Main;

import Tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Menu {
    GamePanel gp;
    Tile[] tile;
    public Menu(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10]; // Array show the number of presented tiles
        getTileImage();
    }
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/imageMap/BackgroundMenu.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2) {
//        Font fnt0 = new Font("arial", Font.BOLD, 60);
//        g2.setFont(fnt0);
//        g2.setColor(Color.white);
//        g2.drawString("MONOPOLY UNIVERSE", 600, 280);

        g2.drawImage(tile[0].image, 0,0,1920,1080,null);

        Rectangle playButton = new Rectangle(gp.screenWidth / 2 - 75, 530, 150, 80);
        Rectangle helpButton = new Rectangle(gp.screenWidth / 2 - 75, 680, 150, 80);
        Rectangle quitButton = new Rectangle(gp.screenWidth / 2 - 75, 830, 150, 80);
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
