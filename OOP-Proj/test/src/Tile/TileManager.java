package Tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[40]; // Array show the number of presented tiles

        mapTileNum = new int [gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
    }

    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/0.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/1.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/2.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/3.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/4.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/5.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/6.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/7.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/8.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/9.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/10.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/11.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/12.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/13.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/14.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/15.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/16.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/17.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/18.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/19.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/20.png"));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/21.png"));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/22.png"));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/23.png"));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/24.png"));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/25.png"));

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/26.png"));

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/27.png"));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/28.png"));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/29.png"));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/30.png"));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/31.png"));

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/32.png"));

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/33.png"));

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/34.png"));

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/35.png"));

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/36.png"));

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/37.png"));

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/38.png"));

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/ImageMap/39.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){

        // Left
        g2.drawImage(tile[20].image, 0, 0, gp.CardCornerSize, gp.CardCornerSize, null);
        int y_left = 100;
        int i;
        for (i =0; i < 9; i++ ){
            g2.drawImage(tile[19 - i].image, 0, y_left, gp.CardCornerSize, gp.CardNormalSize, null);
            y_left += 70;
        }

        // Bottom
        g2.drawImage(tile[10].image, 0, 730, gp.CardCornerSize, gp.CardCornerSize, null);
        int x_bottom = 100;
        for (i = 0; i < 9; i++){
            g2.drawImage(tile[9 - i].image, x_bottom, 730, gp.CardNormalSize, gp.CardCornerSize, null);
            x_bottom += 70;
        }
        g2.drawImage(tile[0].image, 730, 730, gp.CardCornerSize, gp.CardCornerSize, null);

        // Top
        int x_top = 100;
        for (i = 0; i < 9; i++){
            g2.drawImage(tile[21 + i].image, x_top, 0, gp.CardNormalSize, gp.CardCornerSize, null);
            x_top += 70;
        }
        g2.drawImage(tile[30].image, 730, 0, gp.CardCornerSize, gp.CardCornerSize, null);

        // Right
        int y_right = 100;
        for (i = 0; i < 9; i++){
            g2.drawImage(tile[31 + i].image, 730, y_right, gp.CardCornerSize, gp.CardNormalSize, null);
            y_right += 70;
        }
    }


}
