import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Monopoly {

    private DeckOfChanceAndFortuneCards deck;
    private JFrame frame;
    private JLayeredPane center;
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
    private JLayeredPane player_1;
    private JLayeredPane player_2;
    private JLayeredPane player_3;
    private JLayeredPane player_4;
    private JScrollPane gameLog;
    private JTextArea logText;
    private String log;
    private JLayeredPane gameConsole;
    private int frameHeight;
    private JButton fortuneButton;
    private JButton chanceButton;
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
    private JButton addPlayer1;
    private JButton addPlayer2;
    private JButton addPlayer3;
    private JButton addPlayer4;
    private JButton startGame;
    private JButton finishTurn;
    private JTextField player1name;
    private JTextField player2name;
    private JTextField player3name;
    private JTextField player4name;
    private JButton addPlayer1Name;
    private JButton addPlayer2Name;
    private JButton addPlayer3Name;
    private JButton addPlayer4Name;
    private JLabel player1nameLabel;
    private JLabel player2nameLabel;
    private JLabel player3nameLabel;
    private JLabel player4nameLabel;
    private JLabel player1balance;
    private JLabel player2balance;
    private JLabel player3balance;
    private JLabel player4balance;
    private JLabel player1mana;
    private JLabel player2mana;
    private JLabel player3mana;
    private JLabel player4mana;
    private JButton rollTheDice;
    private JLabel dice1;
    private JLabel dice2;
    private int randomDice1;
    private int randomDice2;
    private Random random;
    private int doubleCounter;
    private RentValues entities;
    private ArrayList<Player> players;
    private ArrayList<JLayeredPane> boardPanels;
    private int playerIndex;
    private JLabel player1getOutOfJailLabel;
    private JLabel player2getOutOfJailLabel;
    private JLabel player3getOutOfJailLabel;
    private JLabel player4getOutOfJailLabel;
    private JLabel player1;
    private JLabel player2;
    private JLabel player3;
    private JLabel player4;
    private ArrayList<JLabel> playerIndicators;
    private ArrayList<JLabel> balanceLabels;
    private ArrayList<JLabel> energyLabels;
    private JLabel gamePrompt;
    private JButton useGetOutOfJailCard;
    private JButton dontUseGetOutOfJailCard;
    private JButton pay50toGetOutOfJail;
    private JButton buyProperty;
    private JButton dontBuyProperty;
    private JButton payRent;
    private boolean extraRollNeeded;
    private ArrayList<JLayeredPane> playersPanes;
    private ArrayList<JLabel> getOutOfJailLabels;
    double rentValue;
    private int ownerIndex;
    private JComboBox<String> buyUnwantedProperty;
    private DefaultComboBoxModel<String> buyUnwantedPropertyModel;
    private JTextField priceOfUnwantedProperty;
    private double valueOfUnwantedProperty;
    private JButton buyUnwantedPropertyButton;
    private JLabel mortgageManagement;
    private JComboBox<String> mortgageComboBox;
    private DefaultComboBoxModel<String> mortgageModel;
    private JButton takeLoan;
    private JButton payLoan;
    private JLabel sellProperty;
    private JComboBox<String> sellPropertyComboBox;
    private DefaultComboBoxModel<String> sellPropertyModel;
    private JComboBox<String> buyer;
    private DefaultComboBoxModel<String> buyerModel;
    private JTextField sellingPrice;
    private JButton sellPropertyButton;
    private JLabel buyPlanet;
    private JComboBox<String> addPlanetTo;
    private DefaultComboBoxModel<String> addPlanetToModel;
    private JButton addUpgradeButton;
    private JButton addPerfectPlanetButton;
    private JLabel perfectPlanetLabel0;
    private JLabel perfectPlanetLabel1;
    private JLabel perfectPlanetLabel2;
    private JLabel perfectPlanetLabel3;
    private JLabel perfectPlanetLabel4;
    private JLabel perfectPlanetLabel5;
    private JLabel perfectPlanetLabel6;
    private JLabel perfectPlanetLabel7;
    private JLabel perfectPlanetLabel8;
    private JLabel perfectPlanetLabel9;
    private JLabel perfectPlanetLabel10;
    private JLabel perfectPlanetLabel11;
    private JLabel perfectPlanetLabel12;
    private JLabel perfectPlanetLabel13;
    private JLabel perfectPlanetLabel14;
    private JLabel perfectPlanetLabel15;
    private JLabel perfectPlanetLabel16;
    private JLabel perfectPlanetLabel17;
    private JLabel perfectPlanetLabel18;
    private JLabel perfectPlanetLabel19;
    private JLabel perfectPlanetLabel20;
    private JLabel perfectPlanetLabel21;
    private ArrayList<JLabel> perfectPlanetLabels;
    private boolean upgradeOrPerfectPlanetBought;
    private boolean gotDouble;
    private boolean chanceCardPicked;
    private boolean sentByChanceCard;
    private boolean fortuneCardPicked;
    private int numberOfPerfectPlanets;
    private int numberOfUpgrades;
    private JLabel deed;
    private boolean rentCalculated;
    private JButton declareBankruptcyFromGame;
    private boolean paymentDue;
    private double paymentDueAmount;
    private boolean manaDue;
    private double manaDueAmount;
    private JButton payArrears;
    private int arrearsIndex;
    private JLabel sellGetOutOfJailCard;
    private JComboBox<String> cardBuyers;
    private DefaultComboBoxModel<String> cardBuyersModel;
    private JTextField cardPrice;
    private JButton sellGetOutOfJailCardButton;
    private int valueOfSoldCard;
    private JButton yesButton;
    private JButton noButton;
    private JButton restartGame;
    private JScrollPane howToPlay;
    private JLabel instruction;
    private JLabel buyOwnedProperty;
    private JComboBox<String> ownedProperties;
    private JTextField propertyOwner;
    private JTextField ownedPropertyValue;
    private JButton buyOwnedPropertyButton;
    private DefaultComboBoxModel<String> ownedPropertiesModel;
    private double valueOfOwnedProperty;
    private JButton showInstruction;
    private JButton hideInstruction;
    private int frameWidth;

    // Launch the application.
    public static void main(String[] args) {
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

    // Create the main frame
    public Monopoly() {
        deck = new DeckOfChanceAndFortuneCards();
        players = new ArrayList<Player>();
        entities = new RentValues();
        random = new Random();
        boardPanels = new ArrayList<JLayeredPane>();
        playerIndicators = new ArrayList<JLabel>();
        balanceLabels = new ArrayList<JLabel>();
        energyLabels = new ArrayList<JLabel>();
        playerIndex = 0;
        doubleCounter = 0;
        playersPanes = new ArrayList<JLayeredPane>();
        getOutOfJailLabels = new ArrayList<JLabel>();
        perfectPlanetLabels = new ArrayList<JLabel>();
        upgradeOrPerfectPlanetBought = false;
        numberOfPerfectPlanets = 12;
        numberOfUpgrades = 32;
        initialize();
    }

    // Initialise the contents of the frame
    private void initialize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        FlowLayout flow = new FlowLayout();
        flow.setHgap(0);
        flow.setVgap(0);
        frame = new JFrame("Monopoly Flop Team");
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
        frameHeight = frame.getHeight() - 40;
        frameWidth = frame.getWidth();
        showInstruction = new JButton();
        showInstruction.setBounds(frameWidth - 45, 10, 40, 40);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("/helpIcon.png")));
            showInstruction.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
         showInstruction.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
         0));
         showInstruction.setBorderPainted(false);
         showInstruction.setContentAreaFilled(false);
        showInstruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                howToPlay.setVisible(true);
                hideInstruction.setVisible(true);
                showInstruction.setVisible(false);
            }
        });
        hideInstruction = new JButton();
        hideInstruction.setBounds(frameWidth - 65, 10, 40, 40);
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "hideInstruction.png"));
            hideInstruction.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        hideInstruction.setVisible(false);
        hideInstruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                howToPlay.setVisible(false);
                hideInstruction.setVisible(false);
                showInstruction.setVisible(true);
            }
        });

