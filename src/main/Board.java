package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class Board extends JPanel {
    GamePanel gp;
    private JLayeredPane topLeft;
    private JLayeredPane bottomLeft;
    private JLayeredPane topRight;
    private JLayeredPane bottomRight;
    private JLayeredPane left_1;
    private JLayeredPane left_2;
    private JLayeredPane left_3;
    private JLayeredPane left_4;
    private JLayeredPane left_5;
    private JLayeredPane left_6;
    private JLayeredPane left_7;
    private JLayeredPane left_8;
    private JLayeredPane left_9;
    private JLayeredPane top_1;
    private JLayeredPane top_2;
    private JLayeredPane top_3;
    private JLayeredPane top_4;
    private JLayeredPane top_5;
    private JLayeredPane top_6;
    private JLayeredPane top_7;
    private JLayeredPane top_8;
    private JLayeredPane top_9;
    private JLayeredPane right_1;
    private JLayeredPane right_2;
    private JLayeredPane right_3;
    private JLayeredPane right_4;
    private JLayeredPane right_5;
    private JLayeredPane right_6;
    private JLayeredPane right_7;
    private JLayeredPane right_8;
    private JLayeredPane right_9;
    private JLayeredPane bottom_1;
    private JLayeredPane bottom_2;
    private JLayeredPane bottom_3;
    private JLayeredPane bottom_4;
    private JLayeredPane bottom_5;
    private JLayeredPane bottom_6;
    private JLayeredPane bottom_7;
    private JLayeredPane bottom_8;
    private JLayeredPane bottom_9;
    private JLabel bottomRightLabel;
    private JLabel bottom1Label;
    private JLabel bottom2Label;
    private JLabel bottom3Label;
    private JLabel bottom4Label;
    private JLabel bottom5Label;
    private JLabel bottom6Label;
    private JLabel bottom7Label;
    private JLabel bottom8Label;
    private JLabel bottom9Label;
    private JLabel bottomLeftLabel;
    private JLabel left1Label;
    private JLabel left2Label;
    private JLabel left3Label;
    private JLabel left4Label;
    private JLabel left5Label;
    private JLabel left6Label;
    private JLabel left7Label;
    private JLabel left8Label;
    private JLabel left9Label;
    private JLabel topLeftLabel;
    private JLabel top1Label;
    private JLabel top2Label;
    private JLabel top3Label;
    private JLabel top4Label;
    private JLabel top5Label;
    private JLabel top6Label;
    private JLabel top7Label;
    private JLabel top8Label;
    private JLabel top9Label;
    private JLabel topRightLabel;
    private JLabel right1Label;
    private JLabel right2Label;
    private JLabel right3Label;
    private JLabel right4Label;
    private JLabel right5Label;
    private JLabel right6Label;
    private JLabel right7Label;
    private JLabel right8Label;
    private JLabel right9Label;
    private JLabel buildingLabel0;
    private JLabel buildingLabel1;
    private JLabel buildingLabel2;
    private JLabel buildingLabel3;
    private JLabel buildingLabel4;
    private JLabel buildingLabel5;
    private JLabel buildingLabel6;
    private JLabel buildingLabel7;
    private JLabel buildingLabel8;
    private JLabel buildingLabel9;
    private JLabel buildingLabel10;
    private JLabel buildingLabel11;
    private JLabel buildingLabel12;
    private JLabel buildingLabel13;
    private JLabel buildingLabel14;
    private JLabel buildingLabel15;
    private JLabel buildingLabel16;
    private JLabel buildingLabel17;
    private JLabel buildingLabel18;
    private JLabel buildingLabel19;
    private JLabel buildingLabel20;
    private JLabel buildingLabel21;
    public JFrame frame;
    private JLabel deed;
    private ArrayList<JLayeredPane> boardPanels;

    public Board(GamePanel gp){
        this.gp = gp;
    }

    public void initializeBoard(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        FlowLayout flow = new FlowLayout();
        flow.setHgap(0);
        flow.setVgap(0);
        frame = new JFrame("Monopoly (C) Hasbro. developed by: Pawel Paszki (pawelpaszki@gmail.com)");
        frame.setLayout(flow);
        frame.getContentPane().setBackground(new Color(173, 216, 230));
        frame.setForeground(new Color(173, 216, 230));
        frame.setBackground(new Color(173, 216, 230));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(screenSize);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        topLeft = new JLayeredPane();
        topLeft.setBounds(0,0,gp.CardCornerSize,gp.CardCornerSize);

        left_1 = new JLayeredPane();
        left_1.setBounds(0,gp.CardCornerSize,gp.CardCornerSize,gp.CardNormalSize);

        left_2 = new JLayeredPane();
        left_2.setBounds(0,gp.CardCornerSize*2,gp.CardCornerSize,gp.CardNormalSize);

        left_3 = new JLayeredPane();
        left_3.setBounds(0,gp.CardCornerSize*3,gp.CardCornerSize,gp.CardNormalSize);

        left_4 = new JLayeredPane();
        left_4.setBounds(0,gp.CardCornerSize*4,gp.CardCornerSize,gp.CardNormalSize);

        left_5 = new JLayeredPane();
        left_5.setBounds(0,gp.CardCornerSize*5,gp.CardCornerSize,gp.CardNormalSize);

        left_6 = new JLayeredPane();
        left_6.setBounds(0,gp.CardCornerSize*6,gp.CardCornerSize,gp.CardNormalSize);

        left_7 = new JLayeredPane();
        left_7.setBounds(0,gp.CardCornerSize*7,gp.CardCornerSize,gp.CardNormalSize);

        left_8 = new JLayeredPane();
        left_8.setBounds(0,gp.CardCornerSize*8,gp.CardCornerSize,gp.CardNormalSize);

        left_9 = new JLayeredPane();
        left_9.setBounds(0,gp.CardCornerSize*9,gp.CardCornerSize,gp.CardNormalSize);

        bottomLeft = new JLayeredPane();
        bottomLeft.setBounds(0,930,gp.CardCornerSize,gp.CardCornerSize);

        top_1 = new JLayeredPane();
        top_1.setBounds(gp.CardCornerSize,0,gp.CardNormalSize,gp.CardCornerSize);

        top_2 = new JLayeredPane();
        top_2.setBounds(gp.CardCornerSize*2,0,gp.CardNormalSize,gp.CardCornerSize);

        top_3 = new JLayeredPane();
        top_3.setBounds(gp.CardCornerSize*3,0,gp.CardNormalSize,gp.CardCornerSize);

        top_4 = new JLayeredPane();
        top_4.setBounds(gp.CardCornerSize*4,0,gp.CardNormalSize,gp.CardCornerSize);

        top_5 = new JLayeredPane();
        top_5.setBounds(gp.CardCornerSize*5,0,gp.CardNormalSize,gp.CardCornerSize);

        top_6 = new JLayeredPane();
        top_6.setBounds(gp.CardCornerSize*6,0,gp.CardNormalSize,gp.CardCornerSize);

        top_7 = new JLayeredPane();
        top_7.setBounds(gp.CardCornerSize*7,0,gp.CardNormalSize,gp.CardCornerSize);

        top_8 = new JLayeredPane();
        top_8.setBounds(gp.CardCornerSize*8,0,gp.CardNormalSize,gp.CardCornerSize);

        top_9 = new JLayeredPane();
        top_9.setBounds(gp.CardCornerSize*9,0,gp.CardNormalSize,gp.CardCornerSize);

        topRight = new JLayeredPane();
        topRight.setBounds(930,0,gp.CardCornerSize,gp.CardCornerSize);

        right_1 = new JLayeredPane();
        right_1.setBounds(930,gp.CardCornerSize,gp.CardCornerSize,gp.CardNormalSize);

        right_2 = new JLayeredPane();
        right_2.setBounds(930,gp.CardCornerSize*2,gp.CardCornerSize,gp.CardNormalSize);

        right_3 = new JLayeredPane();
        right_3.setBounds(930,gp.CardCornerSize*3,gp.CardCornerSize,gp.CardNormalSize);

        right_4 = new JLayeredPane();
        right_4.setBounds(930,gp.CardCornerSize*4,gp.CardCornerSize,gp.CardNormalSize);

        right_5 = new JLayeredPane();
        right_5.setBounds(930,gp.CardCornerSize*5,gp.CardCornerSize,gp.CardNormalSize);

        right_6 = new JLayeredPane();
        right_6.setBounds(930,gp.CardCornerSize*6,gp.CardCornerSize,gp.CardNormalSize);

        right_7 = new JLayeredPane();
        right_7.setBounds(930,gp.CardCornerSize*7,gp.CardCornerSize,gp.CardNormalSize);

        right_8 = new JLayeredPane();
        right_8.setBounds(930,gp.CardCornerSize*8,gp.CardCornerSize,gp.CardNormalSize);

        right_9 = new JLayeredPane();
        right_9.setBounds(930,gp.CardCornerSize*9,gp.CardCornerSize,gp.CardNormalSize);

        bottom_1 = new JLayeredPane();
        bottom_1.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_2 = new JLayeredPane();
        bottom_2.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_3 = new JLayeredPane();
        bottom_3.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_4 = new JLayeredPane();
        bottom_4.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_5 = new JLayeredPane();
        bottom_5.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_6 = new JLayeredPane();
        bottom_6.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_7 = new JLayeredPane();
        bottom_7.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_8 = new JLayeredPane();
        bottom_8.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottom_9 = new JLayeredPane();
        bottom_9.setBounds(gp.CardCornerSize,930,gp.CardNormalSize,gp.CardCornerSize);

        bottomRight = new JLayeredPane();
        bottomRight.setBounds(930,930,gp.CardCornerSize,gp.CardCornerSize);

        buildingLabel0 = new JLabel();
        buildingLabel1 = new JLabel();
        buildingLabel2 = new JLabel();
        buildingLabel3 = new JLabel();
        buildingLabel4 = new JLabel();
        buildingLabel5 = new JLabel();
        buildingLabel6 = new JLabel();
        buildingLabel7 = new JLabel();
        buildingLabel8 = new JLabel();
        buildingLabel9 = new JLabel();
        buildingLabel10 = new JLabel();
        buildingLabel11 = new JLabel();
        buildingLabel12 = new JLabel();
        buildingLabel13 = new JLabel();
        buildingLabel14 = new JLabel();
        buildingLabel15 = new JLabel();
        buildingLabel16 = new JLabel();
        buildingLabel17 = new JLabel();
        buildingLabel18 = new JLabel();
        buildingLabel19 = new JLabel();
        buildingLabel20 = new JLabel();
        buildingLabel21 = new JLabel();

        deed = new JLabel();
        deed.setBounds(750,750,500,750);
        deed.setVisible(true);
        bottom_9.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/1deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        bottom_7.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/3deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        bottom_5.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/5deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        bottom_4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/6deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        bottom_2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/8deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        bottom_1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/9deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        left_9.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/11deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        left_8.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/12deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        left_7.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/13deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        left_6.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/14deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        left_5.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/15deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        left_4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/16deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });


        left_1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/19deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        top_1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/21deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        top_3.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/23deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        top_4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/24deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        top_5.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/25deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        top_7.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/27deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        top_9.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/29deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        right_1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/31deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        right_2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/32deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        right_4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/34deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        right_5.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/35deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        right_7.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/37deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        right_9.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "res/39deed.png"));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        boardPanels.add(bottomRight);
        boardPanels.add(bottom_9);
        boardPanels.add(bottom_8);
        boardPanels.add(bottom_7);
        boardPanels.add(bottom_6);
        boardPanels.add(bottom_5);
        boardPanels.add(bottom_4);
        boardPanels.add(bottom_3);
        boardPanels.add(bottom_2);
        boardPanels.add(bottom_1);
        boardPanels.add(bottomLeft);
        boardPanels.add(left_9);
        boardPanels.add(left_8);
        boardPanels.add(left_7);
        boardPanels.add(left_6);
        boardPanels.add(left_5);
        boardPanels.add(left_4);
        boardPanels.add(left_3);
        boardPanels.add(left_2);
        boardPanels.add(left_1);
        boardPanels.add(topLeft);
        boardPanels.add(top_1);
        boardPanels.add(top_2);
        boardPanels.add(top_3);
        boardPanels.add(top_4);
        boardPanels.add(top_5);
        boardPanels.add(top_6);
        boardPanels.add(top_7);
        boardPanels.add(top_8);
        boardPanels.add(top_9);
        boardPanels.add(topRight);
        boardPanels.add(right_1);
        boardPanels.add(right_2);
        boardPanels.add(right_3);
        boardPanels.add(right_4);
        boardPanels.add(right_5);
        boardPanels.add(right_6);
        boardPanels.add(right_7);
        boardPanels.add(right_8);
        boardPanels.add(right_9);

        bottomRightLabel = new JLabel();
        bottomLeftLabel = new JLabel();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/0.png"));
            bottomRightLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/10.png"));
            bottomLeftLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }

        bottom1Label = new JLabel();
        bottom2Label = new JLabel();
        bottom3Label = new JLabel();
        bottom4Label = new JLabel();
        bottom5Label = new JLabel();
        bottom6Label = new JLabel();
        bottom7Label = new JLabel();
        bottom8Label = new JLabel();
        bottom9Label = new JLabel();

        setBottom1Clean();
        setBottom2Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/7.png"));
            bottom3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setBottom4Clean();
        setBottom5Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/4.png"));
            bottom6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setBottom7Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/2.png"));
            bottom8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setBottom9Clean();
        bottom_1.setLayout(flow);
        bottom_2.setLayout(flow);
        bottom_3.setLayout(flow);
        bottom_4.setLayout(flow);
        bottom_5.setLayout(flow);
        bottom_6.setLayout(flow);
        bottom_7.setLayout(flow);
        bottom_8.setLayout(flow);
        bottom_9.setLayout(flow);
        bottomRight.setLayout(flow);
        bottomLeft.setLayout(flow);
        bottomRight.add(bottomRightLabel);
        bottomLeft.add(bottomLeftLabel);

        bottom_1.add(bottom1Label);
        bottom_2.add(bottom2Label);
        bottom_3.add(bottom3Label);
        bottom_4.add(bottom4Label);
        bottom_5.add(bottom5Label);
        bottom_6.add(bottom6Label);
        bottom_7.add(bottom7Label);
        bottom_8.add(bottom8Label);
        bottom_9.add(bottom9Label);
        left1Label = new JLabel();
        left2Label = new JLabel();
        left3Label = new JLabel();
        left4Label = new JLabel();
        left5Label = new JLabel();
        left6Label = new JLabel();
        left7Label = new JLabel();
        left8Label = new JLabel();
        left9Label = new JLabel();

        setLeft1Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/18.png"));
            left2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/17.png"));
            left3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setLeft4Clean();
        setLeft5Clean();
        setLeft6Clean();
        setLeft7Clean();
        setLeft8Clean();
        setLeft9Clean();

        left_1.setLayout(flow);
        left_2.setLayout(flow);
        left_3.setLayout(flow);
        left_4.setLayout(flow);
        left_5.setLayout(flow);
        left_6.setLayout(flow);
        left_7.setLayout(flow);
        left_8.setLayout(flow);
        left_9.setLayout(flow);
        left_1.add(left1Label);
        left_2.add(left2Label);
        left_3.add(left3Label);
        left_4.add(left4Label);
        left_5.add(left5Label);
        left_6.add(left6Label);
        left_7.add(left7Label);
        left_8.add(left8Label);
        left_9.add(left9Label);

        top3Label = new JLabel();
        top4Label = new JLabel();
        top5Label = new JLabel();
        top6Label = new JLabel();
        top7Label = new JLabel();
        top8Label = new JLabel();
        top9Label = new JLabel();

        topLeft.setLayout(flow);
        top_1.setLayout(flow);
        top_2.setLayout(flow);
        top_3.setLayout(flow);
        top_4.setLayout(flow);
        top_5.setLayout(flow);
        top_6.setLayout(flow);
        top_7.setLayout(flow);
        top_8.setLayout(flow);
        top_9.setLayout(flow);
        topLeft.add(topLeftLabel);
        top_1.add(top1Label);
        top_2.add(top2Label);
        top_3.add(top3Label);
        top_4.add(top4Label);
        top_5.add(top5Label);
        top_6.add(top6Label);
        top_7.add(top7Label);
        top_8.add(top8Label);
        top_9.add(top9Label);

        setTop1Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/22.pngg"));
            top2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/20.png"));
            topLeftLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setTop3Clean();
        setTop4Clean();
        setTop5Clean();
        setTop7Clean();
        setTop8Clean();
        setTop9Clean();
        topRightLabel = new JLabel();
        right1Label = new JLabel();
        right2Label = new JLabel();
        right3Label = new JLabel();
        right4Label = new JLabel();
        right5Label = new JLabel();
        right6Label = new JLabel();
        right7Label = new JLabel();
        right8Label = new JLabel();
        right9Label = new JLabel();

        topRight.setLayout(flow);
        right_1.setLayout(flow);
        right_2.setLayout(flow);
        right_3.setLayout(flow);
        right_4.setLayout(flow);
        right_5.setLayout(flow);
        right_6.setLayout(flow);
        right_7.setLayout(flow);
        right_8.setLayout(flow);
        right_9.setLayout(flow);
        topRight.add(topRightLabel);
        right_1.add(right1Label);
        right_2.add(right2Label);
        right_3.add(right3Label);
        right_4.add(right4Label);
        right_5.add(right5Label);
        right_6.add(right6Label);
        right_7.add(right7Label);
        right_8.add(right8Label);
        right_9.add(right9Label);

        setRight1Clean();
        setRight2Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/33.png"));
            right3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setRight4Clean();
        setRight5Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res36.png"));
            right6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setRight7Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res37.png"));
            right8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setRight9Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/30.png"));
            topRightLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        frame.getContentPane().add(bottomLeft, -1);
        frame.getContentPane().add(topLeft, -1);
        frame.getContentPane().add(left_1, -1);
        frame.getContentPane().add(left_2, -1);
        frame.getContentPane().add(left_3, -1);
        frame.getContentPane().add(left_4, -1);
        frame.getContentPane().add(left_5, -1);
        frame.getContentPane().add(left_6, -1);
        frame.getContentPane().add(left_7, -1);
        frame.getContentPane().add(left_8, -1);
        frame.getContentPane().add(left_9, -1);
        frame.getContentPane().add(top_1, -1);
        frame.getContentPane().add(top_2, -1);
        frame.getContentPane().add(top_3, -1);
        frame.getContentPane().add(top_4, -1);
        frame.getContentPane().add(top_5, -1);
        frame.getContentPane().add(top_6, -1);
        frame.getContentPane().add(top_7, -1);
        frame.getContentPane().add(top_8, -1);
        frame.getContentPane().add(top_9, -1);
        frame.getContentPane().add(topRight, -1);
        frame.getContentPane().add(right_1, -1);
        frame.getContentPane().add(right_2, -1);
        frame.getContentPane().add(right_3, -1);
        frame.getContentPane().add(right_4, -1);
        frame.getContentPane().add(right_5, -1);
        frame.getContentPane().add(right_6, -1);
        frame.getContentPane().add(right_7, -1);
        frame.getContentPane().add(right_8, -1);
        frame.getContentPane().add(right_9, -1);
        frame.getContentPane().add(bottom_1, -1);
        frame.getContentPane().add(bottom_2, -1);
        frame.getContentPane().add(bottom_3, -1);
        frame.getContentPane().add(bottom_4, -1);
        frame.getContentPane().add(bottom_5, -1);
        frame.getContentPane().add(bottom_6, -1);
        frame.getContentPane().add(bottom_7, -1);
        frame.getContentPane().add(bottom_8, -1);
        frame.getContentPane().add(bottom_9, -1);

    }

    private void setBottom1Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/9.png"));
            bottom1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setBottom2Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/8.png"));
            bottom2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setBottom4Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/6.png"));
            bottom4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setBottom5Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/5.png"));
            bottom5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setBottom7Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/3.png"));
            bottom7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setBottom9Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/1.png"));
            bottom9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setLeft1Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/19.png"));
            left1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setLeft4Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/16.png"));
            left4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setLeft5Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/15.png"));
            left5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setLeft6Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/14.png"));
            left6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setLeft7Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/13.png"));
            left7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setLeft8Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/12.png"));
            left8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setLeft9Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/11.png"));
            left9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setTop1Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/21.png"));
            top1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setTop3Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/23.png"));
            top3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setTop4Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/24.png"));
            top4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setTop5Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/25.png"));
            top5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setTop7Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/27.png"));
            top7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setTop8Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/28.png"));
            top8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setTop9Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/29.png"));
            top9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setRight1Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/31.png"));
            right1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setRight2Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/32.png"));
            right1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setRight4Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/34.png"));
            right4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setRight5Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/35.png"));
            right5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setRight7Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/37.png"));
            right7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }
    private void setRight9Clean(){
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "res/39.png"));
            right9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex){
        }
    }

}
