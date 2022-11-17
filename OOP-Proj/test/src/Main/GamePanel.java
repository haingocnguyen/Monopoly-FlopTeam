package Main;

import Input.MouseInput;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 15x15 Tile, 15 pixel
    final int scale = 5; // We create 15 pixel, but it will scale it to 80 pixel on the screen
    public final int tileSize = originalTileSize * scale; // The size on the screen currently is 80 pixels // This is the size of Player
    public final int CardNormalSize = tileSize + 10; // 90 pixels
    public final int CardCornerSize = tileSize + 40; // 120 pixels
    // Therefore, 90*9 + 135*2 = 1080
    public final int maxScreenCol = 16; // 16 tiles horizontally
    public final int maxScreenRow = 9; // 9 tile vertically
    public final int screenWidth = (tileSize * 3/2) * maxScreenCol; // 1920 pixels width
    public final int screenHeight = (tileSize * 3/2) * maxScreenRow; // 1080 pixels height

    // FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    Sound sound = new Sound();
    OperationPane opePane = new OperationPane(this);
    PlayerPane playerPane = new PlayerPane(this);
    Menu menu = new Menu(this);
    MouseInput mouseInput = new MouseInput(this);
    Thread gameThread; // to keep The game running until we stop it


    // Set player's default position
    // int playerX = 100; // X increase from left to right
    // int playerY = 100; // Y increase from up to down
    // int playerSpeed = 4; // the distance after moving is 4 pixels
    public GamePanel() {

        // Set the size of this class (JPanel)
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK); // Set the background of the buttons
        this.setDoubleBuffered(true); // Set to true to all drawing from this component will be done in an offscreen painting buffer
        this.setFocusable(true); // This game panel can be "focused" to received key input
        this.addMouseListener(mouseInput);
    }

    public void setupGame(){
        //playMusic(0);
    }

    public static enum STATE{MENU, GAME};
    public static STATE State = STATE.MENU;


    // instantiate this game thread
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run(){ // Delta method

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0; // To check FPS
        int drawCount = 0; // To check FPS

        while(gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta --;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){

        //player.update();
    }

    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        // Create a Game Menu
        if(State == STATE.GAME){
            tileM.draw(g2);
            opePane.draw(g2);
            playerPane.draw(g2);
        }else if(State == STATE.MENU){
            menu.draw(g2);
        }
        g2.dispose();
    }

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }

    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }
}
