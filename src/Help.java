import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Help extends JFrame {
    private static Help singleInstance = null;
    Image helpImage;
    final JPanel panel = new JPanel();

    private Help() {
        try {
            helpImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("help.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel.setPreferredSize(new Dimension(1920, 1080));
        this.setTitle("Help");
        this.add(panel);
        this.pack();
        this.setPreferredSize(new Dimension(1920, 1080));
        this.setVisible(true);
    }

    public static Help getInstance() {
        if (singleInstance == null)
            singleInstance = new Help();
        return singleInstance;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(helpImage, 0, 0, null);
    }
}