//        Create board
//        center = new JLayeredPane();
//        center.setBounds(7,7,(int) (frameHeight - frameHeight / 13 ),(int) (frameHeight - frameHeight / 13));
        topLeft = new JLayeredPane();
        topLeft.setBounds(0, 0, (int) (frameHeight / 6.5),
                (int) (frameHeight / 6.5));
        left_1 = new JLayeredPane();
        left_1.setBounds(0, (int) (frameHeight / 6.5),
                (int) (frameHeight / 6.5), (int) (frameHeight / 13));
        left_2 = new JLayeredPane();
        left_2.setBounds(0, (int) (frameHeight / 6.5 * 1.5),
                (int) (frameHeight / 6.5), (int) (frameHeight / 13));
        left_3 = new JLayeredPane();
        left_3.setBounds(0, (int) (frameHeight / 6.5 * 2),
                (int) (frameHeight / 6.5), (int) (frameHeight / 13));
        left_4 = new JLayeredPane();
        left_4.setBounds(0, (int) (frameHeight / 6.5 * 2.5),
                (int) (frameHeight / 6.5), (int) (frameHeight / 13));
        left_5 = new JLayeredPane();
        left_5.setBounds(0, (int) (frameHeight / 6.5 * 3),
                (int) (frameHeight / 6.5), (int) (frameHeight / 13));
        left_6 = new JLayeredPane();
        left_6.setBounds(0, (int) (frameHeight / 6.5 * 3.5),
                (int) (frameHeight / 6.5), (int) (frameHeight / 13));
        left_7 = new JLayeredPane();
        left_7.setBounds(0, (int) (frameHeight / 6.5 * 4),
                (int) (frameHeight / 6.5), (int) (frameHeight / 13));
        left_8 = new JLayeredPane();
        left_8.setBounds(0, (int) (frameHeight / 6.5 * 4.5),
                (int) (frameHeight / 6.5), (int) (frameHeight / 13));
        left_9 = new JLayeredPane();
        left_9.setBounds(0, (int) (frameHeight / 6.5 * 5),
                (int) (frameHeight / 6.5), (int) (frameHeight / 13));
        bottomLeft = new JLayeredPane();
        bottomLeft.setBounds(0, (int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5), (int) (frameHeight / 6.5));
        top_1 = new JLayeredPane();
        top_1.setBounds((int) (frameHeight / 6.5), 0, (int) (frameHeight / 13),
                (int) (frameHeight / 6.5));
        top_2 = new JLayeredPane();
        top_2.setBounds((int) (frameHeight / 6.5 * 1.5), 0,
                (int) (frameHeight / 13), (int) (frameHeight / 6.5));
        top_3 = new JLayeredPane();
        top_3.setBounds((int) (frameHeight / 6.5 * 2), 0,
                (int) (frameHeight / 13), (int) (frameHeight / 6.5));
        top_4 = new JLayeredPane();
        top_4.setBounds((int) (frameHeight / 6.5 * 2.5), 0,
                (int) (frameHeight / 13), (int) (frameHeight / 6.5));
        top_5 = new JLayeredPane();
        top_5.setBounds((int) (frameHeight / 6.5 * 3), 0,
                (int) (frameHeight / 13), (int) (frameHeight / 6.5));
        top_6 = new JLayeredPane();
        top_6.setBounds((int) (frameHeight / 6.5 * 3.5), 0,
                (int) (frameHeight / 13), (int) (frameHeight / 6.5));
        top_7 = new JLayeredPane();
        top_7.setBounds((int) (frameHeight / 6.5 * 4), 0,
                (int) (frameHeight / 13), (int) (frameHeight / 6.5));
        top_8 = new JLayeredPane();
        top_8.setBounds((int) (frameHeight / 6.5 * 4.5), 0,
                (int) (frameHeight / 13), (int) (frameHeight / 6.5));
        top_9 = new JLayeredPane();
        top_9.setBounds((int) (frameHeight / 6.5 * 5), 0,
                (int) (frameHeight / 13), (int) (frameHeight / 6.5));
        topRight = new JLayeredPane();
        topRight.setBounds((int) (frameHeight / 6.5 * 5.5), 0,
                (int) (frameHeight / 6.5), (int) (frameHeight / 6.5));
        right_1 = new JLayeredPane();
        right_1.setBounds((int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5), (int) (frameHeight / 6.5),
                (int) (frameHeight / 13));
        right_2 = new JLayeredPane();
        right_2.setBounds((int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5 * 1.5), (int) (frameHeight / 6.5),
                (int) (frameHeight / 13));
        right_3 = new JLayeredPane();
        right_3.setBounds((int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5 * 2), (int) (frameHeight / 6.5),
                (int) (frameHeight / 13));
        right_4 = new JLayeredPane();
        right_4.setBounds((int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5 * 2.5), (int) (frameHeight / 6.5),
                (int) (frameHeight / 13));
        right_5 = new JLayeredPane();
        right_5.setBounds((int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5 * 3), (int) (frameHeight / 6.5),
                (int) (frameHeight / 13));
        right_6 = new JLayeredPane();
        right_6.setBounds((int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5 * 3.5), (int) (frameHeight / 6.5),
                (int) (frameHeight / 13));
        right_7 = new JLayeredPane();
        right_7.setBounds((int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5 * 4), (int) (frameHeight / 6.5),
                (int) (frameHeight / 13));
        right_8 = new JLayeredPane();
        right_8.setBounds((int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5 * 4.5), (int) (frameHeight / 6.5),
                (int) (frameHeight / 13));
        right_9 = new JLayeredPane();
        right_9.setBounds((int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5 * 5), (int) (frameHeight / 6.5),
                (int) (frameHeight / 13));
        bottom_1 = new JLayeredPane();
        bottom_1.setBounds((int) (frameHeight / 6.5),
                (int) (frameHeight / 6.5 * 5.5), (int) (frameHeight / 13),
                (int) (frameHeight / 6.5));
        bottom_2 = new JLayeredPane();
        bottom_2.setBounds((int) (frameHeight / 6.5 * 1.5),
                (int) (frameHeight / 6.5 * 5.5), (int) (frameHeight / 13),
                (int) (frameHeight / 6.5));
        bottom_3 = new JLayeredPane();
        bottom_3.setBounds((int) (frameHeight / 6.5 * 2),
                (int) (frameHeight / 6.5 * 5.5), (int) (frameHeight / 13),
                (int) (frameHeight / 6.5));
        bottom_4 = new JLayeredPane();
        bottom_4.setBounds((int) (frameHeight / 6.5 * 2.5),
                (int) (frameHeight / 6.5 * 5.5), (int) (frameHeight / 13),
                (int) (frameHeight / 6.5));
        bottom_5 = new JLayeredPane();
        bottom_5.setBounds((int) (frameHeight / 6.5 * 3),
                (int) (frameHeight / 6.5 * 5.5), (int) (frameHeight / 13),
                (int) (frameHeight / 6.5));
        bottom_6 = new JLayeredPane();
        bottom_6.setBounds((int) (frameHeight / 6.5 * 3.5),
                (int) (frameHeight / 6.5 * 5.5), (int) (frameHeight / 13),
                (int) (frameHeight / 6.5));
        bottom_7 = new JLayeredPane();
        bottom_7.setBounds((int) (frameHeight / 6.5 * 4),
                (int) (frameHeight / 6.5 * 5.5), (int) (frameHeight / 13),
                (int) (frameHeight / 6.5));
        bottom_8 = new JLayeredPane();
        bottom_8.setBounds((int) (frameHeight / 6.5 * 4.5),
                (int) (frameHeight / 6.5 * 5.5), (int) (frameHeight / 13),
                (int) (frameHeight / 6.5));
        bottom_9 = new JLayeredPane();
        bottom_9.setBounds((int) (frameHeight / 6.5 * 5),
                (int) (frameHeight / 6.5 * 5.5), (int) (frameHeight / 13),
                (int) (frameHeight / 6.5));
        bottomRight = new JLayeredPane();
        bottomRight.setBounds((int) (frameHeight / 6.5 * 5.5),
                (int) (frameHeight / 6.5 * 5.5), (int) (frameHeight / 6.5),
                (int) (frameHeight / 6.5));
        deed = new JLabel();
        deed.setBounds((int) (frameHeight / 6.5 * 1.95),
                (int) (frameHeight / 6.5 * 1.6), (int) (frameHeight * 0.4),
                (int) (frameHeight * 0.5));
        deed.setVisible(true);
        bottom_9.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "1deed.png"));
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
                            "3deed.png"));
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
                            "5deed.png"));
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
                            "6deed.png"));
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
                            "8deed.png"));
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
                            "9deed.png"));
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
                            "11deed.png"));
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
                            "12deed.png"));
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
                            "13deed.png"));
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
                            "14deed.png"));
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
                            "15deed.png"));
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
                            "16deed.png"));
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

        left_2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "19deed.png"));
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
                            "19deed.png"));
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
                            "21deed.png"));
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
                            "23deed.png"));
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
                            "24deed.png"));
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
                            "25deed.png"));
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
                            "27deed.png"));
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

        top_8.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "28deed.png"));
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
                            "29deed.png"));
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
                            "31deed.png"));
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
                            "32deed.png"));
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
                            "34deed.png"));
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
                            "35deed.png"));
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
                            "37deed.png"));
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
                            "39deed.png"));
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

        perfectPlanetLabel0 = new JLabel();
        perfectPlanetLabel1 = new JLabel();
        perfectPlanetLabel2 = new JLabel();
        perfectPlanetLabel3 = new JLabel();
        perfectPlanetLabel4 = new JLabel();
        perfectPlanetLabel5 = new JLabel();
        perfectPlanetLabel6 = new JLabel();
        perfectPlanetLabel7 = new JLabel();
        perfectPlanetLabel8 = new JLabel();
        perfectPlanetLabel9 = new JLabel();
        perfectPlanetLabel10 = new JLabel();
        perfectPlanetLabel11 = new JLabel();
        perfectPlanetLabel12 = new JLabel();
        perfectPlanetLabel13 = new JLabel();
        perfectPlanetLabel14 = new JLabel();
        perfectPlanetLabel15 = new JLabel();
        perfectPlanetLabel16 = new JLabel();
        perfectPlanetLabel17 = new JLabel();
        perfectPlanetLabel18 = new JLabel();
        perfectPlanetLabel19 = new JLabel();
        perfectPlanetLabel20 = new JLabel();
        perfectPlanetLabel21 = new JLabel();

        perfectPlanetLabel0.setBounds((int) (frameHeight / 6.5 * 5) + 1,
                (int) (frameHeight / 6.5 * 5.5) + 1, 50, 25);
        perfectPlanetLabel1.setBounds((int) (frameHeight / 6.5 * 4) + 1,
                (int) (frameHeight / 6.5 * 5.5) + 1, 50, 25);
        perfectPlanetLabel2.setBounds((int) (frameHeight / 6.5 * 2.5) + 1,
                (int) (frameHeight / 6.5 * 5.5) + 1, 50, 25);
        perfectPlanetLabel3.setBounds((int) (frameHeight / 6.5 * 1.5) + 1,
                (int) (frameHeight / 6.5 * 5.5) + 1, 50, 25);
        perfectPlanetLabel4.setBounds((int) (frameHeight / 6.5) + 1,
                (int) (frameHeight / 6.5 * 5.5) + 1, 50, 25);
        perfectPlanetLabel5.setBounds((int) (frameHeight / 6.5) - 26,
                (int) (frameHeight / 6.5 * 5) + 4, 25, 50);
        perfectPlanetLabel6.setBounds((int) (frameHeight / 6.5) - 26,
                (int) (frameHeight / 6.5 * 4) + 4, 25, 50);
        perfectPlanetLabel7.setBounds((int) (frameHeight / 6.5) - 26,
                (int) (frameHeight / 6.5 * 3.5) + 4, 25, 50);
        perfectPlanetLabel8.setBounds((int) (frameHeight / 6.5) - 26,
                (int) (frameHeight / 6.5 * 2.5) + 4, 25, 50);
        perfectPlanetLabel9.setBounds((int) (frameHeight / 6.5) - 26,
                (int) (frameHeight / 6.5 * 1.5) + 4, 25, 50);
        perfectPlanetLabel10.setBounds((int) (frameHeight / 6.5) - 26,
                (int) (frameHeight / 6.5) + 4, 25, 50);
        perfectPlanetLabel11.setBounds((int) (frameHeight / 6.5) + 1,
                (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel12.setBounds((int) (frameHeight / 6.5 * 2) + 1,
                (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel13.setBounds((int) (frameHeight / 6.5 * 2.5) + 1,
                (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel14.setBounds((int) (frameHeight / 6.5 * 3.5) + 1,
                (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel15.setBounds((int) (frameHeight / 6.5 * 4) + 1,
                (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel16.setBounds((int) (frameHeight / 6.5 * 5) + 1,
                (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel17.setBounds((int) (frameHeight / 6.5 * 5.5) + 1,
                (int) (frameHeight / 6.5) + 1, 25, 50);
        perfectPlanetLabel18.setBounds((int) (frameHeight / 6.5 * 5.5) + 1,
                (int) (frameHeight / 6.5 * 1.5) + 1, 25, 50);
        perfectPlanetLabel19.setBounds((int) (frameHeight / 6.5 * 5.5) + 1,
                (int) (frameHeight / 6.5 * 2.5) + 1, 25, 50);
        perfectPlanetLabel20.setBounds((int) (frameHeight / 6.5 * 5.5) + 1,
                (int) (frameHeight / 6.5 * 4) + 1, 25, 50);
        perfectPlanetLabel21.setBounds((int) (frameHeight / 6.5 * 5.5) + 1,
                (int) (frameHeight / 6.5 * 5) + 1, 25, 50);

        perfectPlanetLabels.add(perfectPlanetLabel0);
        perfectPlanetLabels.add(perfectPlanetLabel1);
        perfectPlanetLabels.add(perfectPlanetLabel2);
        perfectPlanetLabels.add(perfectPlanetLabel3);
        perfectPlanetLabels.add(perfectPlanetLabel4);
        perfectPlanetLabels.add(perfectPlanetLabel5);
        perfectPlanetLabels.add(perfectPlanetLabel6);
        perfectPlanetLabels.add(perfectPlanetLabel7);
        perfectPlanetLabels.add(perfectPlanetLabel8);
        perfectPlanetLabels.add(perfectPlanetLabel9);
        perfectPlanetLabels.add(perfectPlanetLabel10);
        perfectPlanetLabels.add(perfectPlanetLabel11);
        perfectPlanetLabels.add(perfectPlanetLabel12);
        perfectPlanetLabels.add(perfectPlanetLabel13);
        perfectPlanetLabels.add(perfectPlanetLabel14);
        perfectPlanetLabels.add(perfectPlanetLabel15);
        perfectPlanetLabels.add(perfectPlanetLabel16);
        perfectPlanetLabels.add(perfectPlanetLabel17);
        perfectPlanetLabels.add(perfectPlanetLabel18);
        perfectPlanetLabels.add(perfectPlanetLabel19);
        perfectPlanetLabels.add(perfectPlanetLabel20);
        perfectPlanetLabels.add(perfectPlanetLabel21);

        fortuneButton = new JButton("?");

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
//      boardPanels.add(center);

        bottomRightLabel = new JLabel();
        bottomLeftLabel = new JLabel();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "0.png"));
            bottomRightLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "10.png"));
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
                    "7.png"));
            bottom3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setBottom4Clean();
        setBottom5Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "4.png"));
            bottom6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setBottom7Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "2.png"));
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
                    "18.png"));
            left2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "17.png"));
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

        topLeftLabel = new JLabel();
        top1Label = new JLabel();
        top2Label = new JLabel();
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
                    "22.png"));
            top2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "20.png"));
            topLeftLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setTop3Clean();
        setTop4Clean();
        setTop5Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "26.png"));
            top6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
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
                    "33.png"));
            right3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setRight4Clean();
        setRight5Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "36.png"));
            right6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setRight7Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "38.png"));
            right8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        setRight9Clean();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "30.png"));
            topRightLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }

        // Chance and Fortune
        fortuneButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "fortune.png"));
            fortuneButton.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        fortuneButton.setBounds((int) (frameHeight / 6.5 * 1.125),
                (int) (frameHeight / 6.5 * 1.125), (int) (frameHeight / 3.33),
                (int) (frameHeight / 5));
        fortuneButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        fortuneButton.setBorderPainted(false);
        fortuneButton.setContentAreaFilled(false);
        // fortuneButton.setEnabled(false);
        chanceButton = new JButton();
        chanceButton.setBounds((int) (frameHeight / 6.5 * 3.5),
                (int) (frameHeight / 6.5 * 4), (int) (frameHeight / 3.33),
                (int) (frameHeight / 5));
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "chance.png"));
            chanceButton.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        chanceButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chanceButton.setBorderPainted(false);
        chanceButton.setContentAreaFilled(false);
        // chanceButton.setEnabled(false);

        // Player information
        player_1 = new JLayeredPane();
        player_1.setBounds(frameHeight + 40, 0, (int) (frameHeight / 4),
                (int) (frameHeight / 6.5));
        player_1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        player1name = new JTextField();
        player1name.setBounds(20, 10, 140, 30);
        player1name.setFont(new Font("Arial", Font.ITALIC, 14));
        player1name.setHorizontalAlignment(SwingConstants.CENTER);
        player1name.setVisible(false);
        player_1.add(player1name);

        player_2 = new JLayeredPane();
        player_2.setBounds(frameHeight + 42 + (int) (frameHeight / 4), 0,
                (int) (frameHeight / 4), (int) (frameHeight / 6.5));
        player_2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        player2name = new JTextField();
        player2name.setBounds(20, 10, 140, 30);
        player2name.setFont(new Font("Arial", Font.ITALIC, 14));
        player2name.setHorizontalAlignment(SwingConstants.CENTER);
        player2name.setVisible(false);
        player_2.add(player2name);

        player_3 = new JLayeredPane();
        player_3.setBounds(frameHeight + 44 + (int) (frameHeight / 2), 0,
                (int) (frameHeight / 4), (int) (frameHeight / 6.5));
        player_3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        player3name = new JTextField();
        player3name.setBounds(20, 10, 140, 30);
        player3name.setFont(new Font("Arial", Font.ITALIC, 14));
        player3name.setHorizontalAlignment(SwingConstants.CENTER);
        player3name.setVisible(false);
        player_3.add(player3name);

        player_4 = new JLayeredPane();
        player_4.setBounds(frameHeight + 40, (int) (frameHeight / 6.5) + 2,
                (int) (frameHeight / 4), (int) (frameHeight / 6.5));
        player_4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        player4name = new JTextField();
        player4name.setBounds(20, 10, 140, 30);
        player4name.setFont(new Font("Arial", Font.ITALIC, 14));
        player4name.setHorizontalAlignment(SwingConstants.CENTER);
        player4name.setVisible(false);
        player_4.add(player4name);

        playersPanes.add(player_1);
        playersPanes.add(player_2);
        playersPanes.add(player_3);
        playersPanes.add(player_4);

        gameConsole = new JLayeredPane();
        gamePrompt = new JLabel();
        gamePrompt.setBounds(frameHeight + 50, (int) (frameHeight / 2 + 15),
                (int) (frameHeight / 4) * 3 - 20, 15);
        pay50toGetOutOfJail = new JButton("Pay 50 Galy to get out of Jail");
        pay50toGetOutOfJail.setBounds(frameHeight + 200,
                (int) (frameHeight / 2 + 60), 230, 20);
        pay50toGetOutOfJail.setVisible(false);
        gamePrompt.setHorizontalAlignment(SwingConstants.CENTER);
        gamePrompt.setForeground(Color.RED);
        useGetOutOfJailCard = new JButton("Use the card");
        dontUseGetOutOfJailCard = new JButton("Don't use the card");
        useGetOutOfJailCard.setBounds(frameHeight + 150,
                (int) (frameHeight / 2 + 35), 160, 20);
        dontUseGetOutOfJailCard.setBounds(frameHeight + 320,
                (int) (frameHeight / 2 + 35), 160, 20);
        useGetOutOfJailCard.setVisible(false);
        dontUseGetOutOfJailCard.setVisible(false);
        buyProperty = new JButton("Buy");
        dontBuyProperty = new JButton("Don't buy");
        payRent = new JButton("Pay rent");
        payArrears = new JButton("Pay arrears");
        payArrears.setBounds(frameHeight + 200, (int) (frameHeight / 2 + 60),
                230, 20);
        declareBankruptcyFromGame = new JButton("declare BANKRUPTCY from game");
        yesButton = new JButton("Yes");
        noButton = new JButton("No");
        yesButton.setVisible(false);
        noButton.setVisible(false);
        yesButton.setBounds(frameHeight + 180, (int) (frameHeight / 2 + 35),
                135, 20);
        noButton.setBounds(frameHeight + 325, (int) (frameHeight / 2 + 35),
                135, 20);
        declareBankruptcyFromGame.setBounds(frameHeight + 170,
                (int) (frameHeight / 2 + 35), 290, 20);
        buyProperty.setBounds(frameHeight + 150, (int) (frameHeight / 2 + 35),
                160, 20);
        dontBuyProperty.setBounds(frameHeight + 320,
                (int) (frameHeight / 2 + 35), 160, 20);
        payRent.setBounds(frameHeight + 200, (int) (frameHeight / 2 + 60), 230,
                20);
        declareBankruptcyFromGame.setVisible(false);
        buyProperty.setVisible(false);
        dontBuyProperty.setVisible(false);
        payRent.setVisible(false);
        payArrears.setVisible(false);
        logText = new JTextArea();
        logText.setFont(new Font("Arial", Font.BOLD, 12));
        log = "  /> the Game has started! May the best player wins the game.\n";
        logText.append(log);
        instruction = new JLabel();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "help.png"));
            instruction.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        instruction.setSize(1366, 5427);
        howToPlay = new JScrollPane(instruction);
        howToPlay.setSize(screenSize);
        howToPlay
                .setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        howToPlay.setVisible(false);
        gameLog = new JScrollPane(logText);
        gameConsole.setBounds(frameHeight + 40, (int) (frameHeight / 2),
                (int) (frameHeight / 4) * 3, (int) (frameHeight / 2.8));
        gameLog.setBounds(frameHeight + 40, (int) (frameHeight / 3.25 + 20),
                (int) (frameHeight / 4) * 3, (int) (frameHeight / 6.5));
        gameLog.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        Border lined = BorderFactory.createLineBorder(Color.black, 1);
        Border innerGameLog1 = BorderFactory.createTitledBorder(lined,
                "Game info:", 2, 2, new Font("Arial", Font.ITALIC, 12),
                Color.black);
        Border innerGameConsole1 = BorderFactory.createTitledBorder(lined,
                "Game console:", 2, 2, new Font("Arial", Font.ITALIC, 12),
                Color.black);
        Border outerBorder = BorderFactory.createEmptyBorder(2, 0, 2, 0);
        gameLog.setBorder(BorderFactory.createCompoundBorder(outerBorder,
                innerGameLog1));
        gameConsole.setBorder(BorderFactory.createCompoundBorder(outerBorder,
                innerGameConsole1));
        buyUnwantedProperty = new JComboBox<String>();
        buyUnwantedProperty.setBounds(frameHeight + 150,
                (int) (frameHeight / 2 + 35), 140, 20);
        buyUnwantedProperty.setVisible(false);
        buyUnwantedPropertyButton = new JButton("Buy");
        buyUnwantedPropertyButton.setBounds(frameHeight + 360,
                (int) (frameHeight / 2 + 35), 120, 20);
        buyUnwantedPropertyButton.setEnabled(false);
        buyUnwantedPropertyButton.setVisible(false);
        priceOfUnwantedProperty = new JTextField();
        priceOfUnwantedProperty.setBounds(frameHeight + 300,
                (int) (frameHeight / 2 + 35), 45, 20);
        priceOfUnwantedProperty.setVisible(false);
        gameLog.setVisible(false);
        mortgageManagement = new JLabel("Mortgage management >>");
        mortgageManagement.setBounds(frameHeight + 50,
                (int) (frameHeight / 2 + 90), 150, 20);
        mortgageComboBox = new JComboBox<String>();
        mortgageComboBox.setBounds(frameHeight + 205,
                (int) (frameHeight / 2 + 90), 160, 20);
        takeLoan = new JButton("Take a loan");
        payLoan = new JButton("Pay the loan");
        takeLoan.setBounds(frameHeight + 370, (int) (frameHeight / 2 + 90),
                100, 20);
        payLoan.setBounds(frameHeight + 475, (int) (frameHeight / 2 + 90), 105,
                20);
        mortgageManagement.setVisible(false);
        mortgageComboBox.setVisible(false);
        takeLoan.setVisible(false);
        payLoan.setVisible(false);

        sellProperty = new JLabel("Sell property >>");
        sellProperty.setBounds(frameHeight + 50, (int) (frameHeight / 2 + 120),
                90, 20);
        sellProperty.setVisible(true);
        sellPropertyComboBox = new JComboBox<String>();
        sellPropertyComboBox.setBounds(frameHeight + 155,
                (int) (frameHeight / 2 + 120), 160, 20);
        buyer = new JComboBox<String>();
        buyer.setBounds(frameHeight + 320, (int) (frameHeight / 2 + 120), 140,
                20);
        sellingPrice = new JTextField();
        sellingPrice.setBounds(frameHeight + 465,
                (int) (frameHeight / 2 + 120), 45, 20);
        sellPropertyButton = new JButton("Sell");
        sellPropertyButton.setBounds(frameHeight + 515,
                (int) (frameHeight / 2 + 120), 60, 20);
        sellProperty.setVisible(false);
        sellPropertyComboBox.setVisible(false);
        buyer.setVisible(false);
        sellingPrice.setVisible(false);
        sellPropertyButton.setVisible(false);

        buyOwnedProperty = new JLabel("Buy property >>");
        ownedProperties = new JComboBox<String>();
        propertyOwner = new JTextField();
        ownedPropertyValue = new JTextField();
        buyOwnedPropertyButton = new JButton("Buy");
        buyOwnedProperty.setBounds(frameHeight + 50,
                (int) (frameHeight / 2 + 150), 110, 20);
        ownedProperties.setBounds(frameHeight + 165,
                (int) (frameHeight / 2 + 150), 160, 20);
        propertyOwner.setBounds(frameHeight + 330,
                (int) (frameHeight / 2 + 150), 100, 20);
        ownedPropertyValue.setBounds(frameHeight + 435,
                (int) (frameHeight / 2 + 150), 45, 20);
        buyOwnedPropertyButton.setBounds(frameHeight + 485,
                (int) (frameHeight / 2 + 150), 60, 20);
        propertyOwner.setEditable(false);
        ownedPropertyValue.setToolTipText("Price");
        buyOwnedProperty.setVisible(false);
        ownedProperties.setVisible(false);
        propertyOwner.setVisible(false);
        ownedPropertyValue.setVisible(false);
        buyOwnedPropertyButton.setVisible(false);

        buyPlanet = new JLabel("Upgrade planet >>");
        addPlanetTo = new JComboBox<String>();
        addUpgradeButton = new JButton("+ Upgrade");
        addPerfectPlanetButton = new JButton("+ Perfect Planet");
        buyPlanet.setBounds(frameHeight + 50, (int) (frameHeight / 2 + 180),
                130, 20);
        addPlanetTo.setBounds(frameHeight + 185,
                (int) (frameHeight / 2 + 180), 200, 20);
        addUpgradeButton.setBounds(frameHeight + 390,
                (int) (frameHeight / 2 + 180), 90, 20);
        addPerfectPlanetButton.setBounds(frameHeight + 485,
                (int) (frameHeight / 2 + 180), 90, 20);
        buyPlanet.setVisible(false);
        addPlanetTo.setVisible(false);
        addUpgradeButton.setVisible(false);
        addPerfectPlanetButton.setVisible(false);

        sellGetOutOfJailCard = new JLabel("Sell get out of Jail card >>");
        sellGetOutOfJailCard.setBounds(frameHeight + 50,
                (int) (frameHeight / 2 + 210), 150, 20);
        cardBuyers = new JComboBox<String>();
        cardBuyers.setBounds(frameHeight + 205, (int) (frameHeight / 2 + 210),
                140, 20);
        cardPrice = new JTextField();
        cardPrice.setBounds(frameHeight + 350, (int) (frameHeight / 2 + 210),
                45, 20);
        sellGetOutOfJailCardButton = new JButton("Sell");
        sellGetOutOfJailCardButton.setBounds(frameHeight + 400,
                (int) (frameHeight / 2 + 210), 60, 20);
        sellGetOutOfJailCard.setVisible(false);
        cardBuyers.setVisible(false);
        sellGetOutOfJailCardButton.setVisible(false);
        cardPrice.setVisible(false);
        buyUnwantedProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                priceOfUnwantedProperty.setText("");
                String comboSelection = String.valueOf(buyUnwantedProperty
                        .getSelectedItem());
                System.out.println(comboSelection);
            }
        });

        priceOfUnwantedProperty.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void changedUpdate(DocumentEvent arg0) {
                        checkValue();
                    }

                    @Override
                    public void insertUpdate(DocumentEvent arg0) {
                        checkValue();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent arg0) {
                        checkValue();
                    }

                    public void checkValue() {
                        String value = priceOfUnwantedProperty.getText();
                        int tempQty = 0;
                        try {
                            tempQty = Integer.parseInt(value);
                        } catch (Exception e) {

                        }

                        if (tempQty > 0
                                && tempQty <= players.get(
                                        getPlayerIndex(String
                                                .valueOf(buyUnwantedProperty
                                                        .getSelectedItem())))
                                .getMoneyHeld()) {
                            buyUnwantedPropertyButton.setEnabled(true);
                            valueOfUnwantedProperty = tempQty;
                        } else {
                            buyUnwantedPropertyButton.setEnabled(false);
                            // valueOfUnwantedProperty = 0;
                        }
                    }
                });
        addPlayer1Name = new JButton("Add player's name");
        addPlayer2Name = new JButton("Add player's name");
        addPlayer3Name = new JButton("Add player's name");
        addPlayer4Name = new JButton("Add player's name");

        addPlayer1Name.setBounds(frameHeight + 60, 45, 140, 40);
        addPlayer2Name.setBounds(frameHeight + 62 + (int) (frameHeight / 4),
                45, 140, 40);
        addPlayer3Name.setBounds(frameHeight + 64 + (int) (frameHeight / 2),
                45, 140, 40);
        addPlayer4Name.setBounds(frameHeight + 60,
                (int) (frameHeight / 6.5) + 47, 140, 40);

        addPlayer1Name.setVisible(false);
        addPlayer2Name.setVisible(false);
        addPlayer3Name.setVisible(false);
        addPlayer4Name.setVisible(false);

        addPlayer1 = new JButton();
        player1getOutOfJailLabel = new JLabel();
        player1nameLabel = new JLabel();
        player1balance = new JLabel();
        balanceLabels.add(player1balance);
        player1mana = new JLabel();
        energyLabels.add(player1mana);
        player1nameLabel.setBounds(frameHeight + 60, 5, 140, 40);
        player1balance.setBounds(frameHeight + 60, 20, 140, 40);
        addPlayer1.setBounds(frameHeight + 60, 35, 140, 40);
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "addplayer.jpg"));
            addPlayer1.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        addPlayer1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addPlayer1.setBorderPainted(false);
        addPlayer1.setContentAreaFilled(false);
        addPlayer1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                addPlayer1.setVisible(false);
                player1name.setVisible(true);
                addPlayer1Name.setVisible(true);
                addPlayer1Name.setEnabled(false);
            }
        });

        // Get the name of each player
        player1name.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkName();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkName();
            }

            public void checkName() {
                String name = player1name.getText();
                if (name.length() >= 1) {
                    addPlayer1Name.setEnabled(true);
                } else {
                    addPlayer1Name.setEnabled(false);
                }
            }
        });
        addPlayer1Name.addActionListener(new ActionListener() {
            // adds first player to the ArrayList of players
            @Override
            public void actionPerformed(ActionEvent arg0) {
                players.add(new Player(player1name.getText()));
                player1nameLabel.setText(player1name.getText());
                player1nameLabel.setForeground(Color.RED);
                player1nameLabel.setFont(new Font("Arial", Font.ITALIC, 16));
                player1balance.setText("Galy: "
                        + String.valueOf(players.get(0).getMoneyHeld()));
                player1balance.setFont(new Font("Arial", Font.BOLD, 14));
                player1mana.setText("Mana: "
                        + String.valueOf(players.get(0).getManaHeld()));
                player1mana.setFont(new Font("Arial", Font.BOLD, 14));
                frame.getContentPane().add(player1nameLabel);
                frame.getContentPane().add(player1balance);
                System.out.println(players.get(0).getName());
                player1name.setVisible(false);
                addPlayer1Name.setVisible(false);
                addPlayer2.setEnabled(true);
                player1getOutOfJailLabel.setText("GET OUT OF JAIL CARD remain: "
                        + players.get(0).getNumberOfGetOutOfJailCards());
                player1getOutOfJailLabel.setBounds(frameHeight + 60, 50, 140,
                        15);
                player1getOutOfJailLabel.setFont(new Font("Arial", Font.ITALIC,
                        12));
                player1getOutOfJailLabel.setVisible(false);
                getOutOfJailLabels.add(player1getOutOfJailLabel);
                // highlights panels representing owned properties
                player_1.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent arg0) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent arg0) {

                        for (PlanetProperties property : players.get(0)
                                .getOwnedProperties()) {
                            if (property.getPosition() < 10) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(4,
                                                                0, 0, 0,
                                                                Color.red));
                            } else if (property.getPosition() < 20) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(0,
                                                                0, 0, 6,
                                                                Color.red));
                            } else if (property.getPosition() < 30) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(4,
                                                                0, 0, 0,
                                                                Color.red));
                            } else {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(0,
                                                                5, 0, 0,
                                                                Color.red));
                            }

                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent arg0) {
                        for (PlanetProperties property : players.get(0)
                                .getOwnedProperties()) {
                            boardPanels.get(property.getPosition()).setBorder(
                                    BorderFactory.createEmptyBorder());
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent arg0) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent arg0) {

                    }

                });
                player1 = new JLabel();
                player1.setBounds((int) (frameHeight / 6.5 * 5.5) + 20,
                        (int) (frameHeight / 6.5 * 5.5) + 20, 35, 35);
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "token1.png"));
                    player1.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                }
                frame.getContentPane().add(player1, 2);
                playerIndicators.add(player1);
            }

        });
        addPlayer2 = new JButton();
        addPlayer2.setBounds(frameHeight + 60 + (int) (frameHeight / 4), 35,
                140, 40);
        player2nameLabel = new JLabel();
        player2balance = new JLabel();
        player2mana = new JLabel();
        player2getOutOfJailLabel = new JLabel();
        balanceLabels.add(player2balance);
        energyLabels.add(player2mana);
        player2balance.setBounds(frameHeight + 62 + (int) (frameHeight / 4),
                20, 140, 40);
        player2nameLabel.setBounds(frameHeight + 62 + (int) (frameHeight / 4),
                5, 140, 40);
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "addplayer.jpg"));
            addPlayer2.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        addPlayer2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addPlayer2.setBorderPainted(false);
        addPlayer2.setContentAreaFilled(false);
        addPlayer2.setEnabled(false);
        addPlayer2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                addPlayer2.setVisible(false);
                player2name.setVisible(true);
                addPlayer2Name.setVisible(true);
                addPlayer2Name.setEnabled(false);
            }
        });

        player2name.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkName();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkName();
            }

            // names are to be unique
            public void checkName() {
                String name = player2name.getText();
                if (name.length() >= 1 && !name.equals(players.get(0).getName())) {
                    addPlayer2Name.setEnabled(true);
                } else {
                    addPlayer2Name.setEnabled(false);
                }
            }
        });
        addPlayer2Name.addActionListener(new ActionListener() {
            // adds second player to the ArrayList of players
            @Override
            public void actionPerformed(ActionEvent arg0) {
                players.add(new Player(player2name.getText()));
                player2nameLabel.setText(player2name.getText());
                player2nameLabel.setForeground(Color.BLUE);
                player2nameLabel.setFont(new Font("Arial", Font.ITALIC, 16));
                player2balance.setText("Galy: "
                        + String.valueOf(players.get(1).getMoneyHeld()));
                player2balance.setFont(new Font("Arial", Font.BOLD, 14));
                player2mana.setText("Mana: "
                        + String.valueOf(players.get(1).getManaHeld()));
                player2mana.setFont(new Font("Arial", Font.BOLD, 14));
                frame.getContentPane().add(player2nameLabel);
                frame.getContentPane().add(player2balance);
                System.out.println(players.get(1).getName());
                player2name.setVisible(false);
                addPlayer2Name.setVisible(false);
                addPlayer3.setEnabled(true);
                startGame.setEnabled(true); // after creating two players, the
                // game can be started

                player2getOutOfJailLabel.setText("GET OUT OF JAIL CARD remain: "
                        + players.get(1).getNumberOfGetOutOfJailCards());
                player2getOutOfJailLabel.setBounds(frameHeight + 62
                        + (int) (frameHeight / 4), 50, 140, 15);
                player2getOutOfJailLabel.setFont(new Font("Arial", Font.ITALIC,
                        12));
                player2getOutOfJailLabel.setVisible(false);
                getOutOfJailLabels.add(player2getOutOfJailLabel);
                // highlights panels representing owned properties
                player_2.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent arg0) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent arg0) {

                        for (PlanetProperties property : players.get(1)
                                .getOwnedProperties()) {
                            if (property.getPosition() < 10) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(4,
                                                                0, 0, 0,
                                                                Color.blue));
                            } else if (property.getPosition() < 20) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(0,
                                                                0, 0, 6,
                                                                Color.blue));
                            } else if (property.getPosition() < 30) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(4,
                                                                0, 0, 0,
                                                                Color.blue));
                            } else {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(0,
                                                                5, 0, 0,
                                                                Color.blue));
                            }
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent arg0) {
                        for (PlanetProperties property : players.get(1)
                                .getOwnedProperties()) {
                            boardPanels.get(property.getPosition()).setBorder(
                                    BorderFactory.createEmptyBorder());
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent arg0) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent arg0) {

                    }

                });

                player2 = new JLabel();
                player2.setBounds((int) (frameHeight / 6.5 * 5.5) + 23,
                        (int) (frameHeight / 6.5 * 5.5) + 23, 35, 35);
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "token2.png"));
                    player2.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                }
                frame.getContentPane().add(player2, 2);
                playerIndicators.add(player2);
            }

        });

        addPlayer3 = new JButton();
        player3nameLabel = new JLabel();
        player3balance = new JLabel();
        player3mana = new JLabel();
        player3getOutOfJailLabel = new JLabel();
        balanceLabels.add(player3balance);
        energyLabels.add(player3mana);
        player3balance.setBounds(frameHeight + 64 + (int) (frameHeight / 2),
                20, 140, 40);
        player3nameLabel.setBounds(frameHeight + 64 + (int) (frameHeight / 2),
                5, 140, 40);
        addPlayer3.setBounds(frameHeight + 60 + (int) (frameHeight / 2), 35,
                140, 40);
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "addplayer.jpg"));
            addPlayer3.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        addPlayer3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addPlayer3.setBorderPainted(false);
        addPlayer3.setContentAreaFilled(false);
        addPlayer3.setEnabled(false);
        addPlayer3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                addPlayer3.setVisible(false);
                player3name.setVisible(true);
                addPlayer3Name.setVisible(true);
                addPlayer3Name.setEnabled(false);
            }
        });

        player3name.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkName();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkName();
            }

            // names are to be unique
            public void checkName() {
                String name = player3name.getText();
                if (name.length() >= 1
                        && !name.equals(players.get(0).getName())
                        && !name.equals(players.get(1).getName())) {
                    addPlayer3Name.setEnabled(true);
                } else {
                    addPlayer3Name.setEnabled(false);
                }
            }
        });

        addPlayer3Name.addActionListener(new ActionListener() {
            // adds third player to the ArrayList of players
            @Override
            public void actionPerformed(ActionEvent arg0) {
                players.add(new Player(player3name.getText()));
                player3nameLabel.setText(player3name.getText());
                player3nameLabel.setForeground(Color.BLACK);
                player3nameLabel.setFont(new Font("Arial", Font.ITALIC, 16));
                player3balance.setText("Galy: "
                        + String.valueOf(players.get(2).getMoneyHeld()));
                player3balance.setFont(new Font("Arial", Font.BOLD, 14));
                player3mana.setText("Mana: "
                        + String.valueOf(players.get(2).getManaHeld()));
                player3mana.setFont(new Font("Arial", Font.BOLD, 14));
                frame.getContentPane().add(player3nameLabel);
                frame.getContentPane().add(player3balance);
                System.out.println(players.get(2).getName());
                player3name.setVisible(false);
                addPlayer3Name.setVisible(false);
                addPlayer4.setEnabled(true);

                player3getOutOfJailLabel.setText("GET OUT OF JAIL CARD remain: "
                        + players.get(2).getNumberOfGetOutOfJailCards());
                player3getOutOfJailLabel.setBounds(frameHeight + 64
                        + (int) (frameHeight / 2), 50, 140, 15);
                player3getOutOfJailLabel.setFont(new Font("Arial", Font.ITALIC,
                        12));
                player3getOutOfJailLabel.setVisible(false);
                getOutOfJailLabels.add(player3getOutOfJailLabel);
                // highlights panels representing owned properties
                player_3.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent arg0) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent arg0) {

                        for (PlanetProperties property : players.get(2)
                                .getOwnedProperties()) {
                            if (property.getPosition() < 10) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(4,
                                                                0, 0, 0,
                                                                Color.black));
                            } else if (property.getPosition() < 20) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(0,
                                                                0, 0, 6,
                                                                Color.black));
                            } else if (property.getPosition() < 30) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(4,
                                                                0, 0, 0,
                                                                Color.black));
                            } else {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(0,
                                                                5, 0, 0,
                                                                Color.black));
                            }
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent arg0) {
                        for (PlanetProperties property : players.get(2)
                                .getOwnedProperties()) {
                            boardPanels.get(property.getPosition()).setBorder(
                                    BorderFactory.createEmptyBorder());
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent arg0) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent arg0) {

                    }

                });

                player3 = new JLabel();
                player3.setBounds((int) (frameHeight / 6.5 * 5.5) + 26,
                        (int) (frameHeight / 6.5 * 5.5) + 26, 35, 35);
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "token3.png"));
                    player3.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                }
                frame.getContentPane().add(player3, 2);
                playerIndicators.add(player3);
            }

        });

        addPlayer4 = new JButton();
        player4nameLabel = new JLabel();
        player4balance = new JLabel();
        player4mana = new JLabel();
        player4getOutOfJailLabel = new JLabel();
        balanceLabels.add(player4balance);
        energyLabels.add(player4mana);
        player4balance.setBounds(frameHeight + 60,
                (int) (frameHeight / 6.5) + 22, 140, 40);
        player4nameLabel.setBounds(frameHeight + 60,
                (int) (frameHeight / 6.5) + 7, 140, 40);
        addPlayer4.setBounds(frameHeight + 60, (int) (frameHeight / 6.5) + 35,
                140, 40);
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "addplayer.jpg"));
            addPlayer4.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        addPlayer4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addPlayer4.setBorderPainted(false);
        addPlayer4.setContentAreaFilled(false);
        addPlayer4.setEnabled(false);
        addPlayer4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                addPlayer4.setVisible(false);
                player4name.setVisible(true);
                addPlayer4Name.setVisible(true);
                addPlayer4Name.setEnabled(false);
            }
        });

        player4name.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkName();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkName();
            }

            // names are to be unique
            public void checkName() {
                String name = player4name.getText();
                if (name.length() >= 1
                        && !name.equals(players.get(0).getName())
                        && !name.equals(players.get(1).getName())
                        && !name.equals(players.get(2).getName())) {
                    addPlayer4Name.setEnabled(true);
                } else {
                    addPlayer4Name.setEnabled(false);
                }
            }
        });

        addPlayer4Name.addActionListener(new ActionListener() {
            // adds fourth player to the ArrayList of players
            @Override
            public void actionPerformed(ActionEvent arg0) {
                players.add(new Player(player4name.getText()));
                player4nameLabel.setText(player4name.getText());
                player4nameLabel.setForeground(Color.GREEN);
                player4nameLabel.setFont(new Font("Arial", Font.ITALIC, 16));
                player4balance.setText("Galy: "
                        + String.valueOf(players.get(3).getMoneyHeld()));
                player4balance.setFont(new Font("Arial", Font.BOLD, 14));
                player4mana.setText("Mana: "
                        + String.valueOf(players.get(3).getManaHeld()));
                player4mana.setFont(new Font("Arial", Font.BOLD, 14));
                frame.getContentPane().add(player4nameLabel);
                frame.getContentPane().add(player4balance);
                System.out.println(players.get(3).getName());
                player4name.setVisible(false);
                addPlayer4Name.setVisible(false);

                player4getOutOfJailLabel.setText("GET OUT OF JAIl CARD remain: "
                        + players.get(3).getNumberOfGetOutOfJailCards());
                player4getOutOfJailLabel.setBounds(frameHeight + 60,
                        (int) (frameHeight / 6.5) + 52, 140, 15);
                player4getOutOfJailLabel.setFont(new Font("Arial", Font.ITALIC,
                        12));
                player4getOutOfJailLabel.setVisible(false);
                getOutOfJailLabels.add(player4getOutOfJailLabel);

                // highlights panels representing owned properties
                player_4.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent arg0) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent arg0) {

                        for (PlanetProperties property : players.get(3)
                                .getOwnedProperties()) {
                            if (property.getPosition() < 10) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(4,
                                                                0, 0, 0,
                                                                Color.green));
                            } else if (property.getPosition() < 20) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(0,
                                                                0, 0, 6,
                                                                Color.green));
                            } else if (property.getPosition() < 30) {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(4,
                                                                0, 0, 0,
                                                                Color.green));
                            } else {
                                boardPanels.get(property.getPosition())
                                        .setBorder(
                                                BorderFactory
                                                        .createMatteBorder(0,
                                                                5, 0, 0,
                                                                Color.green));
                            }
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent arg0) {
                        for (PlanetProperties property : players.get(3)
                                .getOwnedProperties()) {
                            boardPanels.get(property.getPosition()).setBorder(
                                    BorderFactory.createEmptyBorder());
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent arg0) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent arg0) {

                    }

                });

                player4 = new JLabel();
                player4.setBounds((int) (frameHeight / 6.5 * 5.5) + 29,
                        (int) (frameHeight / 6.5 * 5.5) + 29, 35, 35);
                try {
                    Image img = ImageIO.read(getClass().getResource(
                            "token4.png"));
                    player4.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                }
                frame.getContentPane().add(player4, 2);
                playerIndicators.add(player4);
            }

        });

        startGame = new JButton();
        finishTurn = new JButton();
        restartGame = new JButton();
        startGame.setBounds(frameHeight + 60 + (int) (frameHeight / 4),
                (int) (frameHeight / 3), 140, 40);
        finishTurn.setBounds(frameHeight + 60 + (int) (frameHeight / 4),
                frameHeight - 80, 140, 40);
        restartGame.setBounds(frameHeight + 60 + (int) (frameHeight / 4),
                frameHeight - 70, 140, 20);
        restartGame.setVisible(false);
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "startthegame.jpg"));
            startGame.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "finishturn.jpg"));
            finishTurn.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        startGame.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        startGame.setBorderPainted(false);
        startGame.setContentAreaFilled(false);
        startGame.setEnabled(false);
        finishTurn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        finishTurn.setBorderPainted(false);
        finishTurn.setContentAreaFilled(false);
        finishTurn.setEnabled(false);
        finishTurn.setVisible(false);
        startGame.addActionListener(new ActionListener() {
        // invisible player adding components
            @Override
            public void actionPerformed(ActionEvent arg0) {
                player_1.setBorder(BorderFactory.createLineBorder(Color.green,
                        2));
                addPlayer3.setVisible(false);
                addPlayer3Name.setVisible(false);
                player3name.setVisible(false);
                addPlayer4.setVisible(false);
                player4name.setVisible(false);
                addPlayer4Name.setVisible(false);
                startNewGame();
            }
        });
        frame.getContentPane().add(hideInstruction);
        frame.getContentPane().add(howToPlay);
        frame.getContentPane().add(player_1);
        frame.getContentPane().add(player_2);
        frame.getContentPane().add(player_3);
        frame.getContentPane().add(player_4);
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
        frame.getContentPane().add(bottomRight, -1);
        frame.getContentPane().add(fortuneButton, -1);
        frame.getContentPane().add(chanceButton, -1);
        frame.getContentPane().add(addPlayer1);
        frame.getContentPane().add(addPlayer2);
        frame.getContentPane().add(addPlayer3);
        frame.getContentPane().add(addPlayer4);
        frame.getContentPane().add(addPlayer1Name);
        frame.getContentPane().add(addPlayer2Name);
        frame.getContentPane().add(addPlayer3Name);
        frame.getContentPane().add(addPlayer4Name);
        frame.getContentPane().add(startGame);
        frame.getContentPane().add(gameLog);
        frame.getContentPane().add(gameConsole);
        frame.getContentPane().add(useGetOutOfJailCard);
        frame.getContentPane().add(dontUseGetOutOfJailCard);
        frame.getContentPane().add(buyProperty);
        frame.getContentPane().add(dontBuyProperty);
        frame.getContentPane().add(payRent);
        frame.getContentPane().add(payArrears);
        frame.getContentPane().add(declareBankruptcyFromGame);
        frame.getContentPane().add(yesButton);
        frame.getContentPane().add(noButton);
        frame.getContentPane().add(deed, 2);
        frame.getContentPane().add(restartGame);
        frame.getContentPane().add(buyOwnedProperty);
        frame.getContentPane().add(ownedProperties);
        frame.getContentPane().add(propertyOwner);
        frame.getContentPane().add(ownedPropertyValue);
        frame.getContentPane().add(buyOwnedPropertyButton);

        rollTheDice = new JButton();
        rollTheDice.setBounds(frameHeight / 2 - 70, frameHeight / 2 + 40, 140,
                40);
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "rollthedice.jpg"));
            rollTheDice.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        rollTheDice.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rollTheDice.setBorderPainted(false);
        rollTheDice.setContentAreaFilled(false);
        rollTheDice.setVisible(false);
        dice1 = new JLabel();
        dice1.setBounds(frameHeight / 2 - 110, frameHeight / 2 - 70, 100, 100);
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "dice6.png"));
            dice1.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        dice2 = new JLabel();
        dice2.setBounds(frameHeight / 2, frameHeight / 2 - 70, 100, 100);
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "dice6.png"));
            dice2.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
        dice1.setVisible(false);
        dice2.setVisible(false);
        frame.getContentPane().add(rollTheDice);
        frame.getContentPane().add(dice1);
        frame.getContentPane().add(dice2);
        frame.getContentPane().add(finishTurn);
        frame.getContentPane().add(gamePrompt);
        frame.getContentPane().add(pay50toGetOutOfJail);
        frame.getContentPane().add(player1getOutOfJailLabel);
        frame.getContentPane().add(player2getOutOfJailLabel);
        frame.getContentPane().add(player3getOutOfJailLabel);
        frame.getContentPane().add(player4getOutOfJailLabel);
        frame.getContentPane().add(buyUnwantedProperty);
        frame.getContentPane().add(priceOfUnwantedProperty);
        frame.getContentPane().add(buyUnwantedPropertyButton);
        frame.getContentPane().add(mortgageManagement);
        frame.getContentPane().add(mortgageComboBox);
        frame.getContentPane().add(takeLoan);
        frame.getContentPane().add(payLoan);
        frame.getContentPane().add(sellProperty);
        frame.getContentPane().add(sellPropertyComboBox);
        frame.getContentPane().add(buyer);
        frame.getContentPane().add(sellingPrice);
        frame.getContentPane().add(sellPropertyButton);
        frame.getContentPane().add(buyPlanet);
        frame.getContentPane().add(addPlanetTo);
        frame.getContentPane().add(addUpgradeButton);
        frame.getContentPane().add(addPerfectPlanetButton);
        frame.getContentPane().add(sellGetOutOfJailCard);
        frame.getContentPane().add(cardBuyers);
        frame.getContentPane().add(sellGetOutOfJailCardButton);
        frame.getContentPane().add(cardPrice);

        frame.getContentPane().add(perfectPlanetLabel0, 2);
        frame.getContentPane().add(perfectPlanetLabel1, 2);
        frame.getContentPane().add(perfectPlanetLabel2, 2);
        frame.getContentPane().add(perfectPlanetLabel3, 2);
        frame.getContentPane().add(perfectPlanetLabel4, 2);
        frame.getContentPane().add(perfectPlanetLabel5, 2);
        frame.getContentPane().add(perfectPlanetLabel6, 2);
        frame.getContentPane().add(perfectPlanetLabel7, 2);
        frame.getContentPane().add(perfectPlanetLabel8, 2);
        frame.getContentPane().add(perfectPlanetLabel9, 2);
        frame.getContentPane().add(perfectPlanetLabel10, 2);
        frame.getContentPane().add(perfectPlanetLabel11, 2);
        frame.getContentPane().add(perfectPlanetLabel12, 2);
        frame.getContentPane().add(perfectPlanetLabel13, 2);
        frame.getContentPane().add(perfectPlanetLabel14, 2);
        frame.getContentPane().add(perfectPlanetLabel15, 2);
        frame.getContentPane().add(perfectPlanetLabel16, 2);
        frame.getContentPane().add(perfectPlanetLabel17, 2);
        frame.getContentPane().add(perfectPlanetLabel18, 2);
        frame.getContentPane().add(perfectPlanetLabel19, 2);
        frame.getContentPane().add(perfectPlanetLabel20, 2);
        frame.getContentPane().add(perfectPlanetLabel21, 2);
        frame.getContentPane().add(showInstruction);

    }

    // Game control button
    private void startNewGame() {
        startGame.setVisible(false);
        gameLog.setVisible(true);
        finishTurn.setVisible(true);
        rollTheDice.setVisible(true);
        dice1.setVisible(true);
        dice2.setVisible(true);
        rollTheDice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                gamePrompt.setText("");
                randomDice1 = random.nextInt(6) + 1;
                randomDice2 = random.nextInt(6) + 1;
                System.out.println(randomDice1);
                System.out.println(randomDice2);
                buyProperty.setEnabled(true);
                buyUnwantedProperty.setVisible(false);
                buyUnwantedPropertyButton.setVisible(false);
                priceOfUnwantedProperty.setVisible(false);
                switch (randomDice1) {
                    case 1:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice1.png"));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                    case 2:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice2.png"));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                    case 3:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice3.png"));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                    case 4:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice4.png"));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                    case 5:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice5.png"));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                    case 6:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice6.png"));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                }
                switch (randomDice2) {
                    case 1:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice1.png"));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                    case 2:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice2.png"));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                    case 3:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice3.png"));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                    case 4:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice4.png"));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                    case 5:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice5.png"));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                    case 6:
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "dice6.png"));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        break;
                }
                System.out.println(extraRollNeeded);
                if (!extraRollNeeded) {
                    if (randomDice1 == randomDice2) {
                        doubleCounter++;
                        gotDouble = true;
                    } else {
                        gotDouble = false;
                    }
                    if (doubleCounter < 3) {
                        players.get(playerIndex).positionOnBoard(
                                randomDice1 + randomDice2);
                        finishTurn.setEnabled(false);
                    }
                    // Go to jail after 3 doubles in a row
                    if (doubleCounter == 3
                            || players.get(playerIndex)
                            .getPositionOnGameBoard() == 30) {
                        // no get out of jail card
                        if (players.get(playerIndex)
                                .getNumberOfGetOutOfJailCards() == 0) {
                            finishTurn.setEnabled(true);
                            rollTheDice.setEnabled(false);
                            players.get(playerIndex).setInJail(true);
                            if (doubleCounter < 3) {
                                log = "  /> "
                                        + players.get(playerIndex).getName()
                                        + " went to Jail" + "\n";
                                logText.append(log);
                            } else {
                                log = "  /> "
                                        + players.get(playerIndex).getName()
                                        + " went to Jail for rolling 3 doubles "
                                        + "\n";
                                logText.append(log);
                            }
                            players.get(playerIndex).positionOnBoard(
                                    10 - players.get(playerIndex)
                                            .getPositionOnGameBoard());
                            adjustPlayerPosition();
                            System.out.println(players.get(playerIndex)
                                    .getName()
                                    + " "
                                    + players.get(playerIndex)
                                    .getPositionOnGameBoard()
                                    + " in Jail: "
                                    + players.get(playerIndex).isInJail());
                            doubleCounter = 0;
                        } else {
                            gamePrompt
                                    .setText("Do you want to use your get out of jail card?");
                            useGetOutOfJailCard.setVisible(true);
                            dontUseGetOutOfJailCard.setVisible(true);
                            rollTheDice.setEnabled(false);
                            finishTurn.setEnabled(false);
                        }
                    } else {
                        adjustPlayerPosition();
                        System.out.println(players.get(playerIndex).getName()
                                + " "
                                + players.get(playerIndex)
                                .getPositionOnGameBoard());
                        buyOrRent();
                    }
                } else {
                    if (players.get(playerIndex).isInJail()) {
                        if (!(randomDice1 == randomDice2)) {
                            if (players.get(playerIndex).getTurnsInJail() == 1) {
                                log = "  /> "
                                        + players.get(playerIndex).getName()
                                        + " has his/her balance deducted by 50 Galy and got out of Jail"
                                        + "\n";
                                logText.append(log);
                                players.get(playerIndex).setMoneyHeld(-50);
                                players.get(playerIndex).setInJail(false);
                                players.get(playerIndex).setTurnsInJail(0);
                                useGetOutOfJailCard.setVisible(false);
                                pay50toGetOutOfJail.setVisible(false);
                                gamePrompt.setText("");
                                balanceLabels.get(playerIndex).setText(
                                        "Galy: "
                                                + players.get(playerIndex)
                                                .getMoneyHeld());
                            } else {
                                players.get(playerIndex).setTurnsInJail(1);
                                useGetOutOfJailCard.setVisible(false);
                                pay50toGetOutOfJail.setVisible(false);
                                gamePrompt.setText("");
                            }
                            extraRollNeeded = false;
                            rollTheDice.setEnabled(false);
                            finishTurn.setEnabled(true);
                        } else {
                            players.get(playerIndex).setInJail(false);
                            players.get(playerIndex).setTurnsInJail(0);
                            useGetOutOfJailCard.setVisible(false);
                            pay50toGetOutOfJail.setVisible(false);
                            log = "  /> " + players.get(playerIndex).getName()
                                    + " rolled double and got out of Jail"
                                    + "\n";
                            logText.append(log);
                            gamePrompt.setText("");
                            extraRollNeeded = false;
                            balanceLabels.get(playerIndex).setText(
                                    "Galy: "
                                            + players.get(playerIndex)
                                            .getMoneyHeld());
                            doubleCounter = 0;
                            if (getNumberOfUpgrades() > 0
                                    || getNumberOfPerfectPlanets() > 0) {
                                generateAddPlanetComboBox();
                            }
                        }
                    } else {
                        rentCalculated = true;
                        rollTheDice.setEnabled(false);
                        if ((players.get(playerIndex).getPositionOnGameBoard() == 12 && entities
                                .getEntities().get(28).getOwner() != null)
                                || (players.get(playerIndex)
                                .getPositionOnGameBoard() == 28 && entities
                                .getEntities().get(12).getOwner() != null)
                                || (sentByChanceCard && players
                                .get(playerIndex)
                                .getPositionOnGameBoard() == 12)
                                || (sentByChanceCard && players
                                .get(playerIndex)
                                .getPositionOnGameBoard() == 28)) {
                            rentValue = 10 * (randomDice1 + randomDice2);
                        } else if (players.get(playerIndex)
                                .getPositionOnGameBoard() == 12
                                && entities.getEntities().get(28).getOwner() == null
                                || players.get(playerIndex)
                                .getPositionOnGameBoard() == 28
                                && entities.getEntities().get(12).getOwner() == null) {
                            rentValue = 4 * (randomDice1 + randomDice2);
                        }
                        if (rentCalculated) {
                            if (rentValue > players.get(playerIndex)
                                    .getMoneyHeld()) {
                                gamePrompt
                                        .setText("You need money to pay the rent. Sell property, take loan or declare BANKRUPTCY from game");
                                declareBankruptcyFromGame.setVisible(true);
                            } else {
                                payRent.setVisible(true);
                                declareBankruptcyFromGame.setVisible(false);
                            }
                        }

                    }
                }
            }

        });

        buyProperty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                // setting new owner of a property
                entities.getEntities()
                        .get(players.get(playerIndex).getPositionOnGameBoard())
                        .setOwner(players.get(playerIndex));

                // adding property to player's ArrayList of properties
                players.get(playerIndex)
                        .getOwnedProperties()
                        .add(entities.getEntities().get(
                                players.get(playerIndex)
                                        .getPositionOnGameBoard()));

                // deducting the value of the property from player's balance
                players.get(playerIndex).setMoneyHeld(
                        -entities
                                .getEntities()
                                .get(players.get(playerIndex)
                                        .getPositionOnGameBoard()).getCost());

                if (!gotDouble || doubleCounter == 3) {
                    finishTurn.setEnabled(true);
                } else if (gotDouble && doubleCounter < 3) {
                    rollTheDice.setEnabled(true);
                }
                buyProperty.setVisible(false);
                dontBuyProperty.setVisible(false);
                log = "  /> "
                        + players.get(playerIndex).getName()
                        + " has just bought "
                        + entities
                        .getEntities()
                        .get(players.get(playerIndex)
                                .getPositionOnGameBoard()).getName()
                        + "(worth Galy"
                        + entities
                        .getEntities()
                        .get(players.get(playerIndex)
                                .getPositionOnGameBoard()).getCost()
                        + ")\n";
                logText.append(log);
                balanceLabels.get(playerIndex).setText(
                        "Galy: " + players.get(playerIndex).getMoneyHeld());

                generateMortgageComboBox();
                if (!upgradeOrPerfectPlanetBought
                        && (getNumberOfPerfectPlanets() > 0 || getNumberOfUpgrades() > 0)
                        && !players.get(playerIndex).isInJail()) {
                    generateAddPlanetComboBox();
                }
            }
        });

        dontBuyProperty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                buyProperty.setVisible(false);
                dontBuyProperty.setVisible(false);
                log = "  /> "
                        + players.get(playerIndex).getName()
                        + " did not buy "
                        + entities
                        .getEntities()
                        .get(players.get(playerIndex)
                                .getPositionOnGameBoard()).getName()
                        + "\n";
                logText.append(log);

                buyUnwantedPropertyModel = new DefaultComboBoxModel<String>();
                for (Player player : players) {
                    if (!player.getName().equals(
                            players.get(playerIndex).getName())
                            && !player.isBankrupt()) {
                        buyUnwantedPropertyModel.addElement(player.getName());
                    }
                }
                buyUnwantedProperty.setModel(buyUnwantedPropertyModel);
                gamePrompt
                        .setText("Please pick a name of a player (if interested) and enter the amount to be paid for the property");
                buyUnwantedProperty.setVisible(true);
                buyUnwantedPropertyButton.setVisible(true);
                priceOfUnwantedProperty.setVisible(true);
                if (gotDouble && doubleCounter < 3) {
                    rollTheDice.setEnabled(true);
                } else {
                    finishTurn.setEnabled(true);
                }
            }
        });

        payRent.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                sentByChanceCard = false;
                rentCalculated = false;
                extraRollNeeded = false;
                ownerIndex = getPlayerIndex(entities.getEntities()
                        .get(players.get(playerIndex).getPositionOnGameBoard())
                        .getOwner());
                players.get(playerIndex).setMoneyHeld(-rentValue);
                players.get(ownerIndex).setMoneyHeld(rentValue);

                if (!gotDouble || doubleCounter == 3) {
                    finishTurn.setEnabled(true);
                    rollTheDice.setEnabled(false);

                } else if (gotDouble && doubleCounter < 3) {
                    rollTheDice.setEnabled(true);

                }
                payRent.setVisible(false);
                log = "  /> "
                        + players.get(playerIndex).getName()
                        + " paid "
                        + rentValue
                        + " rent to "
                        + players.get(
                        getPlayerIndex(entities
                                .getEntities()
                                .get(players.get(playerIndex)
                                        .getPositionOnGameBoard())
                                .getOwner())).getName() + "\n";
                logText.append(log);
                balanceLabels.get(playerIndex).setText(
                        "Galy: " + players.get(playerIndex).getMoneyHeld());
                balanceLabels.get(ownerIndex).setText(
                        "Galy: " + players.get(ownerIndex).getMoneyHeld());
                gamePrompt.setText("");
                System.out.println("Number of upgrades: "
                        + entities
                        .getEntities()
                        .get(players.get(playerIndex)
                                .getPositionOnGameBoard())
                        .getNumberOfUpgrades());
            }

        });

        pay50toGetOutOfJail.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                players.get(playerIndex).setMoneyHeld(-50);
                pay50toGetOutOfJail.setVisible(false);
                useGetOutOfJailCard.setVisible(false);
                rollTheDice.setEnabled(true);
                players.get(playerIndex).setInJail(false);
                players.get(playerIndex).setTurnsInJail(0);
                pay50toGetOutOfJail.setVisible(false);
                log = "  /> " + players.get(playerIndex).getName()
                        + " paid 50 Galy to get out of Jail" + "\n";
                logText.append(log);
                gamePrompt.setText("");
                extraRollNeeded = false;
                balanceLabels.get(playerIndex).setText(
                        "E" + players.get(playerIndex).getMoneyHeld());
            }

        });

        useGetOutOfJailCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!sentByChanceCard) {
                    if (!players.get(playerIndex).isInJail()
                            && players.get(playerIndex)
                            .getPositionOnGameBoard() == 30) {
                        if (doubleCounter == 3 || !gotDouble) {
                            finishTurn.setEnabled(true);
                            log = "  /> "
                                    + players.get(playerIndex).getName()
                                    + " used his/her get out of Jail card to avoid going to Jail"
                                    + "\n";
                            logText.append(log);
                            adjustPlayerPosition();
                        } else if (gotDouble) {
                            rollTheDice.setEnabled(true);
                        }

                    } else if (!players.get(playerIndex).isInJail()
                            && players.get(playerIndex)
                            .getPositionOnGameBoard() != 30) {
                        if (doubleCounter == 3 || !gotDouble) {
                            finishTurn.setEnabled(true);
                        }
                        adjustPlayerPosition();
                        log = "  /> "
                                + players.get(playerIndex).getName()
                                + " used his/her get out of Jail card to avoid going to Jail"
                                + "\n";
                        logText.append(log);
                    } else {
                        rollTheDice.setEnabled(true);
                        players.get(playerIndex).setInJail(false);
                        players.get(playerIndex).setTurnsInJail(0);
                        pay50toGetOutOfJail.setVisible(false);
                        log = "  /> "
                                + players.get(playerIndex).getName()
                                + " used his/her get out of Jail card to get out of Jail"
                                + "\n";
                        logText.append(log);
                        extraRollNeeded = false;
                    }
                    buyOrRent();
                } else {
                    log = "  /> "
                            + players.get(playerIndex).getName()
                            + " used his/her get out of Jail card to avoid going to Jail"
                            + "\n";
                    logText.append(log);
                    sentByChanceCard = false;
                    if (!gotDouble) {
                        finishTurn.setEnabled(true);
                    } else {
                        rollTheDice.setEnabled(true);
                    }
                }
                useGetOutOfJailCard.setVisible(false);
                dontUseGetOutOfJailCard.setVisible(false);
                if (players.get(playerIndex).getOutOfJailCards().get(0) instanceof ChanceCard) {
                    players.get(playerIndex).getOutOfJailCards().remove(0);
                    deck.returnOutOfJailCardChance();
                } else {
                    players.get(playerIndex).getOutOfJailCards().remove(0);
                    deck.returnOutOfJailCardCommunity();
                }

                gamePrompt.setText("");
                getOutOfJailLabels.get(playerIndex).setText(
                        "GET OUT OF JAIL CARD remain: "
                                + players.get(playerIndex)
                                .getNumberOfGetOutOfJailCards());
                if (players.get(playerIndex).getNumberOfGetOutOfJailCards() == 0) {
                    getOutOfJailLabels.get(playerIndex).setVisible(false);
                }
            }
        });

        dontUseGetOutOfJailCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                players.get(playerIndex).positionOnBoard(
                        10 - players.get(playerIndex).getPositionOnGameBoard());
                players.get(playerIndex).setInJail(true);
                adjustPlayerPosition();
                if (doubleCounter == 3) {
                    log = "  /> " + players.get(playerIndex).getName()
                            + " went to Jail for rolling 3 doubles " + "\n";
                    logText.append(log);
                } else {
                    log = "  /> " + players.get(playerIndex).getName()
                            + " went to Jail" + "\n";
                    logText.append(log);
                }
                finishTurn.setEnabled(true);
                gamePrompt.setText("");
                useGetOutOfJailCard.setVisible(false);
                dontUseGetOutOfJailCard.setVisible(false);

            }
        });

        finishTurn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameOn()) {
                    if (chanceCardPicked) {
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "chance.jpg"));
                            chanceButton.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        chanceCardPicked = false;
                    }
                    if (fortuneCardPicked) {
                        try {
                            Image img = ImageIO.read(getClass().getResource(
                                    "fortune.jpg"));
                            fortuneButton.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                        }
                        fortuneCardPicked = false;
                    }

                    do {
                        playersPanes.get(playerIndex).setBorder(
                                BorderFactory.createLineBorder(Color.black, 2));
                        playerIndex = (playerIndex + 1) % players.size();
                        playersPanes.get(playerIndex).setBorder(
                                BorderFactory.createLineBorder(Color.green, 2));
                    } while (players.get(playerIndex).isBankrupt());

                    if (players.get(playerIndex).isInJail()
                            && players.get(playerIndex)
                            .getNumberOfGetOutOfJailCards() > 0) {
                        gamePrompt
                                .setText("Use the card, pay 50 Galy or roll the dice to get out of Jail");
                        useGetOutOfJailCard.setVisible(true);
                        pay50toGetOutOfJail.setVisible(true);
                        rollTheDice.setEnabled(true);
                        extraRollNeeded = true;
                    } else if (players.get(playerIndex).isInJail()) {
                        gamePrompt
                                .setText("You need to pay 50 Galy or roll double to get out of Jail");
                        extraRollNeeded = true;
                        rollTheDice.setEnabled(true);
                        pay50toGetOutOfJail.setVisible(true);
                    } else {
                        rollTheDice.setEnabled(true);
                        gamePrompt.setText("");
                    }
                    finishTurn.setEnabled(false);
                    doubleCounter = 0;
                    buyProperty.setEnabled(true);
                    buyUnwantedProperty.setVisible(false);
                    buyUnwantedPropertyButton.setVisible(false);
                    priceOfUnwantedProperty.setVisible(false);
                    if (players.get(playerIndex).getOwnedProperties().size() > 0) {
                        generateMortgageComboBox();
                    } else {
                        mortgageManagement.setVisible(false);
                        mortgageComboBox.setVisible(false);
                        takeLoan.setVisible(false);
                        payLoan.setVisible(false);
                        sellProperty.setVisible(false);
                        sellPropertyComboBox.setVisible(false);
                        buyer.setVisible(false);
                        sellingPrice.setVisible(false);
                        sellPropertyButton.setVisible(false);
                    }
                    if (getNumberOfUpgrades() > 0 || getNumberOfPerfectPlanets() > 0
                            && !players.get(playerIndex).isInJail()) {
                        generateAddPlanetComboBox();
                    }
                    upgradeOrPerfectPlanetBought = false;
                    if (players.get(playerIndex).getNumberOfGetOutOfJailCards() > 0) {
                        generateSellGetOutOfJailCardComboBox();
                    } else {
                        sellGetOutOfJailCard.setVisible(false);
                        cardBuyers.setVisible(false);
                        cardPrice.setVisible(false);
                        sellGetOutOfJailCardButton.setVisible(false);
                    }
                    generateBuyOwnedPropertyComboBox();
                } else {
                    finishTurn.setEnabled(false);
                    finishTurn.setVisible(false);
                    int winnerIndex = 0;
                    for (int i = 0; i < players.size(); i++) {
                        if (!players.get(i).isBankrupt()) {
                            winnerIndex = i;
                        }

                    }
                    log = "  /> " + players.get(winnerIndex).getName()
                            + " won the game. " + "\n";
                    logText.append(log);
                    balanceLabels.get(winnerIndex).setText("WINNER !!!");
                    restartGame.setVisible(true);

                }

            }

        });

        cardBuyers.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardPrice.setText("");
            }

        });

        buyUnwantedProperty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                priceOfUnwantedProperty.setEnabled(true);
                priceOfUnwantedProperty.setText("");
            }

        });

        // no need to simplify
        buyUnwantedPropertyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                buyUnwantedProperty.setVisible(false);
                buyUnwantedPropertyButton.setVisible(false);
                priceOfUnwantedProperty.setVisible(false);
                gamePrompt.setText("");
                ownerIndex = getPlayerIndex(String.valueOf(buyUnwantedProperty
                        .getSelectedItem()));
                log = "  /> "
                        + players.get(ownerIndex).getName()
                        + " has just bought "
                        + entities
                        .getEntities()
                        .get(players.get(playerIndex)
                                .getPositionOnGameBoard()).getName()
                        + "(for Galy" + valueOfUnwantedProperty + ")\n";
                logText.append(log);
                players.get(ownerIndex).setMoneyHeld(-valueOfUnwantedProperty);
                balanceLabels.get(ownerIndex).setText(
                        "Galy: " + players.get(ownerIndex).getMoneyHeld());

                entities.getEntities()
                        .get(players.get(playerIndex).getPositionOnGameBoard())
                        .setOwner(players.get(ownerIndex));

                players.get(ownerIndex)
                        .getOwnedProperties()
                        .add(entities.getEntities().get(
                                players.get(playerIndex)
                                        .getPositionOnGameBoard()));

                priceOfUnwantedProperty.setText("");
                if (!gotDouble || doubleCounter == 3) {
                    finishTurn.setEnabled(true);
                    rollTheDice.setEnabled(false);
                }
                generateBuyOwnedPropertyComboBox();
            }

        });

        mortgageComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                takeLoan.setEnabled(false);
                payLoan.setEnabled(false);
                String comboSelection = String.valueOf(mortgageComboBox
                        .getSelectedItem());
                for (PlanetProperties entity : players.get(playerIndex)
                        .getOwnedProperties()) {
                    if (entity.getName().equals(comboSelection)
                            && entity.isMortgaged()
                            && players.get(playerIndex).getMoneyHeld() >= (entity
                            .getCost() * 0.6)) {
                        payLoan.setEnabled(true);
                        takeLoan.setEnabled(false);
                    } else if (entity.getName().equals(comboSelection)
                            && !entity.isMortgaged()) {
                        payLoan.setEnabled(false);
                        takeLoan.setEnabled(true);
                    }
                }
                sellPropertyComboBox.setSelectedItem(null);
            }

        });

        sellPropertyComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String combo = String.valueOf(sellPropertyComboBox
                        .getSelectedItem());
                boolean isMortgaged = false;
                for (PlanetProperties entity : entities.getEntities()) {
                    if (entity.getName().equals(combo)) {
                        if (entity.isMortgaged()) {
                            isMortgaged = true;
                        }
                    }
                }
                buyerModel = new DefaultComboBoxModel<String>();
                for (int i = 0; i < players.size(); i++) {
                    if (i != playerIndex && !players.get(i).isBankrupt()) {
                        if (isMortgaged
                                && (getEntityCost(combo) * 0.6) <= players.get(
                                i).getMoneyHeld()) {
                            buyerModel.addElement(players.get(i).getName());
                        } else if (!isMortgaged
                                && players.get(i).getMoneyHeld() >= 1) {
                            buyerModel.addElement(players.get(i).getName());
                        }
                    }
                }
                buyer.setModel(buyerModel);

                buyer.setSelectedItem(null);
            }

        });

        buyer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                sellingPrice.setEnabled(true);
                sellingPrice.setText("");
            }

        });

        sellingPrice.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                if (buyer.getSelectedItem() != null) {
                    checkValue();
                }
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                if (buyer.getSelectedItem() != null) {
                    checkValue();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                sellPropertyButton.setEnabled(false);
                if (buyer.getSelectedItem() != null) {
                    checkValue();
                }
            }

            public void checkValue() {
                String value = sellingPrice.getText();
                int tempQty = 0;
                try {
                    tempQty = Integer.parseInt(value);
                } catch (Exception e) {

                }

                if (tempQty > 0
                        && tempQty <= players.get(
                        getPlayerIndex(String.valueOf(buyer
                                .getSelectedItem()))).getMoneyHeld()) {
                    if (entities
                            .getEntities()
                            .get(getEntityPosition(String
                                    .valueOf(sellPropertyComboBox
                                            .getSelectedItem()))).isMortgaged()
                            && tempQty >= (entities
                            .getEntities()
                            .get(getEntityPosition(String
                                    .valueOf(sellPropertyComboBox
                                            .getSelectedItem())))
                            .getCost() * 0.1)) {
                        sellPropertyButton.setEnabled(true);
                        valueOfUnwantedProperty = tempQty;
                    } else if (!entities
                            .getEntities()
                            .get(getEntityPosition(String
                                    .valueOf(sellPropertyComboBox
                                            .getSelectedItem()))).isMortgaged()) {
                        sellPropertyButton.setEnabled(true);
                        valueOfUnwantedProperty = tempQty;
                    }
                } else {
                    sellPropertyButton.setEnabled(false);
                }
            }
        });

        cardPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent arg0) {
                if (cardBuyers.getSelectedItem() != null) {
                    checkValue();
                }
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                if (cardBuyers.getSelectedItem() != null) {
                    checkValue();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                sellGetOutOfJailCardButton.setEnabled(false);
                if (cardBuyers.getSelectedItem() != null) {
                    checkValue();
                }
            }

            public void checkValue() {
                String value = cardPrice.getText();
                int tempQty = 0;
                try {
                    tempQty = Integer.parseInt(value);
                } catch (Exception e) {

                }

                if (tempQty > 0
                        && tempQty <= players.get(
                        getPlayerIndex(String.valueOf(cardBuyers
                                .getSelectedItem()))).getMoneyHeld()) {
                    sellGetOutOfJailCardButton.setEnabled(true);
                    valueOfSoldCard = tempQty;
                } else {
                    sellGetOutOfJailCardButton.setEnabled(false);
                }
            }
        });

        sellGetOutOfJailCardButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                ownerIndex = getPlayerIndex(String.valueOf(cardBuyers
                        .getSelectedItem()));
                players.get(ownerIndex)
                        .getOutOfJailCards()
                        .add(players.get(playerIndex).getOutOfJailCards()
                                .remove(0));
                players.get(playerIndex).setMoneyHeld(valueOfSoldCard);
                players.get(ownerIndex).setMoneyHeld(-valueOfSoldCard);
                getOutOfJailLabels.get(ownerIndex).setText(
                        "GET OUT OF JAIL CARD remain: "
                                + players.get(ownerIndex)
                                .getNumberOfGetOutOfJailCards());
                getOutOfJailLabels.get(ownerIndex).setVisible(true);
                if (players.get(playerIndex).getNumberOfGetOutOfJailCards() == 0) {
                    sellGetOutOfJailCard.setVisible(false);
                    cardBuyers.setVisible(false);
                    cardPrice.setVisible(false);
                    sellGetOutOfJailCardButton.setVisible(false);
                    getOutOfJailLabels.get(playerIndex).setVisible(false);
                } else {
                    generateSellGetOutOfJailCardComboBox();
                    getOutOfJailLabels.get(playerIndex).setText(
                            "GET OUT OF JAIL CARD remain: "
                                    + players.get(playerIndex)
                                    .getNumberOfGetOutOfJailCards());
                }
            }

        });

        sellPropertyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                boolean isMortgaged = false;
                String entityName = String.valueOf(sellPropertyComboBox
                        .getSelectedItem());
                ownerIndex = getPlayerIndex(String.valueOf(buyer
                        .getSelectedItem()));

                for (int i = 0; i < players.get(playerIndex)
                        .getOwnedProperties().size(); i++) {
                    if (players.get(playerIndex).getOwnedProperties().get(i)
                            .getName().equals(entityName)) {
                        players.get(playerIndex).getOwnedProperties().get(i)
                                .setOwner(players.get(ownerIndex));
                        players.get(ownerIndex)
                                .getOwnedProperties()
                                .add(players.get(playerIndex)
                                        .getOwnedProperties().get(i));
                        players.get(playerIndex).getOwnedProperties().remove(i);
                        break;
                    }
                }

                int entityPosition = getEntityPosition(entityName);
                entities.getEntities().get(entityPosition)
                        .setOwner(players.get(ownerIndex));

                if (entities.getEntities().get(entityPosition).isMortgaged()) {
                    isMortgaged = true;
                }

                log = "  /> " + players.get(playerIndex).getName()
                        + " has just sold "
                        + entities.getEntities().get(entityPosition).getName()
                        + " to " + players.get(ownerIndex).getName()
                        + " (for Galy" + valueOfUnwantedProperty + ")\n";
                logText.append(log);
                if (isMortgaged) {
                    players.get(playerIndex)
                            .setMoneyHeld(
                                    valueOfUnwantedProperty
                                            - (entities.getEntities()
                                            .get(entityPosition)
                                            .getCost() * 0.1));
                } else {
                    players.get(playerIndex).setMoneyHeld(
                            valueOfUnwantedProperty);
                }
                players.get(ownerIndex).setMoneyHeld(-valueOfUnwantedProperty);

                balanceLabels.get(ownerIndex).setText(
                        "Galy: " + players.get(ownerIndex).getMoneyHeld());
                balanceLabels.get(playerIndex).setText(
                        "Galy: " + players.get(playerIndex).getMoneyHeld());
                if (players.get(playerIndex).getOwnedProperties().size() > 0) {
                    generateMortgageComboBox();
                } else {
                    mortgageManagement.setVisible(false);
                    mortgageComboBox.setVisible(false);
                    takeLoan.setVisible(false);
                    payLoan.setVisible(false);
                    takeLoan.setEnabled(false);
                    payLoan.setEnabled(false);
                    sellProperty.setVisible(false);
                    sellPropertyComboBox.setVisible(false);
                    sellPropertyComboBox.setSelectedItem(null);
                    buyer.setVisible(false);
                    buyer.setSelectedItem(null);
                    sellingPrice.setVisible(false);
                    sellingPrice.setText("");
                    sellPropertyButton.setVisible(false);
                    sellPropertyButton.setEnabled(false);
                }
                if (!upgradeOrPerfectPlanetBought
                        && (getNumberOfUpgrades() > 0 || getNumberOfPerfectPlanets() > 0)
                        && !players.get(playerIndex).isInJail()) {
                    generateAddPlanetComboBox();
                }
                if (rentCalculated) {
                    if (rentValue > players.get(playerIndex).getMoneyHeld()) {
                        gamePrompt
                                .setText("You need money to pay the rent. Sell property, take loan or declare BANKRUPTCY from game");
                    } else {
                        payRent.setVisible(true);
                        declareBankruptcyFromGame.setVisible(false);
                    }
                }
                if (paymentDue) {
                    if (paymentDueAmount > players.get(playerIndex)
                            .getMoneyHeld()) {
                        gamePrompt
                                .setText("you need to pay arrears. Sell or mortgage property or declare BANKRUPTCY from game");
                    } else {
                        payArrears.setVisible(true);
                        declareBankruptcyFromGame.setVisible(false);
                        gamePrompt.setText("");
                    }
                }
                generateBuyOwnedPropertyComboBox();
            }

        });

        ownedProperties.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                propertyOwner.setText(getOwner(String.valueOf(ownedProperties
                        .getSelectedItem())));
                ownedPropertyValue.setText("");
                ownedPropertyValue.setEnabled(true);
            }

        });

        ownedPropertyValue.getDocument().addDocumentListener(
                new DocumentListener() {

                    @Override
                    public void changedUpdate(DocumentEvent arg0) {
                        if (ownedProperties.getSelectedItem() != null) {
                            checkValue();
                        }
                    }

                    @Override
                    public void insertUpdate(DocumentEvent arg0) {
                        if (ownedProperties.getSelectedItem() != null) {
                            checkValue();
                        }
                    }

                    @Override
                    public void removeUpdate(DocumentEvent arg0) {
                        buyOwnedPropertyButton.setEnabled(false);
                        if (ownedProperties.getSelectedItem() != null) {
                            checkValue();
                        }
                    }

                    public void checkValue() {
                        String value = ownedPropertyValue.getText();
                        int tempQty = 0;
                        try {
                            tempQty = Integer.parseInt(value);
                        } catch (Exception e) {

                        }

                        if (tempQty > 0
                                && tempQty <= players.get(playerIndex)
                                .getMoneyHeld() && !paymentDue
                                && !rentCalculated) {
                            if (entities
                                    .getEntities()
                                    .get(getEntityPosition(String
                                            .valueOf(ownedProperties
                                                    .getSelectedItem())))
                                    .isMortgaged()
                                    && tempQty >= (entities
                                    .getEntities()
                                    .get(getEntityPosition(String
                                            .valueOf(ownedProperties
                                                    .getSelectedItem())))
                                    .getCost() * 0.1)) {
                                buyOwnedPropertyButton.setEnabled(true);
                                valueOfOwnedProperty = tempQty;
                            } else if (!entities
                                    .getEntities()
                                    .get(getEntityPosition(String
                                            .valueOf(ownedProperties
                                                    .getSelectedItem())))
                                    .isMortgaged()) {
                                buyOwnedPropertyButton.setEnabled(true);
                                valueOfOwnedProperty = tempQty;
                            }
                        } else {
                            buyOwnedPropertyButton.setEnabled(false);
                        }
                    }
                });

        buyOwnedPropertyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                boolean isMortgaged = false;
                String entityName = String.valueOf(ownedProperties
                        .getSelectedItem());
                ownerIndex = getPlayerIndex(String.valueOf(propertyOwner
                        .getText()));

                for (int i = 0; i < players.get(ownerIndex)
                        .getOwnedProperties().size(); i++) {
                    if (players.get(ownerIndex).getOwnedProperties().get(i)
                            .getName().equals(entityName)) {
                        players.get(ownerIndex).getOwnedProperties().get(i)
                                .setOwner(players.get(playerIndex));
                        players.get(playerIndex)
                                .getOwnedProperties()
                                .add(players.get(ownerIndex)
                                        .getOwnedProperties().get(i));
                        players.get(ownerIndex).getOwnedProperties().remove(i);
                        break;
                    }
                }

                int entityPosition = getEntityPosition(entityName);
                entities.getEntities().get(entityPosition)
                        .setOwner(players.get(playerIndex));

                if (entities.getEntities().get(entityPosition).isMortgaged()) {
                    isMortgaged = true;
                }

                log = "  /> " + players.get(playerIndex).getName()
                        + " has just bought "
                        + entities.getEntities().get(entityPosition).getName()
                        + " from " + players.get(ownerIndex).getName()
                        + " (for Galy" + valueOfOwnedProperty + ")\n";
                logText.append(log);
                if (isMortgaged) {
                    players.get(ownerIndex)
                            .setMoneyHeld(
                                    valueOfOwnedProperty
                                            - (entities.getEntities()
                                            .get(entityPosition)
                                            .getCost() * 0.1));
                } else {
                    players.get(ownerIndex).setMoneyHeld(valueOfOwnedProperty);
                }
                players.get(playerIndex).setMoneyHeld(-valueOfOwnedProperty);

                balanceLabels.get(ownerIndex).setText(
                        "Galy: " + players.get(ownerIndex).getMoneyHeld());
                balanceLabels.get(playerIndex).setText(
                        "Galy: " + players.get(playerIndex).getMoneyHeld());
                generateMortgageComboBox();
                if (!upgradeOrPerfectPlanetBought
                        && (getNumberOfUpgrades() > 0 || getNumberOfPerfectPlanets() > 0)
                        && !players.get(playerIndex).isInJail()) {
                    generateAddPlanetComboBox();
                }
                generateBuyOwnedPropertyComboBox();
            }

        });

        payLoan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int position = 0;
                boolean mortgaged = false;
                String comboSelection = String.valueOf(mortgageComboBox
                        .getSelectedItem());
                for (PlanetProperties anEntity : entities.getEntities()) {
                    if (anEntity.getName().equals(comboSelection)) {
                        anEntity.setMortgaged(false);
                        position = anEntity.getPosition();
                    }
                }
                for (PlanetProperties entity : players.get(playerIndex)
                        .getOwnedProperties()) {
                    if (entity.getName().equals(comboSelection)) {
                        entity.setMortgaged(false);
                        players.get(playerIndex).setMoneyHeld(
                                -(entity.getCost() * 0.6));
                        log = "  /> " + players.get(playerIndex).getName()
                                + " entity: " + entity.getName()
                                + "\'s mortgage is now paid" + "\n";
                        logText.append(log);
                        balanceLabels.get(playerIndex).setText(
                                "Galy: " + players.get(playerIndex).getMoneyHeld());
                        mortgageComboBox.setSelectedItem(null);
                        payLoan.setEnabled(false);
                        takeLoan.setEnabled(false);
                    }
                }
                applyOrRemoveMortgagedLabel(position, mortgaged);
            }

        });

        declareBankruptcyFromGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                gamePrompt
                        .setText("Are you sure you want to declare BANKRUPTCY from the game?");
                yesButton.setVisible(true);
                noButton.setVisible(true);
                declareBankruptcyFromGame.setVisible(false);
            }

        });

        noButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                yesButton.setVisible(false);
                noButton.setVisible(false);
                declareBankruptcyFromGame.setVisible(true);
                if (paymentDue) {
                    gamePrompt
                            .setText("you need to pay arrears. Sell or mortgage property or declare BANKRUPTCY from game");
                } else if (rentCalculated) {
                    gamePrompt
                            .setText("You need money to pay the rent. Sell property, take loan or declare BANKRUPTCY from game");
                }
            }

        });

        yesButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                log = "  /> " + players.get(playerIndex).getName()
                        + " declare BANKRUPTED from the game. " + "\n";
                logText.append(log);
                int numberOfUpgradesToBeRestored = 0;
                int numberOfPerfectPlanetsToBeRestored = 0;
                double balanceToBeTransferred = 0;
                yesButton.setVisible(false);
                noButton.setVisible(false);
                declareBankruptcyFromGame.setVisible(false);
                mortgageManagement.setVisible(false);
                mortgageComboBox.setVisible(false);
                takeLoan.setVisible(false);
                payLoan.setVisible(false);
                sellProperty.setVisible(false);
                sellPropertyComboBox.setVisible(false);
                buyer.setVisible(false);
                sellingPrice.setVisible(false);
                sellPropertyButton.setVisible(false);
                sellGetOutOfJailCard.setVisible(false);
                cardBuyers.setVisible(false);
                cardPrice.setVisible(false);
                sellGetOutOfJailCardButton.setVisible(false);
                buyOwnedProperty.setVisible(false);
                ownedProperties.setVisible(false);
                propertyOwner.setVisible(false);
                ownedPropertyValue.setVisible(false);
                buyOwnedPropertyButton.setVisible(false);
                hideAddPlanetComponents();
                if (paymentDue) {
                    System.out.println("Perfect Planets: " + getNumberOfPerfectPlanets());
                    System.out.println("Upgrades: " + getNumberOfUpgrades());
                    paymentDue = false;
                    if (players.get(playerIndex).getOwnedProperties().size() > 0) {
                        for (PlanetProperties entity : entities.getEntities()) {
                            if (entity.getOwner() != null
                                    && entity
                                    .getOwner()
                                    .getName()
                                    .equals(players.get(playerIndex)
                                            .getName())) {
                                entity.setOwner(null);
                            }
                        }
                        for (PlanetProperties property : players.get(playerIndex)
                                .getOwnedProperties()) {
                            if (property.getNumberOfPerfectPlanet() == 1) {
                                numberOfPerfectPlanetsToBeRestored++;
                            }
                            if (property.getNumberOfUpgrades() > 0) {
                                numberOfUpgradesToBeRestored += property
                                        .getNumberOfUpgrades();
                            }
                            if (property.getUpgradeIndex() != -1) {
                                perfectPlanetLabels.get(property.getUpgradeIndex())
                                        .setIcon(null);
                            }

                        }
                        setNumberOfPerfectPlanets(numberOfPerfectPlanetsToBeRestored);
                        setNumberOfUpgrades(numberOfUpgradesToBeRestored);
                        System.out.println("Perfect Planets: " + getNumberOfPerfectPlanets());
                        System.out.println("Upgrades: " + getNumberOfUpgrades());
                        while (players.get(playerIndex)
                                .getNumberOfGetOutOfJailCards() != 0) {
                            if (players.get(playerIndex).getOutOfJailCards()
                                    .get(0) instanceof ChanceCard) {
                                players.get(playerIndex).getOutOfJailCards()
                                        .remove(0);
                                deck.returnOutOfJailCardChance();
                            } else {
                                players.get(playerIndex).getOutOfJailCards()
                                        .remove(0);
                                deck.returnOutOfJailCardCommunity();
                            }
                        }
                    }
                } else if (rentCalculated) {
                    rentCalculated = false;
                    if (players.get(playerIndex).getMoneyHeld() > 0) {
                        balanceToBeTransferred = players.get(playerIndex)
                                .getMoneyHeld();
                    }
                    if (players.get(playerIndex).getOwnedProperties().size() > 0) {
                        for (PlanetProperties entity : entities.getEntities()) {
                            if (entity.getOwner() != null
                                    && entity
                                    .getOwner()
                                    .getName()
                                    .equals(players.get(playerIndex)
                                            .getName())) {
                                entity.setOwner(players.get(ownerIndex));
                            }
                        }
                        for (int i = 0; i < players.get(playerIndex)
                                .getOwnedProperties().size(); i++) {
                            players.get(playerIndex).getOwnedProperties()
                                    .get(i).setOwner(players.get(ownerIndex));
                            players.get(ownerIndex)
                                    .getOwnedProperties()
                                    .add(players.get(playerIndex)
                                            .getOwnedProperties().get(i));
                            if (players.get(playerIndex).getOwnedProperties()
                                    .get(i).isMortgaged()) {
                                balanceToBeTransferred -= (players
                                        .get(playerIndex).getOwnedProperties()
                                        .get(i).getCost() * 0.1);
                            }
                        }
                        for (int i = players.get(playerIndex)
                                .getOwnedProperties().size(); i > 0; i--) {
                            players.get(playerIndex).getOwnedProperties()
                                    .remove(i - 1);
                        }

                    }
                    players.get(ownerIndex)
                            .setMoneyHeld(balanceToBeTransferred);
                    while (players.get(playerIndex)
                            .getNumberOfGetOutOfJailCards() != 0) {
                        players.get(ownerIndex)
                                .getOutOfJailCards()
                                .add(players.get(playerIndex)
                                        .getOutOfJailCards().remove(0));
                        getOutOfJailLabels.get(ownerIndex).setVisible(true);
                        getOutOfJailLabels
                                .get(ownerIndex)
                                .setText(
                                        "GET OUT OF JAIL CARD remain: "
                                                + players
                                                .get(ownerIndex)
                                                .getNumberOfGetOutOfJailCards());
                    }
                    log = "  /> " + players.get(ownerIndex).getName()
                            + " acquired all "
                            + players.get(playerIndex).getName()
                            + "'s properties" + "\n";
                    logText.append(log);
                    balanceLabels.get(ownerIndex).setText(
                            "E" + players.get(ownerIndex).getMoneyHeld());
                }
                players.get(playerIndex).setBankrupt(true);
                balanceLabels.get(playerIndex).setText("declare BANKRUPTED from game");
                getOutOfJailLabels.get(playerIndex).setVisible(false);
                finishTurn.setEnabled(true);
                gamePrompt.setText("");
                playerIndicators.get(playerIndex).setVisible(false);
            }

        });

        takeLoan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int position = 0;
                boolean mortgaged = true;
                String comboSelection = String.valueOf(mortgageComboBox
                        .getSelectedItem());
                for (PlanetProperties anEntity : entities.getEntities()) {
                    if (anEntity.getName().equals(comboSelection)) {
                        anEntity.setMortgaged(true);
                        position = anEntity.getPosition();
                    }
                }
                for (PlanetProperties entity : players.get(playerIndex)
                        .getOwnedProperties()) {
                    if (entity.getName().equals(comboSelection)) {
                        entity.setMortgaged(true);
                        players.get(playerIndex).setMoneyHeld(
                                entity.getCost() * 0.5);
                        log = "  /> " + players.get(playerIndex).getName()
                                + " entity: " + entity.getName()
                                + " is now mortgaged" + "\n";
                        logText.append(log);
                        balanceLabels.get(playerIndex).setText(
                                "E" + players.get(playerIndex).getMoneyHeld());
                        mortgageComboBox.setSelectedItem(null);
                        payLoan.setEnabled(false);
                        takeLoan.setEnabled(false);
                        if (entities
                                .getEntities()
                                .get(players.get(playerIndex)
                                        .getPositionOnGameBoard())
                                .canBePurchased()
                                && entities
                                .getEntities()
                                .get(players.get(playerIndex)
                                        .getPositionOnGameBoard())
                                .getOwner() == null) {
                            buyProperty.setVisible(false);
                            buyProperty.setEnabled(true);
                            gamePrompt.setText("");
                            dontBuyProperty.setVisible(false);
                            buyOrRent();
                        }
                    }
                }
                if (rentCalculated) {
                    if (rentValue > players.get(playerIndex).getMoneyHeld()) {
                        gamePrompt
                                .setText("You need money to pay the rent. Sell property, take loan or declare BANKRUPTCY from game");
                    } else {
                        payRent.setVisible(true);
                        declareBankruptcyFromGame.setVisible(false);
                        gamePrompt.setText("");
                    }
                }
                if (paymentDue) {
                    if (paymentDueAmount > players.get(playerIndex)
                            .getMoneyHeld()) {
                        gamePrompt
                                .setText("you need to pay arrears. Sell or mortgage property or declare BANKRUPTCY from game");
                    } else {
                        payArrears.setVisible(true);
                        declareBankruptcyFromGame.setVisible(false);
                        gamePrompt.setText("");
                    }
                }
                addPlanetTo.setSelectedItem(null);
                if (addUpgradeButton.isEnabled()) {
                    addUpgradeButton.setEnabled(false);
                }
                if (addPerfectPlanetButton.isEnabled()) {
                    addPerfectPlanetButton.setEnabled(false);
                }
                applyOrRemoveMortgagedLabel(position, mortgaged);
            }

        });

        payArrears.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                payArrears.setVisible(false);
                paymentDue = false;
                switch (arrearsIndex) {
                    case 1:
                        followChanceCard1();
                        break;
                    case 3:
                        followChanceCard3();
                        break;
                    case 4:
                        payIncomeTax();
                        break;
                    case 6:
                        followChanceCard6();
                        break;
                    case 16:
                        followChanceCard16();
                        break;
                    case 19:
                        followChanceCard19();
                        break;
                    case 38:
                        payManaTax();
                        break;
                    case 105:
                        followCommunityCard5();
                        break;
                    case 106:
                        followCommunityCard6();
                        break;
                    case 108:
                        followCommunityCard8();
                        break;
                    case 120:
                        followCommunityCard20();
                        break;
                }

                if (!gotDouble || doubleCounter == 3) {
                    finishTurn.setEnabled(true);
                } else {
                    rollTheDice.setEnabled(true);
                }
            }

        });

        addPlanetTo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (addPlanetTo.getSelectedItem() != null) {
                    String entityName = String.valueOf(addPlanetTo
                            .getSelectedItem());
                    String group = "";
                    int entityPosition = 0;
                    int numberOfTheSameGroup = 0;
                    int totalnumberOfUpgradesInAGroup = 0;
                    int totalnumberOfPerfectPlanetsInAGroup = 0;
                    boolean canAfford = false;

                    for (PlanetProperties entity : entities.getEntities()) {
                        if (entity.getName().equals(entityName)) {
                            group = entity.getGroup();
                            entityPosition = entity.getPosition();
                            break;
                        }
                    }
                    for (PlanetProperties anEntity : players.get(playerIndex)
                            .getOwnedProperties()) {
                        if (anEntity.getGroup().equals(group)) {
                            numberOfTheSameGroup++;
                            totalnumberOfUpgradesInAGroup += anEntity
                                    .getNumberOfUpgrades();
                            totalnumberOfPerfectPlanetsInAGroup += anEntity
                                    .getNumberOfPerfectPlanet();
                        }
                    }
                    if (entityPosition < 10) {
                        if (players.get(playerIndex).getMoneyHeld() >= 50) {
                            canAfford = true;
                        }
                    } else if (entityPosition < 20) {
                        if (players.get(playerIndex).getMoneyHeld() >= 100) {
                            canAfford = true;
                        }
                    } else if (entityPosition < 30) {
                        if (players.get(playerIndex).getMoneyHeld() >= 150) {
                            canAfford = true;
                        }
                    } else {
                        if (players.get(playerIndex).getMoneyHeld() >= 200) {
                            canAfford = true;
                        }
                    }
                    addUpgradeButton.setEnabled(false);
                    if (canAfford
                            && !players
                            .get(playerIndex)
                            .getOwnedProperties()
                            .get(getPlayersEntityPosition(String
                                    .valueOf(addPlanetTo
                                            .getSelectedItem())))
                            .isMortgaged()) {
                        if (numberOfTheSameGroup == 1) {
                            if (players
                                    .get(playerIndex)
                                    .getOwnedProperties()
                                    .get(getPlayersEntityPosition(String
                                            .valueOf(addPlanetTo
                                                    .getSelectedItem())))
                                    .getNumberOfUpgrades() == 4
                                    && getNumberOfPerfectPlanets() > 0) {
                                addPerfectPlanetButton.setEnabled(true);
                            }
                            if (getNumberOfUpgrades() > 0) {
                                addUpgradeButton.setEnabled(true);
                            }
                        } else if (numberOfTheSameGroup == 2) {
                            if (totalnumberOfUpgradesInAGroup != 0) {
                                if (players
                                        .get(playerIndex)
                                        .getOwnedProperties()
                                        .get(getPlayersEntityPosition(String
                                                .valueOf(addPlanetTo
                                                        .getSelectedItem())))
                                        .getNumberOfUpgrades() == 0
                                        && getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                } else if (players
                                        .get(playerIndex)
                                        .getOwnedProperties()
                                        .get(getPlayersEntityPosition(String
                                                .valueOf(addPlanetTo
                                                        .getSelectedItem())))
                                        .getNumberOfUpgrades() == 1
                                        && totalnumberOfUpgradesInAGroup >= 2
                                        && getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                } else if (players
                                        .get(playerIndex)
                                        .getOwnedProperties()
                                        .get(getPlayersEntityPosition(String
                                                .valueOf(addPlanetTo
                                                        .getSelectedItem())))
                                        .getNumberOfUpgrades() == 2
                                        && totalnumberOfUpgradesInAGroup >= 4
                                        && getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                } else if (players
                                        .get(playerIndex)
                                        .getOwnedProperties()
                                        .get(getPlayersEntityPosition(String
                                                .valueOf(addPlanetTo
                                                        .getSelectedItem())))
                                        .getNumberOfUpgrades() == 3
                                        && totalnumberOfUpgradesInAGroup >= 6
                                        && getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                } else if (players
                                        .get(playerIndex)
                                        .getOwnedProperties()
                                        .get(getPlayersEntityPosition(String
                                                .valueOf(addPlanetTo
                                                        .getSelectedItem())))
                                        .getNumberOfUpgrades() == 4
                                        && (totalnumberOfUpgradesInAGroup >= 8 || (totalnumberOfUpgradesInAGroup >= 4 && totalnumberOfPerfectPlanetsInAGroup == 1))
                                        && getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                    if (getNumberOfPerfectPlanets() > 0) {
                                        addPerfectPlanetButton.setEnabled(true);
                                    }
                                }
                            } else {
                                if (getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                }
                            }
                        } else if (numberOfTheSameGroup == 3) {
                            if (totalnumberOfUpgradesInAGroup != 0) {
                                if (players
                                        .get(playerIndex)
                                        .getOwnedProperties()
                                        .get(getPlayersEntityPosition(String
                                                .valueOf(addPlanetTo
                                                        .getSelectedItem())))
                                        .getNumberOfUpgrades() == 0
                                        && getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                } else if (players
                                        .get(playerIndex)
                                        .getOwnedProperties()
                                        .get(getPlayersEntityPosition(String
                                                .valueOf(addPlanetTo
                                                        .getSelectedItem())))
                                        .getNumberOfUpgrades() == 1
                                        && totalnumberOfUpgradesInAGroup >= 3
                                        && getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                } else if (players
                                        .get(playerIndex)
                                        .getOwnedProperties()
                                        .get(getPlayersEntityPosition(String
                                                .valueOf(addPlanetTo
                                                        .getSelectedItem())))
                                        .getNumberOfUpgrades() == 2
                                        && totalnumberOfUpgradesInAGroup >= 6
                                        && getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                } else if (players
                                        .get(playerIndex)
                                        .getOwnedProperties()
                                        .get(getPlayersEntityPosition(String
                                                .valueOf(addPlanetTo
                                                        .getSelectedItem())))
                                        .getNumberOfUpgrades() == 3
                                        && totalnumberOfUpgradesInAGroup >= 9
                                        && getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                } else if (players
                                        .get(playerIndex)
                                        .getOwnedProperties()
                                        .get(getPlayersEntityPosition(String
                                                .valueOf(addPlanetTo
                                                        .getSelectedItem())))
                                        .getNumberOfUpgrades() == 4
                                        && (totalnumberOfUpgradesInAGroup >= 12
                                        || (totalnumberOfUpgradesInAGroup >= 8 && totalnumberOfPerfectPlanetsInAGroup == 1) || (totalnumberOfUpgradesInAGroup >= 4 && totalnumberOfPerfectPlanetsInAGroup == 2))
                                        && getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                    if (getNumberOfPerfectPlanets() > 0) {
                                        addPerfectPlanetButton.setEnabled(true);
                                    }
                                }
                            } else {
                                if (getNumberOfUpgrades() > 0) {
                                    addUpgradeButton.setEnabled(true);
                                }
                            }
                        }
                    }

                    System.out.println("Number of total upgrades in a color group: "
                            + totalnumberOfUpgradesInAGroup);
                    System.out.println("Number of the same color group: "
                            + numberOfTheSameGroup);
                }
            }

        });

        addUpgradeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                upgradeOrPerfectPlanetBought = true;
                setNumberOfUpgrades(-1);
                double upgradeCost = 0;
                if (entities
                        .getEntities()
                        .get(getEntityPosition(String.valueOf(addPlanetTo
                                .getSelectedItem()))).getUpgradeIndex() < 5) {
                    upgradeCost = 50;
                } else if (entities
                        .getEntities()
                        .get(getEntityPosition(String.valueOf(addPlanetTo
                                .getSelectedItem()))).getUpgradeIndex() < 11) {
                    upgradeCost = 100;
                } else if (entities
                        .getEntities()
                        .get(getEntityPosition(String.valueOf(addPlanetTo
                                .getSelectedItem()))).getUpgradeIndex() < 17) {
                    upgradeCost = 150;
                } else {
                    upgradeCost = 200;
                }

                for (PlanetProperties entity : players.get(playerIndex)
                        .getOwnedProperties()) {
                    if (entity.getName().equals(
                            String.valueOf(addPlanetTo.getSelectedItem()))) {
                        entity.setNumberOfUpgrades(1);
                        break;
                    }
                }
                int numberOfUpgrades = players
                        .get(playerIndex)
                        .getOwnedProperties()
                        .get(getPlayersEntityPosition(String
                                .valueOf(addPlanetTo.getSelectedItem())))
                        .getNumberOfUpgrades();
                log = "  /> "
                        + players.get(playerIndex).getName()
                        + " has just upgrade at "
                        + entities
                        .getEntities()
                        .get(getEntityPosition(String
                                .valueOf(addPlanetTo
                                        .getSelectedItem()))).getName()
                        + "\n";
                logText.append(log);
                players.get(playerIndex).setMoneyHeld(-upgradeCost);
                hideAddPlanetComponents();
                balanceLabels.get(playerIndex).setText(
                        "E" + players.get(playerIndex).getMoneyHeld());
                displayProperPlanetLabel(
                        players.get(playerIndex)
                                .getOwnedProperties()
                                .get(getPlayersEntityPosition(String
                                        .valueOf(addPlanetTo
                                                .getSelectedItem())))
                                .getNumberOfUpgrades(), numberOfUpgrades);
                generateMortgageComboBox();
            }

        });

        addPerfectPlanetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                setNumberOfPerfectPlanets(-1);
                setNumberOfUpgrades(4);
                upgradeOrPerfectPlanetBought = true;
                double perfectPlanetCost = 0;
                if (entities
                        .getEntities()
                        .get(getEntityPosition(String.valueOf(addPlanetTo
                                .getSelectedItem()))).getUpgradeIndex() < 5) {
                    perfectPlanetCost = 50;
                } else if (entities
                        .getEntities()
                        .get(getEntityPosition(String.valueOf(addPlanetTo
                                .getSelectedItem()))).getUpgradeIndex() < 11) {
                    perfectPlanetCost = 100;
                } else if (entities
                        .getEntities()
                        .get(getEntityPosition(String.valueOf(addPlanetTo
                                .getSelectedItem()))).getUpgradeIndex() < 17) {
                    perfectPlanetCost = 150;
                } else {
                    perfectPlanetCost = 200;
                }
                for (PlanetProperties entity : players.get(playerIndex)
                        .getOwnedProperties()) {
                    if (entity.getName().equals(
                            String.valueOf(addPlanetTo.getSelectedItem()))) {
                        entity.setNumberOfUpgrades(-entity.getNumberOfUpgrades());
                        entity.setNumberOfPerfectPlanet(1);
                        break;
                    }
                }
                int numberOfUpgrades = 0;
                log = "  /> "
                        + players.get(playerIndex).getName()
                        + " has just bought a Perfect Planet at "
                        + entities
                        .getEntities()
                        .get(getEntityPosition(String
                                .valueOf(addPlanetTo
                                        .getSelectedItem()))).getName()
                        + "\n";
                logText.append(log);
                players.get(playerIndex).setMoneyHeld(-perfectPlanetCost);
                hideAddPlanetComponents();
                balanceLabels.get(playerIndex).setText(
                        "Galy: " + players.get(playerIndex).getMoneyHeld());
                displayProperPlanetLabel(
                        players.get(playerIndex)
                                .getOwnedProperties()
                                .get(getPlayersEntityPosition(String
                                        .valueOf(addPlanetTo
                                                .getSelectedItem())))
                                .getUpgradeIndex(), numberOfUpgrades);
            }
        });

        restartGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
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
                restartGame.setVisible(false);

            }

        });
    }

    /**
     *
     * @param position is a position of the deed to be dealt with
     * @param mortgaged specifies whether the deed label needs to
     * be "mortgaged" or "clean"
     */
    private void applyOrRemoveMortgagedLabel(int position, boolean mortgaged) {
        switch (position) {
            case 1:
                if (mortgaged) {
                    setBottom9Mortgaged();
                } else {
                    setBottom9Clean();
                }
                break;
            case 3:
                if (mortgaged) {
                    setBottom7Mortgaged();
                } else {
                    setBottom7Clean();
                }
                break;
            case 5:
                if (mortgaged) {
                    setBottom5Mortgaged();
                } else {
                    setBottom5Clean();
                }
                break;
            case 6:
                if (mortgaged) {
                    setBottom4Mortgaged();
                } else {
                    setBottom4Clean();
                }
                break;
            case 8:
                if (mortgaged) {
                    setBottom2Mortgaged();
                } else {
                    setBottom2Clean();
                }
                break;
            case 9:
                if (mortgaged) {
                    setBottom1Mortgaged();
                } else {
                    setBottom1Clean();
                }
                break;
            case 11:
                if (mortgaged) {
                    setLeft9Mortgaged();
                } else {
                    setLeft9Clean();
                }
                break;
            case 12:
                if (mortgaged) {
                    setLeft8Mortgaged();
                } else {
                    setLeft8Clean();
                }
                break;
            case 13:
                if (mortgaged) {
                    setLeft7Mortgaged();
                } else {
                    setLeft7Clean();
                }
                break;
            case 14:
                if (mortgaged) {
                    setLeft6Mortgaged();
                } else {
                    setLeft6Clean();
                }
                break;
            case 15:
                if (mortgaged) {
                    setLeft5Mortgaged();
                } else {
                    setLeft5Clean();
                }
                break;
            case 16:
                if (mortgaged) {
                    setLeft4Mortgaged();
                } else {
                    setLeft4Clean();
                }
                break;
            case 19:
                if (mortgaged) {
                    setLeft1Mortgaged();
                } else {
                    setLeft1Clean();
                }
                break;
            case 21:
                if (mortgaged) {
                    setTop1Mortgaged();
                } else {
                    setTop1Clean();
                }
                break;
            case 23:
                if (mortgaged) {
                    setTop3Mortgaged();
                } else {
                    setTop3Clean();
                }
                break;
            case 24:
                if (mortgaged) {
                    setTop4Mortgaged();
                } else {
                    setTop4Clean();
                }
                break;
            case 25:
                if (mortgaged) {
                    setTop5Mortgaged();
                } else {
                    setTop5Clean();
                }
                break;
            case 27:
                if (mortgaged) {
                    setTop7Mortgaged();
                } else {
                    setTop7Clean();
                }
                break;
            case 28:
                if (mortgaged) {
                    setTop8Mortgaged();
                } else {
                    setTop8Clean();
                }
                break;
            case 29:
                if (mortgaged) {
                    setTop9Mortgaged();
                } else {
                    setTop9Clean();
                }
                break;
            case 31:
                if (mortgaged) {
                    setRight1Mortgaged();
                } else {
                    setRight1Clean();
                }
                break;
            case 32:
                if (mortgaged) {
                    setRight2Mortgaged();
                } else {
                    setRight2Clean();
                }
                break;
            case 34:
                if (mortgaged) {
                    setRight4Mortgaged();
                } else {
                    setRight4Clean();
                }
                break;
            case 35:
                if (mortgaged) {
                    setRight5Mortgaged();
                } else {
                    setRight5Clean();
                }
                break;
            case 37:
                if (mortgaged) {
                    setRight7Mortgaged();
                } else {
                    setRight7Clean();
                }
                break;
            case 39:
                if (mortgaged) {
                    setRight9Mortgaged();
                } else {
                    setRight9Clean();
                }
                break;
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setBottom9Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "1.png"));
            bottom9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setBottom9Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "1mort.png"));
            bottom9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setBottom7Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "3.png"));
            bottom7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setBottom7Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "3mort.png"));
            bottom7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setBottom5Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "5.png"));
            bottom5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setBottom5Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "5mort.png"));
            bottom5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setBottom4Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "6.png"));
            bottom4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setBottom4Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "6mort.png"));
            bottom4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setBottom2Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "8.png"));
            bottom2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setBottom2Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "8mort.png"));
            bottom2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setBottom1Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "9.png"));
            bottom1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setBottom1Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "9mort.png"));
            bottom1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setLeft9Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "11.png"));
            left9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setLeft9Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "11mort.png"));
            left9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setLeft8Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "12.png"));
            left8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setLeft8Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "12mort.png"));
            left8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setLeft7Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "13.png"));
            left7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setLeft7Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "13mort.png"));
            left7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setLeft6Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "14.png"));
            left6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setLeft6Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "14mort.png"));
            left6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setLeft5Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "15.png"));
            left5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setLeft5Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "15mort.png"));
            left5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setLeft4Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "16.png"));
            left4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setLeft4Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "16mort.png"));
            left4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setLeft1Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "19.png"));
            left1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setLeft1Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "19mort.png"));
            left1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setTop1Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "21.png"));
            top1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setTop1Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "21mort.png"));
            top1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setTop3Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "23.png"));
            top3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setTop3Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "23mort.png"));
            top3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setTop4Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "24.png"));
            top4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setTop4Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "24mort.png"));
            top4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setTop5Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "25.png"));
            top5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setTop5Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "25mort.png"));
            top5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }


    /**
     * sets specified deed label to clean
     */
    private void setTop7Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "27.png"));
            top7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setTop7Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "27mort.png"));
            top7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setTop8Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "28.png"));
            top8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setTop8Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "28mort.png"));
            top8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setTop9Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "29.png"));
            top9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setTop9Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "29mort.png"));
            top9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setRight1Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "31.png"));
            right1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setRight1Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "31mort.png"));
            right1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setRight2Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "32.png"));
            right2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setRight2Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "32mort.png"));
            right2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setRight4Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "34.png"));
            right4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setRight4Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "34mort.png"));
            right4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setRight5Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "35.png"));
            right5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setRight5Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "35mort.png"));
            right5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setRight7Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "37.png"));
            right7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setRight7Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "37mort.png"));
            right7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to clean
     */
    private void setRight9Clean() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "39.png"));
            right9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     * sets specified deed label to mortgaged
     */
    private void setRight9Mortgaged() {
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "39mort.png"));
            right9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    /**
     *
     * @return true if number of players, which did not go bankrupt is greater
     * than or equal to 2, false otherwise
     */
    private boolean gameOn() {
        int playersCounter = 0;
        for (Player player : players) {
            if (!player.isBankrupt()) {
                playersCounter++;
            }
        }
        return (playersCounter >= 2);
    }

    /**
     * buy owned property comboBox is generated, when this method is called and
     * all relevant components are set to be visible, when appropriate
     */
    private void generateBuyOwnedPropertyComboBox() {
        int counter = 0;
        ownedPropertiesModel = new DefaultComboBoxModel<String>();
        for (PlanetProperties entity : entities.getEntities()) {
            if (entity.getOwner() != null
                    && !entity.getOwner().getName()
                    .equals(players.get(playerIndex).getName())) {
                ownedPropertiesModel.addElement(entity.getName());
                counter++;
            }
        }
        if (counter > 0) {
            ownedProperties.setModel(ownedPropertiesModel);
            ownedProperties.setSelectedItem(null);
            propertyOwner.setText("");
            ownedPropertyValue.setText("");
            buyOwnedProperty.setVisible(true);
            ownedProperties.setVisible(true);
            propertyOwner.setVisible(true);
            ownedPropertyValue.setVisible(true);
            ownedPropertyValue.setEnabled(false);
            buyOwnedPropertyButton.setVisible(true);
            buyOwnedPropertyButton.setEnabled(false);
        } else {
            buyOwnedProperty.setVisible(false);
            ownedProperties.setVisible(false);
            propertyOwner.setVisible(false);
            ownedPropertyValue.setVisible(false);
            buyOwnedPropertyButton.setVisible(false);
        }

    }

    /**
     * mortgage comboBox is generated, when this method is called and
     * all relevant components are set to be visible, when appropriate
     */
    private void generateMortgageComboBox() {
        mortgageModel = new DefaultComboBoxModel<String>();
        for (PlanetProperties entity : players.get(playerIndex).getOwnedProperties()) {
            if (entity.getNumberOfUpgrades() == 0
                    && entity.getNumberOfPerfectPlanet() == 0) {
                mortgageModel.addElement(entity.getName());
            }
        }
        mortgageComboBox.setModel(mortgageModel);
        mortgageComboBox.setSelectedItem(null);
        sellPropertyModel = new DefaultComboBoxModel<String>();
        for (PlanetProperties entity : players.get(playerIndex).getOwnedProperties()) {
            sellPropertyModel.addElement(entity.getName());
        }
        sellPropertyComboBox.setModel(sellPropertyModel);
        mortgageManagement.setVisible(true);
        mortgageComboBox.setVisible(true);
        takeLoan.setVisible(true);
        payLoan.setVisible(true);
        takeLoan.setEnabled(false);
        payLoan.setEnabled(false);
        sellProperty.setVisible(true);
        sellPropertyComboBox.setVisible(true);
        sellPropertyComboBox.setSelectedItem(null);
        buyer.setVisible(true);
        buyer.setSelectedItem(null);
        sellingPrice.setVisible(true);
        sellingPrice.setText("");
        sellingPrice.setEnabled(false);
        sellPropertyButton.setVisible(true);
        sellPropertyButton.setEnabled(false);
    }

    /**
     * add Planet comboBox is generated, when this method is called and
     * all relevant components are set to be visible, when appropriate
     */
    private void generateAddPlanetComboBox() {
        Set<String> entitiesNames = new HashSet<String>();
        for (PlanetProperties entity : players.get(playerIndex).getOwnedProperties()) {
            if (playerHasAll(entity.getGroup(), players.get(playerIndex)
                    .getName())
                    || entity.getNumberOfUpgrades() > 0
                    || hasPlanets(entity.getGroup())) {
                if (entity.getGroup() != "constellation"
                        && entity.getGroup() != "star"
                        && entity.getNumberOfUpgrades() < 5
                        && entity.getNumberOfPerfectPlanet() < 1) {
                    entitiesNames.add(entity.getName());
                }

            }
        }
        if (entitiesNames.size() > 0) {
            if (getNumberOfUpgrades() == 0) {
                gamePrompt.setText("Not upgradable...");
            } else if (getNumberOfPerfectPlanets() == 0) {
                gamePrompt.setText("No Perfect Planet available...");
            }
            addPlanetToModel = new DefaultComboBoxModel<String>();
            buyPlanet.setVisible(true);
            for (String name : entitiesNames) {
                addPlanetToModel.addElement(name);
            }
            addPlanetTo.setModel(addPlanetToModel);
            addPlanetTo.setVisible(true);
            addPlanetTo.setSelectedItem(null);
            addUpgradeButton.setVisible(true);
            addUpgradeButton.setEnabled(false);
            addPerfectPlanetButton.setVisible(true);
            addPerfectPlanetButton.setEnabled(false);
        } else {
            hideAddPlanetComponents();
        }
    }

    /**
     * sell get out of jail card comboBox is generated, when this method is
     * called and all relevant components are set to be visible, when appropriate
     */
    private void generateSellGetOutOfJailCardComboBox() {
        cardBuyersModel = new DefaultComboBoxModel<String>();
        for (int i = 0; i < players.size(); i++) {
            if (i != playerIndex && !players.get(i).isBankrupt()
                    && players.get(i).getMoneyHeld() > 0) {
                cardBuyersModel.addElement(players.get(i).getName());
            }
        }

        cardBuyers.setModel(cardBuyersModel);
        cardPrice.setText("");
        cardBuyers.setSelectedItem(null);
        sellGetOutOfJailCard.setVisible(true);
        cardBuyers.setVisible(true);
        cardPrice.setVisible(true);
        sellGetOutOfJailCardButton.setVisible(true);
        sellGetOutOfJailCardButton.setEnabled(false);
    }

    /**
     * add perfect planet and upgrade buttons and comboBox are hidden, when this method
     * is called
     */
    private void hideAddPlanetComponents() {
        addPerfectPlanetButton.setEnabled(false);
        addUpgradeButton.setEnabled(false);
        addPerfectPlanetButton.setVisible(false);
        addUpgradeButton.setVisible(false);
        addPlanetTo.setVisible(false);
        buyPlanet.setVisible(false);
    }

    /**
     * Chance card is dealt, when this method is called and appropriate action
     * is taken according to the dealt card
     */
    private void ChanceCardActive() {
        this.chanceCardPicked = true;
        int position = ((Player) this.players.get(this.playerIndex)).getPositionOnGameBoard();
        BufferedImage img;
        switch (this.deck.dealChanceCard()) {
            case 1:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c1.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var20) {
                }
                int counter = 0;

                for (int i = 0; i < this.players.size(); ++i) {
                    if (i != this.playerIndex && !((Player) this.players.get(i)).isBankrupt()) {
                        ++counter;
                    }
                }
                this.paymentDueAmount = (double) (counter * 50);
                if (this.paymentDueAmount > ((Player) this.players.get(this.playerIndex)).getMoneyHeld()) {
                    this.paymentDue = true;
                    this.arrearsIndex = 1;
                } else {
                    this.followChanceCard1();
                }
                break;
            case 2:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c2.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var19) {
                }
                ((Player) this.players.get(this.playerIndex)).setMoneyHeld(50.0);
                ((JLabel) this.balanceLabels.get(this.playerIndex)).setText("Mana: " + ((Player) this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player) this.players.get(this.playerIndex)).getName() + " has received 50 Galy for meeting a gold meteorite" + "\n";
                this.logText.append(this.log);
                break;
            case 3:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c3.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var18) {
                }
                this.manaDueAmount = 30.0;
                if (((Player) this.players.get(this.playerIndex)).getManaHeld() >= this.manaDueAmount) {
                    this.followChanceCard3();
                } else {
                    this.manaDue = true;
                    this.arrearsIndex = 109;
                }
                break;
            case 4:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c4.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var17) {
                }
                ((Player) this.players.get(this.playerIndex)).positionOnBoard(-3);
                this.adjustPlayerPosition();
                this.log = "  /> " + ((Player) this.players.get(this.playerIndex)).getName() + " has turned 3 steps back to avoid asteroid hit\n";
                this.logText.append(this.log);
                break;
            case 5:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c5.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var16) {
                }
                if (position == 7) {
                    position = 9;
                } else {
                    position = 56 - position;
                }
                ((Player) this.players.get(this.playerIndex)).positionOnBoard(position);
                this.adjustPlayerPosition();
                break;
            case 6:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c6.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var15) {
                }
                this.paymentDueAmount = 0.0;
                Iterator var23 = ((Player) this.players.get(this.playerIndex)).getOwnedProperties().iterator();

                while (var23.hasNext()) {
                    PlanetProperties entity = (PlanetProperties) var23.next();
                    if (entity.getNumberOfUpgrades() > 0) {
                        this.paymentDueAmount += (double) (entity.getNumberOfUpgrades() * 25);
                    }

                    if (entity.getNumberOfPerfectPlanet() > 0) {
                        this.paymentDueAmount += 100.0;
                    }
                }
                if (this.paymentDueAmount > 0.0) {
                    if (this.paymentDueAmount <= ((Player) this.players.get(this.playerIndex)).getMoneyHeld()) {
                        this.followChanceCard6();
                    } else {
                        this.paymentDue = true;
                        this.arrearsIndex = 9;
                    }
                }
                break;
            case 7:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c7.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var14) {
                }

                position = ((Player) this.players.get(this.playerIndex)).getPositionOnGameBoard();
                if (((Player) this.players.get(this.playerIndex)).getNumberOfGetOutOfJailCards() == 0) {
                    position = 10 - position;
                    ((Player) this.players.get(this.playerIndex)).positionOnBoard(position);
                    this.finishTurn.setEnabled(true);
                    this.rollTheDice.setEnabled(false);
                    ((Player) this.players.get(this.playerIndex)).setInJail(true);
                    this.log = "  /> " + ((Player) this.players.get(this.playerIndex)).getName() + " went to Jail" + "\n";
                    this.logText.append(this.log);
                    this.adjustPlayerPosition();
                    ((Player) this.players.get(this.playerIndex)).setManaHeld(0);
                    ((JLabel) this.energyLabels.get(this.playerIndex)).setText("Mana: " + ((Player) this.players.get(this.playerIndex)).getManaHeld());
                    this.log = "  /> " + ((Player) this.players.get(this.playerIndex)).getName() + " has lost all the Mana due to colliding high-velocity stars" + "\n";
                    this.logText.append(this.log);
                } else {
                    this.gamePrompt.setText("Do you want to use your get out of jail card?");
                    this.useGetOutOfJailCard.setVisible(true);
                    this.dontUseGetOutOfJailCard.setVisible(true);
                    this.rollTheDice.setEnabled(false);
                    this.finishTurn.setEnabled(false);
                    ((Player) this.players.get(this.playerIndex)).setManaHeld(500.0);
                    ((JLabel) this.energyLabels.get(this.playerIndex)).setText("E" + ((Player) this.players.get(this.playerIndex)).getManaHeld());
                    this.log = "  /> " + ((Player) this.players.get(this.playerIndex)).getName() + " has gained 500 mana from ISS gift" + "\n";
                    this.logText.append(this.log);
                }
                break;
            case 8:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c8.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var13) {
                }

                ((Player) this.players.get(this.playerIndex)).setMoneyHeld(150.0);
                ((JLabel) this.balanceLabels.get(this.playerIndex)).setText("Mana: " + ((Player) this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player) this.players.get(this.playerIndex)).getName() + " has received 150 Galy from meeting peer-to-peer spacecraft" + "\n";
                this.logText.append(this.log);
                break;
            case 9:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c9.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var12) {
                }

                ((Player) this.players.get(this.playerIndex)).addGetOutOfJailCard(this.deck.getFortuneCard(3));
                ((JLabel) this.getOutOfJailLabels.get(this.playerIndex)).setText("GET OUT OF JAIL CARD remain: " + ((Player) this.players.get(this.playerIndex)).getNumberOfGetOutOfJailCards());
                ((JLabel) this.getOutOfJailLabels.get(this.playerIndex)).setVisible(true);
                this.generateSellGetOutOfJailCardComboBox();
                this.log = "  /> " + ((Player) this.players.get(this.playerIndex)).getName() + " has received GET OUT OF JAIL CARD \n";
                this.logText.append(this.log);
                break;
            case 10:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c10.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var11) {
                }

                if (position < 12) {
                    position = 12 - position;
                } else if (position < 28) {
                    position = 28 - position;
                } else {
                    position = 52 - position;
                }

                ((Player) this.players.get(this.playerIndex)).positionOnBoard(position);
                this.sentByChanceCard = true;
                this.adjustPlayerPosition();
                break;

            case 11:
                try {
                    img = ImageIO.read(this.getClass().getResource("c11.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var10) {
                }

                ((Player) this.players.get(this.playerIndex)).positionOnBoard(40 - ((Player) this.players.get(this.playerIndex)).getPositionOnGameBoard());
                this.adjustPlayerPosition();
                break;
            case 12:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c12.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var9) {
                }

                position = 41 - position;
                ((Player) this.players.get(this.playerIndex)).positionOnBoard(position);
                this.adjustPlayerPosition();
                break;
            case 13:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c13.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var8) {
                }
                if (position == 7) {
                    position = 22;
                } else if (position == 22) {
                    position = 7;
                } else {
                    position = 69 - position;
                }
                ((Player) this.players.get(this.playerIndex)).positionOnBoard(position);
                this.adjustPlayerPosition();
                break;
            case 14:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c14.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var7) {
                }

                position = 45 - position;
                ((Player) this.players.get(this.playerIndex)).positionOnBoard(position);
                this.adjustPlayerPosition();
                break;

            case 15:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c15.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var6) {
                }

                if (position == 7) {
                    position = 8;
                } else if (position == 22) {
                    position = 3;
                } else {
                    position = 9;
                }

                ((Player) this.players.get(this.playerIndex)).positionOnBoard(position);
                if (((PlanetProperties) this.entities.getEntities().get(((Player) this.players.get(this.playerIndex)).getPositionOnGameBoard())).getOwner() != null && ((PlanetProperties) this.entities.getEntities().get(((Player) this.players.get(this.playerIndex)).getPositionOnGameBoard())).getOwner().getName() != ((Player) this.players.get(this.playerIndex)).getName()) {
                    this.sentByChanceCard = true;
                }
                this.adjustPlayerPosition();
                break;
            case 16:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c16.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var5) {
                }
                this.manaDueAmount = 150.0;
                if (((Player) this.players.get(this.playerIndex)).getManaHeld() >= this.manaDueAmount) {
                    this.followChanceCard16();
                } else {
                    this.manaDue = true;
                    this.arrearsIndex = 109;
                }
                break;
            case 17:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c17.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var4) {
                }
                ((Player) this.players.get(this.playerIndex)).setManaHeld(200.0);
                ((JLabel) this.balanceLabels.get(this.playerIndex)).setText("Mana: " + ((Player) this.players.get(this.playerIndex)).getManaHeld());
                this.log = "  /> " + ((Player) this.players.get(this.playerIndex)).getName() + " has received 200 Mana from supply ship coming" + "\n";
                this.logText.append(this.log);
                break;
            case 18:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c18.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var3) {
                }
                ((Player) this.players.get(this.playerIndex)).setMoneyHeld(200.0);
                ((JLabel) this.balanceLabels.get(this.playerIndex)).setText("Mana: " + ((Player) this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player) this.players.get(this.playerIndex)).getName() + " has received 200 Galy from new matter founding" + "\n";
                this.logText.append(this.log);
                break;
            case 19:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c19.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var2) {
                }
                this.manaDueAmount = 50.0;
                if (((Player) this.players.get(this.playerIndex)).getManaHeld() >= this.manaDueAmount) {
                    this.followChanceCard19();
                } else {
                    this.manaDue = true;
                    this.arrearsIndex = 109;
                }
                break;
            case 20:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("c20.png"));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var1) {
                }
                ((Player) this.players.get(this.playerIndex)).setMoneyHeld(100.0);
                ((JLabel) this.balanceLabels.get(this.playerIndex)).setText("Mana: " + ((Player) this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player) this.players.get(this.playerIndex)).getName() + " has received 100 Galy from new batteries" + "\n";
                this.logText.append(this.log);
                break;
            }
        }

    
    private void followChanceCard1() {
        for(int i = 0; i < this.players.size(); ++i) {
            if (i != this.playerIndex && !((Player)this.players.get(i)).isBankrupt()) {
                ((Player)this.players.get(i)).setMoneyHeld(50.0);
                ((JLabel)this.balanceLabels.get(i)).setText("Mana: " + ((Player)this.players.get(i)).getMoneyHeld());
            }
        }
        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-this.paymentDueAmount);
        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("Mana: " + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " paid each of other players 50 Galy on success on Alpha-leap" + "\n";
        this.logText.append(this.log);
    }
    private void followChanceCard3() {
        ((Player)this.players.get(this.playerIndex)).setManaHeld(-this.manaDueAmount);
        ((JLabel)this.energyLabels.get(this.playerIndex)).setText("Mana: " + ((Player)this.players.get(this.playerIndex)).getManaHeld());
        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost 30 Mana due to energy leak" + "\n";
        this.logText.append(this.log);
    }
    private void followChanceCard6() {
        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-this.paymentDueAmount);
        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("Mana: " + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has spent Galy" + this.paymentDueAmount + " on general repairs on his properties \n";
        this.logText.append(this.log);
    }

    private void followChanceCard16() {
        ((Player)this.players.get(this.playerIndex)).setManaHeld(-this.manaDueAmount);
        ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost 150 Mana due to black hole edge" + "\n";
        this.logText.append(this.log);
    }
    private void followChanceCard19() {
        ((Player)this.players.get(this.playerIndex)).setManaHeld(-this.manaDueAmount);
        ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost 50 Mana due to gamma ray burst" + "\n";
        this.logText.append(this.log);
    }

    /**
     * when player has sufficient funds, action is taken according to the
     * dealt card
     */
    private void followCommunityCard1() {
        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-this.paymentDueAmount);
        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has spent M" + this.paymentDueAmount + " on street repairs \n";
        this.logText.append(this.log);
    }

        private void followCommunityCard5() {
        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-this.paymentDueAmount);
        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has paid 50 Galy for maintenance fee" + "\n";
        this.logText.append(this.log);
    }
    private void followCommunityCard6() {
        ((Player)this.players.get(this.playerIndex)).setMoneyHeld(-this.paymentDueAmount);
        ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has paid 50 Galy for space garage fee" + "\n";
        this.logText.append(this.log);
    }

    private void followCommunityCard8() {
        ((Player)this.players.get(this.playerIndex)).setManaHeld(-this.manaDueAmount);
        ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost 150 mana due to letting the sub-spacecraft to explore" + "\n";
        this.logText.append(this.log);
    }

        private void followCommunityCard20() {
        ((Player)this.players.get(this.playerIndex)).setManaHeld(-this.manaDueAmount);
        ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
        this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost 100 mana due to losing connection" + "\n";
        this.logText.append(this.log);
    }
    private void FortuneCardActive() {
        this.fortuneCardPicked = true;
        int counter;
        BufferedImage img;
        int i;
        switch (this.deck.dealFortuneCard()) {
            case 1:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune1.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var20) {
                }
                this.paymentDueAmount = 0.0;
                Iterator var20 = ((Player)this.players.get(this.playerIndex)).getOwnedProperties().iterator();

                while(var20.hasNext()) {
                    PlanetProperties PlanetProperties = (PlanetProperties)var20.next();
                    if (PlanetProperties.getNumberOfUpgrades() > 0) {
                        this.paymentDueAmount += (double)(PlanetProperties.getNumberOfUpgrades() * 40);
                    }
                    if (PlanetProperties.getNumberOfPerfectPlanet() > 0) {
                        this.paymentDueAmount += 115.0;
                    }
                }
                if (this.paymentDueAmount > 0.0) {
                    if (this.paymentDueAmount <= ((Player)this.players.get(this.playerIndex)).getMoneyHeld()) {
                        this.followCommunityCard1();
                    } else {
                        this.paymentDue = true;
                        this.arrearsIndex = 112;
                    }
                }
                break;
            case 2:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune2.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var19) {
                }

                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(10.0);
                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 10 Galy for being a Miss Universe 2023" + "\n";
                this.logText.append(this.log);
                break;
            case 3:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune3.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var18) {
                }

                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(200.0);
                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 200 Galy for meeting a diamond meteorite\n";
                this.logText.append(this.log);
                break;
            case 4:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune4.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var17) {
                }
                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(100.0);
                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 Galy from the bank" + "\n";
                this.logText.append(this.log);
                break;
            case 5:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune5.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var16) {
                }

                this.paymentDueAmount = 50.0;
                if (((Player)this.players.get(this.playerIndex)).getMoneyHeld() >= this.paymentDueAmount) {
                    this.followCommunityCard5();
                } else {
                    this.paymentDue = true;
                    this.arrearsIndex = 109;
                }
                break;
            case 6:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune6.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var15) {
                }

                this.paymentDueAmount = 100.0;
                if (((Player)this.players.get(this.playerIndex)).getMoneyHeld() >= this.paymentDueAmount) {
                    this.followCommunityCard6();
                } else {
                    this.paymentDue = true;
                    this.arrearsIndex = 109;
                }
                break;
            case 7:     // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune7.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var14) {
                }
                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(100.0);
                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 Galy from the alien gift" + "\n";
                this.logText.append(this.log);
                break;
            case 8:         // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune8.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var13) {
                }

                this.manaDueAmount = 150.0;
                if (((Player)this.players.get(this.playerIndex)).getManaHeld() >= this.manaDueAmount) {
                    this.followCommunityCard8();
                } else {
                    this.manaDue = true;
                    this.arrearsIndex = 109;
                }
                break;
            case 9:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune9.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var12) {
                }
                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(25.0);
                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 25 Galy from Alien's spacecraft" + "\n";
                this.logText.append(this.log);
                break;
            case 10:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune10.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var11) {
                }
                ((Player)this.players.get(this.playerIndex)).positionOnBoard(40 - ((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard());
                this.adjustPlayerPosition();
                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(200.0);
                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 200 Galy from the government" + "\n";
                this.logText.append(this.log);
                break;
            case 11:       // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune11.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var10) {
                }

                counter = 0;
                for(i = 0; i < this.players.size(); ++i) {
                    if (i != this.playerIndex) {
                        ((Player)this.players.get(i)).setMoneyHeld(-50.0);
                        ++counter;
                        ((JLabel)this.balanceLabels.get(i)).setText("E" + ((Player)this.players.get(i)).getMoneyHeld());
                    }
                }

                ((Player)this.players.get(this.playerIndex)).setMoneyHeld((double)(counter * 50));
                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received from each of other players 50 Galy" + "\n";
                this.logText.append(this.log);
                break;
            case 12:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune12.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var9) {
                }
                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(200.0);
                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 200 Galy for awarding the Universe Oldie Pension" + "\n";
                this.logText.append(this.log);
                break;
            case 13:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune13.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var8) {
                }

                ((Player)this.players.get(this.playerIndex)).addGetOutOfJailCard(this.deck.getFortuneCard(3));
                ((JLabel)this.getOutOfJailLabels.get(this.playerIndex)).setText("get out of jail cards : " + ((Player)this.players.get(this.playerIndex)).getNumberOfGetOutOfJailCards());
                ((JLabel)this.getOutOfJailLabels.get(this.playerIndex)).setVisible(true);
                this.generateSellGetOutOfJailCardComboBox();
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received get out of Jail card \n";
                this.logText.append(this.log);
                break;
            case 14:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune14.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var7) {
                }

                int position = ((Player)this.players.get(this.playerIndex)).getPositionOnGameBoard();
                if (((Player)this.players.get(this.playerIndex)).getNumberOfGetOutOfJailCards() == 0) {
                    position = 10 - position;
                    ((Player)this.players.get(this.playerIndex)).positionOnBoard(position);
                    this.finishTurn.setEnabled(true);
                    this.rollTheDice.setEnabled(false);
                    ((Player)this.players.get(this.playerIndex)).setInJail(true);
                    this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " went to Jail" + "\n";
                    this.logText.append(this.log);
                    this.adjustPlayerPosition();
                    ((Player)this.players.get(this.playerIndex)).setManaHeld(-5000);
                    ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
                    this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has lost all the mana due to colliding high-velocity stars" + "\n";
                    this.logText.append(this.log);
                } else {
                    this.gamePrompt.setText("Do you want to use your get out of jail card?");
                    this.useGetOutOfJailCard.setVisible(true);
                    this.dontUseGetOutOfJailCard.setVisible(true);
                    this.rollTheDice.setEnabled(false);
                    this.finishTurn.setEnabled(false);
                    ((Player)this.players.get(this.playerIndex)).setManaHeld(+500.0);
                    ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
                    this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has gained 500 mana from ISS gift" + "\n";
                    this.logText.append(this.log);
                }
                break;
            case 15:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune15.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var6) {
                }
                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(50.0);
                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 50 Galy from lucky money" + "\n";
                this.logText.append(this.log);
                break;
            case 16:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune16.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var5) {
                }
                ((Player)this.players.get(this.playerIndex)).setMoneyHeld(20.0);
                ((JLabel)this.balanceLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getMoneyHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 20 Galy for doing overtime discovery" + "\n";
                this.logText.append(this.log);
                break;
            case 17:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune17.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var4) {
                }
                ((Player)this.players.get(this.playerIndex)).setManaHeld(100.0);
                ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 mana from solar energy charging" + "\n";
                this.logText.append(this.log);
                break;
            case 18:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune18.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var3) {
                }
                ((Player)this.players.get(this.playerIndex)).setManaHeld(100.0);
                ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 mana from radioisotope thermoelectric generators" + "\n";
                this.logText.append(this.log);
                break;
            case 19:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune19.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var2) {
                }
                ((Player)this.players.get(this.playerIndex)).setManaHeld(100.0);
                ((JLabel)this.energyLabels.get(this.playerIndex)).setText("E" + ((Player)this.players.get(this.playerIndex)).getManaHeld());
                this.log = "  /> " + ((Player)this.players.get(this.playerIndex)).getName() + " has received 100 mana from fuel cells" + "\n";
                this.logText.append(this.log);
                break;
            case 20:        // DONE
                try {
                    img = ImageIO.read(this.getClass().getResource("resources/fortune20.jpg"));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var1) {
                }
                this.manaDueAmount = 100.0;
                if (((Player)this.players.get(this.playerIndex)).getManaHeld() >= this.manaDueAmount) {
                    this.followCommunityCard20();
                } else {
                    this.manaDue = true;
                    this.arrearsIndex = 109;
                }
                break;
        }
    }

    /**
     * after a player makes a move to a certain position action is taken
     * according to that position. this method control it - deals chance
     * or community card, asks for rent or allows to buy the property.
     * if a player does not have sufficient funds to pay arrears, further
     * action is taken to let the player get money to pay the arrears or
     * declare BANKRUPTCY from the game
     */
    private void buyOrRent() {
        if (players.get(playerIndex).getPositionOnGameBoard() == 7
                || players.get(playerIndex).getPositionOnGameBoard() == 22
                || players.get(playerIndex).getPositionOnGameBoard() == 36) {
            ChanceCardActive();
        }
        if (players.get(playerIndex).getPositionOnGameBoard() == 2
                || players.get(playerIndex).getPositionOnGameBoard() == 17
                || players.get(playerIndex).getPositionOnGameBoard() == 33) {
            FortuneCardActive();
        }
        if (entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .canBePurchased()) {

            if (entities.getEntities()
                    .get(players.get(playerIndex).getPositionOnGameBoard())
                    .getOwner() != null
                    && entities
                    .getEntities()
                    .get(players.get(playerIndex)
                            .getPositionOnGameBoard()).getOwner()
                    .getName()
                    .equals(players.get(playerIndex).getName())) {
                if (!gotDouble || doubleCounter == 3) {
                    finishTurn.setEnabled(true);
                    rollTheDice.setEnabled(false);
                }
            } else {
                finishTurn.setEnabled(false);
                // mortgaged
                if (entities.getEntities()
                        .get(players.get(playerIndex).getPositionOnGameBoard())
                        .getOwner() != null
                        && !entities
                        .getEntities()
                        .get(players.get(playerIndex)
                                .getPositionOnGameBoard()).getOwner()
                        .getName()
                        .equals(players.get(playerIndex).getName())
                        && entities
                        .getEntities()
                        .get(players.get(playerIndex)
                                .getPositionOnGameBoard())
                        .isMortgaged()) {
                    gamePrompt
                            .setText("The property is mortgaged, so there is no need to pay rent");
                    if (!gotDouble || doubleCounter == 3) {
                        finishTurn.setEnabled(true);
                        rollTheDice.setEnabled(false);
                    }
                }

                // unowned property
                if (entities.getEntities()
                        .get(players.get(playerIndex).getPositionOnGameBoard())
                        .getOwner() == null) {
                    // sufficient funds to buy
                    if (entities
                            .getEntities()
                            .get(players.get(playerIndex)
                                    .getPositionOnGameBoard()).getCost() <= players
                            .get(playerIndex).getMoneyHeld()) {
                        buyProperty.setVisible(true);
                        dontBuyProperty.setVisible(true);
                        rollTheDice.setEnabled(false);
                        // insufficient funds
                    } else {
                        buyProperty.setVisible(true);
                        buyProperty.setEnabled(false);
                        gamePrompt
                                .setText("You don't have enough cash to buy this property. Press don't buy or borrow some money");
                        dontBuyProperty.setVisible(true);
                        rollTheDice.setEnabled(false);
                    }

                } else if (!entities.getEntities()
                        .get(players.get(playerIndex).getPositionOnGameBoard())
                        .getOwner().getName()
                        .equals(players.get(playerIndex).getName())
                        && !entities
                        .getEntities()
                        .get(players.get(playerIndex)
                                .getPositionOnGameBoard())
                        .isMortgaged()) {
                    if (!rentCalculated) {
                        calculateRent();
                    }
                    if (rentCalculated) {
                        if (rentValue > players.get(playerIndex).getMoneyHeld()) {
                            gamePrompt
                                    .setText("You need money to pay the rent. Sell property, take loan or declare BANKRUPTCY from game");
                            declareBankruptcyFromGame.setVisible(true);
                        } else {
                            if (players.get(playerIndex)
                                    .getPositionOnGameBoard() != 12
                                    && players.get(playerIndex)
                                    .getPositionOnGameBoard() != 28)
                                payRent.setVisible(true);
                        }
                    }
                }
            }

        }
        if (!entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .canBePurchased()) {
            if (!paymentDue) {
                if (!gotDouble || doubleCounter == 3) {
                    finishTurn.setEnabled(true);
                    rollTheDice.setEnabled(false);
                }
            } else {
                gamePrompt
                        .setText("you need to pay arrears. Sell or mortgage property or declare BANKRUPTCY from game");
                rollTheDice.setEnabled(false);
                declareBankruptcyFromGame.setVisible(true);
            }
        }

    }

    /**
     * rent is calculated, when this method is called
     */
    private void calculateRent() {
        ownerIndex = getPlayerIndex(entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .getOwner());

        if (entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .getGroup().equals("utilities")) {
            gamePrompt.setText("Roll the dice to estimate the amount of rent");
            extraRollNeeded = true;
            rollTheDice.setEnabled(true);
            payRent.setVisible(false);
            if (randomDice1 == randomDice2) {
                gotDouble = true;
            } // needed??
        }

        if (entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .getNumberOfPerfectPlanet() == 0
                && !entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .getGroup().equals("utilities")
                && !entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .getGroup().equals("railroads")) {
            rentValue = entities
                    .getEntities()
                    .get(players.get(playerIndex).getPositionOnGameBoard())
                    .getRentValues()
                    .get(entities
                            .getEntities()
                            .get(players.get(playerIndex)
                                    .getPositionOnGameBoard())
                            .getNumberOfUpgrades());

            if (playerHasAll(
                    entities.getEntities()
                            .get(players.get(playerIndex)
                                    .getPositionOnGameBoard()).getGroup(),
                    players.get(ownerIndex).getName())
                    && entities
                    .getEntities()
                    .get(players.get(playerIndex)
                            .getPositionOnGameBoard())
                    .getNumberOfPerfectPlanet() == 0
                    && entities
                    .getEntities()
                    .get(players.get(playerIndex)
                            .getPositionOnGameBoard())
                    .getNumberOfUpgrades() == 0) {
                rentValue = rentValue * 2;
            }
        } else if (entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .getNumberOfPerfectPlanet() == 1) {
            rentValue = entities.getEntities()
                    .get(players.get(playerIndex).getPositionOnGameBoard())
                    .getRentValues().get(5);
        } else if (entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .getGroup().equals("railroads")) {

            rentValue = getRailRoadRent(players.get(ownerIndex).getName());
            if (sentByChanceCard) {
                rentValue *= 2;
            }
        }

        if (players.get(playerIndex).getPositionOnGameBoard() == 12
                || players.get(playerIndex).getPositionOnGameBoard() == 28) {
            rollTheDice.setEnabled(true);
        } else {
            rollTheDice.setEnabled(false);
            rentCalculated = true;
        }
    }

    /**
     * @param group - group of the property
     * @param name - name of the player
     * are passed to determine, if a player has all properties of specified
     * group
     * @return true, if he/she has or false, if a player does not have all
     * the properties of specified group
     */
    private boolean playerHasAll(String group, String name) {
        int counter = 0;
        for (PlanetProperties entity : entities.getEntities()) {
            if (entity.canBePurchased()) {
                if (entity.getGroup().equals(group)) {
                    if (entity.getOwner() != null
                            && entity.getOwner().getName().equals(name)) {
                        counter++;
                    }
                }
            }
        }
        if ((group.equals("brown") || group.equals("blue"))) {
            if (counter == 2) {
                return true;
            }

        } else if (!group.equals("brown") || !group.equals("blue")) {
            if (counter == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param name of the player is passed to determine number of railroad
     * properties held
     * @return amount of rent to be paid by other player, which has landed
     * on the player specified by the passed name parameter
     */
    private double getRailRoadRent(String name) {
        int counter = 0;
        double rentValue = 0;
        for (PlanetProperties entity : entities.getEntities()) {
            if (entity.getGroup() != null
                    && entity.getGroup().equals("railroads")) {
                if (entity.getOwner() != null
                        && entity.getOwner().getName().equals(name)) {
                    counter++;
                }
            }

        }
        switch (counter) {
            case 1:
                rentValue = 25;
                break;
            case 2:
                rentValue = 50;
                break;
            case 3:
                rentValue = 100;
                break;
            case 4:
                rentValue = 200;
                break;
        }
        return rentValue;
    }

    /**
     *
     * @param player is passed to determine index to be returned
     * @return the index of the player
     */
    private int getPlayerIndex(Player player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(player.getName())) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param name is passed to determine index to be returned
     * @return the index of the player
     */
    private int getPlayerIndex(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param name of the entity is passed
     * @return cost of that property
     */
    private double getEntityCost(String name) {
        for (PlanetProperties entity : entities.getEntities()) {
            if (entity.getName().equals(name)) {
                return entity.getCost();
            }
        }
        return -1;
    }

    /**
     *
     * @param group is passed
     * @return true, if any property of the specified group has any Planets
     * or false otherwise
     */
    private boolean hasPlanets(String group) {
        for (Player player : players) {
            for (PlanetProperties entity : player.getOwnedProperties()) {
                if (entity.getGroup().equals(group)) {
                    if (entity.getNumberOfUpgrades() > 0
                            || entity.getNumberOfPerfectPlanet() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * @param name is passed
     * @return position of the entity with specified name
     */
    private int getEntityPosition(String name) {
        for (PlanetProperties entity : entities.getEntities()) {
            if (entity.getName().equals(name)) {
                return entity.getPosition();
            }
        }
        return -1;
    }

    /**
     *
     * @param entityName is passed to determine its owner
     * @return the name of the entity owner
     */
    private String getOwner(String entityName) {
        for (PlanetProperties entity : entities.getEntities()) {
            if (entity.getName().equals(entityName)) {
                return entity.getOwner().getName();
            }
        }
        return null;
    }

    /**
     *
     * @param name of the property is passed
     * @return position of the player's entity
     */
    private int getPlayersEntityPosition(String name) {
        for (int i = 0; i < players.get(playerIndex).getOwnedProperties()
                .size(); i++) {
            if (players.get(playerIndex).getOwnedProperties().get(i).getName()
                    .equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param PlanetIndex is passed to determine a label to deal with
     * @param numberOfUpgrades is passed to determine, which label should be
     * displayed. Label indicating number of upgrades/hotels on the property
     * is updated on the appropriate property panel
     */
    private void displayProperPlanetLabel(int PlanetIndex,
                                            int numberOfUpgrades) {
        if (PlanetIndex < 5) {
            switch (numberOfUpgrades) {
                case 0:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/hotel.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 1:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade1.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 2:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade2.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 3:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade3.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 4:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade4.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 5:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade5.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
            }
        } else if (PlanetIndex < 11) {
            switch (numberOfUpgrades) {
                case 0:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/hotelFlippedRight.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 1:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade1FlippedRight.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 2:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade2FlippedRight.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 3:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade3FlippedRight.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 4:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade4FlippedRight.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 5:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade5FlippedRight.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
            }
        } else if (PlanetIndex < 17) {
            switch (numberOfUpgrades) {
                case 0:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/hotelUpsideDown.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 1:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade1UpsideDown.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 2:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade2UpsideDown.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 3:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade3UpsideDown.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 4:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade4UpsideDown.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 5:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade5UpsideDown.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
            }
        } else {
            switch (numberOfUpgrades) {
                case 0:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/hotelFlippedLeft.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 1:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade1FlippedLeft.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 2:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade2FlippedLeft.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 3:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade3FlippedLeft.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 4:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade4FlippedLeft.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
                case 5:
                    try {
                        Image img = ImageIO.read(getClass().getResource(
                                "resources/upgrade5FlippedLeft.png"));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                    }
                    break;
            }
        }
    }

    /**
     * income tax is paid by a player and appropriate info is displayed
     * in the log
     */
    private void payIncomeTax() {
        players.get(playerIndex).setMoneyHeld(-manaDueAmount);
        energyLabels.get(playerIndex).setText(
                "E" + players.get(playerIndex).getManaHeld());
        log = "  /> " + players.get(playerIndex).getName()
                + " losing 200 mana due to losing connection (200 mana) " + "\n";
        logText.append(log);
    }

    /**
     * luxury tax is paid by a player and appropriate info is displayed
     * in the log
     */
    private void payManaTax() {
        players.get(playerIndex).setManaHeld(-manaDueAmount);
        energyLabels.get(playerIndex).setText(
                "Mana: " + players.get(playerIndex).getManaHeld());
        log = "  /> " + players.get(playerIndex).getName()
                + " losing 100 MANA due to alpha jump " + "\n";
        logText.append(log);
    }

    /**
     * player's position label is updated accordingly to his/her current position
     * and info of the position change is displayed in the game log
     */
    private void adjustPlayerPosition() {
        if (!(players.get(playerIndex).getPositionOnGameBoard() == 10)) {
            log = "  /> "
                    + players.get(playerIndex).getName()
                    + " went to "
                    + entities
                    .getEntities()
                    .get(players.get(playerIndex)
                            .getPositionOnGameBoard()).getName() + "\n";
            logText.append(log);
        } else {
            if (!players.get(playerIndex).isInJail()) {
                log = "  /> "
                        + players.get(playerIndex).getName()
                        + " went to "
                        + entities
                        .getEntities()
                        .get(players.get(playerIndex)
                                .getPositionOnGameBoard()).getName()
                        + " (just visiting)\n";
                logText.append(log);
            }
        }

        switch (players.get(playerIndex).getPositionOnGameBoard()) {
            case 0:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 5.5) + 20 + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 1:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 5) + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 2:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 4.5) + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 3:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 4) + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 4:
                manaDueAmount = 200;
                if (manaDueAmount > players.get(playerIndex).getManaHeld()) {
                    gamePrompt
                            .setText("you need to pay arrears. Sell or mortgage property or declare BANKRUPTCY from game");
                    rollTheDice.setEnabled(false);
                    declareBankruptcyFromGame.setVisible(true);
                    manaDue = true;
                    arrearsIndex = 4;
                } else {
                    payIncomeTax();
                }
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 3.5) + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 5:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 3) + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 6:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 2.5) + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 7:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 2) + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 8:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 1.5) + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 9:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5) + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 10:
                playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 4, 38,
                        35);
                break;
            case 11:
                playerIndicators
                        .get(playerIndex)
                        .setBounds(
                                20 + playerIndex * 3,
                                (int) (frameHeight / 6.5 * 5) + 2 + playerIndex * 3,
                                38, 35);
                break;
            case 12:
                playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 4.5) + 2 + playerIndex * 3, 38,
                        35);
                break;
            case 13:
                playerIndicators
                        .get(playerIndex)
                        .setBounds(
                                20 + playerIndex * 3,
                                (int) (frameHeight / 6.5 * 4) + 2 + playerIndex * 3,
                                38, 35);
                break;
            case 14:
                playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 3.5) + 2 + playerIndex * 3, 38,
                        35);
                break;
            case 15:
                playerIndicators
                        .get(playerIndex)
                        .setBounds(
                                20 + playerIndex * 3,
                                (int) (frameHeight / 6.5 * 3) + 2 + playerIndex * 3,
                                38, 35);
                break;
            case 16:
                playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 2.5) + 2 + playerIndex * 3, 38,
                        35);
                break;
            case 17:
                playerIndicators
                        .get(playerIndex)
                        .setBounds(
                                20 + playerIndex * 3,
                                (int) (frameHeight / 6.5 * 2) + 2 + playerIndex * 3,
                                38, 35);
                break;
            case 18:
                playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 1.5) + 2 + playerIndex * 3, 38,
                        35);
                break;
            case 19:
                playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                        (int) (frameHeight / 6.5) + 2 + playerIndex * 3, 38, 35);
                break;
            case 20:
                playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                        30 + playerIndex * 4, 38, 35);
                break;
            case 21:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5) + playerIndex * 3,
                        20 + playerIndex * 4, 38, 35);
                break;
            case 22:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 1.5) + playerIndex * 3,
                        20 + playerIndex * 4, 38, 35);
                break;
            case 23:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 2) + playerIndex * 3,
                        20 + playerIndex * 4, 38, 35);
                break;
            case 24:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 2.5) + playerIndex * 3,
                        20 + playerIndex * 4, 38, 35);
                break;
            case 25:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 3) + playerIndex * 3,
                        20 + playerIndex * 4, 38, 35);
                break;
            case 26:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 3.5) + playerIndex * 3,
                        20 + playerIndex * 4, 38, 35);
                break;
            case 27:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 4) + playerIndex * 3,
                        20 + playerIndex * 4, 38, 35);
                break;
            case 28:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 4.5) + playerIndex * 3,
                        20 + playerIndex * 4, 38, 35);
                break;
            case 29:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 5) + playerIndex * 3,
                        20 + playerIndex * 4, 38, 35);
                break;
            case 30:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 5.5) + playerIndex * 3,
                        20 + playerIndex * 4, 38, 35);
                break;
            case 31:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 3,
                        (int) (frameHeight / 6.5) + 2 + playerIndex * 3, 38, 35);
                break;
            case 32:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 1.5) + 2 + playerIndex * 3, 38,
                        35);
                break;
            case 33:
                playerIndicators
                        .get(playerIndex)
                        .setBounds(
                                (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex
                                        * 3,
                                (int) (frameHeight / 6.5 * 2) + 2 + playerIndex * 3,
                                38, 35);
                break;
            case 34:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 2.5) + 2 + playerIndex * 3, 38,
                        35);
                break;
            case 35:
                playerIndicators
                        .get(playerIndex)
                        .setBounds(
                                (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex
                                        * 3,
                                (int) (frameHeight / 6.5 * 3) + 2 + playerIndex * 3,
                                38, 35);
                break;
            case 36:
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 3.5) + 2 + playerIndex * 3, 38,
                        35);
                break;
            case 37:
                playerIndicators
                        .get(playerIndex)
                        .setBounds(
                                (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex
                                        * 3,
                                (int) (frameHeight / 6.5 * 4) + 2 + playerIndex * 3,
                                38, 35);
                break;
            case 38:
                manaDueAmount = 100;
                if (manaDueAmount > players.get(playerIndex).getManaHeld()) {
                    gamePrompt
                            .setText("you need to pay arrears. Sell or mortgage property or declare BANKRUPTCY from game");
                    rollTheDice.setEnabled(false);
                    declareBankruptcyFromGame.setVisible(true);
                    manaDue = true;
                    arrearsIndex = 38;
                } else {
                    payManaTax();
                }
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex * 3,
                        (int) (frameHeight / 6.5 * 4.5) + 2 + playerIndex * 3, 38,
                        35);
                break;
            case 39:
                playerIndicators
                        .get(playerIndex)
                        .setBounds(
                                (int) (frameHeight / 6.5 * 5.5) + 30 + playerIndex
                                        * 3,
                                (int) (frameHeight / 6.5 * 5) + 2 + playerIndex * 3,
                                38, 35);
                break;
        }
        if (players.get(playerIndex).didPassGo()) {
            balanceLabels.get(playerIndex).setText(
                    "E" + players.get(playerIndex).getMoneyHeld());
            log = "  /> " + players.get(playerIndex).getName()
                    + " got 200 Galy for passing \"GO\" " + "\n";
            logText.append(log);
            players.get(playerIndex).setPassedGo(false);
        }

    }

    /**
     *
     * @return number of hotels available in the perfect planets pool
     */
    public int getNumberOfPerfectPlanets() {
        return numberOfPerfectPlanets;
    }

    /**
     *
     * @param update is added to the current number of perfect planets
     */
    public void setNumberOfPerfectPlanets(int update) {
        numberOfPerfectPlanets += update;
    }

    /**
     *
     * @return number of upgrades available in the upgrades pool
     */
    public int getNumberOfUpgrades() {
        return numberOfUpgrades;
    }

    /**
     *
     * @param update is added to the current number of upgrades
     */
    public void setNumberOfUpgrades(int update) {
        numberOfUpgrades += update;
    }
}
