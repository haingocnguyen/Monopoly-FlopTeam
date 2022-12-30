import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class Monopoly {

    public final static int cornerCardSize = 135;
    public final static int normalCardSize = 90;
    private final DeckOfChanceAndFortuneCards deck;
    private final Random random;
    private final RentValues entities;
    private final ArrayList<Player> players;
    private final ArrayList<JLayeredPane> boardPanels;
    private final ArrayList<JLabel> playerIndicators;
    private final ArrayList<JLabel> balanceLabels;
    private final ArrayList<JLabel> energyLabels;
    private final ArrayList<JLayeredPane> playersPanes;
    private final ArrayList<JLabel> getOutOfJailLabels;
    private final ArrayList<JLabel> perfectPlanetLabels;
    private final Sound sound;
    public JFrame frame;
    double rentValue;
    private JLayeredPane player_1;
    private JLayeredPane player_2;
    private JLayeredPane player_3;
    private JLayeredPane player_4;
    private JScrollPane gameLog;
    private JTextArea logText;
    private String log;
    private int frameHeight;
    private JButton fortuneButton;
    private JButton chanceButton;
    private JLabel bottom1Label;
    private JLabel bottom2Label;
    private JLabel bottom4Label;
    private JLabel bottom5Label;
    private JLabel bottom7Label;
    private JLabel bottom9Label;
    private JLabel left1Label;
    private JLabel left4Label;
    private JLabel left5Label;
    private JLabel left6Label;
    private JLabel left7Label;
    private JLabel left8Label;
    private JLabel left9Label;
    private JLabel top1Label;
    private JLabel top3Label;
    private JLabel top4Label;
    private JLabel top5Label;
    private JLabel top7Label;
    private JLabel top8Label;
    private JLabel top9Label;
    private JLabel right1Label;
    private JLabel right2Label;
    private JLabel right4Label;
    private JLabel right5Label;
    private JLabel right7Label;
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
    private int doubleCounter;
    private int playerIndex;
    private JLabel player1getOutOfJailLabel;
    private JLabel player2getOutOfJailLabel;
    private JLabel player3getOutOfJailLabel;
    private JLabel player4getOutOfJailLabel;
    private JLabel player1;
    private JLabel player2;
    private JLabel player3;
    private JLabel player4;
    private JLabel gamePrompt;
    private JButton useGetOutOfJailCard;
    private JButton dontUseGetOutOfJailCard;
    private JButton pay50toGetOutOfJail;
    private JButton buyProperty;
    private JButton dontBuyProperty;
    private JButton payRent;
    private boolean extraRollNeeded;
    private int ownerIndex;
    private JComboBox<String> buyUnwantedProperty;
    private DefaultComboBoxModel<String> buyUnwantedPropertyModel;
    private JTextField priceOfUnwantedProperty;
    private double valueOfUnwantedProperty;
    private JButton buyUnwantedPropertyButton;
    private JLabel mortgageManagement;
    private JComboBox<String> mortgageComboBox;
    private JButton takeLoan;
    private JButton payLoan;
    private JLabel sellProperty;
    private JComboBox<String> sellPropertyComboBox;
    private JComboBox<String> buyer;
    private DefaultComboBoxModel<String> buyerModel;
    private JTextField sellingPrice;
    private JButton sellPropertyButton;
    private JLabel buyPlanet;
    private JComboBox<String> addPlanetTo;
    private JButton addUpgradeButton;
    private JButton addPerfectPlanetButton;
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
    private double manaDueAmount;
    private JButton payArrears;
    private int arrearsIndex;
    private JLabel sellGetOutOfJailCard;
    private JComboBox<String> cardBuyers;
    private JTextField cardPrice;
    private JButton sellGetOutOfJailCardButton;
    private int valueOfSoldCard;
    private JButton yesButton;
    private JButton noButton;
    private JButton restartGame;
    private JScrollPane howToPlay;
    private JLabel buyOwnedProperty;
    private JComboBox<String> ownedProperties;
    private JTextField propertyOwner;
    private JTextField ownedPropertyValue;
    private JButton buyOwnedPropertyButton;
    private double valueOfOwnedProperty;
    private JButton showInstruction;
    private JButton hideInstruction;

    // Create the main frame
    public Monopoly() {
        deck = new DeckOfChanceAndFortuneCards();
        players = new ArrayList<>();
        entities = new RentValues();
        random = new Random();
        boardPanels = new ArrayList<>();
        playerIndicators = new ArrayList<>();
        balanceLabels = new ArrayList<>();
        energyLabels = new ArrayList<>();
        playerIndex = 0;
        doubleCounter = 0;
        playersPanes = new ArrayList<>();
        getOutOfJailLabels = new ArrayList<>();
        perfectPlanetLabels = new ArrayList<>();
        upgradeOrPerfectPlanetBought = false;
        numberOfPerfectPlanets = 12;
        numberOfUpgrades = 32;
        sound = new Sound();
        initialize();
    }

    // Initialise the contents of the frame
    private void initialize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        FlowLayout flow = new FlowLayout();
        flow.setHgap(0);
        flow.setVgap(0);
        frame = new JFrame("Monopoly Universe");
        frame.setLayout(flow);
        frame.getContentPane().setBackground(new Color(137, 135, 162));
        frame.setForeground(new Color(137, 135, 162));
        frame.setBackground(new Color(69, 75, 110));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(screenSize);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frameHeight = frame.getHeight() - 40;
        int frameWidth = frame.getWidth();
        sound.playMusic(0);
        showInstruction = new JButton();
        showInstruction.setBounds(frameWidth - 45, 10, 40, 40);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("helpIcon.png")));
            showInstruction.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        showInstruction.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        showInstruction.setBorderPainted(false);
        showInstruction.setContentAreaFilled(false);
        showInstruction.addActionListener(arg0 -> {
            howToPlay.setVisible(true);
            hideInstruction.setVisible(true);
            showInstruction.setVisible(false);
        });
        hideInstruction = new JButton();
        hideInstruction.setBounds(frameWidth - 65, 10, 40, 40);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("closeHelp.png")));
            hideInstruction.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        hideInstruction.setVisible(false);
        hideInstruction.addActionListener(arg0 -> {
            howToPlay.setVisible(false);
            hideInstruction.setVisible(false);
            showInstruction.setVisible(true);
        });

        //Create board
        JLayeredPane center = new JLayeredPane();
        center.setBounds(135, 135, 810, 810);
        JLayeredPane topLeft = new JLayeredPane();
        topLeft.setBounds(0, 0, cornerCardSize, cornerCardSize);
        JLayeredPane left_1 = new JLayeredPane();
        left_1.setBounds(0, 135, cornerCardSize, normalCardSize);
        JLayeredPane left_2 = new JLayeredPane();
        left_2.setBounds(0, 225, cornerCardSize, normalCardSize);
        JLayeredPane left_3 = new JLayeredPane();
        left_3.setBounds(0, 315, cornerCardSize, normalCardSize);
        JLayeredPane left_4 = new JLayeredPane();
        left_4.setBounds(0, 405, cornerCardSize, normalCardSize);
        JLayeredPane left_5 = new JLayeredPane();
        left_5.setBounds(0, 495, cornerCardSize, normalCardSize);
        JLayeredPane left_6 = new JLayeredPane();
        left_6.setBounds(0, 585, cornerCardSize, normalCardSize);
        JLayeredPane left_7 = new JLayeredPane();
        left_7.setBounds(0, 675, cornerCardSize, normalCardSize);
        JLayeredPane left_8 = new JLayeredPane();
        left_8.setBounds(0, 765, cornerCardSize, normalCardSize);
        JLayeredPane left_9 = new JLayeredPane();
        left_9.setBounds(0, 855, cornerCardSize, normalCardSize);
        JLayeredPane bottomLeft = new JLayeredPane();
        bottomLeft.setBounds(0, 945, cornerCardSize, cornerCardSize);
        JLayeredPane top_1 = new JLayeredPane();
        top_1.setBounds(135, 0, normalCardSize, cornerCardSize);
        JLayeredPane top_2 = new JLayeredPane();
        top_2.setBounds(225, 0, normalCardSize, cornerCardSize);
        JLayeredPane top_3 = new JLayeredPane();
        top_3.setBounds(315, 0, normalCardSize, cornerCardSize);
        JLayeredPane top_4 = new JLayeredPane();
        top_4.setBounds(405, 0, normalCardSize, cornerCardSize);
        JLayeredPane top_5 = new JLayeredPane();
        top_5.setBounds(495, 0, normalCardSize, cornerCardSize);
        JLayeredPane top_6 = new JLayeredPane();
        top_6.setBounds(585, 0, normalCardSize, cornerCardSize);
        JLayeredPane top_7 = new JLayeredPane();
        top_7.setBounds(675, 0, normalCardSize, cornerCardSize);
        JLayeredPane top_8 = new JLayeredPane();
        top_8.setBounds(765, 0, normalCardSize, cornerCardSize);
        JLayeredPane top_9 = new JLayeredPane();
        top_9.setBounds(855, 0, normalCardSize, cornerCardSize);
        JLayeredPane topRight = new JLayeredPane();
        topRight.setBounds(945, 0, cornerCardSize, cornerCardSize);
        JLayeredPane right_1 = new JLayeredPane();
        right_1.setBounds(945, 135, cornerCardSize, normalCardSize);
        JLayeredPane right_2 = new JLayeredPane();
        right_2.setBounds(945, 225, cornerCardSize, normalCardSize);
        JLayeredPane right_3 = new JLayeredPane();
        right_3.setBounds(945, 315, cornerCardSize, normalCardSize);
        JLayeredPane right_4 = new JLayeredPane();
        right_4.setBounds(945, 405, cornerCardSize, normalCardSize);
        JLayeredPane right_5 = new JLayeredPane();
        right_5.setBounds(945, 495, cornerCardSize, normalCardSize);
        JLayeredPane right_6 = new JLayeredPane();
        right_6.setBounds(945, 585, cornerCardSize, normalCardSize);
        JLayeredPane right_7 = new JLayeredPane();
        right_7.setBounds(945, 675, cornerCardSize, normalCardSize);
        JLayeredPane right_8 = new JLayeredPane();
        right_8.setBounds(945, 765, cornerCardSize, normalCardSize);
        JLayeredPane right_9 = new JLayeredPane();
        right_9.setBounds(945, 855, cornerCardSize, normalCardSize);
        JLayeredPane bottom_1 = new JLayeredPane();
        bottom_1.setBounds(135, 945, normalCardSize, cornerCardSize);
        JLayeredPane bottom_2 = new JLayeredPane();
        bottom_2.setBounds(225, 945, normalCardSize, cornerCardSize);
        JLayeredPane bottom_3 = new JLayeredPane();
        bottom_3.setBounds(315, 945, normalCardSize, cornerCardSize);
        JLayeredPane bottom_4 = new JLayeredPane();
        bottom_4.setBounds(405, 945, normalCardSize, cornerCardSize);
        JLayeredPane bottom_5 = new JLayeredPane();
        bottom_5.setBounds(495, 945, normalCardSize, cornerCardSize);
        JLayeredPane bottom_6 = new JLayeredPane();
        bottom_6.setBounds(585, 945, normalCardSize, cornerCardSize);
        JLayeredPane bottom_7 = new JLayeredPane();
        bottom_7.setBounds(675, 945, normalCardSize, cornerCardSize);
        JLayeredPane bottom_8 = new JLayeredPane();
        bottom_8.setBounds(765, 945, normalCardSize, cornerCardSize);
        JLayeredPane bottom_9 = new JLayeredPane();
        bottom_9.setBounds(855, 945, normalCardSize, cornerCardSize);
        JLayeredPane bottomRight = new JLayeredPane();
        bottomRight.setBounds(945, 945, cornerCardSize, cornerCardSize);
        deed = new JLabel();
        deed.setBounds(403, 403, 274, 388);
        deed.setVisible(true);
        bottom_9.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("1deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        bottom_7.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("3deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        bottom_5.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("5deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        bottom_4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("6deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        bottom_2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("8deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        bottom_1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("9deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        left_9.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("11deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        left_8.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("12deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        left_7.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("13deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        left_6.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource(
                            "14deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        left_5.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("15deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        left_4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("16deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        left_1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("19deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        top_1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("21deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        top_3.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("23deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        top_4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("24deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        top_5.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("25deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        top_7.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("27deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        top_8.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("28deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        top_9.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("29deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        right_1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("31deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        right_2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("32deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        right_4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("34deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        right_5.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("35deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        right_7.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("37deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        right_9.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("39deed.png")));
                    deed.setIcon(new ImageIcon(img));
                    deed.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deed.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

        });

        JLabel perfectPlanetLabel0 = new JLabel();
        JLabel perfectPlanetLabel1 = new JLabel();
        JLabel perfectPlanetLabel2 = new JLabel();
        JLabel perfectPlanetLabel3 = new JLabel();
        JLabel perfectPlanetLabel4 = new JLabel();
        JLabel perfectPlanetLabel5 = new JLabel();
        JLabel perfectPlanetLabel6 = new JLabel();
        JLabel perfectPlanetLabel7 = new JLabel();
        JLabel perfectPlanetLabel8 = new JLabel();
        JLabel perfectPlanetLabel9 = new JLabel();
        JLabel perfectPlanetLabel10 = new JLabel();
        JLabel perfectPlanetLabel11 = new JLabel();
        JLabel perfectPlanetLabel12 = new JLabel();
        JLabel perfectPlanetLabel13 = new JLabel();
        JLabel perfectPlanetLabel14 = new JLabel();
        JLabel perfectPlanetLabel15 = new JLabel();
        JLabel perfectPlanetLabel16 = new JLabel();
        JLabel perfectPlanetLabel17 = new JLabel();
        JLabel perfectPlanetLabel18 = new JLabel();
        JLabel perfectPlanetLabel19 = new JLabel();
        JLabel perfectPlanetLabel20 = new JLabel();
        JLabel perfectPlanetLabel21 = new JLabel();

        perfectPlanetLabel0.setBounds((int) (frameHeight / 6.5 * 5) + 1, (int) (frameHeight / 6.5 * 5.5) + 1, 50, 25);
        perfectPlanetLabel1.setBounds((int) (frameHeight / 6.5 * 4) + 1, (int) (frameHeight / 6.5 * 5.5) + 1, 50, 25);
        perfectPlanetLabel2.setBounds((int) (frameHeight / 6.5 * 2.5) + 1, (int) (frameHeight / 6.5 * 5.5) + 1, 50, 25);
        perfectPlanetLabel3.setBounds((int) (frameHeight / 6.5 * 1.5) + 1, (int) (frameHeight / 6.5 * 5.5) + 1, 50, 25);
        perfectPlanetLabel4.setBounds((int) (frameHeight / 6.5) + 1, (int) (frameHeight / 6.5 * 5.5) + 1, 50, 25);
        perfectPlanetLabel5.setBounds((int) (frameHeight / 6.5) - 26, (int) (frameHeight / 6.5 * 5) + 4, 25, 50);
        perfectPlanetLabel6.setBounds((int) (frameHeight / 6.5) - 26, (int) (frameHeight / 6.5 * 4) + 4, 25, 50);
        perfectPlanetLabel7.setBounds((int) (frameHeight / 6.5) - 26, (int) (frameHeight / 6.5 * 3.5) + 4, 25, 50);
        perfectPlanetLabel8.setBounds((int) (frameHeight / 6.5) - 26, (int) (frameHeight / 6.5 * 2.5) + 4, 25, 50);
        perfectPlanetLabel9.setBounds((int) (frameHeight / 6.5) - 26, (int) (frameHeight / 6.5 * 1.5) + 4, 25, 50);
        perfectPlanetLabel10.setBounds((int) (frameHeight / 6.5) - 26, (int) (frameHeight / 6.5) + 4, 25, 50);
        perfectPlanetLabel11.setBounds((int) (frameHeight / 6.5) + 1, (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel12.setBounds((int) (frameHeight / 6.5 * 2) + 1, (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel13.setBounds((int) (frameHeight / 6.5 * 2.5) + 1, (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel14.setBounds((int) (frameHeight / 6.5 * 3.5) + 1, (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel15.setBounds((int) (frameHeight / 6.5 * 4) + 1, (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel16.setBounds((int) (frameHeight / 6.5 * 5) + 1, (int) (frameHeight / 6.5) - 26, 50, 25);
        perfectPlanetLabel17.setBounds((int) (frameHeight / 6.5 * 5.5) + 1, (int) (frameHeight / 6.5) + 1, 25, 50);
        perfectPlanetLabel18.setBounds((int) (frameHeight / 6.5 * 5.5) + 1, (int) (frameHeight / 6.5 * 1.5) + 1, 25, 50);
        perfectPlanetLabel19.setBounds((int) (frameHeight / 6.5 * 5.5) + 1, (int) (frameHeight / 6.5 * 2.5) + 1, 25, 50);
        perfectPlanetLabel20.setBounds((int) (frameHeight / 6.5 * 5.5) + 1, (int) (frameHeight / 6.5 * 4) + 1, 25, 50);
        perfectPlanetLabel21.setBounds((int) (frameHeight / 6.5 * 5.5) + 1, (int) (frameHeight / 6.5 * 5) + 1, 25, 50);

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
        boardPanels.add(center);

        JLabel bottomRightLabel = new JLabel();
        JLabel bottomLeftLabel = new JLabel();
        JLabel centerLabel = new JLabel();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("0.png")));
            bottomRightLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("10.png")));
            bottomLeftLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("center.png")));
            centerLabel.setIcon((new ImageIcon(img)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        bottom1Label = new JLabel();
        bottom2Label = new JLabel();
        JLabel bottom3Label = new JLabel();
        bottom4Label = new JLabel();
        bottom5Label = new JLabel();
        JLabel bottom6Label = new JLabel();
        bottom7Label = new JLabel();
        JLabel bottom8Label = new JLabel();
        bottom9Label = new JLabel();

        setBottom1Clean();
        setBottom2Clean();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("7.png")));
            bottom3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setBottom4Clean();
        setBottom5Clean();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("4.png")));
            bottom6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setBottom7Clean();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("2.png")));
            bottom8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setBottom9Clean();
        center.setLayout(flow);
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

        center.add(centerLabel);
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
        JLabel left2Label = new JLabel();
        JLabel left3Label = new JLabel();
        left4Label = new JLabel();
        left5Label = new JLabel();
        left6Label = new JLabel();
        left7Label = new JLabel();
        left8Label = new JLabel();
        left9Label = new JLabel();

        setLeft1Clean();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("18.png")));
            left2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("17.png")));
            left3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
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

        JLabel topLeftLabel = new JLabel();
        top1Label = new JLabel();
        JLabel top2Label = new JLabel();
        top3Label = new JLabel();
        top4Label = new JLabel();
        top5Label = new JLabel();
        JLabel top6Label = new JLabel();
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
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("22.png")));
            top2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("20.png")));
            topLeftLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setTop3Clean();
        setTop4Clean();
        setTop5Clean();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("26.png")));
            top6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setTop7Clean();
        setTop8Clean();
        setTop9Clean();
        JLabel topRightLabel = new JLabel();
        right1Label = new JLabel();
        right2Label = new JLabel();
        JLabel right3Label = new JLabel();
        right4Label = new JLabel();
        right5Label = new JLabel();
        JLabel right6Label = new JLabel();
        right7Label = new JLabel();
        JLabel right8Label = new JLabel();
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
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("33.png")));
            right3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setRight4Clean();
        setRight5Clean();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("36.png")));
            right6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setRight7Clean();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("38.png")));
            right8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setRight9Clean();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("30.png")));
            topRightLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Chance and Fortune
        fortuneButton = new JButton();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("fortune.png")));
            fortuneButton.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        fortuneButton.setBounds(255, 255, 194, 129);
        fortuneButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        fortuneButton.setBorderPainted(false);
        fortuneButton.setContentAreaFilled(false);
        // fortuneButton.setEnabled(false);
        chanceButton = new JButton();
        chanceButton.setBounds(661, 726, 194, 129);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("chance.png")));
            chanceButton.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        chanceButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chanceButton.setBorderPainted(false);
        chanceButton.setContentAreaFilled(false);
        // chanceButton.setEnabled(false);

        // Player information
        player_1 = new JLayeredPane();
        player_1.setBounds(frameHeight + 40, 0, frameHeight / 4, (int) (frameHeight / 6.5));
        player_1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        player1name = new JTextField();
        player1name.setBounds(20, 10, 140, 30);
        player1name.setFont(new Font("Arial", Font.ITALIC, 14));
        player1name.setHorizontalAlignment(SwingConstants.CENTER);
        player1name.setVisible(false);
        player_1.add(player1name);

        player_2 = new JLayeredPane();
        player_2.setBounds(frameHeight + 42 + (frameHeight / 4), 0, frameHeight / 4, (int) (frameHeight / 6.5));
        player_2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        player2name = new JTextField();
        player2name.setBounds(20, 10, 140, 30);
        player2name.setFont(new Font("Arial", Font.ITALIC, 14));
        player2name.setHorizontalAlignment(SwingConstants.CENTER);
        player2name.setVisible(false);
        player_2.add(player2name);

        player_3 = new JLayeredPane();
        player_3.setBounds(frameHeight + 44 + (frameHeight / 2), 0, frameHeight / 4, (int) (frameHeight / 6.5));
        player_3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        player3name = new JTextField();
        player3name.setBounds(20, 10, 140, 30);
        player3name.setFont(new Font("Arial", Font.ITALIC, 14));
        player3name.setHorizontalAlignment(SwingConstants.CENTER);
        player3name.setVisible(false);
        player_3.add(player3name);

        player_4 = new JLayeredPane();
        player_4.setBounds(frameHeight + 40, (int) (frameHeight / 6.5) + 2, frameHeight / 4, (int) (frameHeight / 6.5));
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

        JLayeredPane gameConsole = new JLayeredPane();
        gamePrompt = new JLabel();
        gamePrompt.setBounds(frameHeight + 50, frameHeight / 2 + 15, (frameHeight / 4) * 3 - 20, 15);
        pay50toGetOutOfJail = new JButton("Pay 50 Galy to RESTORING SPACECRAFT");
        pay50toGetOutOfJail.setBounds(frameHeight + 200, frameHeight / 2 + 60, 230, 20);
        pay50toGetOutOfJail.setVisible(false);
        gamePrompt.setHorizontalAlignment(SwingConstants.CENTER);
        gamePrompt.setForeground(Color.RED);
        useGetOutOfJailCard = new JButton("USE CARD");
        dontUseGetOutOfJailCard = new JButton("DON'T USE CARD");
        useGetOutOfJailCard.setBounds(frameHeight + 150, frameHeight / 2 + 35, 160, 20);
        dontUseGetOutOfJailCard.setBounds(frameHeight + 320, frameHeight / 2 + 35, 160, 20);
        useGetOutOfJailCard.setVisible(false);
        dontUseGetOutOfJailCard.setVisible(false);
        buyProperty = new JButton("BUY");
        dontBuyProperty = new JButton("DON'T BUY");
        payRent = new JButton("PAY RENT");
        payArrears = new JButton("PAY ARREARS");
        payArrears.setBounds(frameHeight + 200, frameHeight / 2 + 60, 230, 20);
        declareBankruptcyFromGame = new JButton("DECLARE BANKRUPTCY FROM GAME");
        yesButton = new JButton("YES");
        noButton = new JButton("NO");
        yesButton.setVisible(false);
        noButton.setVisible(false);
        yesButton.setBounds(frameHeight + 180, frameHeight / 2 + 35, 135, 20);
        noButton.setBounds(frameHeight + 325, frameHeight / 2 + 35, 135, 20);
        declareBankruptcyFromGame.setBounds(frameHeight + 170, frameHeight / 2 + 35, 290, 20);
        buyProperty.setBounds(frameHeight + 150, frameHeight / 2 + 35, 160, 20);
        dontBuyProperty.setBounds(frameHeight + 320, frameHeight / 2 + 35, 160, 20);
        payRent.setBounds(frameHeight + 200, frameHeight / 2 + 60, 230, 20);
        declareBankruptcyFromGame.setVisible(false);
        buyProperty.setVisible(false);
        dontBuyProperty.setVisible(false);
        payRent.setVisible(false);
        payArrears.setVisible(false);
        logText = new JTextArea();
        logText.setFont(new Font("Arial", Font.BOLD, 12));
        log = "  /> The Game has started! May the best player wins the game.\n";
        logText.append(log);
        JLabel instruction = new JLabel();
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("help.png")));
            instruction.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        instruction.setSize(1366, 5427);
        howToPlay = new JScrollPane(instruction);
        howToPlay.setSize(screenSize);
        howToPlay.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        howToPlay.setVisible(false);
        gameLog = new JScrollPane(logText);
        gameConsole.setBounds(frameHeight + 40, frameHeight / 2, (frameHeight / 4) * 3, (int) (frameHeight / 2.8));
        gameLog.setBounds(frameHeight + 40, (int) (frameHeight / 3.25 + 20), (frameHeight / 4) * 3, (int) (frameHeight / 6.5));
        gameLog.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        Border lined = BorderFactory.createLineBorder(Color.black, 1);
        Border innerGameLog1 = BorderFactory.createTitledBorder(lined, "HISTORY LOGGING", 2, 2, new Font("Arial", Font.ITALIC, 12), Color.black);
        Border innerGameConsole1 = BorderFactory.createTitledBorder(lined, "MANAGEMENT BOARD", 2, 2, new Font("Arial", Font.ITALIC, 12), Color.black);
        Border outerBorder = BorderFactory.createEmptyBorder(2, 0, 2, 0);
        gameLog.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerGameLog1));
        gameConsole.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerGameConsole1));
        buyUnwantedProperty = new JComboBox<>();
        buyUnwantedProperty.setBounds(frameHeight + 150, frameHeight / 2 + 35, 140, 20);
        buyUnwantedProperty.setVisible(false);
        buyUnwantedPropertyButton = new JButton("BUY");
        buyUnwantedPropertyButton.setBounds(frameHeight + 360, frameHeight / 2 + 35, 120, 20);
        buyUnwantedPropertyButton.setEnabled(false);
        buyUnwantedPropertyButton.setVisible(false);
        priceOfUnwantedProperty = new JTextField();
        priceOfUnwantedProperty.setBounds(frameHeight + 300, frameHeight / 2 + 35, 45, 20);
        priceOfUnwantedProperty.setVisible(false);
        gameLog.setVisible(false);
        mortgageManagement = new JLabel("MORTGAGE >>");
        mortgageManagement.setBounds(frameHeight + 50, frameHeight / 2 + 90, 150, 20);
        mortgageComboBox = new JComboBox<>();
        mortgageComboBox.setBounds(frameHeight + 205, frameHeight / 2 + 90, 160, 20);
        takeLoan = new JButton("TAKE LOAN");
        payLoan = new JButton("PAY BACK");
        takeLoan.setBounds(frameHeight + 370, frameHeight / 2 + 90, 100, 20);
        payLoan.setBounds(frameHeight + 475, frameHeight / 2 + 90, 105, 20);
        mortgageManagement.setVisible(false);
        mortgageComboBox.setVisible(false);
        takeLoan.setVisible(false);
        payLoan.setVisible(false);
        sellProperty = new JLabel("SELL >>");
        sellProperty.setBounds(frameHeight + 50, frameHeight / 2 + 120, 90, 20);
        sellProperty.setVisible(true);
        sellPropertyComboBox = new JComboBox<>();
        sellPropertyComboBox.setBounds(frameHeight + 155, frameHeight / 2 + 120, 160, 20);
        buyer = new JComboBox<>();
        buyer.setBounds(frameHeight + 320, frameHeight / 2 + 120, 140, 20);
        sellingPrice = new JTextField();
        sellingPrice.setBounds(frameHeight + 465, frameHeight / 2 + 120, 45, 20);
        sellPropertyButton = new JButton("SELL");
        sellPropertyButton.setBounds(frameHeight + 515, frameHeight / 2 + 120, 60, 20);
        sellProperty.setVisible(false);
        sellPropertyComboBox.setVisible(false);
        buyer.setVisible(false);
        sellingPrice.setVisible(false);
        sellPropertyButton.setVisible(false);
        buyOwnedProperty = new JLabel("BUY >>");
        ownedProperties = new JComboBox<>();
        propertyOwner = new JTextField();
        ownedPropertyValue = new JTextField();
        buyOwnedPropertyButton = new JButton("BUY");
        buyOwnedProperty.setBounds(frameHeight + 50, frameHeight / 2 + 150, 110, 20);
        ownedProperties.setBounds(frameHeight + 165, frameHeight / 2 + 150, 160, 20);
        propertyOwner.setBounds(frameHeight + 330, frameHeight / 2 + 150, 100, 20);
        ownedPropertyValue.setBounds(frameHeight + 435, frameHeight / 2 + 150, 45, 20);
        buyOwnedPropertyButton.setBounds(frameHeight + 485, frameHeight / 2 + 150, 60, 20);
        propertyOwner.setEditable(false);
        ownedPropertyValue.setToolTipText("PRICE");
        buyOwnedProperty.setVisible(false);
        ownedProperties.setVisible(false);
        propertyOwner.setVisible(false);
        ownedPropertyValue.setVisible(false);
        buyOwnedPropertyButton.setVisible(false);
        buyPlanet = new JLabel("UPGRADE >>");
        addPlanetTo = new JComboBox<>();
        addUpgradeButton = new JButton("NEXT UPGRADE");
        addPerfectPlanetButton = new JButton("PERFECT PLANET");
        buyPlanet.setBounds(frameHeight + 50, frameHeight / 2 + 180, 130, 20);
        addPlanetTo.setBounds(frameHeight + 185, frameHeight / 2 + 180, 200, 20);
        addUpgradeButton.setBounds(frameHeight + 390, frameHeight / 2 + 180, 90, 20);
        addPerfectPlanetButton.setBounds(frameHeight + 485, frameHeight / 2 + 180, 90, 20);
        buyPlanet.setVisible(false);
        addPlanetTo.setVisible(false);
        addUpgradeButton.setVisible(false);
        addPerfectPlanetButton.setVisible(false);
        sellGetOutOfJailCard = new JLabel("SELL CARD >>");
        sellGetOutOfJailCard.setBounds(frameHeight + 50, frameHeight / 2 + 210, 150, 20);
        cardBuyers = new JComboBox<>();
        cardBuyers.setBounds(frameHeight + 205, frameHeight / 2 + 210, 140, 20);
        cardPrice = new JTextField();
        cardPrice.setBounds(frameHeight + 350, frameHeight / 2 + 210, 45, 20);
        sellGetOutOfJailCardButton = new JButton("SELL");
        sellGetOutOfJailCardButton.setBounds(frameHeight + 400, frameHeight / 2 + 210, 60, 20);
        sellGetOutOfJailCard.setVisible(false);
        cardBuyers.setVisible(false);
        sellGetOutOfJailCardButton.setVisible(false);
        cardPrice.setVisible(false);
        buyUnwantedProperty.addActionListener(e -> {
            priceOfUnwantedProperty.setText("");
            String comboSelection = String.valueOf(buyUnwantedProperty.getSelectedItem());
            System.out.println(comboSelection);
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
                        try {
                            Integer.parseInt(value);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        buyUnwantedPropertyButton.setEnabled(false);
                        // valueOfUnwantedProperty = 0;
                    }
                });
        addPlayer1Name = new JButton("Add player's name");
        addPlayer2Name = new JButton("Add player's name");
        addPlayer3Name = new JButton("Add player's name");
        addPlayer4Name = new JButton("Add player's name");

        addPlayer1Name.setBounds(frameHeight + 60, 45, 140, 40);
        addPlayer2Name.setBounds(frameHeight + 62 + (frameHeight / 4),
                45, 140, 40);
        addPlayer3Name.setBounds(frameHeight + 64 + (frameHeight / 2),
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
        player1mana.setBounds(frameHeight + 60, 35, 140, 40);
        addPlayer1.setBounds(frameHeight + 60, 50, 140, 40);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("addPlayer.jpg")));
            addPlayer1.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        addPlayer1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addPlayer1.setBorderPainted(false);
        addPlayer1.setContentAreaFilled(false);
        addPlayer1.addActionListener(arg0 -> {
            addPlayer1.setVisible(false);
            player1name.setVisible(true);
            addPlayer1Name.setVisible(true);
            addPlayer1Name.setEnabled(false);
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
                addPlayer1Name.setEnabled(name.length() >= 1);
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
                player1balance.setText("Galy: " + players.get(0).getMoneyHeld());
                player1balance.setFont(new Font("Arial", Font.BOLD, 14));
                player1mana.setText("Mana: " + players.get(0).getManaHeld());
                player1mana.setFont(new Font("Arial", Font.BOLD, 14));
                frame.getContentPane().add(player1nameLabel);
                frame.getContentPane().add(player1balance);
                frame.getContentPane().add(player1mana);
                System.out.println(players.get(0).getName());
                player1name.setVisible(false);
                addPlayer1Name.setVisible(false);
                addPlayer2.setEnabled(true);
                player1getOutOfJailLabel.setText("RESTORING SPACECRAFT CARD remain: " + players.get(0).getNumberOfGetOutOfJailCards());
                player1getOutOfJailLabel.setBounds(frameHeight + 60, 50, 140, 15);
                player1getOutOfJailLabel.setFont(new Font("Arial", Font.ITALIC, 12));
                player1getOutOfJailLabel.setVisible(false);
                getOutOfJailLabels.add(player1getOutOfJailLabel);
                // highlights panels representing owned properties
                player_1.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent arg0) {}

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
                    public void mousePressed(MouseEvent arg0) {}

                    @Override
                    public void mouseReleased(MouseEvent arg0) {}
                    
                });
                player1 = new JLabel();
                player1.setBounds((int) (frameHeight / 6.5 * 5.5) + 50, (int) (frameHeight / 6.5 * 5.5) + 50, 60, 60);
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("token1.png")));
                    player1.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                frame.getContentPane().add(player1, 2);
                playerIndicators.add(player1);
            }

        });
        addPlayer2 = new JButton();
        addPlayer2.setBounds(frameHeight + 60 + (frameHeight / 4), 50, 140, 40);
        player2nameLabel = new JLabel();
        player2balance = new JLabel();
        player2mana = new JLabel();
        player2getOutOfJailLabel = new JLabel();
        balanceLabels.add(player2balance);
        energyLabels.add(player2mana);
        player2balance.setBounds(frameHeight + 62 + (frameHeight / 4), 20, 140, 40);
        player2nameLabel.setBounds(frameHeight + 62 + (frameHeight / 4), 5, 140, 40);
        player2mana.setBounds(frameHeight + 62 + (frameHeight / 4), 35, 140, 40);

        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("addPlayer.jpg")));
            addPlayer2.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        addPlayer2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addPlayer2.setBorderPainted(false);
        addPlayer2.setContentAreaFilled(false);
        addPlayer2.setEnabled(false);
        addPlayer2.addActionListener(arg0 -> {
            addPlayer2.setVisible(false);
            player2name.setVisible(true);
            addPlayer2Name.setVisible(true);
            addPlayer2Name.setEnabled(false);
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
                addPlayer2Name.setEnabled(name.length() >= 1 && !name.equals(players.get(0).getName()));
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
                player2balance.setText("Galy: " + players.get(1).getMoneyHeld());
                player2balance.setFont(new Font("Arial", Font.BOLD, 14));
                player2mana.setText("Mana: " + players.get(1).getManaHeld());
                player2mana.setFont(new Font("Arial", Font.BOLD, 14));
                frame.getContentPane().add(player2nameLabel);
                frame.getContentPane().add(player2balance);
                frame.getContentPane().add(player2mana);
                System.out.println(players.get(1).getName());
                player2name.setVisible(false);
                addPlayer2Name.setVisible(false);
                addPlayer3.setEnabled(true);
                startGame.setEnabled(true); // after creating two players, the
                // game can be started

                player2getOutOfJailLabel.setText("RESTORING SPACECRAFT CARD remain: " + players.get(1).getNumberOfGetOutOfJailCards());
                player2getOutOfJailLabel.setBounds(frameHeight + 62 + (frameHeight / 4), 50, 140, 15);
                player2getOutOfJailLabel.setFont(new Font("Arial", Font.ITALIC, 12));
                player2getOutOfJailLabel.setVisible(false);
                getOutOfJailLabels.add(player2getOutOfJailLabel);
                // highlights panels representing owned properties
                player_2.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent arg0) {}

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
                    public void mousePressed(MouseEvent arg0) {}

                    @Override
                    public void mouseReleased(MouseEvent arg0) {}

                });

                player2 = new JLabel();
                player2.setBounds((int) (frameHeight / 6.5 * 5.5) + 53, (int) (frameHeight / 6.5 * 5.5) + 53, 60, 60);
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("token2.png")));
                    player2.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    ex.printStackTrace();
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
        player3balance.setBounds(frameHeight + 64 + (frameHeight / 2), 20, 140, 40);
        player3mana.setBounds(frameHeight + 64 + (frameHeight / 2), 35, 140, 40);
        player3nameLabel.setBounds(frameHeight + 64 + (frameHeight / 2), 5, 140, 40);
        addPlayer3.setBounds(frameHeight + 60 + (frameHeight / 2), 50, 140, 40);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("addPlayer.jpg")));
            addPlayer3.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        addPlayer3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addPlayer3.setBorderPainted(false);
        addPlayer3.setContentAreaFilled(false);
        addPlayer3.setEnabled(false);
        addPlayer3.addActionListener(arg0 -> {
            addPlayer3.setVisible(false);
            player3name.setVisible(true);
            addPlayer3Name.setVisible(true);
            addPlayer3Name.setEnabled(false);
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
                addPlayer3Name.setEnabled(name.length() >= 1
                        && !name.equals(players.get(0).getName())
                        && !name.equals(players.get(1).getName()));
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
                player3balance.setText("Galy: " + players.get(2).getMoneyHeld());
                player3balance.setFont(new Font("Arial", Font.BOLD, 14));
                player3mana.setText("Mana: " + players.get(2).getManaHeld());
                player3mana.setFont(new Font("Arial", Font.BOLD, 14));
                frame.getContentPane().add(player3nameLabel);
                frame.getContentPane().add(player3balance);
                frame.getContentPane().add(player3mana);
                System.out.println(players.get(2).getName());
                player3name.setVisible(false);
                addPlayer3Name.setVisible(false);
                addPlayer4.setEnabled(true);
                player3getOutOfJailLabel.setText("RESTORING SPACECRAFT CARD remain: " + players.get(2).getNumberOfGetOutOfJailCards());
                player3getOutOfJailLabel.setBounds(frameHeight + 64 + (frameHeight / 2), 50, 140, 15);
                player3getOutOfJailLabel.setFont(new Font("Arial", Font.ITALIC, 12));
                player3getOutOfJailLabel.setVisible(false);
                getOutOfJailLabels.add(player3getOutOfJailLabel);
                // highlights panels representing owned properties
                player_3.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent arg0) {}

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
                    public void mousePressed(MouseEvent arg0) {}

                    @Override
                    public void mouseReleased(MouseEvent arg0) {}

                });

                player3 = new JLabel();
                player3.setBounds((int) (frameHeight / 6.5 * 5.5) + 56,
                        (int) (frameHeight / 6.5 * 5.5) + 56, 60, 60);
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("token3.png")));
                    player3.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    ex.printStackTrace();
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
        player4balance.setBounds(frameHeight + 60, (int) (frameHeight / 6.5) + 25, 140, 40);
        player4mana.setBounds(frameHeight + 60, (int) (frameHeight / 6.5) + 40, 140, 40);
        player4nameLabel.setBounds(frameHeight + 60, (int) (frameHeight / 6.5) + 10, 140, 40);
        addPlayer4.setBounds(frameHeight + 60, (int) (frameHeight / 6.5) + 55, 140, 40);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("addPlayer.jpg")));
            addPlayer4.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        addPlayer4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addPlayer4.setBorderPainted(false);
        addPlayer4.setContentAreaFilled(false);
        addPlayer4.setEnabled(false);
        addPlayer4.addActionListener(arg0 -> {
            addPlayer4.setVisible(false);
            player4name.setVisible(true);
            addPlayer4Name.setVisible(true);
            addPlayer4Name.setEnabled(false);
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
                addPlayer4Name.setEnabled(name.length() >= 1
                        && !name.equals(players.get(0).getName())
                        && !name.equals(players.get(1).getName())
                        && !name.equals(players.get(2).getName()));
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
                player4balance.setText("Galy: " + players.get(3).getMoneyHeld());
                player4balance.setFont(new Font("Arial", Font.BOLD, 14));
                player4mana.setText("Mana: " + players.get(3).getManaHeld());
                player4mana.setFont(new Font("Arial", Font.BOLD, 14));
                frame.getContentPane().add(player4nameLabel);
                frame.getContentPane().add(player4balance);
                frame.getContentPane().add(player4mana);
                System.out.println(players.get(3).getName());
                player4name.setVisible(false);
                addPlayer4Name.setVisible(false);
                player4getOutOfJailLabel.setText("RESTORING SPACECRAFT CARD remain: " + players.get(3).getNumberOfGetOutOfJailCards());
                player4getOutOfJailLabel.setBounds(frameHeight + 60, (int) (frameHeight / 6.5) + 52, 140, 15);
                player4getOutOfJailLabel.setFont(new Font("Arial", Font.ITALIC, 12));
                player4getOutOfJailLabel.setVisible(false);
                getOutOfJailLabels.add(player4getOutOfJailLabel);

                // highlights panels representing owned properties
                player_4.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent arg0) {}

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
                    public void mousePressed(MouseEvent arg0) {}

                    @Override
                    public void mouseReleased(MouseEvent arg0) {}

                });

                player4 = new JLabel();
                player4.setBounds((int) (frameHeight / 6.5 * 5.5) + 59,
                        (int) (frameHeight / 6.5 * 5.5) + 59, 60, 60);
                try {
                    Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("token4.png")));
                    player4.setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                frame.getContentPane().add(player4, 2);
                playerIndicators.add(player4);
            }

        });

        startGame = new JButton();
        finishTurn = new JButton();
        restartGame = new JButton();
        startGame.setBounds(frameHeight + 60 + (frameHeight / 4), frameHeight / 3, 140, 40);
        finishTurn.setBounds(frameHeight + 60 + (frameHeight / 4), frameHeight - 80, 140, 40);
        restartGame.setBounds(frameHeight + 60 + (frameHeight / 4), frameHeight - 70, 140, 20);
        restartGame.setVisible(false);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("startTheGame.jpg")));
            startGame.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("finishTurn.jpg")));
            finishTurn.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
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
        // invisible player adding components
        startGame.addActionListener(arg0 -> {
            player_1.setBorder(BorderFactory.createLineBorder(Color.green, 2));
            addPlayer3.setVisible(false);
            addPlayer3Name.setVisible(false);
            player3name.setVisible(false);
            addPlayer4.setVisible(false);
            player4name.setVisible(false);
            addPlayer4Name.setVisible(false);
            startNewGame();
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
        rollTheDice.setBounds(frameHeight / 2 - 70, frameHeight / 2 + 40, 140, 40);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("rollTheDice.jpg")));
            rollTheDice.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        rollTheDice.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rollTheDice.setBorderPainted(false);
        rollTheDice.setContentAreaFilled(false);
        rollTheDice.setVisible(false);
        dice1 = new JLabel();
        dice1.setBounds(frameHeight / 2 - 110, frameHeight / 2 - 70, 100, 100);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice6.png")));
            dice1.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        dice2 = new JLabel();
        dice2.setBounds(frameHeight / 2, frameHeight / 2 - 70, 100, 100);
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice6.png")));
            dice2.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
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
        frame.getContentPane().add(center, -1);

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
                    case 1 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice1.png")));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 2 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice2.png")));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 3 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice3.png")));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 4 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice4.png")));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 5 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice5.png")));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 6 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice6.png")));
                            dice1.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                switch (randomDice2) {
                    case 1 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice1.png")));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 2 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice2.png")));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 3 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice3.png")));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 4 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice4.png")));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 5 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice5.png")));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    case 6 -> {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("dice6.png")));
                            dice2.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
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
                            || players.get(playerIndex).getPositionOnGameBoard() == 30) {
                        // no RESTORING SPACECRAFT CARD
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
                                    .setText("Do you want to use your RESTORING SPACECRAFT CARD?");
                            useGetOutOfJailCard.setVisible(true);
                            dontUseGetOutOfJailCard.setVisible(true);
                            rollTheDice.setEnabled(false);
                            finishTurn.setEnabled(false);
                        }
                    } else {
                        adjustPlayerPosition();
                        System.out.println(players.get(playerIndex).getName()
                                + " "
                                + players.get(playerIndex).getPositionOnGameBoard());
                        buyOrRent();
                    }
                } else {
                    if (players.get(playerIndex).isInJail()) {
                        if (!(randomDice1 == randomDice2)) {
                            if (players.get(playerIndex).getTurnsInJail() == 1) {
                                log = "  /> "
                                        + players.get(playerIndex).getName()
                                        + " has his/her balance deducted by 50 Galy and got spaceships restored"
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
                        if ((players.get(playerIndex).getPositionOnGameBoard() == 12 && entities.getEntities().get(28).getOwner() != null)
                                || (players.get(playerIndex).getPositionOnGameBoard() == 28 && entities.getEntities().get(12).getOwner() != null)
                                || (sentByChanceCard && players.get(playerIndex).getPositionOnGameBoard() == 12)
                                || (sentByChanceCard && players.get(playerIndex).getPositionOnGameBoard() == 28)) {
                            rentValue = 10 * (randomDice1 + randomDice2);
                        } else if (players.get(playerIndex).getPositionOnGameBoard() == 12
                                && entities.getEntities().get(28).getOwner() == null
                                || players.get(playerIndex).getPositionOnGameBoard() == 28
                                && entities.getEntities().get(12).getOwner() == null) {
                            rentValue = 4 * (randomDice1 + randomDice2);
                        }
                        if (rentCalculated) {
                            if (rentValue > players.get(playerIndex).getMoneyHeld()) {
                                gamePrompt.setText("You need money to pay the rent. Sell property, take loan or DECLARE BANKRUPTCY FROM GAME");
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

        buyProperty.addActionListener(arg0 -> {

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
            } else if (doubleCounter < 3) {
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
                    + " (worth Galy "
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
        });

        dontBuyProperty.addActionListener(arg0 -> {

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

            buyUnwantedPropertyModel = new DefaultComboBoxModel<>();
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
        });

        payRent.addActionListener(arg0 -> {
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

            } else if (doubleCounter < 3) {
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
        });

        pay50toGetOutOfJail.addActionListener(e -> {
            players.get(playerIndex).setMoneyHeld(-50);
            pay50toGetOutOfJail.setVisible(false);
            useGetOutOfJailCard.setVisible(false);
            rollTheDice.setEnabled(true);
            players.get(playerIndex).setInJail(false);
            players.get(playerIndex).setTurnsInJail(0);
            pay50toGetOutOfJail.setVisible(false);
            log = "  /> " + players.get(playerIndex).getName()
                    + " paid 50 Galy to RESTORING SPACECRAFT" + "\n";
            logText.append(log);
            gamePrompt.setText("");
            extraRollNeeded = false;
            balanceLabels.get(playerIndex).setText(
                    "Galy: " + players.get(playerIndex).getMoneyHeld());
        });

        useGetOutOfJailCard.addActionListener(arg0 -> {
            if (!sentByChanceCard) {
                if (!players.get(playerIndex).isInJail()
                        && players.get(playerIndex)
                        .getPositionOnGameBoard() == 30) {
                    if (doubleCounter == 3 || !gotDouble) {
                        finishTurn.setEnabled(true);
                        log = "  /> "
                                + players.get(playerIndex).getName()
                                + " used his/her RESTORING SPACECRAFT CARD to avoid going to Jail"
                                + "\n";
                        logText.append(log);
                        adjustPlayerPosition();
                    } else {
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
                            + " used his/her RESTORING SPACECRAFT CARD to avoid going to Jail"
                            + "\n";
                    logText.append(log);
                } else {
                    rollTheDice.setEnabled(true);
                    players.get(playerIndex).setInJail(false);
                    players.get(playerIndex).setTurnsInJail(0);
                    pay50toGetOutOfJail.setVisible(false);
                    log = "  /> "
                            + players.get(playerIndex).getName()
                            + " used his/her RESTORING SPACECRAFT CARD to RESTORING SPACECRAFT"
                            + "\n";
                    logText.append(log);
                    extraRollNeeded = false;
                }
                buyOrRent();
            } else {
                log = "  /> "
                        + players.get(playerIndex).getName()
                        + " used his/her RESTORING SPACECRAFT CARD to avoid going to Jail"
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
                    "RESTORING SPACECRAFT CARD remain: "
                            + players.get(playerIndex)
                            .getNumberOfGetOutOfJailCards());
            if (players.get(playerIndex).getNumberOfGetOutOfJailCards() == 0) {
                getOutOfJailLabels.get(playerIndex).setVisible(false);
            }
        });

        dontUseGetOutOfJailCard.addActionListener(arg0 -> {

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

        });

        finishTurn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameOn()) {
                    if (chanceCardPicked) {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource(
                                    "chance.png")));
                            chanceButton.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        chanceCardPicked = false;
                    }
                    if (fortuneCardPicked) {
                        try {
                            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource(
                                    "fortune.png")));
                            fortuneButton.setIcon(new ImageIcon(img));
                        } catch (IOException ex) {
                            ex.printStackTrace();
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
                                .setText("USE CARD, pay 50 Galy or roll the dice to RESTORING SPACECRAFT");
                        useGetOutOfJailCard.setVisible(true);
                        pay50toGetOutOfJail.setVisible(true);
                        rollTheDice.setEnabled(true);
                        extraRollNeeded = true;
                    } else if (players.get(playerIndex).isInJail()) {
                        gamePrompt
                                .setText("You need to pay 50 Galy or roll double to RESTORING SPACECRAFT");
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

        cardBuyers.addActionListener(e -> cardPrice.setText(""));

        buyUnwantedProperty.addActionListener(arg0 -> {
            priceOfUnwantedProperty.setEnabled(true);
            priceOfUnwantedProperty.setText("");
        });

        // no need to simplify
        buyUnwantedPropertyButton.addActionListener(arg0 -> {
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
        });

        mortgageComboBox.addActionListener(arg0 -> {
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
        });

        sellPropertyComboBox.addActionListener(e -> {
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
            buyerModel = new DefaultComboBoxModel<>();
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
        });

        buyer.addActionListener(arg0 -> {
            sellingPrice.setEnabled(true);
            sellingPrice.setText("");
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
                    e.printStackTrace();
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
                    e.printStackTrace();
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

        sellGetOutOfJailCardButton.addActionListener(arg0 -> {
            ownerIndex = getPlayerIndex(String.valueOf(cardBuyers
                    .getSelectedItem()));
            players.get(ownerIndex)
                    .getOutOfJailCards()
                    .add(players.get(playerIndex).getOutOfJailCards()
                            .remove(0));
            players.get(playerIndex).setMoneyHeld(valueOfSoldCard);
            players.get(ownerIndex).setMoneyHeld(-valueOfSoldCard);
            getOutOfJailLabels.get(ownerIndex).setText(
                    "RESTORING SPACECRAFT CARD remain: "
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
                        "RESTORING SPACECRAFT CARD remain: "
                                + players.get(playerIndex)
                                .getNumberOfGetOutOfJailCards());
            }
        });

        sellPropertyButton.addActionListener(arg0 -> {

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
                            .setText("You need money to pay the rent. Sell property, take loan or DECLARE BANKRUPTCY FROM GAME");
                } else {
                    payRent.setVisible(true);
                    declareBankruptcyFromGame.setVisible(false);
                }
            }
            if (paymentDue) {
                if (paymentDueAmount > players.get(playerIndex)
                        .getMoneyHeld()) {
                    gamePrompt
                            .setText("you need to PAY ARREARS. Sell or mortgage property or DECLARE BANKRUPTCY FROM GAME");
                } else {
                    payArrears.setVisible(true);
                    declareBankruptcyFromGame.setVisible(false);
                    gamePrompt.setText("");
                }
            }
            generateBuyOwnedPropertyComboBox();
        });

        ownedProperties.addActionListener(e -> {
            propertyOwner.setText(getOwner(String.valueOf(ownedProperties
                    .getSelectedItem())));
            ownedPropertyValue.setText("");
            ownedPropertyValue.setEnabled(true);
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
            e.printStackTrace();
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

        buyOwnedPropertyButton.addActionListener(arg0 -> {
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
                    + " (for Galy " + valueOfOwnedProperty + ")\n";
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
        });

        payLoan.addActionListener(arg0 -> {
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
                            + "'s mortgage is now paid" + "\n";
                    logText.append(log);
                    balanceLabels.get(playerIndex).setText(
                            "Galy: " + players.get(playerIndex).getMoneyHeld());
                    mortgageComboBox.setSelectedItem(null);
                    payLoan.setEnabled(false);
                    takeLoan.setEnabled(false);
                }
            }
            applyOrRemoveMortgagedLabel(position, mortgaged);
        });

        declareBankruptcyFromGame.addActionListener(arg0 -> {
            gamePrompt
                    .setText("Are you sure you want to declare BANKRUPTCY from the game?");
            yesButton.setVisible(true);
            noButton.setVisible(true);
            declareBankruptcyFromGame.setVisible(false);
        });

        noButton.addActionListener(e -> {
            yesButton.setVisible(false);
            noButton.setVisible(false);
            declareBankruptcyFromGame.setVisible(true);
            if (paymentDue) {
                gamePrompt
                        .setText("You need to PAY ARREARS. Sell or mortgage property or DECLARE BANKRUPTCY FROM GAME");
            } else if (rentCalculated) {
                gamePrompt
                        .setText("You need money to pay the rent. Sell property, take loan or DECLARE BANKRUPTCY FROM GAME");
            }
        });

        yesButton.addActionListener(e -> {
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
                                    "RESTORING SPACECRAFT CARD remain: "
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
                        "Galy: " + players.get(ownerIndex).getMoneyHeld());
            }
            players.get(playerIndex).setBankrupt(true);
            balanceLabels.get(playerIndex).setText("declare BANKRUPTED from game");
            getOutOfJailLabels.get(playerIndex).setVisible(false);
            finishTurn.setEnabled(true);
            gamePrompt.setText("");
            playerIndicators.get(playerIndex).setVisible(false);
        });

        takeLoan.addActionListener(e -> {
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
                            "Galy: " + players.get(playerIndex).getMoneyHeld());
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
                            .setText("You need money to pay the rent. Sell property, take loan or DECLARE BANKRUPTCY FROM GAME");
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
                            .setText("you need to PAY ARREARS. Sell or mortgage property or DECLARE BANKRUPTCY FROM GAME");
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
        });

        payArrears.addActionListener(arg0 -> {
            payArrears.setVisible(false);
            paymentDue = false;
            switch (arrearsIndex) {
                case 1 -> followChanceCard1();
                case 3 -> followChanceCard3();
                case 4 -> payIncomeTax();
                case 6 -> followChanceCard6();
                case 16 -> followChanceCard16();
                case 19 -> followChanceCard19();
                case 38 -> payManaTax();
                case 105 -> followFortuneCard5();
                case 106 -> followFortuneCard6();
                case 108 -> followFortuneCard8();
                case 120 -> followFortuneCard20();
            }

            if (!gotDouble || doubleCounter == 3) {
                finishTurn.setEnabled(true);
            } else {
                rollTheDice.setEnabled(true);
            }
        });

        addPlanetTo.addActionListener(e -> {
            if (addPlanetTo.getSelectedItem() != null) {
                String entityName = String.valueOf(addPlanetTo
                        .getSelectedItem());
                String group = "";
                int entityPosition = 0;
                int numberOfTheSameGroup = 0;
                int totalNumberOfUpgradesInAGroup = 0;
                int totalNumberOfPerfectPlanetsInAGroup = 0;
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
                        totalNumberOfUpgradesInAGroup += anEntity
                                .getNumberOfUpgrades();
                        totalNumberOfPerfectPlanetsInAGroup += anEntity
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
                        if (totalNumberOfUpgradesInAGroup != 0) {
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
                                    && totalNumberOfUpgradesInAGroup >= 2
                                    && getNumberOfUpgrades() > 0) {
                                addUpgradeButton.setEnabled(true);
                            } else if (players
                                    .get(playerIndex)
                                    .getOwnedProperties()
                                    .get(getPlayersEntityPosition(String
                                            .valueOf(addPlanetTo
                                                    .getSelectedItem())))
                                    .getNumberOfUpgrades() == 2
                                    && totalNumberOfUpgradesInAGroup >= 4
                                    && getNumberOfUpgrades() > 0) {
                                addUpgradeButton.setEnabled(true);
                            } else if (players
                                    .get(playerIndex)
                                    .getOwnedProperties()
                                    .get(getPlayersEntityPosition(String
                                            .valueOf(addPlanetTo
                                                    .getSelectedItem())))
                                    .getNumberOfUpgrades() == 3
                                    && totalNumberOfUpgradesInAGroup >= 6
                                    && getNumberOfUpgrades() > 0) {
                                addUpgradeButton.setEnabled(true);
                            } else if (players
                                    .get(playerIndex)
                                    .getOwnedProperties()
                                    .get(getPlayersEntityPosition(String
                                            .valueOf(addPlanetTo
                                                    .getSelectedItem())))
                                    .getNumberOfUpgrades() == 4
                                    && (totalNumberOfUpgradesInAGroup >= 8 || (totalNumberOfUpgradesInAGroup >= 4 && totalNumberOfPerfectPlanetsInAGroup == 1))
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
                        if (totalNumberOfUpgradesInAGroup != 0) {
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
                                    && totalNumberOfUpgradesInAGroup >= 3
                                    && getNumberOfUpgrades() > 0) {
                                addUpgradeButton.setEnabled(true);
                            } else if (players
                                    .get(playerIndex)
                                    .getOwnedProperties()
                                    .get(getPlayersEntityPosition(String
                                            .valueOf(addPlanetTo
                                                    .getSelectedItem())))
                                    .getNumberOfUpgrades() == 2
                                    && totalNumberOfUpgradesInAGroup >= 6
                                    && getNumberOfUpgrades() > 0) {
                                addUpgradeButton.setEnabled(true);
                            } else if (players
                                    .get(playerIndex)
                                    .getOwnedProperties()
                                    .get(getPlayersEntityPosition(String
                                            .valueOf(addPlanetTo
                                                    .getSelectedItem())))
                                    .getNumberOfUpgrades() == 3
                                    && totalNumberOfUpgradesInAGroup >= 9
                                    && getNumberOfUpgrades() > 0) {
                                addUpgradeButton.setEnabled(true);
                            } else if (players
                                    .get(playerIndex)
                                    .getOwnedProperties()
                                    .get(getPlayersEntityPosition(String
                                            .valueOf(addPlanetTo
                                                    .getSelectedItem())))
                                    .getNumberOfUpgrades() == 4
                                    && (totalNumberOfUpgradesInAGroup >= 12
                                    || (totalNumberOfUpgradesInAGroup >= 8 && totalNumberOfPerfectPlanetsInAGroup == 1) || (totalNumberOfUpgradesInAGroup >= 4 && totalNumberOfPerfectPlanetsInAGroup == 2))
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
                        + totalNumberOfUpgradesInAGroup);
                System.out.println("Number of the same color group: "
                        + numberOfTheSameGroup);
            }
        });

        addUpgradeButton.addActionListener(arg0 -> {
            upgradeOrPerfectPlanetBought = true;
            setNumberOfUpgrades(-1);
            double upgradeCost;
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
                    "Galy: " + players.get(playerIndex).getMoneyHeld());
            displayProperPlanetLabel(
                    players.get(playerIndex)
                            .getOwnedProperties()
                            .get(getPlayersEntityPosition(String
                                    .valueOf(addPlanetTo
                                            .getSelectedItem())))
                            .getNumberOfUpgrades(), numberOfUpgrades);
            generateMortgageComboBox();
        });

        addPerfectPlanetButton.addActionListener(arg0 -> {
            setNumberOfPerfectPlanets(-1);
            setNumberOfUpgrades(4);
            upgradeOrPerfectPlanetBought = true;
            double perfectPlanetCost;
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
        });

        restartGame.addActionListener(arg0 -> {
            frame.dispose();
            EventQueue.invokeLater(() -> {
                try {
                    Monopoly window = new Monopoly();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            restartGame.setVisible(false);

        });
    }


    private void applyOrRemoveMortgagedLabel(int position, boolean mortgaged) {
        switch (position) {
            case 1 -> {
                if (mortgaged) {
                    setBottom9Mortgaged();
                } else {
                    setBottom9Clean();
                }
            }
            case 3 -> {
                if (mortgaged) {
                    setBottom7Mortgaged();
                } else {
                    setBottom7Clean();
                }
            }
            case 5 -> {
                if (mortgaged) {
                    setBottom5Mortgaged();
                } else {
                    setBottom5Clean();
                }
            }
            case 6 -> {
                if (mortgaged) {
                    setBottom4Mortgaged();
                } else {
                    setBottom4Clean();
                }
            }
            case 8 -> {
                if (mortgaged) {
                    setBottom2Mortgaged();
                } else {
                    setBottom2Clean();
                }
            }
            case 9 -> {
                if (mortgaged) {
                    setBottom1Mortgaged();
                } else {
                    setBottom1Clean();
                }
            }
            case 11 -> {
                if (mortgaged) {
                    setLeft9Mortgaged();
                } else {
                    setLeft9Clean();
                }
            }
            case 12 -> {
                if (mortgaged) {
                    setLeft8Mortgaged();
                } else {
                    setLeft8Clean();
                }
            }
            case 13 -> {
                if (mortgaged) {
                    setLeft7Mortgaged();
                } else {
                    setLeft7Clean();
                }
            }
            case 14 -> {
                if (mortgaged) {
                    setLeft6Mortgaged();
                } else {
                    setLeft6Clean();
                }
            }
            case 15 -> {
                if (mortgaged) {
                    setLeft5Mortgaged();
                } else {
                    setLeft5Clean();
                }
            }
            case 16 -> {
                if (mortgaged) {
                    setLeft4Mortgaged();
                } else {
                    setLeft4Clean();
                }
            }
            case 19 -> {
                if (mortgaged) {
                    setLeft1Mortgaged();
                } else {
                    setLeft1Clean();
                }
            }
            case 21 -> {
                if (mortgaged) {
                    setTop1Mortgaged();
                } else {
                    setTop1Clean();
                }
            }
            case 23 -> {
                if (mortgaged) {
                    setTop3Mortgaged();
                } else {
                    setTop3Clean();
                }
            }
            case 24 -> {
                if (mortgaged) {
                    setTop4Mortgaged();
                } else {
                    setTop4Clean();
                }
            }
            case 25 -> {
                if (mortgaged) {
                    setTop5Mortgaged();
                } else {
                    setTop5Clean();
                }
            }
            case 27 -> {
                if (mortgaged) {
                    setTop7Mortgaged();
                } else {
                    setTop7Clean();
                }
            }
            case 28 -> {
                if (mortgaged) {
                    setTop8Mortgaged();
                } else {
                    setTop8Clean();
                }
            }
            case 29 -> {
                if (mortgaged) {
                    setTop9Mortgaged();
                } else {
                    setTop9Clean();
                }
            }
            case 31 -> {
                if (mortgaged) {
                    setRight1Mortgaged();
                } else {
                    setRight1Clean();
                }
            }
            case 32 -> {
                if (mortgaged) {
                    setRight2Mortgaged();
                } else {
                    setRight2Clean();
                }
            }
            case 34 -> {
                if (mortgaged) {
                    setRight4Mortgaged();
                } else {
                    setRight4Clean();
                }
            }
            case 35 -> {
                if (mortgaged) {
                    setRight5Mortgaged();
                } else {
                    setRight5Clean();
                }
            }
            case 37 -> {
                if (mortgaged) {
                    setRight7Mortgaged();
                } else {
                    setRight7Clean();
                }
            }
            case 39 -> {
                if (mortgaged) {
                    setRight9Mortgaged();
                } else {
                    setRight9Clean();
                }
            }
        }
    }

    private void setBottom9Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("1.png")));
            bottom9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void setBottom9Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("1mort.png")));
            bottom9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setBottom7Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("3.png")));
            bottom7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setBottom7Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("3mort.png")));
            bottom7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setBottom5Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("5.png")));
            bottom5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setBottom5Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("5mort.png")));
            bottom5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setBottom4Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("6.png")));
            bottom4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setBottom4Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("6mort.png")));
            bottom4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setBottom2Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("8.png")));
            bottom2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setBottom2Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("8mort.png")));
            bottom2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setBottom1Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("9.png")));
            bottom1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setBottom1Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("9mort.png")));
            bottom1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft9Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("11.png")));
            left9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft9Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("11mort.png")));
            left9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft8Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("12.png")));
            left8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft8Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("12mort.png")));
            left8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft7Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("13.png")));
            left7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft7Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("13mort.png")));
            left7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft6Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("14.png")));
            left6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft6Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("14mort.png")));
            left6Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft5Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("15.png")));
            left5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft5Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("15mort.png")));
            left5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft4Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("16.png")));
            left4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft4Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("16mort.png")));
            left4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft1Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("19.png")));
            left1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setLeft1Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("19mort.png")));
            left1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop1Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("21.png")));
            top1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop1Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("21mort.png")));
            top1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop3Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("23.png")));
            top3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop3Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("23mort.png")));
            top3Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop4Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("24.png")));
            top4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop4Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("24mort.png")));
            top4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop5Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("25.png")));
            top5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop5Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("25mort.png")));
            top5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    private void setTop7Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("27.png")));
            top7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop7Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("27mort.png")));
            top7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop8Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("28.png")));
            top8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop8Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("28mort.png")));
            top8Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop9Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("29.png")));
            top9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setTop9Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("29mort.png")));
            top9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight1Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("31.png")));
            right1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight1Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("31mort.png")));
            right1Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight2Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("32.png")));
            right2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight2Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("32mort.png")));
            right2Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight4Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("34.png")));
            right4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight4Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("34mort.png")));
            right4Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight5Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("35.png")));
            right5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight5Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("35mort.png")));
            right5Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight7Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("37.png")));
            right7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight7Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("37mort.png")));
            right7Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight9Clean() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("39.png")));
            right9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void setRight9Mortgaged() {
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("39mort.png")));
            right9Label.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private boolean gameOn() {
        int playersCounter = 0;
        for (Player player : players) {
            if (!player.isBankrupt()) {
                playersCounter++;
            }
        }
        return (playersCounter >= 2);
    }


    private void generateBuyOwnedPropertyComboBox() {
        int counter = 0;
        DefaultComboBoxModel<String> ownedPropertiesModel = new DefaultComboBoxModel<>();
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
    private void generateMortgageComboBox() {
        DefaultComboBoxModel<String> mortgageModel = new DefaultComboBoxModel<>();
        for (PlanetProperties entity : players.get(playerIndex).getOwnedProperties()) {
            if (entity.getNumberOfUpgrades() == 0
                    && entity.getNumberOfPerfectPlanet() == 0) {
                mortgageModel.addElement(entity.getName());
            }
        }
        mortgageComboBox.setModel(mortgageModel);
        mortgageComboBox.setSelectedItem(null);
        DefaultComboBoxModel<String> sellPropertyModel = new DefaultComboBoxModel<>();
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


    private void generateAddPlanetComboBox() {
        Set<String> entitiesNames = new HashSet<>();
        for (PlanetProperties entity : players.get(playerIndex).getOwnedProperties()) {
            if (playerHasAll(entity.getGroup(), players.get(playerIndex)
                    .getName())
                    || entity.getNumberOfUpgrades() > 0
                    || hasPlanets(entity.getGroup())) {
                if (!Objects.equals(entity.getGroup(), "constellation")
                        && !Objects.equals(entity.getGroup(), "star")
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
            DefaultComboBoxModel<String> addPlanetToModel = new DefaultComboBoxModel<>();
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


    private void generateSellGetOutOfJailCardComboBox() {
        DefaultComboBoxModel<String> cardBuyersModel = new DefaultComboBoxModel<>();
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


    private void hideAddPlanetComponents() {
        addPerfectPlanetButton.setEnabled(false);
        addUpgradeButton.setEnabled(false);
        addPerfectPlanetButton.setVisible(false);
        addUpgradeButton.setVisible(false);
        addPlanetTo.setVisible(false);
        buyPlanet.setVisible(false);
    }


    private void ChanceCardActive() {
        this.chanceCardPicked = true;
        int position = this.players.get(this.playerIndex).getPositionOnGameBoard();
        BufferedImage img;
        switch (this.deck.dealChanceCard()) {
            case 1 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c1.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var20) {
                    var20.printStackTrace();
                }
                int counter = 0;
                for (int i = 0; i < this.players.size(); ++i) {
                    if (i != this.playerIndex && !this.players.get(i).isBankrupt()) {
                        ++counter;
                    }
                }
                this.paymentDueAmount = counter * 50;
                if (this.paymentDueAmount > this.players.get(this.playerIndex).getMoneyHeld()) {
                    this.paymentDue = true;
                    this.arrearsIndex = 1;
                } else {
                    this.followChanceCard1();
                }
            }
            case 2 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c2.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var19) {
                    var19.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(50.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 50 Galy for meeting a gold meteorite" + "\n";
                this.logText.append(this.log);
            }
            case 3 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c3.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var18) {
                    var18.printStackTrace();
                }
                this.manaDueAmount = 30.0;
                if (this.players.get(this.playerIndex).getManaHeld() >= this.manaDueAmount) {
                    this.followChanceCard3();
                } else {
                    this.arrearsIndex = 109;
                }
            }
            case 4 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c4.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var17) {
                    var17.printStackTrace();
                }
                this.players.get(this.playerIndex).positionOnBoard(-3);
                this.adjustPlayerPosition();
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has turned 3 steps back to avoid asteroid hit\n";
                this.logText.append(this.log);
            }
            case 5 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c5.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var16) {
                    var16.printStackTrace();
                }
                if (position == 7) {
                    position = 9;
                } else {
                    position = 56 - position;
                }
                this.players.get(this.playerIndex).positionOnBoard(position);
                this.adjustPlayerPosition();
            }
            case 6 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c6.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var15) {
                    var15.printStackTrace();
                }
                this.paymentDueAmount = 0.0;
                for (PlanetProperties entity : this.players.get(this.playerIndex).getOwnedProperties()) {
                    if (entity.getNumberOfUpgrades() > 0) {
                        this.paymentDueAmount += entity.getNumberOfUpgrades() * 25;
                    }

                    if (entity.getNumberOfPerfectPlanet() > 0) {
                        this.paymentDueAmount += 100.0;
                    }
                }
                if (this.paymentDueAmount > 0.0) {
                    if (this.paymentDueAmount <= this.players.get(this.playerIndex).getMoneyHeld()) {
                        this.followChanceCard6();
                    } else {
                        this.paymentDue = true;
                        this.arrearsIndex = 9;
                    }
                }
            }
            case 7 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c7.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var14) {
                    var14.printStackTrace();
                }
                position = this.players.get(this.playerIndex).getPositionOnGameBoard();
                if (this.players.get(this.playerIndex).getNumberOfGetOutOfJailCards() == 0) {
                    position = 10 - position;
                    this.players.get(this.playerIndex).positionOnBoard(position);
                    this.finishTurn.setEnabled(true);
                    this.rollTheDice.setEnabled(false);
                    this.players.get(this.playerIndex).setInJail(true);
                    this.log = "  /> " + this.players.get(this.playerIndex).getName() + " went to Jail" + "\n";
                    this.logText.append(this.log);
                    this.adjustPlayerPosition();
                    this.players.get(this.playerIndex).setManaHeld(0);
                    this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
                    this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has lost all the Mana due to colliding high-velocity stars" + "\n";
                    this.logText.append(this.log);
                } else {
                    this.gamePrompt.setText("Do you want to use your RESTORING SPACECRAFT CARD?");
                    this.useGetOutOfJailCard.setVisible(true);
                    this.dontUseGetOutOfJailCard.setVisible(true);
                    this.rollTheDice.setEnabled(false);
                    this.finishTurn.setEnabled(false);
                    this.players.get(this.playerIndex).setManaHeld(500.0);
                    this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
                    this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has gained 500 Mana from ISS gift" + "\n";
                    this.logText.append(this.log);
                }
            }
            case 8 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c8.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var13) {
                    var13.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(150.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 150 Galy from meeting peer-to-peer spacecraft" + "\n";
                this.logText.append(this.log);
            }
            case 9 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c9.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var12) {
                    var12.printStackTrace();
                }
                this.players.get(this.playerIndex).addGetOutOfJailCard(this.deck.getFortuneCard(3));
                this.getOutOfJailLabels.get(this.playerIndex).setText("RESTORING SPACECRAFT CARD remain: " + this.players.get(this.playerIndex).getNumberOfGetOutOfJailCards());
                this.getOutOfJailLabels.get(this.playerIndex).setVisible(true);
                this.generateSellGetOutOfJailCardComboBox();
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received RESTORING SPACECRAFT CARD \n";
                this.logText.append(this.log);
            }
            case 10 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c10.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var11) {
                    var11.printStackTrace();
                }
                if (position < 12) {
                    position = 12 - position;
                } else if (position < 28) {
                    position = 28 - position;
                } else {
                    position = 52 - position;
                }
                this.players.get(this.playerIndex).positionOnBoard(position);
                this.sentByChanceCard = true;
                this.adjustPlayerPosition();
            }
            case 11 -> {
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c11.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var10) {
                    var10.printStackTrace();
                }
                this.players.get(this.playerIndex).positionOnBoard(40 - this.players.get(this.playerIndex).getPositionOnGameBoard());
                this.adjustPlayerPosition();
            }
            case 12 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c12.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var9) {
                    var9.printStackTrace();
                }
                position = 41 - position;
                this.players.get(this.playerIndex).positionOnBoard(position);
                this.adjustPlayerPosition();
            }
            case 13 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c13.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var8) {
                    var8.printStackTrace();
                }
                if (position == 7) {
                    position = 22;
                } else if (position == 22) {
                    position = 7;
                } else {
                    position = 69 - position;
                }
                this.players.get(this.playerIndex).positionOnBoard(position);
                this.adjustPlayerPosition();
            }
            case 14 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c14.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var7) {
                    var7.printStackTrace();
                }
                position = 45 - position;
                this.players.get(this.playerIndex).positionOnBoard(position);
                this.adjustPlayerPosition();
            }
            case 15 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c15.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var6) {
                    var6.printStackTrace();
                }
                if (position == 7) {
                    position = 8;
                } else if (position == 22) {
                    position = 3;
                } else {
                    position = 9;
                }
                this.players.get(this.playerIndex).positionOnBoard(position);
                if (this.entities.getEntities().get(this.players.get(this.playerIndex).getPositionOnGameBoard()).getOwner() != null && !Objects.equals(this.entities.getEntities().get(this.players.get(this.playerIndex).getPositionOnGameBoard()).getOwner().getName(), this.players.get(this.playerIndex).getName())) {
                    this.sentByChanceCard = true;
                }
                this.adjustPlayerPosition();
            }
            case 16 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c16.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var5) {
                    var5.printStackTrace();
                }
                this.manaDueAmount = 150.0;
                if (this.players.get(this.playerIndex).getManaHeld() >= this.manaDueAmount) {
                    this.followChanceCard16();
                } else {
                    this.arrearsIndex = 109;
                }
            }
            case 17 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c17.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var4) {
                    var4.printStackTrace();
                }
                this.players.get(this.playerIndex).setManaHeld(200.0);
                this.balanceLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 200 Mana from supply ship coming" + "\n";
                this.logText.append(this.log);
            }
            case 18 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c18.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var3) {
                    var3.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(200.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 200 Galy from new matter founding" + "\n";
                this.logText.append(this.log);
            }
            case 19 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c19.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var2) {
                    var2.printStackTrace();
                }
                this.manaDueAmount = 50.0;
                if (this.players.get(this.playerIndex).getManaHeld() >= this.manaDueAmount) {
                    this.followChanceCard19();
                } else {
                    this.arrearsIndex = 109;
                }
            }
            case 20 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("c20.png")));
                    this.chanceButton.setIcon(new ImageIcon(img));
                } catch (IOException var1) {
                    var1.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(100.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 100 Galy from new batteries" + "\n";
                this.logText.append(this.log);
            }
        }
    }


    private void followChanceCard1() {
        for (int i = 0; i < this.players.size(); ++i) {
            if (i != this.playerIndex && !this.players.get(i).isBankrupt()) {
                this.players.get(i).setMoneyHeld(50.0);
                this.balanceLabels.get(i).setText("Galy: " + this.players.get(i).getMoneyHeld());
            }
        }
        this.players.get(this.playerIndex).setMoneyHeld(-this.paymentDueAmount);
        this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
        this.log = "  /> " + this.players.get(this.playerIndex).getName() + " paid each of other players 50 Galy on success on Alpha-leap" + "\n";
        this.logText.append(this.log);
    }

    private void followChanceCard3() {
        this.players.get(this.playerIndex).setManaHeld(-this.manaDueAmount);
        this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
        this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has lost 30 Mana due to energy leak" + "\n";
        this.logText.append(this.log);
    }

    private void followChanceCard6() {
        this.players.get(this.playerIndex).setMoneyHeld(-this.paymentDueAmount);
        this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
        this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has spent Galy" + this.paymentDueAmount + " on general repairs on his properties \n";
        this.logText.append(this.log);
    }

    private void followChanceCard16() {
        this.players.get(this.playerIndex).setManaHeld(-this.manaDueAmount);
        this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
        this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has lost 150 Mana due to black hole edge" + "\n";
        this.logText.append(this.log);
    }

    private void followChanceCard19() {
        this.players.get(this.playerIndex).setManaHeld(-this.manaDueAmount);
        this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
        this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has lost 50 Mana due to gamma ray burst" + "\n";
        this.logText.append(this.log);
    }

    private void followFortuneCard1() {
        this.players.get(this.playerIndex).setMoneyHeld(-this.paymentDueAmount);
        this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
        this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has spent Galy" + this.paymentDueAmount + " on street repairs \n";
        this.logText.append(this.log);
    }

    private void followFortuneCard5() {
        this.players.get(this.playerIndex).setMoneyHeld(-this.paymentDueAmount);
        this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
        this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has paid 50 Galy for maintenance fee" + "\n";
        this.logText.append(this.log);
    }

    private void followFortuneCard6() {
        this.players.get(this.playerIndex).setMoneyHeld(-this.paymentDueAmount);
        this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
        this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has paid 50 Galy for space garage fee" + "\n";
        this.logText.append(this.log);
    }

    private void followFortuneCard8() {
        this.players.get(this.playerIndex).setManaHeld(-this.manaDueAmount);
        this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
        this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has lost 150 Mana due to letting the sub-spacecraft to explore" + "\n";
        this.logText.append(this.log);
    }

    private void followFortuneCard20() {
        this.players.get(this.playerIndex).setManaHeld(-this.manaDueAmount);
        this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
        this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has lost 100 Mana due to losing connection" + "\n";
        this.logText.append(this.log);
    }

    private void FortuneCardActive() {
        this.fortuneCardPicked = true;
        int counter;
        BufferedImage img;
        int i;
        switch (this.deck.dealFortuneCard()) {
            case 1 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k1.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var20) {
                    var20.printStackTrace();
                }
                this.paymentDueAmount = 0.0;
                for (PlanetProperties PlanetProperties : this.players.get(this.playerIndex).getOwnedProperties()) {
                    if (PlanetProperties.getNumberOfUpgrades() > 0) {
                        this.paymentDueAmount += PlanetProperties.getNumberOfUpgrades() * 40;
                    }
                    if (PlanetProperties.getNumberOfPerfectPlanet() > 0) {
                        this.paymentDueAmount += 115.0;
                    }
                }
                if (this.paymentDueAmount > 0.0) {
                    if (this.paymentDueAmount <= this.players.get(this.playerIndex).getMoneyHeld()) {
                        this.followFortuneCard1();
                    } else {
                        this.paymentDue = true;
                        this.arrearsIndex = 112;
                    }
                }
            }
            case 2 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k2.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var19) {
                    var19.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(10.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 10 Galy for being a Miss Universe 2023" + "\n";
                this.logText.append(this.log);
            }
            case 3 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k3.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var18) {
                    var18.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(200.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 200 Galy for meeting a diamond meteorite\n";
                this.logText.append(this.log);
            }
            case 4 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k4.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var17) {
                    var17.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(100.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 100 Galy from the bank" + "\n";
                this.logText.append(this.log);
            }
            case 5 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k5.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var16) {
                    var16.printStackTrace();
                }
                this.paymentDueAmount = 50.0;
                if (this.players.get(this.playerIndex).getMoneyHeld() >= this.paymentDueAmount) {
                    this.followFortuneCard5();
                } else {
                    this.paymentDue = true;
                    this.arrearsIndex = 109;
                }
            }
            case 6 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k6.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var15) {
                    var15.printStackTrace();
                }
                this.paymentDueAmount = 100.0;
                if (this.players.get(this.playerIndex).getMoneyHeld() >= this.paymentDueAmount) {
                    this.followFortuneCard6();
                } else {
                    this.paymentDue = true;
                    this.arrearsIndex = 109;
                }
            }
            case 7 -> {     // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k7.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var14) {
                    var14.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(100.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 100 Galy from the alien gift" + "\n";
                this.logText.append(this.log);
            }
            case 8 -> {         // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k8.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var13) {
                    var13.printStackTrace();
                }
                this.manaDueAmount = 150.0;
                if (this.players.get(this.playerIndex).getManaHeld() >= this.manaDueAmount) {
                    this.followFortuneCard8();
                } else {
                    this.arrearsIndex = 109;
                }
            }
            case 9 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k9.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var12) {
                    var12.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(25.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 25 Galy from Alien's spacecraft" + "\n";
                this.logText.append(this.log);
            }
            case 10 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k10.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var11) {
                    var11.printStackTrace();
                }
                this.players.get(this.playerIndex).positionOnBoard(40 - this.players.get(this.playerIndex).getPositionOnGameBoard());
                this.adjustPlayerPosition();
                this.players.get(this.playerIndex).setMoneyHeld(200.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 200 Galy from the government" + "\n";
                this.logText.append(this.log);
            }
            case 11 -> {       // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k11.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var10) {
                    var10.printStackTrace();
                }
                counter = 0;
                for (i = 0; i < this.players.size(); ++i) {
                    if (i != this.playerIndex) {
                        this.players.get(i).setMoneyHeld(-50.0);
                        ++counter;
                        this.balanceLabels.get(i).setText("Galy: " + this.players.get(i).getMoneyHeld());
                    }
                }
                this.players.get(this.playerIndex).setMoneyHeld(counter * 50);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received from each of other players 50 Galy" + "\n";
                this.logText.append(this.log);
            }
            case 12 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k12.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var9) {
                    var9.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(200.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 200 Galy for awarding the Universe Oldie Pension" + "\n";
                this.logText.append(this.log);
            }
            case 13 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k13.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var8) {
                    var8.printStackTrace();
                }
                this.players.get(this.playerIndex).addGetOutOfJailCard(this.deck.getFortuneCard(3));
                this.getOutOfJailLabels.get(this.playerIndex).setText("RESTORING SPACECRAFT CARD remain: " + this.players.get(this.playerIndex).getNumberOfGetOutOfJailCards());
                this.getOutOfJailLabels.get(this.playerIndex).setVisible(true);
                this.generateSellGetOutOfJailCardComboBox();
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received RESTORING SPACECRAFT CARD \n";
                this.logText.append(this.log);
            }
            case 14 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k14.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var7) {
                    var7.printStackTrace();
                }
                int position = this.players.get(this.playerIndex).getPositionOnGameBoard();
                if (this.players.get(this.playerIndex).getNumberOfGetOutOfJailCards() == 0) {
                    position = 10 - position;
                    this.players.get(this.playerIndex).positionOnBoard(position);
                    this.finishTurn.setEnabled(true);
                    this.rollTheDice.setEnabled(false);
                    this.players.get(this.playerIndex).setInJail(true);
                    this.log = "  /> " + this.players.get(this.playerIndex).getName() + " went to Jail" + "\n";
                    this.logText.append(this.log);
                    this.adjustPlayerPosition();
                    this.players.get(this.playerIndex).setManaHeld(-5000);
                    this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
                    this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has lost all the Mana due to colliding high-velocity stars" + "\n";
                    this.logText.append(this.log);
                } else {
                    this.gamePrompt.setText("Do you want to use your RESTORING SPACECRAFT CARD?");
                    this.useGetOutOfJailCard.setVisible(true);
                    this.dontUseGetOutOfJailCard.setVisible(true);
                    this.rollTheDice.setEnabled(false);
                    this.finishTurn.setEnabled(false);
                    this.players.get(this.playerIndex).setManaHeld(+500.0);
                    this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
                    this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has gained 500 Mana from ISS gift" + "\n";
                    this.logText.append(this.log);
                }
            }
            case 15 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k15.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var6) {
                    var6.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(50.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 50 Galy from lucky money" + "\n";
                this.logText.append(this.log);
            }
            case 16 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k16.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var5) {
                    var5.printStackTrace();
                }
                this.players.get(this.playerIndex).setMoneyHeld(20.0);
                this.balanceLabels.get(this.playerIndex).setText("Galy: " + this.players.get(this.playerIndex).getMoneyHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 20 Galy for doing overtime discovery" + "\n";
                this.logText.append(this.log);
            }
            case 17 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k17.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var4) {
                    var4.printStackTrace();
                }
                this.players.get(this.playerIndex).setManaHeld(100.0);
                this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 100 Mana from solar energy charging" + "\n";
                this.logText.append(this.log);
            }
            case 18 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k18.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var3) {
                    var3.printStackTrace();
                }
                this.players.get(this.playerIndex).setManaHeld(100.0);
                this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 100 Mana from radioisotope thermoelectric generators" + "\n";
                this.logText.append(this.log);
            }
            case 19 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k19.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var2) {
                    var2.printStackTrace();
                }
                this.players.get(this.playerIndex).setManaHeld(100.0);
                this.energyLabels.get(this.playerIndex).setText("Mana: " + this.players.get(this.playerIndex).getManaHeld());
                this.log = "  /> " + this.players.get(this.playerIndex).getName() + " has received 100 Mana from fuel cells" + "\n";
                this.logText.append(this.log);
            }
            case 20 -> {        // DONE
                try {
                    img = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("k20.png")));
                    this.fortuneButton.setIcon(new ImageIcon(img));
                } catch (IOException var1) {
                    var1.printStackTrace();
                }
                this.manaDueAmount = 100.0;
                if (this.players.get(this.playerIndex).getManaHeld() >= this.manaDueAmount) {
                    this.followFortuneCard20();
                } else {
                    this.arrearsIndex = 109;
                }
            }
        }
    }

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
                            .setText("The property is mortgaged, so there is no need to PAY RENT");
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
                        // insufficient funds
                    } else {
                        buyProperty.setVisible(true);
                        buyProperty.setEnabled(false);
                        gamePrompt
                                .setText("You DON'T have enough cash to buy this property. Press DON'T BUY or borrow some money");
                    }
                    dontBuyProperty.setVisible(true);
                    rollTheDice.setEnabled(false);

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
                                    .setText("You need money to pay the rent. Sell property, take loan or DECLARE BANKRUPTCY FROM GAME");
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
                        .setText("You need to PAY ARREARS. Sell or mortgage property or DECLARE BANKRUPTCY FROM GAME");
                rollTheDice.setEnabled(false);
                declareBankruptcyFromGame.setVisible(true);
            }
        }

    }

    private void calculateRent() {
        ownerIndex = getPlayerIndex(entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .getOwner());

        if (entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .getGroup().equals("stars")) {
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
                .getGroup().equals("stars")
                && !entities.getEntities()
                .get(players.get(playerIndex).getPositionOnGameBoard())
                .getGroup().equals("constellation")) {
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
                .getGroup().equals("constellation")) {

            rentValue = getConstellationRent(players.get(ownerIndex).getName());
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
            return counter == 2;

        } else {
            return counter == 3;
        }
    }


    private double getConstellationRent(String name) {
        int counter = 0;
        double rentValue = 0;
        for (PlanetProperties entity : entities.getEntities()) {
            if (entity.getGroup() != null
                    && entity.getGroup().equals("constellation")) {
                if (entity.getOwner() != null
                        && entity.getOwner().getName().equals(name)) {
                    counter++;
                }
            }

        }
        switch (counter) {
            case 1 -> rentValue = 25;
            case 2 -> rentValue = 50;
            case 3 -> rentValue = 100;
            case 4 -> rentValue = 200;
        }
        return rentValue;
    }


    private int getPlayerIndex(Player player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(player.getName())) {
                return i;
            }
        }
        return -1;
    }

    private int getPlayerIndex(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    private double getEntityCost(String name) {
        for (PlanetProperties entity : entities.getEntities()) {
            if (entity.getName().equals(name)) {
                return entity.getCost();
            }
        }
        return -1;
    }


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


    private int getEntityPosition(String name) {
        for (PlanetProperties entity : entities.getEntities()) {
            if (entity.getName().equals(name)) {
                return entity.getPosition();
            }
        }
        return -1;
    }


    private String getOwner(String entityName) {
        for (PlanetProperties entity : entities.getEntities()) {
            if (entity.getName().equals(entityName)) {
                return entity.getOwner().getName();
            }
        }
        return null;
    }


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


    private void displayProperPlanetLabel(int PlanetIndex, int numberOfUpgrades) {
        if (PlanetIndex < 5) {
            switch (numberOfUpgrades) {
                case 0 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("hotel.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 1 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("house1.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 2 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("house2.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 3 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("house3.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 4 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("house4.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else if (PlanetIndex < 11) {
            switch (numberOfUpgrades) {
                case 0 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("hotelFlippedRight.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 1 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade1FlippedRight.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 2 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade2FlippedRight.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 3 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade3FlippedRight.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 4 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade4FlippedRight.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 5 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade5FlippedRight.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else if (PlanetIndex < 17) {
            switch (numberOfUpgrades) {
                case 0 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("hotelUpsideDown.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 1 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade1UpsideDown.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 2 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade2UpsideDown.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 3 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade3UpsideDown.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 4 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade4UpsideDown.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 5 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade5UpsideDown.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else {
            switch (numberOfUpgrades) {
                case 0 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("hotelFlippedLeft.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 1 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade1FlippedLeft.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 2 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade2FlippedLeft.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 3 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade3FlippedLeft.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 4 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade4FlippedLeft.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                case 5 -> {
                    try {
                        Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("upgrade5FlippedLeft.png")));
                        perfectPlanetLabels.get(PlanetIndex).setIcon(
                                new ImageIcon(img));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }


    private void payIncomeTax() {
        players.get(playerIndex).setMoneyHeld(-manaDueAmount);
        energyLabels.get(playerIndex).setText(
                "Mana: " + players.get(playerIndex).getManaHeld());
        log = "  /> " + players.get(playerIndex).getName()
                + " losing 200 Mana due to losing connection " + "\n";
        logText.append(log);
    }


    private void payManaTax() {
        players.get(playerIndex).setManaHeld(-manaDueAmount);
        energyLabels.get(playerIndex).setText(
                "Mana: " + players.get(playerIndex).getManaHeld());
        log = "  /> " + players.get(playerIndex).getName()
                + " losing 100 Mana due to alpha jump " + "\n";
        logText.append(log);
    }

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
            case 0 -> playerIndicators.get(playerIndex).setBounds(
                    (int)(frameHeight * 49 / 54) + playerIndex * 3,
                    (int) frameHeight * 49 / 54 + playerIndex * 4, 60 ,60);
//                    (int) (frameHeight / 6.5 * 5.5) + 50 + playerIndex * 3,
//                    (int) (frameHeight / 6.5 * 5.5) + 60 + playerIndex * 4, 60,
//                    60);
            case 1 -> playerIndicators.get(playerIndex).setBounds(
                    (int)(frameHeight * 49 / 54) + playerIndex * 3 - 90,
                    (int) frameHeight * 49 / 54 + playerIndex * 4, 60,
                    60);
            case 2 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 90 * 2,
                    (int) (frameHeight * 49 / 54) + playerIndex * 4, 60,
                    60);
            case 3 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 90 * 3,
                    (int) (frameHeight * 49 / 54) + playerIndex * 4, 60,
                    60);
            case 4 -> {
                manaDueAmount = 200;
                if (manaDueAmount > players.get(playerIndex).getManaHeld()) {
                    gamePrompt.setText("You need to PAY ARREARS. Sell or mortgage property or DECLARE BANKRUPTCY FROM GAME");
                    rollTheDice.setEnabled(false);
                    declareBankruptcyFromGame.setVisible(true);
                    arrearsIndex = 4;
                } else {
                    payIncomeTax();
                }
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight * 49 / 54) + playerIndex * 3 - 90 * 4,
                        (int) (frameHeight * 49 / 54) + playerIndex * 4, 60,
                        60);
            }
            case 5 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 90 * 5,
                    (int) (frameHeight * 49 / 54) + playerIndex * 4, 60,
                    60);
            case 6 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 90 * 6,
                    (int) (frameHeight * 49 / 54) + playerIndex * 4, 60,
                    60);
            case 7 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 90 * 7,
                    (int) (frameHeight * 49 / 54) + playerIndex * 4, 60,
                    60);
            case 8 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 90 * 8,
                    (int) (frameHeight * 49 / 54) + playerIndex * 4, 60,
                    60);
            case 9 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 90 * 9,
                    (int) (frameHeight * 49 / 54) + playerIndex * 4, 60,
                    35);
            case 10 -> playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                    (int) (frameHeight * 49 / 54) + playerIndex * 4, 60,
                    60);
            case 11 -> playerIndicators
                    .get(playerIndex)
                    .setBounds(
                            20 + playerIndex * 3,
                            (int)(frameHeight * 49 / 54) + playerIndex * 3 - 110,
                            60, 60);
            case 12 -> playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 110 - 90, 60,
                    60);
            case 13 -> playerIndicators
                    .get(playerIndex)
                    .setBounds(
                            20 + playerIndex * 3,
                            (int) (frameHeight * 49 / 54) + playerIndex * 3 - 110 - 90 * 2,
                            60, 60);
            case 14 -> playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 110 - 90 * 3, 60,
                    60);
            case 15 -> playerIndicators
                    .get(playerIndex)
                    .setBounds(
                            20 + playerIndex * 3,
                            (int) (frameHeight * 49 / 54) + playerIndex * 3 - 110 - 90 * 4,
                            60, 60);
            case 16 -> playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 110 - 90 * 5, 60,
                    60);
            case 17 -> playerIndicators
                    .get(playerIndex)
                    .setBounds(
                            20 + playerIndex * 3,
                            (int) (frameHeight * 49 / 54) + playerIndex * 3 - 110 - 90 * 6,
                            60, 60);
            case 18 -> playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 110 - 90 * 7, 60,
                    60);
            case 19 -> playerIndicators.get(playerIndex).setBounds(20 + playerIndex * 3,
                    (int) (frameHeight * 49 / 54) + playerIndex * 3 - 110 - 90 * 8, 60, 60);
            case 20 -> playerIndicators.get(playerIndex).setBounds(playerIndex * 3 + 20,
                    playerIndex * 4 + 20, 60, 60);
            case 21 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight / 54) + playerIndex * 3 + 130,
                    playerIndex * 4 + 20, 60, 60);
            case 22 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight / 54) + playerIndex * 3 + 130 + 90,
                    playerIndex * 4 + 20, 60, 60);
            case 23 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight / 54) + playerIndex * 3 + 130 + 90 * 2,
                    playerIndex * 4 + 20, 60, 60);
            case 24 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight / 54) + playerIndex * 3 + 130 + 90 * 3,
                    playerIndex * 4 + 20, 60, 60);
            case 25 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight / 54) + playerIndex * 3 + 130 + 90 * 4,
                    playerIndex * 4 + 20, 60, 60);
            case 26 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight / 54) + playerIndex * 3 + 130 + 90 * 5,
                    playerIndex * 4 + 20, 60, 60);
            case 27 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight / 54) + playerIndex * 3 + 130 + 90 * 6,
                    playerIndex * 4 + 20, 60, 60);
            case 28 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight / 54) + playerIndex * 3 + 130 + 90 * 7,
                    playerIndex * 4 + 20, 60, 60);
            case 29 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight / 54) + playerIndex * 3 + 130 + 90 * 8,
                    playerIndex * 4 + 20, 60, 60);
            case 30 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3,
                    playerIndex * 4 + 20, 60, 60);
            case 31 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3,
                    (int) (frameHeight / 54) + 150 + playerIndex * 3, 60, 60);
            case 32 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3,
                    (int) (frameHeight /54) + 150 + 90 + playerIndex * 3, 60,
                    60);
            case 33 -> playerIndicators
                    .get(playerIndex)
                    .setBounds(
                            (int) (frameHeight * 49 / 54) + playerIndex * 3,
                            (int) (frameHeight /54) + 150 + 90 * 2 + playerIndex * 3,
                            60, 60);
            case 34 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight / 6.5 * 5.5) + 60 + playerIndex * 3,
                    (int) (frameHeight / 54) + 130 + 90 * 3 + playerIndex * 3, 60,
                    60);
            case 35 -> playerIndicators
                    .get(playerIndex)
                    .setBounds(
                            (int) (frameHeight * 49 / 54) + playerIndex * 3,
                            (int) (frameHeight / 54) + 130 + 90 * 4 + playerIndex * 3,
                            60, 60);
            case 36 -> playerIndicators.get(playerIndex).setBounds(
                    (int) (frameHeight * 49 / 54) + playerIndex * 3,
                    (int) (frameHeight / 54) + 130 + 90 * 5 + playerIndex * 3, 60,
                    60);
            case 37 -> playerIndicators
                    .get(playerIndex)
                    .setBounds(
                            (int) (frameHeight * 49 / 54) + playerIndex * 3,
                            (int) (frameHeight / 54) + 130 + 90 * 6 + playerIndex * 3,
                            60, 60);
            case 38 -> {
                manaDueAmount = 100;
                if (manaDueAmount > players.get(playerIndex).getManaHeld()) {
                    gamePrompt
                            .setText("You need to PAY ARREARS. Sell or mortgage property or DECLARE BANKRUPTCY FROM GAME");
                    rollTheDice.setEnabled(false);
                    declareBankruptcyFromGame.setVisible(true);
                    arrearsIndex = 38;
                } else {
                    payManaTax();
                }
                playerIndicators.get(playerIndex).setBounds(
                        (int) (frameHeight * 49 / 54) + playerIndex * 3,
                        (int) (frameHeight / 54) + 130 + 90 * 7 + playerIndex * 3, 60,
                        60);
            }
            case 39 -> playerIndicators
                    .get(playerIndex)
                    .setBounds(
                            (int) (frameHeight * 49 / 54) + playerIndex * 3,
                            (int) (frameHeight / 54) + 130 + 90 * 8 + playerIndex * 3,
                            60, 60);
        }
        if (players.get(playerIndex).didPassGo()) {
            balanceLabels.get(playerIndex).setText(
                    "Galy: " + players.get(playerIndex).getMoneyHeld());
            log = "  /> " + players.get(playerIndex).getName()
                    + " got 200 Galy for passing \"GO\" " + "\n";
            logText.append(log);
            players.get(playerIndex).setPassedGo(false);
        }

    }


    public int getNumberOfPerfectPlanets() {
        return numberOfPerfectPlanets;
    }


    public void setNumberOfPerfectPlanets(int update) {
        numberOfPerfectPlanets += update;
    }


    public int getNumberOfUpgrades() {
        return numberOfUpgrades;
    }

    public void setNumberOfUpgrades(int update) {
        numberOfUpgrades += update;
    }
}
