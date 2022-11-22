package Input;

import Main.DicePane;
import Main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Random;

public class MouseInput implements MouseListener {
    GamePanel gp;
    DicePane dp;
    private String[] images = {
            "src/DiceImages/ResultFace/Face1.png",
            "src/DiceImages/ResultFace/Face2.png",
            "src/DiceImages/ResultFace/Face3.png",
            "src/DiceImages/ResultFace/Face4.png",
            "src/DiceImages/ResultFace/Face5.png",
            "src/DiceImages/ResultFace/Face6.png",
    };
    public MouseInput(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        int num1, num2;
        if (mx > 400 && mx < 650 && my > 400 && my < 650) {
            Random rand = new Random();

            num1 = rand.nextInt(6);
            num2 = rand.nextInt(6);

            System.out.println(num1 + 1);
            System.out.println(num2 + 1);

            dp.draw(new Graphics2D() {
                @Override
                public void draw(Shape s) {

                }

                @Override
                public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
                    return false;
                }

                @Override
                public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {

                }

                @Override
                public void drawRenderedImage(RenderedImage img, AffineTransform xform) {

                }

                @Override
                public void drawRenderableImage(RenderableImage img, AffineTransform xform) {

                }

                @Override
                public void drawString(String str, int x, int y) {

                }

                @Override
                public void drawString(String str, float x, float y) {

                }

                @Override
                public void drawString(AttributedCharacterIterator iterator, int x, int y) {

                }

                @Override
                public void drawString(AttributedCharacterIterator iterator, float x, float y) {

                }

                @Override
                public void drawGlyphVector(GlyphVector g, float x, float y) {

                }

                @Override
                public void fill(Shape s) {

                }

                @Override
                public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
                    return false;
                }

                @Override
                public GraphicsConfiguration getDeviceConfiguration() {
                    return null;
                }

                @Override
                public void setComposite(Composite comp) {

                }

                @Override
                public void setPaint(Paint paint) {

                }

                @Override
                public void setStroke(Stroke s) {

                }

                @Override
                public void setRenderingHint(RenderingHints.Key hintKey, Object hintValue) {

                }

                @Override
                public Object getRenderingHint(RenderingHints.Key hintKey) {
                    return null;
                }

                @Override
                public void setRenderingHints(Map<?, ?> hints) {

                }

                @Override
                public void addRenderingHints(Map<?, ?> hints) {

                }

                @Override
                public RenderingHints getRenderingHints() {
                    return null;
                }

                @Override
                public void translate(int x, int y) {

                }

                @Override
                public void translate(double tx, double ty) {

                }

                @Override
                public void rotate(double theta) {

                }

                @Override
                public void rotate(double theta, double x, double y) {

                }

                @Override
                public void scale(double sx, double sy) {

                }

                @Override
                public void shear(double shx, double shy) {

                }

                @Override
                public void transform(AffineTransform Tx) {

                }

                @Override
                public void setTransform(AffineTransform Tx) {

                }

                @Override
                public AffineTransform getTransform() {
                    return null;
                }

                @Override
                public Paint getPaint() {
                    return null;
                }

                @Override
                public Composite getComposite() {
                    return null;
                }

                @Override
                public void setBackground(Color color) {

                }

                @Override
                public Color getBackground() {
                    return null;
                }

                @Override
                public Stroke getStroke() {
                    return null;
                }

                @Override
                public void clip(Shape s) {

                }

                @Override
                public FontRenderContext getFontRenderContext() {
                    return null;
                }

                @Override
                public Graphics create() {
                    return null;
                }

                @Override
                public Color getColor() {
                    return null;
                }

                @Override
                public void setColor(Color c) {

                }

                @Override
                public void setPaintMode() {

                }

                @Override
                public void setXORMode(Color c1) {

                }

                @Override
                public Font getFont() {
                    return null;
                }

                @Override
                public void setFont(Font font) {

                }

                @Override
                public FontMetrics getFontMetrics(Font f) {
                    return null;
                }

                @Override
                public Rectangle getClipBounds() {
                    return null;
                }

                @Override
                public void clipRect(int x, int y, int width, int height) {

                }

                @Override
                public void setClip(int x, int y, int width, int height) {

                }

                @Override
                public Shape getClip() {
                    return null;
                }

                @Override
                public void setClip(Shape clip) {

                }

                @Override
                public void copyArea(int x, int y, int width, int height, int dx, int dy) {

                }

                @Override
                public void drawLine(int x1, int y1, int x2, int y2) {

                }

                @Override
                public void fillRect(int x, int y, int width, int height) {

                }

                @Override
                public void clearRect(int x, int y, int width, int height) {

                }

                @Override
                public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

                }

                @Override
                public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

                }

                @Override
                public void drawOval(int x, int y, int width, int height) {

                }

                @Override
                public void fillOval(int x, int y, int width, int height) {

                }

                @Override
                public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

                }

                @Override
                public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

                }

                @Override
                public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

                }

                @Override
                public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

                }

                @Override
                public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

                }

                @Override
                public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
                    return false;
                }

                @Override
                public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
                    return false;
                }

                @Override
                public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
                    return false;
                }

                @Override
                public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
                    return false;
                }

                @Override
                public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
                    return false;
                }

                @Override
                public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
                    return false;
                }

                @Override
                public void dispose() {

                }
            });
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

//        Rectangle helpButton = new Rectangle(gp.screenWidth / 2 - 75, 580, 150, 80);
//        Rectangle quitButton = new Rectangle(gp.screenWidth / 2 - 75, 730, 150, 80);
        // Play Button
        if(mx >= gp.screenWidth / 2 - 75 && mx <= gp.screenWidth / 2 + (75 + 150)){
            if(my >= 530 && my <= 610){
                // Press Play Button
                GamePanel.State = GamePanel.STATE.GAME;
                gp.playMusic(0);
            }
        }
        // Quit Button
        if(mx >= gp.screenWidth / 2 - 75 && mx <= gp.screenWidth / 2 + (75 + 150)){
            if(my >= 830 && my <= 910){
                // Press Quit Button
                System.exit(1);
            }
        }
        // Help Button
        if(mx >= gp.screenWidth / 2 - 75 && mx <= gp.screenWidth / 2 + (75 + 150)){
            if(my >= 730 && my <= 810){
                // Press Help Button
                JFrame helper = new JFrame("HOUSE RULES");
                helper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(getClass().getResource("/Resources/helper.png"));
                } catch (IOException er) {
                    er.printStackTrace();
                    System.exit(1);
                }
                ImageIcon imgIcon = new ImageIcon(img);
                JLabel jlb = new JLabel();
                jlb.setIcon(imgIcon);
                helper.getContentPane().add(jlb, BorderLayout.CENTER);
                helper.pack();
                helper.setLocationRelativeTo(null);
                helper.setVisible(true);
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
