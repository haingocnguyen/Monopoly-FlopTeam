package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DicePane extends JFrame {
    private JPanel lblPanel = new JPanel();
    private JPanel btnPanel = new JPanel();
    private String[] images = {
            "OOP-Proj/test/src/DiceImages/ResultFaces/Face1.png",
            "OOP-Proj/test/src/DiceImages/ResultFaces/Face2.png",
            "OOP-Proj/test/src/DiceImages/ResultFaces/Face3.png",
            "OOP-Proj/test/src/DiceImages/ResultFaces/Face4.png",
            "OOP-Proj/test/src/DiceImages/ResultFaces/Face5.png",
            "OOP-Proj/test/src/DiceImages/ResultFaces/Face6.png",
    };
    private JButton rollBtn = new JButton("Roll");

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    private int num1 = 5;
    private int num2 = 5;
    GamePanel gp;

    public DicePane(GamePanel gp) {
        this.gp = gp;
        buildPanel();
    }
    public void buildPanel() {
        gp.setBackground(Color.RED);

        gp.setLayout(new BorderLayout());
        gp.setBorder(new EmptyBorder(50, 20, 20, 50));

        label1 = new JLabel(new ImageIcon(images[num1]));
        label2 = new JLabel(new ImageIcon(images[num2]));
        label3 = new JLabel();


        lblPanel.setLayout(new GridLayout(1, 2));
        lblPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        lblPanel.setBackground(Color.RED);

        lblPanel.add(label1);
        lblPanel.add(label2);

        btnPanel.setLayout(new GridLayout(2, 1));
        btnPanel.add(rollBtn);
        btnPanel.add(label3);


        gp.add(lblPanel, BorderLayout.CENTER);
        gp.add(btnPanel, BorderLayout.SOUTH);

        btnPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        btnPanel.setBackground(Color.RED);
        rollBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Random rand = new Random();

                num1 = rand.nextInt(6);
                num2 = rand.nextInt(6);

                System.out.println(num1 + 1);
                System.out.println(num2 + 1);

                label1.setIcon(new ImageIcon(images[num1]));
                label2.setIcon(new ImageIcon(images[num2]));

                label3.setText("You have to move " + (num1 + num2 + 2) + " steps.");
            }
        });
    }
}