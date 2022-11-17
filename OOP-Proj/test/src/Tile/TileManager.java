package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[41]; // Array show the number of presented tiles

        mapTileNum = new int [gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
    }

    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/0.png")));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/1.png")));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/2.png")));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/3.png")));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/4.png")));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/5.png")));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/6.png")));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/7.png")));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/8.png")));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/9.png")));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/10.png")));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/11.png")));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/12.png")));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/13.png")));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/14.png")));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/15.png")));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/16.png")));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/17.png")));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/18.png")));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/19.png")));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/20.png")));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/21.png")));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/22.png")));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/23.png")));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/24.png")));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/25.png")));

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/26.png")));

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/27.png")));

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/28.png")));

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/29.png")));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/30.png")));

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/31.png")));

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/32.png")));

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/33.png")));

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/34.png")));

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/35.png")));

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/36.png")));

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/37.png")));

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/38.png")));

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/39.png")));

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Resource/center.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){

        // Left
        g2.drawImage(tile[20].image, 0, 0, gp.CardCornerSize, gp.CardCornerSize, null);
        int y_left = gp.CardCornerSize;
        int i;
        for (i =0; i < 9; i++ ){
            g2.drawImage(tile[19 - i].image, 0, y_left, gp.CardCornerSize, gp.CardNormalSize, null);
            y_left += gp.CardNormalSize;
        }

        // Bottom
        g2.drawImage(tile[10].image, 0, 930, gp.CardCornerSize, gp.CardCornerSize, null);
        int x_bottom = gp.CardCornerSize;
        for (i = 0; i < 9; i++){
            g2.drawImage(tile[9 - i].image, x_bottom, 930, gp.CardNormalSize, gp.CardCornerSize, null);
            x_bottom += gp.CardNormalSize;
        }
        g2.drawImage(tile[0].image, 930, 930, gp.CardCornerSize, gp.CardCornerSize, null);

        // Top
        int x_top = gp.CardCornerSize;
        for (i = 0; i < 9; i++){
            g2.drawImage(tile[21 + i].image, x_top, 0, gp.CardNormalSize, gp.CardCornerSize, null);
            x_top += gp.CardNormalSize;
        }
        g2.drawImage(tile[30].image, 930, 0, gp.CardCornerSize, gp.CardCornerSize, null);

        // Right
        int y_right = gp.CardCornerSize;
        for (i = 0; i < 9; i++){
            g2.drawImage(tile[31 + i].image, 930, y_right, gp.CardCornerSize, gp.CardNormalSize, null);
            y_right += gp.CardNormalSize;
        }
        g2.drawImage(tile[40].image, 120,120,810,810,null);
    }


}
